package test;

import java.sql.Time;
import java.sql.Timestamp;

import connection.AppConnection;
import models.*;
import orm.database.connection.DatabaseConnection;
import orm.utilities.Treatment;

public class Test {
    public static void main(String[] args) throws Exception {
        Object[] x = new Object[3];
        System.out.println(x.getClass().getComponentType().getSimpleName());
    }
}
