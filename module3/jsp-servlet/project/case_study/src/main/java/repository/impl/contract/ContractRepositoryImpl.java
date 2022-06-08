package repository.impl.contract;

import connection.DBConnect;
import model.contract.Contract;
import repository.contract.IContractRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepositoryImpl implements IContractRepository {
    DBConnect dbConnect = new DBConnect();
    private final String SELECT_ALL_CONTRACT_IS_ACTIVE = " select * from `contract` where `status` = 0; ";
    private final String SELECT_ALL_CONTRACT = " select * from `contract` ";
    private final String INSERT_CONTRACT = " INSERT INTO `contract` (`contract_start_date`, `contract_end_date`, `contract_deposit`, `contract_total_money`, `employee_id`, `customer_id`, `service_id`) " +
            " VALUES (?, ?, ?, ?, ?, ?, ?); ";
    private final String DELETE_CONTRACT = " update `contract` set `status` = 1 where `contract_id` = ?; ";
    private final String SELECT_CONTRACT = " select * from `contract` where contract_id = ? ";
    private final String UPDATE_CONTRACT = " UPDATE `contract` " +
            " SET `contract_start_date` = ?, `contract_end_date` = ?, `contract_deposit` = ?, `contract_total_money` = ?, `employee_id` = ?, `customer_id` = ?, `service_id` = ?, `status` = ? " +
            " WHERE (`contract_id` = ?); ";
    private final String SEARCH_CONTRACT_BY_ID = " select * from `contract` where `contract_id` = ?; ";

    @Override
    public List<Contract> getAllContractIdActive() {
        Connection connection = dbConnect.getConnection();
        List<Contract> contracts = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT_IS_ACTIVE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer contractId = resultSet.getInt("contract_id");
                String contractStartDate = resultSet.getString("contract_start_date");
                String contractEndDate = resultSet.getString("contract_end_date");
                Double contractDeposit = resultSet.getDouble("contract_deposit");
                Double contractTotalMoney = resultSet.getDouble("contract_total_money");
                Integer employeeId = resultSet.getInt("employee_id");
                Integer customerId = resultSet.getInt("customer_id");
                Integer serviceId = resultSet.getInt("service_id");
                Integer status = resultSet.getInt("status");
                Contract contract = new Contract(contractId, contractStartDate, contractEndDate, contractDeposit, contractTotalMoney, employeeId, customerId, serviceId, status);
                contracts.add(contract);
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
        return contracts;
    }

    @Override
    public void saveContract(Contract contract) {
        Connection connection = dbConnect.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTRACT);
            preparedStatement.setString(1, contract.getContractStartDate());
            preparedStatement.setString(2, contract.getContractEndDate());
            preparedStatement.setDouble(3, contract.getContractDeposit());
            preparedStatement.setDouble(4, contract.getContractTotalMoney());
            preparedStatement.setInt(5, contract.getEmployeeId());
            preparedStatement.setInt(6, contract.getCustomerId());
            preparedStatement.setInt(7, contract.getServiceId());
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
    public void deleteContract(int idDelete) {
        Connection connection = dbConnect.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CONTRACT);
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
    public Contract getContractById(int idEdit) {
        Contract contract = new Contract();
        Connection connection = dbConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CONTRACT);
            preparedStatement.setInt(1, idEdit);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer contractId = resultSet.getInt("contract_id");
                String contractStartDate = resultSet.getString("contract_start_date");
                String contractEndDate = resultSet.getString("contract_end_date");
                Double contractDeposit = resultSet.getDouble("contract_deposit");
                Double contractTotalMoney = resultSet.getDouble("contract_total_money");
                Integer employeeId = resultSet.getInt("employee_id");
                Integer customerId = resultSet.getInt("customer_id");
                Integer serviceId = resultSet.getInt("service_id");
                Integer status = resultSet.getInt("status");
                contract = new Contract(contractId, contractStartDate, contractEndDate, contractDeposit, contractTotalMoney, employeeId, customerId, serviceId, status);
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

        return contract;
    }

    @Override
    public void updateContract(Contract contract) {
        Connection connection = dbConnect.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CONTRACT);
            preparedStatement.setString(1, contract.getContractStartDate());
            preparedStatement.setString(2, contract.getContractEndDate());
            preparedStatement.setDouble(3, contract.getContractDeposit());
            preparedStatement.setDouble(4, contract.getContractTotalMoney());
            preparedStatement.setInt(5, contract.getEmployeeId());
            preparedStatement.setInt(6, contract.getCustomerId());
            preparedStatement.setInt(7, contract.getServiceId());
            preparedStatement.setInt(8, contract.getStatus());
            preparedStatement.setInt(9, contract.getContractId());
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
    public List<Contract> searchContractById(String contractSearchValue) {
        Connection connection = dbConnect.getConnection();
        List<Contract> contracts = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_CONTRACT_BY_ID);
            preparedStatement.setString(1, contractSearchValue);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer contractId = resultSet.getInt("contract_id");
                String contractStartDate = resultSet.getString("contract_start_date");
                String contractEndDate = resultSet.getString("contract_end_date");
                Double contractDeposit = resultSet.getDouble("contract_deposit");
                Double contractTotalMoney = resultSet.getDouble("contract_total_money");
                Integer employeeId = resultSet.getInt("employee_id");
                Integer customerId = resultSet.getInt("customer_id");
                Integer serviceId = resultSet.getInt("service_id");
                Integer status = resultSet.getInt("status");
                Contract contract = new Contract(contractId, contractStartDate, contractEndDate, contractDeposit, contractTotalMoney, employeeId, customerId, serviceId, status);
                contracts.add(contract);
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
        return contracts;
    }

    @Override
    public List<Contract> getAllContract() {
        Connection connection = dbConnect.getConnection();
        List<Contract> contracts = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer contractId = resultSet.getInt("contract_id");
                String contractStartDate = resultSet.getString("contract_start_date");
                String contractEndDate = resultSet.getString("contract_end_date");
                Double contractDeposit = resultSet.getDouble("contract_deposit");
                Double contractTotalMoney = resultSet.getDouble("contract_total_money");
                Integer employeeId = resultSet.getInt("employee_id");
                Integer customerId = resultSet.getInt("customer_id");
                Integer serviceId = resultSet.getInt("service_id");
                Integer status = resultSet.getInt("status");
                Contract contract = new Contract(contractId, contractStartDate, contractEndDate, contractDeposit, contractTotalMoney, employeeId, customerId, serviceId, status);
                contracts.add(contract);
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
        return contracts;
    }
}
