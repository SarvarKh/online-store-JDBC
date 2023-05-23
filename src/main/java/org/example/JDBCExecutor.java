package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExecutor {
    public static void main(String[] args) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost:5432",
                "postgres", "postgres", "password");

        try {
            Connection connection = dcm.getConnection();
            CustomerDAO customerDAO = new CustomerDAO(connection);
            Customer customer = customerDAO.findById(1000);
            System.out.println(customer.getId() + " " + customer.getFirstName() + " " + customer.getEmail());
            customer.setEmail("changedAgain@mail.com");
            customer = customerDAO.update(customer);
            System.out.println(customer.getId() + " " + customer.getFirstName() + " " + customer.getEmail());
        } catch (SQLException e){
          e.printStackTrace();
        }
    }
}