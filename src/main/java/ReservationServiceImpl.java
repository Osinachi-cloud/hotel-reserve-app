import exceptions.CustomerNotFoundException;
import exceptions.RoomNotFoundException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ReservationServiceImpl implements ReservationService {
    private CustomerService customerService;

    public ReservationServiceImpl(CustomerService customerService) {
        this.customerService = customerService;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    List<Room> allHotelRooms = CustomerServiceImpl.HotelResource.getRooms();

    public boolean isRoomFree(int roomNumberSearch) throws RoomNotFoundException {
        boolean roomIsFree = true;
        for(Room room: allHotelRooms){
            if (room.getRoomNumber() != roomNumberSearch) {
                throw new RoomNotFoundException("this room number " + roomNumberSearch + " does not exist");
            }else if(room.getRoomNumber() == roomNumberSearch && room.isEmpty() == true){
                roomIsFree = true;
            }else{
                roomIsFree = false;
            }
        }
        return roomIsFree;
    }

    public List<Room> getAllFreeRooms(){
        List<Room> listOfFreeRooms = new ArrayList<>();
        for (Room room : allHotelRooms) {
            if(room.isEmpty() == true){
                listOfFreeRooms.add(room);
                return listOfFreeRooms;
            }
            if(listOfFreeRooms.size() == 0){
                System.out.println("all room has been occupied");
            }
        }
        return listOfFreeRooms;
    }
    public List<Room> getAllFreeRoomType(RoomType roomType) throws RoomNotFoundException {
        List<Room> listOfFreeRoomTypes = new ArrayList<>();
        for (Room room : getAllFreeRooms()) {
            if(room.getRoomType() != roomType){
                throw new RoomNotFoundException("this room type is not found");
            }
            if(room.isEmpty() == true && room.getRoomType().equals(RoomType.MASTERS)){
                listOfFreeRoomTypes.add(room);
            }else if(room.getRoomType().equals(RoomType.COMMON)){
                listOfFreeRoomTypes.add(room);
            }
            if(listOfFreeRoomTypes.size() < 1){
                System.out.println("all rooms have been occupied");
            }
        }
        return listOfFreeRoomTypes;
    }
    public void bokNow(UUID customerId, RoomType roomType, int periodOfStayInDays) throws RoomNotFoundException, CustomerNotFoundException {
        Customer customer = customerService.findCustomer(customerId);
        List<Room> listOfFreeRoomsForDesiredType = getAllFreeRoomType(roomType);
        Room designatedRoom = listOfFreeRoomsForDesiredType.get(0);
        Reservation Reservation = new Reservation(1L, new Date(), new Date(), designatedRoom, customer);
        designatedRoom.setCustomer(customer);
        designatedRoom.setEmpty(false);
        if(customer.getWallet() >= designatedRoom.getRoomPrize()){
            double customerWalletBalance = customer.getWallet() - designatedRoom.getRoomPrize() * periodOfStayInDays;
            customer.setWallet(customerWalletBalance);
            double hotelRevenue = CustomerServiceImpl.AdminResource.getHotelPurse() + designatedRoom.getRoomPrize();
            CustomerServiceImpl.AdminResource.setHotelPurse(hotelRevenue);
        }else{
            System.out.println("customer does not have enough balance in wallet, credit your wallet");
        }
    }


}
