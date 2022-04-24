package phuong.case_study.furama_manager.sevice.impl;

import phuong.case_study.furama_manager.model.facility.Facility;
import phuong.case_study.furama_manager.model.facility.House;
import phuong.case_study.furama_manager.model.facility.Room;
import phuong.case_study.furama_manager.model.facility.Villa;
import phuong.case_study.furama_manager.sevice.FacilityService;

import java.util.*;

public class FacilityServiceImpl implements FacilityService {
    private static Scanner sc = new Scanner(System.in);
    private static Map<Facility, Integer> facilityMap = new LinkedHashMap<>();
    private static List<Facility> facilities = new ArrayList<>();
    private static List<Facility> maintenancefacilities = new ArrayList<>();

    static {
        Facility house = new House("House", 100D, 100000D,
                5, "Thue theo thang", "Phòng đơn", 1);
        Facility room = new Room("Room", 200D, 200000D,
                5, "Thue theo nam", "free wifi");
        Facility villa = new Villa("Villa", 200D, 300000D,
                5, "Thue theo nam", "Phòng đôi", 100D, 3);
        facilities.add(house);
        facilities.add(room);
        facilities.add(villa);


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
        System.out.print("Enter service name: ");
        String name = sc.nextLine();
        System.out.print("Enter usable area: ");
        double area = Double.parseDouble(sc.nextLine());
        System.out.print("Enter rental costs: ");
        double rentalCosts = Double.parseDouble(sc.nextLine());
        System.out.print("Enter maximum number of people: ");
        int maximumrPeople = Integer.parseInt(sc.nextLine());
        System.out.print("Enter rental type: ");
        String rentalType = sc.nextLine();
        System.out.print("Enter room standard: ");
        String roomStandard = sc.nextLine();
        System.out.print("Enter floors number: ");
        int floors = Integer.parseInt(sc.nextLine());

        Facility house = new House(name, area, rentalCosts, maximumrPeople, rentalType, roomStandard, floors);
        this.add(house);


    }

    @Override
    public void addNewRoomService() {
        System.out.print("Enter service name: ");
        String name = sc.nextLine();
        System.out.print("Enter usable area: ");
        double area = Double.parseDouble(sc.nextLine());
        System.out.print("Enter rental costs: ");
        double rentalCosts = Double.parseDouble(sc.nextLine());
        System.out.print("Enter maximum number of people: ");
        int maximumrPeople = Integer.parseInt(sc.nextLine());
        System.out.print("Enter rental type: ");
        String rentalType = sc.nextLine();
        System.out.print("Enter free service: ");
        String freeService = sc.nextLine();

        Facility room = new Room(name, area, rentalCosts, maximumrPeople, rentalType, freeService);
        this.add(room);

    }

    @Override
    public void addNewVillaService() {
        System.out.print("Enter service name: ");
        String name = sc.nextLine();
        System.out.print("Enter usable area: ");
        double area = Double.parseDouble(sc.nextLine());
        System.out.print("Enter rental costs: ");
        double rentalCosts = Double.parseDouble(sc.nextLine());
        System.out.print("Enter maximum number of people: ");
        int maximumrPeople = Integer.parseInt(sc.nextLine());
        System.out.print("Enter rental type: ");
        String rentalType = sc.nextLine();
        System.out.print("Enter room standard: ");
        String roomStandard = sc.nextLine();
        System.out.print("Enter swimming pool area: ");
        double swimmingPoolArea = Double.parseDouble(sc.nextLine());
        System.out.print("Enter floors number: ");
        int floors = Integer.parseInt(sc.nextLine());
        Facility villa = new Villa(name, area, rentalCosts, maximumrPeople, rentalType, roomStandard, swimmingPoolArea, floors);
        this.add(villa);

    }

    @Override
    public void maintenanceCheck(Facility facility) {
        if (facilityMap.get(facility) >= 5) {
            System.out.println("Service is under maintenance!");
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
    public void displayListFacility() {
        for (Map.Entry<Facility,Integer> entry: facilityMap.entrySet()) {
            System.out.println("Service: " + entry.getKey().getServiceName());
            System.out.println("Number of uses: " + entry.getValue());
        }
    }

    @Override
    public void displayNumberUsedOfService() {
        for (Map.Entry<Facility,Integer> entry: facilityMap.entrySet()) {
            System.out.println("Service: " + entry.getKey().getServiceName());
            System.out.println("Number of used: " + entry.getValue());
        }
    }

    public static List<Facility> getFacilities() {
        return facilities;
    }


}
