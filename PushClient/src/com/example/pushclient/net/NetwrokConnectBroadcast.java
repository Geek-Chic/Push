package com.example.pushclient.net;

import com.example.pushclient.util.NetworkProber;

import android.app.Notification.Action;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;

public class NetwrokConnectBroadcast extends BroadcastReceiver{

	private final static String NETWORK_STATE_ACTION="android.net.conn.CONNECTIVITY_CHANGE";
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		 String action=intent.getAction();
		 System.out.println("收到广播"+action);
		if(action.equals(ConnectivityManager.CONNECTIVITY_ACTION)){
			if(NetworkProber.isNetworkAvailable(context)){
				System.out.println("网络连接正常");
			}else {
				System.out.println("网络连接不正常");
			}
		}
		}
		
	

}
