package com.pensar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class ShellCommand {
 
	public static void main(String args[]) {
 
		ShellCommand shell = new ShellCommand();
        System.out.println("Starting..");
		String result = shell.run("service tomcat7 restart");
		System.out.println(result);
       System.out.println("ending");
	}
 
	public String run(String command) {
 
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = null;
		Process p;
 
		try {
			 String[] cmd = {"/bin/bash","-c","echo t@bkids| sudo -S "+command};
			p = Runtime.getRuntime().exec(cmd);
		    System.out.println(p.waitFor());
			reader = new BufferedReader(
				new InputStreamReader(p.getInputStream()));
			String line = "";
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
 
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
 
		return sb.toString();
 
	}
 
}