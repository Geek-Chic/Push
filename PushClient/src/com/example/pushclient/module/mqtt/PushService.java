package com.example.pushclient.module.mqtt;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.example.pushclient.aidl.IAIDLPushService;
import com.example.pushclient.aidl.IPushServerListener;
import com.example.pushclient.module.mail.MailAccount;
import com.example.pushclient.module.net.PushConnector;
import com.example.pushclient.module.sms.SMSReceiver;
import com.example.pushclient.module.sms.SMSReceiver.OnPushMessageLinstener;

public class PushService extends Service implements OnPushMessageLinstener {

	private static final String TAG="PushService";
	private NotificationManager mNotificationManager;
	private IPushServerListener mIPushServerListener;
	private SMSReceiver mSmsReceiver;
	private PushConnector mPushConnector;
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		initService();
	    registerReceiver();
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
	@Override
	public void onDestroy()
	{
	    // TODO Auto-generated method stub
	    super.onDestroy();
	    unRegisterReceiver();
	}
	private void initService()
    {
	    mSmsReceiver=new SMSReceiver();
	    mSmsReceiver.addPushMessageLinstener(this);
	    mPushConnector=new PushConnector();
        mPushConnector.start();
        
    }
	public void registerReceiver(){
	     IntentFilter fliter = new IntentFilter(); 
         fliter.addAction(SMSReceiver.SMS_ACTION); 
         registerReceiver(mSmsReceiver, fliter); 
         Log.e(TAG, "短信已监听");
	}
	public void unRegisterReceiver(){
	    if(mSmsReceiver!=null){
	        unregisterReceiver(mSmsReceiver);
	    }
	}
  private final IAIDLPushService.Stub mPushBinder=new IAIDLPushService.Stub() {
	
	@Override
	public boolean removePushListener(String uuid,int type) throws RemoteException {
		// TODO Auto-generated method stub
		if(mIPushServerListener!=null){
			mIPushServerListener=null;
		}
		return true;
	}
	
	@Override
	public void test() throws RemoteException {
		// TODO Auto-generated method stub
		if(mIPushServerListener!=null){
			mIPushServerListener.onPushMessage(null);
		}
	}

    @Override
    public void registerSMS(String uuid, String[] phoneNumbers,
            IPushServerListener pushServerListener) throws RemoteException
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void registerMail(String uuid, MailAccount mailAccounts,
            IPushServerListener pushServerListener) throws RemoteException
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void registerNet(String uuid, IPushServerListener pushServerListener)
            throws RemoteException
    {
        // TODO Auto-generated method stub
        
    }


};

@Override
public void onMessageGet(int msgType, String message)
{
    // TODO Auto-generated method stub
    Log.e(TAG, "收到短信"+message);
    
}
	  
 

}
