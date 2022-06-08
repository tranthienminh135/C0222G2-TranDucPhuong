package service.impl.contract;

import model.contract.Contract;
import repository.contract.IContractRepository;
import repository.impl.contract.ContractRepositoryImpl;
import service.contract.IContractService;

import java.util.List;

public class ContractServiceImpl implements IContractService {
    IContractRepository contractRepository = new ContractRepositoryImpl();

    @Override
    public List<Contract> getAllContractIsActive() {
        return contractRepository.getAllContractIdActive();
    }

    @Override
    public void saveContract(Contract contract) {
        contractRepository.saveContract(contract);
    }

    @Override
    public void deleteContract(int idDelete) {
        contractRepository.deleteContract(idDelete);
    }

    @Override
    public Contract getContractById(int idEdit) {
        return contractRepository.getContractById(idEdit);
    }

    @Override
    public void updateContract(Contract contract) {
        contractRepository.updateContract(contract);
    }

    @Override
    public List<Contract> searchContractById(String contractSearchValue) {
        return contractRepository.searchContractById(contractSearchValue);
    }

    @Override
    public List<Contract> getAllContract() {
        return contractRepository.getAllContract();
    }
}
