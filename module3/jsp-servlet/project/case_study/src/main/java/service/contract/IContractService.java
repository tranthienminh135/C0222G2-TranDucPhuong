package service.contract;

import model.contract.Contract;
import model.contract_detail.ContractDetail;

import java.util.List;

public interface IContractService {
    List<Contract> getAllContractIsActive();

    void saveContract(Contract contract);

    void deleteContract(int idDelete);

    Contract getContractById(int idEdit);

    void updateContract(Contract contract);

    List<Contract> searchContractById(String contractSearchValue);

    List<Contract> getAllContract();
}
