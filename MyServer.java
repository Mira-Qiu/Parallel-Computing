import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MyServer {
  public static void main(String[] args){
    ServerSocket serverSocket = null;
    Scanner keyboard = new Scanner(System.in);
    try {
      serverSocket = new ServerSocket(16790);
      Socket clientSocket = null;
      clientSocket = serverSocket.accept();
      PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
      
      System.out.print("Please Enter a work: Blue, Green, or any other word. ");
      String  color = keyboard.nextLine();
      out.println(color);
      System.out.println("Please enter a message: ");
      String mess = keyboard.nextLine();
      out.println(mess);
      out.close();
      clientSocket.close();
      serverSocket.close();
    } catch (IOException e) {
      System.out.println("Error: " + e);
      System.exit(0);
    }
  }
}
