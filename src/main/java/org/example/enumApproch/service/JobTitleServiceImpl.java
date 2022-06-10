package org.example.enumApproch.service;

import org.example.enumApproch.dbConnection.HikariCPDataSource;
import org.example.enumApproch.entity.JobTitle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobTitleServiceImpl implements JobTitleService {
    private final HikariCPDataSource hikariCPDataSource;

    public JobTitleServiceImpl() {
        this.hikariCPDataSource = new HikariCPDataSource();

    }

//    @Override
//    public void save(BigDecimal grossSalary) {
//        PreparedStatement preparedStatement;
//        try {
//            String saveAllDataQuery = "INSERT INTO public.salary_calculator(" +
//                    "pension_zus, disability_zus, sickness_zus, total_zus, health, gross_yearly, tax, net_monthly, net_early, gross_monthly)" +
//                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//            preparedStatement = hikariCPDataSource.getConnection().prepareStatement(saveAllDataQuery);
//
//            int count = 0;
//            for (var value : SalaryCalculatorEnum.values()) {
//                count++;
//                preparedStatement.setBigDecimal(count, value.getOperator().apply(grossSalary));
//            }
//            preparedStatement.execute();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }

    @Override
    public JobTitle getJobTitleById(int id) {

        try {
            PreparedStatement preparedStatement = hikariCPDataSource.getConnection().prepareStatement(
                    "select * from salary_statistic where id= '" + id + "'");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) return new JobTitle(resultSet.getInt("id"), resultSet.getString("job_title"), resultSet.getBigDecimal("gross_yearly"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public List<JobTitle> getJobTitles() {
        List<JobTitle> jobTitleList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = hikariCPDataSource.getConnection().prepareStatement("select * from salary_statistic order by id");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                jobTitleList.add(new JobTitle(resultSet.getInt("id"), resultSet.getString("job_title"), resultSet.getBigDecimal("gross_yearly")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return jobTitleList;

    }
}
