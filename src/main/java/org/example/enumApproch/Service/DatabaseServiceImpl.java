package org.example.enumApproch.Service;

import org.example.enumApproch.DbConnection.HikariCPDataSource;
import org.example.enumApproch.SalaryCalculatorEnum;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DatabaseServiceImpl implements DatabaseService {
    private final HikariCPDataSource hikariCPDataSource;

    private final String saveAllDataQuery = "INSERT INTO public.salary_calculator(" +
            "pension_zus, disability_zus, sickness_zus, total_zus, health, gross_yearly, tax, net_monthly, net_early, gross_monthly)" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public DatabaseServiceImpl() {
        this.hikariCPDataSource = new HikariCPDataSource();


    }

    @Override
    public void save(BigDecimal grossSalary) {
        PreparedStatement preparedStatement;
        try {
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
    public BigDecimal getDataByJobTitle(String jobTitle, String position) {
        try {
            PreparedStatement preparedStatement = hikariCPDataSource.getConnection().prepareStatement("select gross_yearly from salary_statistic where job_title= '" + jobTitle + "' and position= '" + position +"'");
            ResultSet resultSet = preparedStatement.executeQuery();
             if (resultSet.next()) return resultSet.getBigDecimal("gross_yearly");
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return null;

    }
}
