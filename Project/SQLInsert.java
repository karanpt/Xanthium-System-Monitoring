import java.io.*;
import java.util.*;
import java.sql.*;
public class SQLInsert{
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
static final String DB_URL = "jdbc:mysql://localhost:3306/Project";
static final String USER = "root";
static final String PASS = "root";
public static void main (String args[])
{
try
{
Connection conn = null;
Statement stmt = null;
Scanner sc = new Scanner (System.in);
int sl;
System.out.println("Enter the load");
sl=sc.nextInt();
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection(DB_URL,USER,PASS);
stmt = conn.createStatement();
String sql ="INSERT INTO SystemLoad (SystemLoad) VALUES ("+sl+")";
stmt.executeUpdate(sql);
}
catch (Exception ex)
{
System.out.println("Error "+ex);
}
}
}


//export CLASSPATH=$CLASSPATH:/usr/share/java/mysql-connector-java.jar

