import java.io.*;
import java.util.*;

public class timer{
public static  void main (String args[]) throws Exception {
int delay = 500;
int period = 1000;
Timer timer = new Timer();
timer.scheduleAtFixedRate(new TimerTask(){
public void run()
{
System.out.println("doing");
}
},delay,period);
}
}
