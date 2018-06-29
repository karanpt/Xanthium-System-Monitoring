import java.io.*;
import java.util.*;
import java.net.*;
class client2
{
public static void main(String args[]) throws IOException
{
int delay = 500;
int period = 15000;
Timer timer = new Timer();
timer.scheduleAtFixedRate(new TimerTask(){
public void run()
{
try{
Socket s = new Socket("localhost",1326);

String filename ="/proc/net/dev";
String line = null;
String word[]= new String [1000];
int c = 3;
int i=0;
PrintStream pr = new PrintStream(s.getOutputStream());
try{
FileReader fr = new FileReader(filename);
BufferedReader br = new BufferedReader (fr);
while((line=br.readLine())!=null && c!=0)
{
c=c-1;
}
pr.println(line);
System.out.println(line);
Thread.sleep(1000);
}
catch(Exception e){
System.out.println("Error opening file");
}

s.close();}
catch(Exception e)
{
System.out.println("Error"+e);
}
}
},delay,period);
}
}
