package com.example.pushclient.module.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

import com.example.pushclient.module.base.BasePushMessageChannel;

import android.util.Log;

public class PushConnector extends Thread{
	private static final String TAG="PushConnector";
  private static final String HOST = "192.168.1.103";  
  private static final int PORT = 9999;  
  private Socket socket = null;  
  private InputStream in = null;  
  private OutputStream out = null;
  private boolean isActive=false;
  private String content = "";  
  public PushConnector(){
  }
  @Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		isActive=true;
		while(isActive){
			try {
				socket = new Socket(HOST, PORT);
				in=socket.getInputStream();
				out=socket.getOutputStream();
				byte[] buffer=new byte[1024*4];
				int index=0;
				while((index=in.read(buffer))!=-1){
					System.out.println(new String(buffer,0,index));
				}
				Log.i(TAG,"hello");
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		}
	}
  public void writeDate(String data){
	  if(out!=null){
		  try {
			out.write(data.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
  }
  public void stopConnect(){
	  try {
		isActive=false;
		in.close();
		out.close();
		socket.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
}
