package com.avelycure;

import java.util.Date;

public class DBHelper {
    public static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/postgres";
    public static final String JDBC_DRIVER = "org.postgresql.Driver";
    public static final String USER = "postgres";
    public static final String PASSWORD = "root";

public static String createTable(String name){
    return "";
}

public static String insertBook(String name, String pub_house, String author, String theme){
    return "INSERT INTO books (name, pub_house, author, theme) VALUES ('" + name +"','"+ pub_house +"','" + author + "','" + theme + "');";
}

public static String insertIssue(long date, long realDate, long returnDate){
    return "INSERT INTO issues (date, real_return_date, return_date) VALUES ('" + new Date(date) +"','" + new Date(realDate) + "','" + new Date(returnDate) + "');";
}

public static String insertReader(String name, String address, String telephone, boolean active, int passportId){
    return "INSERT INTO readers (name, address, telephone, active, passport_id) VALUES ('"+ name+"','" + address +"','" + telephone +"'," + active + ","+ passportId + ");";
}

public static String selectAll(String tableName){
    return "SELECT * FROM " + tableName + ";";
}



}
