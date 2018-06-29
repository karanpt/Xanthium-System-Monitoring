import java.io.*;
import java.util.*;
import java.net.*;
import java.sql.*;
class server
{
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
static final String DB_URL = "jdbc:mysql://localhost:3306/Project";
static final String USER = "root";
static final String PASS = "root";
public static void main(String args[]) throws IOException
{
int delay = 500;
int period = 15000;
//client1
Timer timer = new Timer();
timer.scheduleAtFixedRate(new TimerTask(){
public void run() 
{
try{
ServerSocket ss = new ServerSocket(1026);
Socket s = ss.accept();

int c=1;
int i;
BufferedReader br = new BufferedReader (new InputStreamReader (s.getInputStream()));
String words[] = new String[1000];
String line= null;
while((line=br.readLine())!=null && c!=0)
{
c=0;
words = line.split(" ");
}


s.close();
ss.close();

Connection conn = null;
Statement stmt = null;
Scanner sc = new Scanner (System.in);
int sl,sl1,sl2,sl3,sl4,sl5,sl6,sl7,sl8,f,f1,f2,u;
sl1=Integer.parseInt(words[2]);
sl2=Integer.parseInt(words[3]);
sl3=Integer.parseInt(words[4]);
sl4=Integer.parseInt(words[7]);
sl5=Integer.parseInt(words[8]);
sl6=Integer.parseInt(words[9]);
sl7=Integer.parseInt(words[10]);
sl8=Integer.parseInt(words[11]);
f1=Integer.parseInt(words[5]);
f2=Integer.parseInt(words[6]);
f=f1+f2;
sl=sl1+sl2+sl3+sl4+sl5+sl6+sl7+sl8;
u=(sl*100)/(sl+f);
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection(DB_URL,USER,PASS);
stmt = conn.createStatement();
String sql ="INSERT INTO SystemLoad (SystemLoad) VALUES ("+u+")";
stmt.executeUpdate(sql);
}
catch (Exception ex)
{
System.out.println("Error "+ex);
}

}
},delay,period);

////////////////////////////////////////////////////////////
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
s.close();
ss.close();

Connection conn = null;
Statement stmt = null;
int ml,ml1,ml2,u;
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
//////////////////////////////////////////////////////////////////
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
Connection conn = null;
Statement stmt = null;
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection(DB_URL,USER,PASS);
stmt = conn.createStatement();
String sql ="INSERT INTO NetLoad (NetLoad) VALUES ("+t+")";
stmt.executeUpdate(sql);

}
s.close();
ss.close();
}
catch (Exception ex)
{
System.out.println("Error "+ex);
}
}
},delay,period);
//client2
Timer timer2 = new Timer();
timer2.scheduleAtFixedRate(new TimerTask(){
public void run() 
{
try{
ServerSocket ss = new ServerSocket(1027);
Socket s = ss.accept();

int c=1;
int i;
BufferedReader br = new BufferedReader (new InputStreamReader (s.getInputStream()));
String words[] = new String[1000];
String line= null;
while((line=br.readLine())!=null && c!=0)
{
c=0;
words = line.split(" ");
}

s.close();
ss.close();

Connection conn = null;
Statement stmt = null;
Scanner sc = new Scanner (System.in);
int sl,sl1,sl2,sl3,sl4,sl5,sl6,sl7,sl8,f,f1,f2,u;
sl1=Integer.parseInt(words[2]);
sl2=Integer.parseInt(words[3]);
sl3=Integer.parseInt(words[4]);
sl4=Integer.parseInt(words[7]);
sl5=Integer.parseInt(words[8]);
sl6=Integer.parseInt(words[9]);
sl7=Integer.parseInt(words[10]);
sl8=Integer.parseInt(words[11]);
f1=Integer.parseInt(words[5]);
f2=Integer.parseInt(words[6]);
f=f1+f2;
sl=sl1+sl2+sl3+sl4+sl5+sl6+sl7+sl8;
u=(sl*100)/(sl+f);
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection(DB_URL,USER,PASS);
stmt = conn.createStatement();
String sql ="INSERT INTO SystemLoad2 (SystemLoad) VALUES ("+u+")";
stmt.executeUpdate(sql);
}
catch (Exception ex)
{
System.out.println("Error "+ex);
}
}
},delay,period);
///////////////////////////////////////////////////////////////
Timer timer6 = new Timer();
timer6.scheduleAtFixedRate(new TimerTask(){
public void run() 
{
try{
ServerSocket ss = new ServerSocket(1327);
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
s.close();
ss.close();

Connection conn = null;
Statement stmt = null;
int ml,ml1,ml2,u;
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
String sql ="INSERT INTO MemLoad2 (MemLoad) VALUES ("+u+")";
stmt.executeUpdate(sql);

}
catch (Exception ex)
{
System.out.println("Error "+ex);
}
}
},delay,period);
///////////////////////////////////////////////////////////////
Timer timer10 = new Timer();
timer10.scheduleAtFixedRate(new TimerTask(){
public void run() 
{
try{
ServerSocket ss = new ServerSocket(1627);
Socket s = ss.accept();

int c=3;
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
Connection conn = null;
Statement stmt = null;
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection(DB_URL,USER,PASS);
stmt = conn.createStatement();
String sql ="INSERT INTO NetLoad2 (NetLoad) VALUES ("+t+")";
stmt.executeUpdate(sql);

}
s.close();
ss.close();
}
catch (Exception ex)
{
System.out.println("Error "+ex);
}
}
},delay,period);

//client3
Timer timer3 = new Timer();
timer3.scheduleAtFixedRate(new TimerTask(){
public void run() 
{
try{
ServerSocket ss = new ServerSocket(1028);
Socket s = ss.accept();

int c=1;
int i;
BufferedReader br = new BufferedReader (new InputStreamReader (s.getInputStream()));
String words[] = new String[1000];
String line= null;
while((line=br.readLine())!=null && c!=0)
{
c=0;
words = line.split(" ");
}

s.close();
ss.close();

Connection conn = null;
Statement stmt = null;
Scanner sc = new Scanner (System.in);
int sl,sl1,sl2,sl3,sl4,sl5,sl6,sl7,sl8,f,f1,f2,u;
sl1=Integer.parseInt(words[2]);
sl2=Integer.parseInt(words[3]);
sl3=Integer.parseInt(words[4]);
sl4=Integer.parseInt(words[7]);
sl5=Integer.parseInt(words[8]);
sl6=Integer.parseInt(words[9]);
sl7=Integer.parseInt(words[10]);
sl8=Integer.parseInt(words[11]);
f1=Integer.parseInt(words[5]);
f2=Integer.parseInt(words[6]);
f=f1+f2;
sl=sl1+sl2+sl3+sl4+sl5+sl6+sl7+sl8;
u=(sl*100)/(sl+f);
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection(DB_URL,USER,PASS);
stmt = conn.createStatement();
String sql ="INSERT INTO SystemLoad3 (SystemLoad) VALUES ("+u+")";
stmt.executeUpdate(sql);
}
catch (Exception ex)
{
System.out.println("Error "+ex);
}
}
},delay,period);
//////////////////////////////////////////////////////////////////////
Timer timer7 = new Timer();
timer7.scheduleAtFixedRate(new TimerTask(){
public void run() 
{
try{
ServerSocket ss = new ServerSocket(1328);
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
s.close();
ss.close();

Connection conn = null;
Statement stmt = null;
int ml,ml1,ml2,u;
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
String sql ="INSERT INTO MemLoad3 (MemLoad) VALUES ("+u+")";
stmt.executeUpdate(sql);

}
catch (Exception ex)
{
System.out.println("Error "+ex);
}
}
},delay,period);
///////////////////////////////////////////////
Timer timer11 = new Timer();
timer11.scheduleAtFixedRate(new TimerTask(){
public void run() 
{
try{
ServerSocket ss = new ServerSocket(1628);
Socket s = ss.accept();

int c=3;
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
Connection conn = null;
Statement stmt = null;
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection(DB_URL,USER,PASS);
stmt = conn.createStatement();
String sql ="INSERT INTO NetLoad3 (NetLoad) VALUES ("+t+")";
stmt.executeUpdate(sql);

}
s.close();
ss.close();
}
catch (Exception ex)
{
System.out.println("Error "+ex);
}
}
},delay,period);

//client4
Timer timer4 = new Timer();
timer4.scheduleAtFixedRate(new TimerTask(){
public void run() 
{
try{
ServerSocket ss = new ServerSocket(1029);
Socket s = ss.accept();

int c=1;
int i;
BufferedReader br = new BufferedReader (new InputStreamReader (s.getInputStream()));
String words[] = new String[1000];
String line= null;
while((line=br.readLine())!=null && c!=0)
{
c=0;
words = line.split(" ");
}

s.close();
ss.close();

Connection conn = null;
Statement stmt = null;
Scanner sc = new Scanner (System.in);
int sl,sl1,sl2,sl3,sl4,sl5,sl6,sl7,sl8,f,f1,f2,u;
sl1=Integer.parseInt(words[2]);
sl2=Integer.parseInt(words[3]);
sl3=Integer.parseInt(words[4]);
sl4=Integer.parseInt(words[7]);
sl5=Integer.parseInt(words[8]);
sl6=Integer.parseInt(words[9]);
sl7=Integer.parseInt(words[10]);
sl8=Integer.parseInt(words[11]);
f1=Integer.parseInt(words[5]);
f2=Integer.parseInt(words[6]);
f=f1+f2;
sl=sl1+sl2+sl3+sl4+sl5+sl6+sl7+sl8;
u=(sl*100)/(sl+f);
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection(DB_URL,USER,PASS);
stmt = conn.createStatement();
String sql ="INSERT INTO SystemLoad4 (SystemLoad) VALUES ("+u+")";
stmt.executeUpdate(sql);
}
catch (Exception ex)
{
System.out.println("Error "+ex);
}
}
},delay,period);
///////////////////////////////////////////////////////////
Timer timer8 = new Timer();
timer8.scheduleAtFixedRate(new TimerTask(){
public void run() 
{
try{
ServerSocket ss = new ServerSocket(1329);
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
s.close();
ss.close();

Connection conn = null;
Statement stmt = null;
int ml,ml1,ml2,u;
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
String sql ="INSERT INTO MemLoad4 (MemLoad) VALUES ("+u+")";
stmt.executeUpdate(sql);

}
catch (Exception ex)
{
System.out.println("Error "+ex);
}
}
},delay,period);
///////////////////////////////////////////////////////
Timer timer12 = new Timer();
timer12.scheduleAtFixedRate(new TimerTask(){
public void run() 
{
try{
ServerSocket ss = new ServerSocket(1629);
Socket s = ss.accept();

int c=3;
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
Connection conn = null;
Statement stmt = null;
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection(DB_URL,USER,PASS);
stmt = conn.createStatement();
String sql ="INSERT INTO NetLoad4 (NetLoad) VALUES ("+t+")";
stmt.executeUpdate(sql);
}
s.close();
ss.close();
}
catch (Exception ex)
{
System.out.println("Error "+ex);
}
}
},delay,period);

}

}
