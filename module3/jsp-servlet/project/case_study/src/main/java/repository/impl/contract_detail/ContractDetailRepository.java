package repository.impl.contract_detail;

import connection.DBConnect;
import model.contract_detail.AttachService;
import model.contract_detail.ContractDetail;
import repository.contract_detail.IContractDetailRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailRepository implements IContractDetailRepository {
    private DBConnect dbConnect = new DBConnect();

    private final String SELECT_ALL_CONTRACT_DETAIL_IS_ACTIVE = " select * from contract_detail where status = 0 ";
    private final String SELECT_ALL_CONTRACT_DETAIL = " select * from contract_detail ";
    private final String SELECT_ALL_ATTACH_SERVICE = " SELECT * FROM attach_service where status = 0; ";
    private final String INSERT_CONTRACT_DETAIL = " INSERT INTO `contract_detail` (`contract_id`, `attach_service_id`, `quantity`) " +
            " VALUES (?, ?, ?); ";
    private final String DELETE_CONTRACT_DETAIL = " update contract_detail " +
            " set status = 1 where contract_detail_id = ?; ";
    private final String SELECT_CONTRACT_DETAIL = " select * from `contract_detail` where contract_detail_id = ? ";
    private final String UPDATE_CONTRACT_DETAIL = " UPDATE `contract_detail` SET `contract_id` = ?, `attach_service_id` = ?, `quantity` = ?, `status` = ? " +
            " WHERE (`contract_detail_id` = ?); ";
    private final String SEARCH_CONTRACT_DETAIL = " select * from contract_detail " +
            " where contract_detail_id = ? ";

    @Override
    public List<ContractDetail> getAllContractDetailIsActive() {
        List<ContractDetail> contractDetails = new ArrayList<>();
        Connection connection = dbConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT_DETAIL_IS_ACTIVE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int contractDetailId = resultSet.getInt("contract_detail_id");
                int contractId = resultSet.getInt("contract_id");
                int attachServiceId = resultSet.getInt("attach_service_id");
                int quantity = resultSet.getInt("quantity");
                int status = resultSet.getInt("status");
                ContractDetail contractDetail = new ContractDetail(contractDetailId, contractId, attachServiceId, quantity, status);
                contractDetails.add(contractDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return contractDetails;
    }

    @Override
    public List<AttachService> getAllAttachService() {
        List<AttachService> attachServices = new ArrayList<>();
        Connection connection = dbConnect.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ATTACH_SERVICE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int attachServiceId = resultSet.getInt("attach_service_id");
                String attachServiceName = resultSet.getString("attach_service_name");
                double attachServiceCost = resultSet.getDouble("attach_service_cost");
                int attachServiceUnit = resultSet.getInt("attach_service_unit");
                String attachServiceStatus = resultSet.getString("attach_service_status");
                int status = resultSet.getInt("status");
                AttachService attachService = new AttachService(attachServiceId, attachServiceName, attachServiceCost, attachServiceUnit, attachServiceStatus, status);
                attachServices.add(attachService);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return attachServices;
    }

    @Override
    public void saveContractDetail(ContractDetail contractDetail) {
        Connection connection = dbConnect.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTRACT_DETAIL);
            preparedStatement.setInt(1, contractDetail.getContractId());
            preparedStatement.setInt(2, contractDetail.getAttachServiceId());
            preparedStatement.setInt(3, contractDetail.getQuantity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteContractDetail(int idDelete) {
        Connection connection = dbConnect.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CONTRACT_DETAIL);
            preparedStatement.setInt(1, idDelete);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public ContractDetail getContractDetail(int idEdit) {
        ContractDetail contractDetail = new ContractDetail();
        Connection connection = dbConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CONTRACT_DETAIL);
            preparedStatement.setInt(1, idEdit);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int contractDetailId = resultSet.getInt("contract_detail_id");
                int contractId = resultSet.getInt("contract_id");
                int attachServiceId = resultSet.getInt("attach_service_id");
                int quantity = resultSet.getInt("quantity");
                int status = resultSet.getInt("status");
                contractDetail = new ContractDetail(contractDetailId, contractId, attachServiceId, quantity, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return contractDetail;
    }

    @Override
    public void editContractDetail(ContractDetail contractDetail) {
        Connection connection = dbConnect.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CONTRACT_DETAIL);
            preparedStatement.setInt(1, contractDetail.getContractId());
            preparedStatement.setInt(2, contractDetail.getAttachServiceId());
            preparedStatement.setInt(3, contractDetail.getQuantity());
            preparedStatement.setInt(4, contractDetail.getStatus());
            preparedStatement.setInt(5, contractDetail.getContractDetailId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<ContractDetail> getAllContractDetail() {
        List<ContractDetail> contractDetails = new ArrayList<>();
        Connection connection = dbConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT_DETAIL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int contractDetailId = resultSet.getInt("contract_detail_id");
                int contractId = resultSet.getInt("contract_id");
                int attachServiceId = resultSet.getInt("attach_service_id");
                int quantity = resultSet.getInt("quantity");
                int status = resultSet.getInt("status");
                ContractDetail contractDetail = new ContractDetail(contractDetailId, contractId, attachServiceId, quantity, status);
                contractDetails.add(contractDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return contractDetails;
    }

    @Override
    public List<ContractDetail> searchContractDetail(String contractDetailSearchValue) {
        List<ContractDetail> contractDetails = new ArrayList<>();
        Connection connection = dbConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_CONTRACT_DETAIL);
            preparedStatement.setString(1, contractDetailSearchValue);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int contractDetailId = resultSet.getInt("contract_detail_id");
                int contractId = resultSet.getInt("contract_id");
                int attachServiceId = resultSet.getInt("attach_service_id");
                int quantity = resultSet.getInt("quantity");
                int status = resultSet.getInt("status");
                ContractDetail contractDetail = new ContractDetail(contractDetailId, contractId, attachServiceId, quantity, status);
                contractDetails.add(contractDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return contractDetails;
    }
}
