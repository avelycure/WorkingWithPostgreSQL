package com.avelycure;

import java.sql.*;

public class Main {
    private static Connection connection = null;
    private static Statement statement = null;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        //
        DBHelper dbHelper = new DBHelper();
        Class.forName(dbHelper.JDBC_DRIVER);
        connection = DriverManager.getConnection(dbHelper.DATABASE_URL, dbHelper.USER, dbHelper.PASSWORD);
        statement = connection.createStatement();

        //fillBooksTable(dbHelper);
        ResultSet resultSet1 = statement.executeQuery(dbHelper.selectAll("books"));
        printBooksTable(resultSet1);

        //fillIssues(dbHelper);
        ResultSet resultSet2 = statement.executeQuery(dbHelper.selectAll("issues"));
        printIssuesTable(resultSet2);

        //fillReaders(dbHelper);
        ResultSet resultSet3 = statement.executeQuery(dbHelper.selectAll("readers"));
        printReadersTable(resultSet3);

        resultSet1.close();
        resultSet2.close();
        resultSet3.close();
        connection.close();
        statement.close();
    }

    public void fillBooksTable(DBHelper dbHelper) throws SQLException {
        statement.executeUpdate(dbHelper.insertBook("War and Peace", "Drofa", "L.N. Tolstoy", "War"));
        statement.executeUpdate(dbHelper.insertBook("Anna Karenina", "Drofa", "L.N. Tolstoy", "Love"));
        statement.executeUpdate(dbHelper.insertBook("Master and Margarita", "Intuit", "M.A. Bulgakov", "Philosophy"));
        statement.executeUpdate(dbHelper.insertBook("The children of capitan Grant", "Soyuz", "J. Vern", "Adventures"));
        statement.executeUpdate(dbHelper.insertBook("Harry Potter and the philosophers stone", "London tower", "J. Rouling", "Adventures"));
    }

    public static void fillIssues(DBHelper dbHelper) throws SQLException {
        statement.executeUpdate(dbHelper.insertIssue(1212121212121L, 2812121212121L, 2812121212121L));
        statement.executeUpdate(dbHelper.insertIssue(8912121212121L, 9112121212121L, 9412121212121L));
        statement.executeUpdate(dbHelper.insertIssue(4512121212121L, 5512121212121L, 5512121212121L));
        statement.executeUpdate(dbHelper.insertIssue(3300121212121L, 3977121212121L, 3977121212121L));
        statement.executeUpdate(dbHelper.insertIssue(4660121212121L, 5007121212121L, 4907121212121L));
    }

    public static void fillReaders(DBHelper dbHelper) throws SQLException {
        statement.executeUpdate(dbHelper.insertReader("Ivan", "Balashiha", "89164620904", true, 100000));
        statement.executeUpdate(dbHelper.insertReader("John", "London", "192245687", true, 400000));
        statement.executeUpdate(dbHelper.insertReader("Mary", "Moscow", "789554136", true, 700000));
        statement.executeUpdate(dbHelper.insertReader("Carl", "New York", "456897522", true, 789955));
        statement.executeUpdate(dbHelper.insertReader("Tony", "San Francisco", "456897522", true, 987895));
    }

    public static void printBooksTable(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name") + " " + resultSet.getString("pub_house") + " " +
                    resultSet.getString("author") + " " + resultSet.getString("theme"));
        }
    }

    public static void printIssuesTable(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            System.out.println(resultSet.getDate("date") + " " + resultSet.getString("real_return_date") + " " +
                    resultSet.getString("return_date"));
        }
    }

    public static void printReadersTable(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name") + " " + resultSet.getString("address") + " " +
                    resultSet.getString("telephone") + " " + resultSet.getBoolean("active") +" "+ resultSet.getInt("passport_id"));
        }
    }
}
