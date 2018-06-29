import java.io.*;
import java.util.*;
import java.net.*;
import java.sql.*;
class mems
{
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
static final String DB_URL = "jdbc:mysql://localhost:3306/Project";
static final String USER = "root";
static final String PASS = "root";
public static void main(String args[]) throws IOException
{
int delay = 500;
int period = 15000;
Timer timer5 = new Timer();
timer5.scheduleAtFixedRate(new TimerTask(){
public void run() 
{
try{
ServerSocket ss = new ServerSocket(1326);
Socket s = ss.accept();

int c=2;
int i=0;
BufferedReader br = new BufferedReader (new InputStreamReader (s.getInputStream()));
String words[] = new String[1000];
String words1[] = new String[1000];
String word[]=new String[1000];
String line= null;
while((line=br.readLine())!=null && c!=0)
{
c=c-1;
word[i]=line;
i=i+1;
}
words=word[0].split(" ");
words1=word[1].split(" ");
System.out.println(words[8]);
System.out.println("Words1");
System.out.println(words1[9]);
System.out.println(words1[10]);
System.out.println(words1[11]);
s.close();
ss.close();
Connection conn = null;
Statement stmt = null;
int ml,ml1,ml2,u;
String m;
ml1=Integer.parseInt(words[8]);
if(words1[9].equals("") && words1[10].equals(""))
{
System.out.println(" Case 9 10");
ml2=Integer.parseInt(words1[11]);
}
else if(words1[9].equals(""))
{
System.out.println("Case 9");
ml2=Integer.parseInt(words1[10]);
}
else
{
System.out.println("Case Rest");
ml2=Integer.parseInt(words1[9]);
}
ml=ml1-ml2;
u=(ml*100)/(ml1);
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection(DB_URL,USER,PASS);
stmt = conn.createStatement();
String sql ="INSERT INTO MemLoad (MemLoad) VALUES ("+u+")";
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
