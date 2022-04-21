package phuong.case_study.furama_manager.sevice;

public interface EmployeeService extends IPeronService {
    boolean checkIdExists(String id);
}
