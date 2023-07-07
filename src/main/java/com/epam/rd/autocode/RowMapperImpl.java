package com.epam.rd.autocode;


import com.epam.rd.autocode.domain.Employee;
import com.epam.rd.autocode.domain.FullName;
import com.epam.rd.autocode.domain.Position;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class RowMapperImpl implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet resultSet) {
        BigInteger id;
        String firstName;
        String lastName;
        String middleName;
        FullName fullName;
        Position position;
        LocalDate hired;
        BigDecimal salary;
        Employee employee;
       try {
           id = BigInteger.valueOf(resultSet.getInt(1));
           firstName = resultSet.getString(2);
           lastName = resultSet.getString(3);
           middleName = resultSet.getString(4);
           position = Position.valueOf(resultSet.getString(5).toUpperCase());
           hired = resultSet.getDate(7).toLocalDate();
           salary = resultSet.getBigDecimal(8);
           fullName = new FullName(firstName, lastName, middleName);
           employee = new Employee(id, fullName, position, hired, salary);
           return employee;

       }catch (SQLException e){
           e.printStackTrace();
           throw new RuntimeException(e);
       }
    }
}
