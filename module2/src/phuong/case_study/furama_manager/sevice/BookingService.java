package phuong.case_study.furama_manager.sevice;

import phuong.case_study.furama_manager.model.booking.Booking;

public interface BookingService extends IService{
    void addNewBooking();

    void displayListBooking();

    void deleteBooking(Booking b);
}
