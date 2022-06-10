package org.example.enumApproch.service;

import org.example.enumApproch.SalaryCalculatorEnum;
import org.example.enumApproch.dbConnection.HikariCPDataSource;
import org.example.enumApproch.entity.JobTitle;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JobTitleServiceImpl implements JobTitleService {
    private final HikariCPDataSource hikariCPDataSource;
    private final Connection connection ;


    public JobTitleServiceImpl() {
        this.hikariCPDataSource = new HikariCPDataSource();
        this.connection = hikariCPDataSource.getConnection();


    }

    @Override
    public int save(BigDecimal grossSalary) {
        PreparedStatement preparedStatement;
        try {
            String saveAllDataQuery = "INSERT INTO public.salary_calculator(" +
                    "pension_zus, disability_zus, sickness_zus, total_zus, health, gross_yearly, tax, net_monthly, net_early, gross_monthly) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id";
            preparedStatement = connection.prepareStatement(saveAllDataQuery);

            int count = 0;
            for (var value : SalaryCalculatorEnum.values()) {
                count++;
                preparedStatement.setBigDecimal(count, value.getOperator().apply(grossSalary));
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) return resultSet.getInt("id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    @Override
    public JobTitle getJobTitleById(int id) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select * from salary_statistic where id= '" + id + "'");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) return new JobTitle(resultSet.getInt("id"), resultSet.getString("job_title"), resultSet.getBigDecimal("gross_yearly"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }




    @Override
    public BigDecimal getAverageByJobTile(String jobTitle) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select avg(gross_monthly) from salary_calculator where job_title= '" + jobTitle + "'");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getBigDecimal("avg");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateJobTitle(int id, String jobTitle) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE public.salary_calculator SET job_title=? where id=" + id);
            preparedStatement.setString(1, jobTitle);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
}
