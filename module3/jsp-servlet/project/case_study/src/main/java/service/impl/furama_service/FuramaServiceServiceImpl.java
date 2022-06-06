package service.impl.furama_service;

import model.service.RentType;
import model.service.Service;
import model.service.ServiceType;
import repository.impl.service.ServiceRepositoryImpl;
import repository.service.IServiceRepository;
import service.furama_service.IFuramaServiceService;

import java.util.List;

public class FuramaServiceServiceImpl implements IFuramaServiceService {
    private IServiceRepository serviceRepository = new ServiceRepositoryImpl();
    @Override
    public List<RentType> getAllRentType() {
        return serviceRepository.getAllRentType();
    }

    @Override
    public List<ServiceType> getAllServiceType() {
        return serviceRepository.getAllServiceType();
    }

    @Override
    public List<Service> getAllServiceIsActive() {
        return serviceRepository.getAllServiceIsActive();
    }

    @Override
    public void saveService(Service service) {
        serviceRepository.saveService(service);
    }

    @Override
    public void deleteService(int idDelete) {
        serviceRepository.deleteService(idDelete);
    }

    @Override
    public List<Service> getAllService() {
        return serviceRepository.getAllService();
    }

    @Override
    public Service getServiceForEdit(int idEdit) {
        return serviceRepository.getServiceForEdit(idEdit);
    }

    @Override
    public void editService(Service service) {
        serviceRepository.editService(service);
    }

    @Override
    public List<Service> findServiceByName(String searchValue) {
        return serviceRepository.findServiceByName(searchValue);
    }
}
