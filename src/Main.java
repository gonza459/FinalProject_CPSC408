import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.*;
import java.sql.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception{

        Connection conn;
        DBConnection database = new DBConnection();
        conn = database.getMySqlConnection();

        UserInteraction UI = new UserInteraction();

        boolean go = true;

        UI.Instructions(conn);


    }

}
