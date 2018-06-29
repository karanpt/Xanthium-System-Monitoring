import java.io.*;
import java.util.*;
class fileread
{
public static void main(String args[]) throws IOException
{
String filename ="/proc/stat";
String line = null;
String words[] = new String[1000];
int c = 1;
try{
FileReader fr = new FileReader(filename);
BufferedReader br = new BufferedReader (fr);
while((line=br.readLine())!=null && c!=0)
{
c=0;
words = line.split(" ");
}
for (int i=0;i<=11;i++)
{
System.out.println(words[i]);
}
}
catch(Exception e){
System.out.println("Error opening file");
}
}
}
