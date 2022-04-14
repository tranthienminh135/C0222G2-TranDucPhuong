package my_crud_project;

import java.util.Scanner;

public class OfficeStaffManager {
    OfficeStaff[] officeStaffs = new OfficeStaff[100];
    {
        OfficeStaff officeStaff = new OfficeStaff();
    }

    public void add() {
        OfficeStaff officeStaff = new OfficeStaff();
        officeStaff.input();

        for (int i = 0; i < officeStaffs.length; i++) {
            if (officeStaffs[i] == null) {
                officeStaff.setId(i);
                officeStaffs[i] = officeStaff;
                break;
            }
        }
    }

    public void display() {
        for (int i = 0; i < officeStaffs.length; i++) {
            if (officeStaffs[i] != null) {
                System.out.println(officeStaffs[i].output());
            } else {
                continue;
            }
        }
    }

    public void edit() {
        boolean flag = false;
        System.out.print("Enter id element for edit: ");
        int id = Integer.parseInt((new Scanner(System.in).nextLine()));
        for (int i = 0; i < officeStaffs.length; i++) {
            if (officeStaffs[i] != null && officeStaffs[i].getId() == id) {
                officeStaffs[i].input();
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("ID " + id + " not found!");
        }
    }

    public void delete() {
        System.out.print("Enter id element for edit: ");
        int id = Integer.parseInt((new Scanner(System.in).nextLine()));

        for (int i = 0; i < officeStaffs.length - 1; i++) {
            if (officeStaffs[i] != null) {
                if(officeStaffs[i].getId() == id) {
                    officeStaffs[i] = null;
                    return;
                }
            }
        }
    }

    public void search() {
        boolean flag = false;
        System.out.print("Enter name for search: ");
        String nameSearch = (new Scanner(System.in)).nextLine();
        OfficeStaff[] os = new OfficeStaff[100];

        for (int i = 0; i < officeStaffs.length; i++) {
            if (officeStaffs[i] != null) {
                if (officeStaffs[i].getName().equalsIgnoreCase(nameSearch)) {
                    flag = true;
                    break;
                }
            }
        }

        if (flag) {
            for (int i = 0; i < officeStaffs.length; i++) {
                if (officeStaffs[i] != null) {
                    if (officeStaffs[i].getName().equalsIgnoreCase(nameSearch)) {
                        if (os[i] == null) {
                            os[i] = officeStaffs[i];
                        }
                    }
                }
            }
            for (int i = 0; i < os.length; i++) {
                if (os[i] != null) {
                    System.out.println(os[i].output());
                }
            }
        } else {
            System.out.println(nameSearch + " not found!");
        }
    }
}
