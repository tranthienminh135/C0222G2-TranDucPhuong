package my_crud_project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OfficeStaffManager officeStaffManager = new OfficeStaffManager();
        boolean flag = true;
        int choice;
        do {
            System.out.println("1. Add");
            System.out.println("2. Display");
            System.out.println("3. Edit");
            System.out.println("4. Delete");
            System.out.println("5. Search");
            System.out.print("Your choice: ");
            choice = (Integer.parseInt((new Scanner(System.in)).nextLine()));
            switch (choice) {
                case 1:
                    officeStaffManager.add();
                    break;
                case 2:
                    officeStaffManager.display();
                    break;
                case 3:
                    officeStaffManager.edit();
                    break;
                case 4:
                    officeStaffManager.delete();
                    break;
                case 5:
                    officeStaffManager.search();
                    break;
                default:
                    flag = false;
                    break;
            }
        }
        while (flag);
    }
}
