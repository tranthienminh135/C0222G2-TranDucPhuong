package service.impl.contract_detail;

import model.contract_detail.AttachService;
import model.contract_detail.ContractDetail;
import repository.contract_detail.IContractDetailRepository;
import repository.impl.contract_detail.ContractDetailRepository;
import service.contract_detail.IContractDetailService;

import java.util.List;

public class ContractDetailServiceImpl implements IContractDetailService {
    private IContractDetailRepository contractDetailRepository = new ContractDetailRepository();

    @Override
    public List<ContractDetail> getAllContractDetailIdActive() {
        return contractDetailRepository.getAllContractDetailIsActive();
    }

    @Override
    public List<AttachService> getAllAttachService() {
        return contractDetailRepository.getAllAttachService();
    }

    @Override
    public void saveContractDetail(ContractDetail contractDetail) {
        contractDetailRepository.saveContractDetail(contractDetail);
    }

    @Override
    public void deleteContractDetail(int idDelete) {
        contractDetailRepository.deleteContractDetail(idDelete);
    }

    @Override
    public ContractDetail getContractDetail(int idEdit) {
        return contractDetailRepository.getContractDetail(idEdit);
    }

    @Override
    public void editContractDetail(ContractDetail contractDetail) {
        contractDetailRepository.editContractDetail(contractDetail);
    }

    @Override
    public List<ContractDetail> getAllContractDetail() {
        return contractDetailRepository.getAllContractDetail();
    }

    @Override
    public List<ContractDetail> searchContractDetail(String contractDetailSearchValue) {
        return contractDetailRepository.searchContractDetail(contractDetailSearchValue);
    }
}
