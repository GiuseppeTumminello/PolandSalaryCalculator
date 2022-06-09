package org.example.enumApproch.Service;

import org.example.enumApproch.DbConnection.HikariCPDataSource;
import org.example.enumApproch.SalaryCalculatorEnum;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AverageSalaryServiceImpl implements AverageSalaryService {
    private final HikariCPDataSource hikariCPDataSource;

    public AverageSalaryServiceImpl() {
        this.hikariCPDataSource = new HikariCPDataSource();

    }

    @Override
    public void save(BigDecimal grossSalary) {
        PreparedStatement preparedStatement;
        try {
            String saveAllDataQuery = "INSERT INTO public.salary_calculator(" +
                    "pension_zus, disability_zus, sickness_zus, total_zus, health, gross_yearly, tax, net_monthly, net_early, gross_monthly)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = hikariCPDataSource.getConnection().prepareStatement(saveAllDataQuery);

            int count = 0;
            for (var value : SalaryCalculatorEnum.values()) {
                count++;
                preparedStatement.setBigDecimal(count, value.getOperator().apply(grossSalary));
            }
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public BigDecimal getById(int id) {
        try {
            PreparedStatement preparedStatement = hikariCPDataSource.getConnection().prepareStatement(
                    "select gross_yearly from salary_statistic where id= '" + id + "'");
            ResultSet resultSet = preparedStatement.executeQuery();
             if (resultSet.next()) return resultSet.getBigDecimal("gross_yearly");
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return null;

    }
}
