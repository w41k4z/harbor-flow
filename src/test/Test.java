package test;

import java.sql.SQLException;

import connection.AppConnection;

public class Test {
    public static void main(String[] args) throws SQLException {
        System.out.println(new AppConnection().defaultConnection().toString());
    }
}
