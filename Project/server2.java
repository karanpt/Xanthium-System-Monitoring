import java.io.*;
import java.util.*;
import java.net.*;
import java.sql.*;
class server2
{
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
static final String DB_URL = "jdbc:mysql://localhost:3306/Project";
static final String USER = "root";
static final String PASS = "root";
public static void main(String args[]) throws IOException
{
int delay = 500;
int period = 15000;
Timer timer = new Timer();
timer.scheduleAtFixedRate(new TimerTask(){
public void run() 
{
try{
ServerSocket ss = new ServerSocket(1326);
Socket s = ss.accept();

int c=3;
int i=0;
BufferedReader br = new BufferedReader (new InputStreamReader (s.getInputStream()));
String words[] = new String[1000];
String line= null;
while((line=br.readLine())!=null && c!=0)
{
c=c-1;
words=line.split(" ");
}
int r,send,t;
r=Integer.parseInt(words[1]);
send=Integer.parseInt(words[44]);
t=r+send;
s.close();
ss.close();

Connection conn = null;
Statement stmt = null;
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection(DB_URL,USER,PASS);
stmt = conn.createStatement();
String sql ="INSERT INTO NetLoad (NetLoad) VALUES ("+t+")";
stmt.executeUpdate(sql);

}
catch (Exception ex)
{
System.out.println("Error "+ex);
}
}
},delay,period);
}

}
