package phuong.case_study.furama_manager.model.booking;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking implements Comparable<Booking> {
    private final static String COMMA = ",";
    private final static String PATTERN = "dd-MM-yyyy";
    private static SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN);
    private String bookingId;
    private Date dateStart;
    private Date dateEnd;
    private String customerID;
    private String serviceName;
    private String serviceId;

    public Booking() {
    }

    public Booking(String bookingId, Date dateStart, Date dateEnd, String customerID, String serviceName, String serviceId) {
        this.bookingId = bookingId;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.customerID = customerID;
        this.serviceName = serviceName;
        this.serviceId = serviceId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String convertLine() {
        String line = this.bookingId + COMMA + dateFormat.format(this.dateStart) + COMMA + dateFormat.format(this.dateEnd) + COMMA + this.customerID + COMMA + serviceName + COMMA + serviceId;
        return line;
    }

    @Override
    public String toString() {
        return "Booking {" +
                "idBooking = '" + bookingId + '\'' +
                ", dateStart = " + dateFormat.format(dateStart) +
                ", dateEnd = " + dateFormat.format(dateEnd) +
                ", customerID = '" + customerID + '\'' +
                ", serviceName = '" + serviceName + '\'' +
                ", serviceId = '" + serviceId + '\'' +
                '}';
    }

    @Override
    public int compareTo(Booking o) {
        if (o.getDateStart().getTime() - this.getDateStart().getTime() > 0) {
            return -1;
        } else if (o.getDateStart().getTime() - this.getDateStart().getTime() < 0) {
            return 1;
        } else {
            if (o.getDateEnd().getTime() - this.getDateEnd().getTime() > 0) {
                return -1;
            } else if (o.getDateEnd().getTime() - this.getDateEnd().getTime() < 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
