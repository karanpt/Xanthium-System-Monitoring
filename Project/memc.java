import java.io.*;
import java.util.*;
import java.net.*;
class memc
{
public static void main(String args[]) throws IOException
{
int delay = 500;
int period = 15000;

Timer timer2 = new Timer();
timer2.scheduleAtFixedRate(new TimerTask(){
public void run()
{
try{
Socket s = new Socket("localhost",1326);

String filename ="/proc/meminfo";
String line = null;
String word[]= new String [1000];
int c = 2;
int i=0;
PrintStream pr = new PrintStream(s.getOutputStream());
try{
FileReader fr = new FileReader(filename);
BufferedReader br = new BufferedReader (fr);
while((line=br.readLine())!=null && c!=0)
{
c=c-1;
word[i]=line;
i=i+1;
}
pr.println(word[0]);
pr.println(word[1]);
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
