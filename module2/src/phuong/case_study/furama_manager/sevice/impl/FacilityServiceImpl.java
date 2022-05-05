package phuong.case_study.furama_manager.sevice.impl;

import phuong.case_study.furama_manager.common.CheckException;
import phuong.case_study.furama_manager.common.FileService;
import phuong.case_study.furama_manager.common.RegexService;
import phuong.case_study.furama_manager.model.facility.Facility;
import phuong.case_study.furama_manager.model.facility.House;
import phuong.case_study.furama_manager.model.facility.Room;
import phuong.case_study.furama_manager.model.facility.Villa;
import phuong.case_study.furama_manager.sevice.FacilityService;

import java.util.*;

public class FacilityServiceImpl implements FacilityService {
    private final static String FILE_NAME_VILLA = "src/phuong/case_study/furama_manager/common/data/villa.csv";
    private final static String FILE_NAME_HOUSE = "src/phuong/case_study/furama_manager/common/data/house.csv";
    private final static String FILE_NAME_ROOM = "src/phuong/case_study/furama_manager/common/data/room.csv";
    private static Scanner sc = new Scanner(System.in);
    private static Map<Facility, Integer> facilityMap = new LinkedHashMap<>();
    private static List<Facility> facilities = new ArrayList<>();
    private static List<Villa> villas = new ArrayList<>();
    private static List<House> houses = new ArrayList<>();
    private static List<Room> rooms = new ArrayList<>();
    private static List<Facility> maintenancefacilities = new ArrayList<>();

    static {
        House house = new House("House", 100D, 100000D,
                5, "Thue theo thang", "SVHO-1234", "Phòng đơn", 1);
        Room room = new Room("Room", 200D, 200000D,
                5, "Thue theo nam", "SVRO-4576", "free wifi");
        Villa villa = new Villa("Villa", 200D, 300000D,
                5, "Thue theo nam", "SVVL-7895", "Phòng đôi", 100D, 3);
        houses.add(house);
        facilities.add(house);
        rooms.add(room);
        facilities.add(room);
        villas.add(villa);
        facilities.add(villa);

        FileService.writeVilla(FILE_NAME_VILLA, villas);
        FileService.writeHouse(FILE_NAME_HOUSE, houses);
        FileService.writeRoom(FILE_NAME_ROOM, rooms);

        facilityMap.put(house, 1);
        facilityMap.put(room, 1);
        facilityMap.put(villa, 1);
    }

    @Override
    public void add(Facility facility) {
        Set<Facility> facilityKey = facilityMap.keySet();

        if (facilityMap.isEmpty()) {
            facilityMap.put(facility, 1);
        } else {
            boolean flag = true;
            for (Facility key : facilityKey) {
                if (facility.equals(key)) {
                    maintenanceCheck(key);
                    facilityMap.put(key, facilityMap.get(key) + 1);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                facilityMap.put(facility, 1);
            }
        }
    }

    @Override
    public void addNewHouseService() {
        houses = FileService.readListHouseFromFile(FILE_NAME_HOUSE);
        System.out.print("Enter service name: ");
        String name = sc.nextLine();
        while (!RegexService.checkServiceName(name)) {
            System.out.print("Enter service name again: ");
            name = sc.nextLine();
        }
        System.out.print("Enter usable area: ");
        double area = 0;
            area = CheckException.checkExForParseDouble(area);
        while (!RegexService.checkArea(String.valueOf(area))) {
            System.out.print("Enter usable area: ");
            area = CheckException.checkExForParseDouble(area);
        }
        System.out.print("Enter rental costs: ");
        double rentalCosts = 0;
        rentalCosts = CheckException.checkExForParseDouble(rentalCosts);
        while (!RegexService.checkRentalCosts(String.valueOf(rentalCosts))) {
            System.out.print("Enter rental costs again: ");
            rentalCosts = CheckException.checkExForParseDouble(rentalCosts);
        }
        System.out.print("Enter maximum number of people: ");
        int maximumPeople = 0;
        maximumPeople = CheckException.checkExForParseInt(maximumPeople);
        while (!RegexService.checkMaximumPeople(String.valueOf(maximumPeople))){
            System.out.print("Enter maximum number of people again: ");
            maximumPeople = CheckException.checkExForParseInt(maximumPeople);
        }
        System.out.print("Enter rental type: ");
        String rentalType = sc.nextLine();
        while (!RegexService.checkServiceName(rentalType)) {
            System.out.print("Enter rental type again: ");
            rentalType = sc.nextLine();
        }
        System.out.print("Enter room standard: ");
        String roomStandard = sc.nextLine();
        while (!RegexService.checkServiceName(roomStandard)) {
            System.out.print("Enter room standard again: ");
            roomStandard = sc.nextLine();
        }
        System.out.print("Enter floors number: ");
        int floors = 0;
        floors = CheckException.checkExForParseInt(floors);
        while (!RegexService.checkFloorsNumber(String.valueOf(floors))) {
            System.out.print("Enter floors number again: ");
            floors = CheckException.checkExForParseInt(floors);
        }
        System.out.print("Enter service id: ");
        String serviceId = sc.nextLine();
        while (!RegexService.checkServiceIdHouse(serviceId)) {
            System.out.print("Enter service id again: ");
            serviceId = sc.nextLine();
        }

        House house = new House(name, area, rentalCosts, maximumPeople, rentalType, serviceId, roomStandard, floors);
        houses.add(house);
        FileService.writeHouse(FILE_NAME_HOUSE, houses);
        this.add(house);
    }

    @Override
    public void addNewRoomService() {
        rooms = FileService.readListRoomFromFile(FILE_NAME_ROOM);
        System.out.print("Enter service name: ");
        String name = sc.nextLine();
        while (!RegexService.checkServiceName(name)) {
            System.out.print("Enter service name again: ");
            name = sc.nextLine();
        }
        System.out.print("Enter usable area: ");
        double area = 0;
        area = CheckException.checkExForParseDouble(area);
        while (!RegexService.checkArea(String.valueOf(area))) {
            System.out.print("Enter usable area again: ");
            area = CheckException.checkExForParseDouble(area);
        }
        System.out.print("Enter rental costs: ");
        double rentalCosts = 0;
        rentalCosts = CheckException.checkExForParseDouble(rentalCosts);
        while (!RegexService.checkRentalCosts(String.valueOf(rentalCosts))) {
            System.out.print("Enter rental costs again: ");
            rentalCosts = CheckException.checkExForParseDouble(rentalCosts);
        }
        System.out.print("Enter maximum number of people: ");
        int maximumPeople = 0;
        maximumPeople = CheckException.checkExForParseInt(maximumPeople);
        while (!RegexService.checkMaximumPeople(String.valueOf(maximumPeople))){
            System.out.print("Enter maximum number of people again: ");
            maximumPeople = CheckException.checkExForParseInt(maximumPeople);
        }
        System.out.print("Enter rental type: ");
        String rentalType = sc.nextLine();
        while (!RegexService.checkServiceName(rentalType)) {
            System.out.print("Enter rental type again: ");
            rentalType = sc.nextLine();
        }
        System.out.print("Enter free service: ");
        String freeService = sc.nextLine();
        System.out.print("Enter service id: ");
        String serviceId = sc.nextLine();
        while (!RegexService.checkServiceIdRoom(serviceId)) {
            System.out.print("Enter service id again: ");
            serviceId = sc.nextLine();
        }

        Room room = new Room(name, area, rentalCosts, maximumPeople, rentalType, serviceId, freeService);
        rooms.add(room);
        FileService.writeRoom(FILE_NAME_ROOM,rooms);
        this.add(room);

    }

    @Override
    public void addNewVillaService() {
        villas = FileService.readListVillaFromFile(FILE_NAME_VILLA);
        System.out.print("Enter service name: ");
        String name = sc.nextLine();
        while (!RegexService.checkServiceName(name)) {
            System.out.print("Enter service name again: ");
            name = sc.nextLine();
        }
        System.out.print("Enter usable area: ");
        double area = 0;
        area = CheckException.checkExForParseDouble(area);
        while (!RegexService.checkArea(String.valueOf(area))) {
            System.out.print("Enter usable area again: ");
            area = CheckException.checkExForParseDouble(area);
        }
        System.out.print("Enter rental costs: ");
        double rentalCosts = 0;
        rentalCosts = CheckException.checkExForParseDouble(rentalCosts);
        while (!RegexService.checkRentalCosts(String.valueOf(rentalCosts))) {
            System.out.print("Enter rental costs again: ");
            rentalCosts = CheckException.checkExForParseDouble(rentalCosts);
        }
        System.out.print("Enter maximum number of people: ");
        int maximumPeople = 0;
        maximumPeople = CheckException.checkExForParseInt(maximumPeople);
        while (!RegexService.checkMaximumPeople(String.valueOf(maximumPeople))){
            System.out.print("Enter maximum number of people again: ");
            maximumPeople = CheckException.checkExForParseInt(maximumPeople);
        }
        System.out.print("Enter rental type: ");
        String rentalType = sc.nextLine();
        while (!RegexService.checkServiceName(rentalType)) {
            System.out.print("Enter rental type again: ");
            rentalType = sc.nextLine();
        }
        System.out.print("Enter room standard: ");
        String roomStandard = sc.nextLine();
        while (!RegexService.checkServiceName(roomStandard)) {
            System.out.print("Enter room standard again: ");
            roomStandard = sc.nextLine();
        }
        System.out.print("Enter swimming pool area: ");
        double swimmingPoolArea = 0;
        swimmingPoolArea = CheckException.checkExForParseDouble(swimmingPoolArea);
        while (!RegexService.checkArea(String.valueOf(swimmingPoolArea))) {
            System.out.print("Enter swimming pool area again: ");
            swimmingPoolArea = CheckException.checkExForParseDouble(swimmingPoolArea);
        }
        System.out.print("Enter floors number: ");
        int floors = 0;
        floors = CheckException.checkExForParseInt(floors);
        while (!RegexService.checkFloorsNumber(String.valueOf(floors))) {
            System.out.print("Enter floors number again: ");
            floors = CheckException.checkExForParseInt(floors);
        }
        System.out.print("Enter service id: ");
        String serviceId = sc.nextLine();
        while (!RegexService.checkServiceIdVilla(serviceId)) {
            System.out.print("Enter service id again: ");
            serviceId = sc.nextLine();
        }

        Villa villa = new Villa(name, area, rentalCosts, maximumPeople, rentalType, serviceId, roomStandard, swimmingPoolArea, floors);
        villas.add(villa);
        FileService.writeVilla(FILE_NAME_VILLA,villas);
        this.add(villa);

    }

    @Override
    public void maintenanceCheck(Facility facility) {
        if (facilityMap.get(facility) >= 5) {
            System.err.println("Service is under maintenance!");
            maintenancefacilities.add(facility);
            facilityMap.put(facility, 0);
        }
    }

    @Override
    public void displayMaintenance() {
        if (!maintenancefacilities.isEmpty()) {
            for (Facility facility : maintenancefacilities) {
                System.out.println(facility);
            }
        } else {
            System.err.println("Maintenance facilities is empty!");
        }

    }

    @Override
    public void displayNumberUsedOfService() {
        for (Map.Entry<Facility, Integer> entry : facilityMap.entrySet()) {
            System.out.println("Service: " + entry.getKey().getServiceName());
            System.out.println("Number of used: " + entry.getValue());
        }
    }

    public static List<Facility> getFacilities() {
        return facilities;
    }


}
