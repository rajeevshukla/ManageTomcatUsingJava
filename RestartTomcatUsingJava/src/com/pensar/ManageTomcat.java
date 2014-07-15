package com.pensar;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ManageTomcat {

	public static void main(String[] args) {
		
		try {
			Socket socket=new Socket("localhost", 9005);
			 OutputStream outputStream= socket.getOutputStream();
			 PrintWriter printWriter=new PrintWriter(outputStream, true);
			 printWriter.write("RESTART");
             System.out.println("comand executed successfully");
			  printWriter.flush();
			  
			  printWriter.close();
			  socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	 System.out.println(System.getProperty("catalina.base"));
	}
	
}
