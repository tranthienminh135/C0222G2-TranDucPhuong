package phuong.case_study.furama_manager.sevice;

import phuong.case_study.furama_manager.model.person.Person;

public interface IPeronService extends IService<Person> {
    void add();
    void display();
    void edit();
}
