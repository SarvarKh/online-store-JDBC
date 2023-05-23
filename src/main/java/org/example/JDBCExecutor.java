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
            Customer customer = new Customer();
            customer.setFirstName("Sarvar");
            customer.setLastName("Khalimov");
            customer.setEmail("sarvar@khalimov.com");
            customer.setPhone("(555) 555-5555");
            customer.setAddress("1234 Main St");
            customer.setCity("San Francisco");
            customer.setState("CA");
            customer.setZipcode("94102");

            customerDAO.create(customer);
        } catch (SQLException e){
          e.printStackTrace();
        }
    }
}