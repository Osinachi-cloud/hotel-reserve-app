import exceptions.CustomerNotFoundException;
import exceptions.RoomNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface ReservationService {
    boolean isRoomFree(int roomNumberSearch) throws RoomNotFoundException;
    List<Room> getAllFreeRooms();
    List<Room> getAllFreeRoomType(RoomType roomType) throws RoomNotFoundException;
    void bokNow(UUID customerId, RoomType roomType, int periodOfStay) throws RoomNotFoundException, CustomerNotFoundException;
}

