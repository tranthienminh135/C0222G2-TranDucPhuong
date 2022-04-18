package phuong.case_study.furama_manager.view;

import phuong.case_study.furama_manager.controllers.FuramaController;

public class FuramaView {
    public static void main(String[] args) {
        FuramaController furamaController = new FuramaController();
        furamaController.displayMainMenu();
    }
}
