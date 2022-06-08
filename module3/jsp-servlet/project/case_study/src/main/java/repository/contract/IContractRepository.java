package repository.contract;

import model.contract.Contract;

import java.util.List;

public interface IContractRepository {
    List<Contract> getAllContractIdActive();

    void saveContract(Contract contract);

    void deleteContract(int idDelete);

    Contract getContractById(int idEdit);

    void updateContract(Contract contract);

    List<Contract> searchContractById(String contractSearchValue);

    List<Contract> getAllContract();
}
