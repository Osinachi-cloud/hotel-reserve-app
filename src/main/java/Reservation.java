import exceptions.RoomNotFoundException;

import java.util.Date;
import java.util.UUID;

public class Reservation {
    private long reservationId;
    private Date dateCheckedIn;
    private Date dateCheckedOut;
    private Room room;
    private Customer customer;

    public Reservation(long reservationId, Date dateCheckedIn, Date dateCheckedOut, Room room, Customer customer) {
        this.reservationId = reservationId;
        this.dateCheckedIn = dateCheckedIn;
        this.dateCheckedOut = dateCheckedOut;
        this.room = room;
        this.customer = customer;
    }

    public long getReservationId() {
        return reservationId;
    }

    public void setReservationId(long reservationId) {
        this.reservationId = reservationId;
    }

    public Date getDateCheckedIn() {
        return dateCheckedIn;
    }

    public void setDateCheckedIn(Date dateCheckedIn) {
        this.dateCheckedIn = dateCheckedIn;
    }

    public Date getDateCheckedOut() {
        return dateCheckedOut;
    }

    public void setDateCheckedOut(Date dateCheckedOut) {
        this.dateCheckedOut = dateCheckedOut;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
