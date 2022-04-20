package phuong.case_study.furama_manager.sevice;

public interface CustomerService extends IService{
    void add();
    void display();
    void edit();
    boolean checkIdExists(String id);
}
