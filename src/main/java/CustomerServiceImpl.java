import exceptions.CustomerNotFoundException;
import exceptions.RoomNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerServiceImpl implements CustomerService {
    List<Customer> allCustomerInDb = AdminResource.getCustomerList();

    @Override
    public Customer createNewCustomer(String name, double wallet){
        Customer newCustomer = new Customer(name, wallet);
        AdminResource.addCustomerList(newCustomer);
        return newCustomer;
    }

    @Override
    public Customer findCustomer(UUID customerId) throws CustomerNotFoundException {
        List<Customer> foundCustomer = new ArrayList<>();
        for(Customer customer: allCustomerInDb){
            if (customerId != customer.getId()) {
                throw new CustomerNotFoundException("this customer with id: " + customerId + " does not exist, pls create an account");
            }else{
                foundCustomer.add(customer);
            }
        }
        return foundCustomer.get(0);
    }

    public static class AdminResource {
        private static List<Customer> customerList;
        private static double hotelPurse;

        public static List<Customer> getCustomerList() {
            return customerList;
        }

        public static void addCustomerList(Customer customer) {
            AdminResource.customerList.add(customer);
        }

        public static double getHotelPurse() {
            return hotelPurse;
        }

        public static void setHotelPurse(double hotelPurse) {
            AdminResource.hotelPurse = hotelPurse;
        }
    }

    public static class HotelResource {
        private static List<Room> rooms;

        public HotelResource() {
        }

        public static List<Room> getRooms() {
            return rooms;
        }

        public static void addToRooms(Room newRoom) {
            HotelResource.rooms.add(newRoom);
        }
    }
}
