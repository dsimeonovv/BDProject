package com.libraries.server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;


public class ClientThread extends Thread {
	Socket sock;
	PrintStream out;
	Scanner in;
	
	public ClientThread(Socket s) throws IOException{
		this.sock = s;
		out = new PrintStream(s.getOutputStream());
		in = new Scanner(s.getInputStream());
	}
	
	public void run(){
		System.out.println("ad");
	}
}
