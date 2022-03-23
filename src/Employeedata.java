import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Employeedata {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int option;
        while(true){
            System.out.println("Select an option :");
            System.out.println("1. Add employee data ");
            System.out.println("2. View all employee data ");
            System.out.println("3. Exit ");
            option = in.nextInt();
            switch (option){
                case 1 :
                    try {
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/companydb?autoReconnect=true&useSSL=false", "root", "");
                        String empCode, name, phone, email, designation, salary, companyname, address;
                        System.out.println("Enter the code :");
                        empCode = in.next();
                        System.out.println("Enter the name :");
                        name = in.next();
                        System.out.println("Enter the phone number :");
                        phone = in.next();
                        System.out.println("Enter email :");
                        email = in.next();
                        System.out.println("Enter the designation :");
                        designation = in.next();
                        System.out.println("Enter the salary :");
                        salary = in.next();
                        System.out.println("Enter the company name :");
                        companyname = in.next();
                        System.out.println("Enter the address :");
                        address = in.next();
                        Statement stmt = c.createStatement();
                        stmt.executeUpdate("INSERT INTO `employee`( `empcode`, `name`, `phone`, `email`, `designation`, `salary`, `company name`, `address`) " +
                                "VALUES("+empCode+",'"+name+"',"+phone+",'"+email+"','"+designation+"',"+salary+",'"+companyname+"','"+address+"')");
                        System.out.println("Inserted sucessfully");

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 2 :
                    System.out.println("View all details ");
                    try {
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/companydb?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT `id`, `empcode`, `name`, `phone`, `email`, `designation`, `salary`, `company name`, `address` FROM `employee` WHERE 1");
                        while (rs.next()){
                            System.out.println("empcode = "+rs.getInt("empcode"));
                            System.out.println("name =" +rs.getString("name"));
                            System.out.println("phone =" + rs.getBigDecimal("phone"));
                            System.out.println("email = "+ rs.getString("email"));
                            System.out.println("designation ="+ rs.getString("designation"));
                            System.out.println("salary = "+ rs.getInt("salary"));
                            System.out.println("companyname ="+rs.getString("company name"));
                            System.out.println("address = " +rs.getString("address"));
                        }



                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }

    }
}
