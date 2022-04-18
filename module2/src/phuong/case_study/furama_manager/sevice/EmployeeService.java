package phuong.case_study.furama_manager.sevice;

import phuong.case_study.furama_manager.model.person.Employee;

public interface EmployeeService extends IService<Employee>{
    void add();
    void display();
    void edit();
    boolean checkIdExists(String id);
}
