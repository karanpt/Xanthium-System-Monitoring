import java.io.*;
import java.util.*;
import java.net.*;
import java.sql.*;
class nets
{
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
static final String DB_URL = "jdbc:mysql://localhost:3306/Project";
static final String USER = "root";
static final String PASS = "root";
public static void main(String args[]) throws IOException
{
int delay = 500;
int period = 15000;
Timer timer9 = new Timer();
timer9.scheduleAtFixedRate(new TimerTask(){
public void run() 
{
try{
ServerSocket ss = new ServerSocket(1626);
Socket s = ss.accept();
int c=1;
int i=0;
int r=0,send=0,t=0;
BufferedReader br = new BufferedReader (new InputStreamReader (s.getInputStream()));
String words[] = new String[1000];
String line= null;
while((line=br.readLine())!=null && c!=0)
{
c=0;
words=line.split(" ");
for(i=1;i<=5;i++)
{
if(words[i].equals(""))
{
continue;
}
else
{
r=Integer.parseInt(words[i]);
System.out.println("Case"+i);
System.out.println(words[i]);
}
}
for(i=46;i<=50;i++)
{
if(words[i].equals(""))
{
continue;
}
else
{
send=Integer.parseInt(words[i]);
System.out.println("Case"+i);
System.out.println(words[i]);
}
}
t=send+r;
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
}
catch (Exception ex)
{
System.out.println("Error "+ex);
}
}
},delay,period);
}
}
