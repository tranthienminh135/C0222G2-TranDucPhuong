package repository.service;

import model.service.RentType;
import model.service.Service;
import model.service.ServiceType;

import java.util.List;

public interface IServiceRepository {
    List<RentType> getAllRentType();

    List<ServiceType> getAllServiceType();

    List<Service> getAllServiceIsActive();

    void saveService(Service service);

    void deleteService(int idDelete);

    List<Service> getAllService();

    Service getServiceForEdit(int idEdit);

    void editService(Service service);

    List<Service> findServiceByName(String searchValue);
}
