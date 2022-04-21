package phuong.case_study.furama_manager.model.booking;

import java.sql.Date;

public class Booking {
    private String idBooking;
    private Date dateStart;
    private Date dateEnd;
    private String customerID;
    private String serviceName;
    private String serviceId;

    public Booking() {
    }

    public Booking(String idBooking, Date dateStart, Date dateEnd, String customerID, String serviceName, String serviceId) {
        this.idBooking = idBooking;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.customerID = customerID;
        this.serviceName = serviceName;
        this.serviceId = serviceId;
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

    @Override
    public String toString() {
        return "Booking{" +
                "idBooking='" + idBooking + '\'' +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", customerID='" + customerID + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", serviceId='" + serviceId + '\'' +
                '}';
    }
}
