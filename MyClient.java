import java.applet.Applet;
import java.awt.*;
import java.applet.*;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client extends Applet {
  private String s;
  private Color c;
  public void init(){
    setSize(400, 400);
    try{
      Scanner keyboard = new Scanner(System.in);
      InetAddress host = InetAddress.getByName("localhost");
      Socket clientSocket = new Socket(host, 16790);
      BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
  
      color(in.readLine().toLowerCase());
      repaint();
      s = in.readLine();
      setBackground(c);
      
    }catch(Exception e){
      System.out.println("Error: " + e);
      System.exit(0);
    }
  }

  public void paint(Graphics page){
    //Complete this method.
    page.setFont(new Font("Tohoma",2,24));
    page.drawString(s,20,20);

  }
  public void color(String color){
	  if(color.toLowerCase().equals("green"))
		  c = Color.GREEN;
	  else if(color.toLowerCase().equals("blue"))
		  c = Color.BLUE;
  }
}
