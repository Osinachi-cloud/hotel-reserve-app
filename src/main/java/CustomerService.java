import exceptions.CustomerNotFoundException;
import exceptions.RoomNotFoundException;

import java.util.UUID;

    public interface CustomerService {
        Customer findCustomer(UUID customerId) throws RoomNotFoundException, CustomerNotFoundException;
        Customer createNewCustomer(String name, double wallet);
    }
