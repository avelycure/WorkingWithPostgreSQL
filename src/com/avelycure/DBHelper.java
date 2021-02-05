package com.avelycure;

import java.util.Date;

public class DBHelper {
    public static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/postgres";
    public static final String JDBC_DRIVER = "org.postgresql.Driver";
    public static final String USER = "postgres";
    public static final String PASSWORD = "root";

    public static String createTable(String name) {
        return "";
    }

    public static String insertBook(String name, String pub_house, String author, String theme) {
        return "INSERT INTO books (book_name, pub_house, author, theme) VALUES ('" + name + "','" + pub_house + "','" + author + "','" + theme + "');";
    }

    public static String insertIssue(long date, long realDate, long returnDate) {
        return "INSERT INTO issues (date, real_return_date, return_date) VALUES ('" + new Date(date) + "','" + new Date(realDate) + "','" + new Date(returnDate) + "');";
    }

    public static String insertReader(String name, String address, String telephone, boolean active, int passportId) {
        return "INSERT INTO readers (reader_name, address, telephone, active, passport_id) VALUES ('" + name + "','" + address + "','" + telephone + "'," + active + "," + passportId + ");";
    }

    public static String selectAll(String tableName) {
        return "SELECT * FROM " + tableName + ";";
    }

    public static String addColumnIdToIssues() {
        return "ALTER TABLE issues ADD COLUMN id serial; ALTER TABLE issues ADD PRIMARY KEY (id);";
    }

    public static String createIntermediateTable() {
        return "CREATE TABLE inter_table (book_id integer, passport_id integer," +
                " PRIMARY KEY (book_id, passport_id), FOREIGN KEY (book_id) REFERENCES books(id)," +
                "FOREIGN KEY(passport_id) REFERENCES readers(passport_id));";
    }


    public static String insertInIterTable(int book_id, int passport_id) {
        return "INSERT INTO inter_table(book_id, passport_id) VALUES(" + book_id + "," + passport_id + ");";
    }

    public static String selectReadersAndTheirBooks(){
        return "SELECT readers.reader_name, books.book_name FROM " +
                "books JOIN inter_table ON(books.id=inter_table.book_id)" +
                "JOIN readers ON(readers.passport_id=inter_table.passport_id);";
    }

    public static String dropTable(String name){
        return "DROP TABLE " + name + ";";
    }

    public static String selectBooksAndIssues(){
        return "SELECT books.book_name, issues.date, issues.return_date FROM " +
                "books FULL JOIN issues ON(books.id=issues.id_book);";
    }
}
