package phuong.case_study.furama_manager.common;

public class RegexService {
    private final static String REGEX_SERVICE_ID_VILLA = "^SVVL\\-[0-9]{4}$";
    private final static String REGEX_SERVICE_ID_HOUSE = "^SVHO\\-[0-9]{4}$";
    private final static String REGEX_SERVICE_ID_ROOM = "^SVRO\\-[0-9]{4}$";

    private final static String REGEX_SERVICE_NAME = "^[A-Z][a-z]{0,}$";

    private final static String REGEX_AREA = "^((([3-9][0-9])|([1-9][0-9][0-9]+))\\.[0-9]{1,})$";

    private final static String REGEX_RENTAL_COSTS = "^([1-9]+)\\.[0-9]{1,}$";

    private final static String REGEX_MAXIMUM_PEOPLE = "^(([1-9])|[1][0-9])$";

    private final static String REGEX_FLOORS_NUMBER = "^([1-9]|[1-9][0-9]+)$";

    public static boolean checkServiceIdVilla(String serviceId) {
        return serviceId.matches(REGEX_SERVICE_ID_VILLA);
    }

    public static boolean checkServiceIdHouse(String serviceId) {
        return serviceId.matches(REGEX_SERVICE_ID_HOUSE);
    }

    public static boolean checkServiceIdRoom(String serviceId) {
        return serviceId.matches(REGEX_SERVICE_ID_ROOM);
    }

    public static boolean checkServiceName(String serviceName) {
        return serviceName.matches(REGEX_SERVICE_NAME);
    }

    public static boolean checkArea(String area) {
        return area.matches(REGEX_AREA);
    }

    public static boolean checkRentalCosts(String rentalCosts) {
        return rentalCosts.matches(REGEX_RENTAL_COSTS);
    }

    public static boolean checkMaximumPeople(String maximumPeople) {
        return maximumPeople.matches(REGEX_MAXIMUM_PEOPLE);
    }

    public static boolean checkFloorsNumber(String floorsNumber) {
        return floorsNumber.matches(REGEX_FLOORS_NUMBER);
    }
}
