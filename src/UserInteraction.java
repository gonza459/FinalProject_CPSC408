import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.*;
import java.sql.*;
import java.util.*;

public class UserInteraction{

    Connection conn;
    DBConnection database = new DBConnection();

    List<List<String>> salonArray;
    boolean cont = true;

    SearchDB sD = new SearchDB();
    PopulateDB pop = new PopulateDB();
    UpdateDB u = new UpdateDB();
    DeleteDB d = new DeleteDB();

    Sales s = new Sales();
    DisplayDB dis = new DisplayDB();


    public boolean temp = true;

    UserInteraction(){

    }

    public void Instructions(Connection conn) throws SQLException {
        //conn = database.getMySqlConnection();
        Scanner action = new Scanner(System.in);

        while(temp) {

            System.out.println("Enter the number of the action you would like to perform: " + "\n" +
                    "\n" +
                    "1.Search" + "\n" +
                    "2.Insert a new record" + "\n" +
                    "3.Edit an existing record" + "\n" +
                    "4.Insert a csv of records to import into the tables" + "\n" +
                    "4.Export a csv of your current data" + "\n" +
                    "5.Display a table" + "\n" +
                    "6.Delete a record" + "\n" +
                    "7.Exit" + "\n");

            int response = action.nextInt();
            System.out.println("\n");
            while (cont) {
                switch (response) {
                    case 1: {

                        try {
                            sD.SearchDatabase(conn);
                        } catch (Exception SQLException) {
                            System.out.println("Error!");
                        }

                        break;

                    }
                    case 2: {
                        try {
                            pop.InsertIntoDatabase(conn);
                        } catch (Exception SQLException) {
                            System.out.println("Error!");
                        }

                        break;

                    }
                    case 3: {
                        try {

                            u.UpdateDatabase(conn);

                        } catch (Exception SQLException) {
                            System.out.println("Error!");
                        }

                        break;

                    }
                    case 4: {
                        try {
                            pop.InsertCSVtoDatabase(conn);
                        } catch (Exception SQLException) {
                            System.out.println("Error!");
                        }


                        break;

                    }
                    case 5: {

                        try {
                            dis.DisplayDatabase(conn);
                        } catch (Exception SQLException) {
                            System.out.println("Error!");
                        }

                        break;


                    }
                    case 6: {

                        try {
                            d.DeleteRecord(conn);
                        } catch (Exception SQLException) {
                            System.out.println("Error!");
                        }

                        break;


                    }
                    case 7: {

                        cont = false;
                        System.out.println("Goodbye! :)");
                        temp = false;
                        //conn.closeWriter();
                        System.exit(0);
                       

                    }
                }


            }
        }
    }
}
