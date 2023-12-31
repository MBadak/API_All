package pojos.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import pojos.booking.BookingPojo;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingResponsePojo {

    private BookingPojo booking;

    public BookingResponsePojo() {
    }

    public BookingResponsePojo(BookingPojo booking) {

        this.booking = booking;
    }





    public BookingPojo getBooking() {
        return booking;
    }

    public void setBooking(BookingPojo booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "BookingAllPojo{" +
               ", booking=" + booking +
                '}';
    }
}
