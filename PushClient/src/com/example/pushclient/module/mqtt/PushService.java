package com.example.pushclient.module.mqtt;

import com.example.pushclient.aidl.IAIDLPushService;
import com.example.pushclient.aidl.IPushServerListener;
import com.example.pushclient.net.PushConnector;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class PushService extends Service {

	private static final String TAG="PushService";
	private NotificationManager mNotificationManager;
	private IPushServerListener mIPushServerListener;
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		PushConnector pushConnector=new PushConnector();
		pushConnector.start();
		Log.i(TAG,"服务创建进程启动");
	}
	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
		Log.i(TAG, "服务start");
	}
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return mPushBinder;
	}
  private final IAIDLPushService.Stub mPushBinder=new IAIDLPushService.Stub() {
	
	@Override
	public boolean removePushListener() throws RemoteException {
		// TODO Auto-generated method stub
		if(mIPushServerListener!=null){
			mIPushServerListener=null;
		}
		return true;
	}
	
	@Override
	public void addPushListener(IPushServerListener pushServerListener)
			throws RemoteException {
		// TODO Auto-generated method stub
		mIPushServerListener=pushServerListener;
		
	}

	@Override
	public void test() throws RemoteException {
		// TODO Auto-generated method stub
		if(mIPushServerListener!=null){
			mIPushServerListener.onPushMessage(null);
		}
	}
};
	  
 

}
