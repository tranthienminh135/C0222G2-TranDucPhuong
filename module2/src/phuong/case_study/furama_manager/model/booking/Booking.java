package phuong.case_study.furama_manager.model.booking;

import java.sql.Date;

public class Booking {
    private String idBooking;
    private Date dateStart;
    private Date dateEnd;
    private String customerID;

    public Booking() {
    }

    public Booking(String idBooking, Date dateStart, Date dateEnd, String customerID) {
        this.idBooking = idBooking;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.customerID = customerID;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
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

    @Override
    public String toString() {
        return "Booking {" +
                "idBooking = '" + idBooking + '\'' +
                ", dateStart = " + dateStart +
                ", dateEnd = " + dateEnd +
                ", customerID = '" + customerID + '\'' +
                '}';
    }
}
