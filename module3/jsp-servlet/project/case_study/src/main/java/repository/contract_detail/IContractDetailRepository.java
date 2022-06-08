package repository.contract_detail;

import model.contract_detail.AttachService;
import model.contract_detail.ContractDetail;

import java.util.List;

public interface IContractDetailRepository {
    List<ContractDetail> getAllContractDetailIsActive();

    List<AttachService> getAllAttachService();

    void saveContractDetail(ContractDetail contractDetail);

    void deleteContractDetail(int idDelete);

    ContractDetail getContractDetail(int idEdit);

    void editContractDetail(ContractDetail contractDetail);

    List<ContractDetail> getAllContractDetail();

    List<ContractDetail> searchContractDetail(String contractDetailSearchValue);
}
