package com.example.pushclient;

import java.net.ServerSocket;

import com.example.pushclient.aidl.IAIDLPushService;
import com.example.pushclient.aidl.IPushServerListener;
import com.example.pushclient.common.NotificationBuilder;
import com.example.pushclient.module.mqtt.PushService;
import com.example.pushclient.util.PushMessage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private final static String TAG="MainActivity";
	private PushService mPushService;
    private IAIDLPushService mIaidlPushService;
    private PushMessageListener mPushMessageListener;
    private Button mStartButton,mStopButton;
    private NotificationBuilder mNotificationBuilder;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}
	private void initView(){
		mStartButton=(Button)findViewById(R.id.push_start);
		mStopButton=(Button)findViewById(R.id.push_stop);
		mStartButton.setOnClickListener(serviceControlListener);
		mStopButton.setOnClickListener(serviceControlListener);
		mPushMessageListener=new PushMessageListener();
		mNotificationBuilder=new NotificationBuilder(this);
	}
    private ServiceConnection mPushConnection=new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			mIaidlPushService=null;
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			mIaidlPushService=IAIDLPushService.Stub.asInterface(service);
			try {
				if(mPushMessageListener!=null)
				mIaidlPushService.addPushListener(mPushMessageListener);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};
	private OnClickListener serviceControlListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(v.getId()==R.id.push_start){
				
			}else if(v.getId()==R.id.push_stop){
//				unbindService(mPushConnection);
				mNotificationBuilder.showDefaultNotification("测试","测试文本");
//				try {
//					mIaidlPushService.test();
//				} catch (RemoteException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
		}
	};
	class PushMessageListener extends IPushServerListener.Stub{

		@Override
		public void onPushMessage(PushMessage pushMessage)
				throws RemoteException {
			// TODO Auto-generated method stub
			Log.i(TAG, "有推送消息了");
		}
		
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Intent intent=new Intent(MainActivity.this,PushService.class);
		 bindService(intent, mPushConnection,Context.BIND_AUTO_CREATE);
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		if(mPushConnection!=null){
			unbindService(mPushConnection);
		}
	}
  
}
