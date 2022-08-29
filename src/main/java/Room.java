import java.util.Objects;

public class Room implements IRoom{
    private int roomNumber;
    private RoomType roomType;
    private double roomPrize;
    private boolean isEmpty;
    private Customer occupant;

    public Room(int roomNumber, RoomType roomType, double roomPrize, boolean isEmpty) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        if(roomType.equals(RoomType.MASTERS)){
            this.roomPrize = 100;
        }else if(roomType.equals(RoomType.COMMON)){
            this.roomPrize = 50;
        }
        this.isEmpty = isEmpty;
    }

    public Room() {
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public double getRoomPrize() {
        return roomPrize;
    }

    public void setRoomPrize(double roomPrize) {
        this.roomPrize = roomPrize;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public Customer getCustomer() {
        return occupant;
    }

    public void setCustomer(Customer customer) {
        this.occupant = customer;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", roomType=" + roomType +
                ", roomPrize=" + roomPrize +
                ", isEmpty=" + isEmpty +
                '}';
    }
}
