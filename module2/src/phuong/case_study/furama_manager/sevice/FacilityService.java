package phuong.case_study.furama_manager.sevice;

import phuong.case_study.furama_manager.model.facility.Facility;

public interface FacilityService extends IService<Facility> {
    void add(Facility facility);

    void addNewHouseService();

    void addNewRoomService();

    void addNewVillaService();

    void maintenanceCheck(Facility facility);

    void displayMaintenance();

    void displayListFacility();

    void displayNumberUsedOfService();
}
