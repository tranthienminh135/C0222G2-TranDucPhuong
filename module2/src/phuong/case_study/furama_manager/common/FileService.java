package phuong.case_study.furama_manager.common;

import phuong.case_study.furama_manager.model.booking.Booking;
import phuong.case_study.furama_manager.model.booking.Contract;
import phuong.case_study.furama_manager.model.facility.House;
import phuong.case_study.furama_manager.model.facility.Room;
import phuong.case_study.furama_manager.model.facility.Villa;
import phuong.case_study.furama_manager.model.person.Customer;
import phuong.case_study.furama_manager.model.person.Employee;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FileService {
    private final static String COMMA = ",";
    private final static String PATTERN = "dd-MM-yyyy";
    private static SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN);


    /**
     * Write to file
     */
    private static void writeToFile(String pathFile, List<String> list) {
        try {
            FileWriter fileWriter = new FileWriter(pathFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String line = null;
            for (String s : list) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void writeEmployee(String pathFile, List<Employee> employees) {
        List<String> list = new ArrayList<>();

        for (Employee e : employees) {
            list.add(e.convertLine());
        }

        writeToFile(pathFile, list);
    }

    public static void writeCustomer(String pathFile, List<Customer> customers) {
        List<String> list = new ArrayList<>();

        for (Customer c : customers) {
            list.add(c.convertLine());
        }

        writeToFile(pathFile, list);
    }

    public static void writeVilla(String pathFile, List<Villa> villas) {
        List<String> list = new ArrayList<>();

        for (Villa v : villas) {
            list.add(v.convertLine());
        }

        writeToFile(pathFile, list);
    }
    public static void writeHouse(String pathFile, List<House> houses) {
        List<String> list = new ArrayList<>();

        for (House h : houses) {
            list.add(h.convertLine());
        }

        writeToFile(pathFile, list);
    }
    public static void writeRoom(String pathFile, List<Room> rooms) {
        List<String> list = new ArrayList<>();

        for (Room r : rooms) {
            list.add(r.convertLine());
        }

        writeToFile(pathFile, list);
    }

    public static void writeBooking(String pathFile, Set<Booking> bookings) {
        List<String> list = new ArrayList<>();

        for (Booking b : bookings) {
            list.add(b.convertLine());
        }

        writeToFile(pathFile, list);
    }

    public static void writeContract(String pathFile, List<Contract> contracts) {
        List<String> list = new ArrayList<>();

        for (Contract c : contracts) {
            list.add(c.convertLine());
        }

        writeToFile(pathFile, list);
    }

    /**
     * Read from file
     */
    public static List<Employee> readListEmployeeFromFile(String pathFile) {
        List<Employee> employees = new ArrayList<>();
        String[] lines = null;
        try {
            FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                lines = line.split(COMMA);

                Date date = null;
            try {
                date = dateFormat.parse(lines[2]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            employees.add(new Employee(lines[0], lines[1], date, lines[3], Long.parseLong(lines[4]), Long.parseLong(lines[5]), lines[6], lines[7], lines[8], Double.parseDouble(lines[9])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public static List<Customer> readListCustomerFromFile(String pathFile) {
        List<Customer> customers = new ArrayList<>();
        String[] lines = null;
        try {
            FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                lines = line.split(COMMA);

                Date date = null;
                try {
                    date = dateFormat.parse(lines[2]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                customers.add(new Customer(lines[0], lines[1], date, lines[3], Long.parseLong(lines[4]), Long.parseLong(lines[5]), lines[6], lines[7], lines[8]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public static List<Villa> readListVillaFromFile(String pathFile) {
        List<Villa> villas = new ArrayList<>();
        String[] lines = null;
        try {
            FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                lines = line.split(COMMA);

                villas.add(new Villa(lines[0], Double.parseDouble(lines[1]), Double.parseDouble(lines[2]), Integer.parseInt(lines[3]), lines[4], lines[5], lines[6], Double.parseDouble(lines[7]), Integer.parseInt(lines[8])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return villas;
    }
    public static List<House> readListHouseFromFile(String pathFile) {
        List<House> houses = new ArrayList<>();
        String[] lines = null;
        try {
            FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                lines = line.split(COMMA);

                houses.add(new House(lines[0], Double.parseDouble(lines[1]), Double.parseDouble(lines[2]), Integer.parseInt(lines[3]), lines[4], lines[5], lines[6], Integer.parseInt(lines[7])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return houses;
    }
    public static List<Room> readListRoomFromFile(String pathFile) {
        List<Room> rooms = new ArrayList<>();
        String[] lines = null;
        try {
            FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                lines = line.split(COMMA);

                rooms.add(new Room(lines[0], Double.parseDouble(lines[1]), Double.parseDouble(lines[2]), Integer.parseInt(lines[3]), lines[4], lines[5], lines[6]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rooms;
    }
    public static Set<Booking> readListBookingFromFile(String pathFile) {
        Set<Booking> bookingSet = new TreeSet<>();
        String[] lines = null;
        try {
            FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                lines = line.split(COMMA);

                Date dateStart = null;
                Date dateEnd = null;
                try {
                    dateStart = dateFormat.parse(lines[1]);
                    dateEnd = dateFormat.parse(lines[2]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                bookingSet.add(new Booking(lines[0], dateStart, dateEnd, lines[3], lines[4], lines[5]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookingSet;
    }
    public static List<Contract> readListContractFromFile(String pathFile) {
        List<Contract> contracts = new ArrayList<>();
        String[] lines = null;
        try {
            FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                lines = line.split(COMMA);

                contracts.add(new Contract(lines[0], lines[1], Long.parseLong(lines[2]), Long.parseLong(lines[3]), lines[4]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contracts;
    }
}
