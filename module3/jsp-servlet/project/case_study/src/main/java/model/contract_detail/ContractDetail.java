package model.contract_detail;

public class ContractDetail {
    private Integer contractDetailId;
    private Integer contractId;
    private Integer attachServiceId;
    private Integer quantity;
    private Integer status;

    public ContractDetail() {
    }

    public ContractDetail(Integer contractId, Integer attachServiceId, Integer quantity) {
        this.contractId = contractId;
        this.attachServiceId = attachServiceId;
        this.quantity = quantity;
    }

    public ContractDetail(Integer contractDetailId, Integer contractId, Integer attachServiceId, Integer quantity, Integer status) {
        this.contractDetailId = contractDetailId;
        this.contractId = contractId;
        this.attachServiceId = attachServiceId;
        this.quantity = quantity;
        this.status = status;
    }

    public Integer getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Integer contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Integer getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(Integer attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ContactDetail{" +
                "contactDetailId=" + contractDetailId +
                ", contactId=" + contractId +
                ", AttachServiceId=" + attachServiceId +
                ", quantity=" + quantity +
                ", status=" + status +
                '}';
    }
}
