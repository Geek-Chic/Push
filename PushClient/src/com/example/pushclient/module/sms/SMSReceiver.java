package com.example.pushclient.module.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class SMSReceiver extends BroadcastReceiver {
	private final static String TAG="SMSReceiver";
    public final static String SMS_ACTION="android.provider.Telephony.SMS_RECEIVED";
    private OnPushMessageLinstener mOnMessageLinstener;
    public void addPushMessageLinstener(OnPushMessageLinstener onPushMessageLinstener){
        this.mOnMessageLinstener=onPushMessageLinstener;
    }
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Log.e(TAG, "有消息来了");
		if(intent.getAction().equals(SMS_ACTION)){
			StringBuilder body=new StringBuilder();
			StringBuilder number=new StringBuilder();
			Bundle bundle=intent.getExtras();
			if(bundle!=null){
				Object[] pdus=(Object[]) bundle.get("pdus");
			    SmsMessage[] smsMessages=new SmsMessage[pdus.length];
			    for(int i=0;i<pdus.length;i++){
			    	smsMessages[i]=SmsMessage.createFromPdu((byte[]) pdus[i]);
			    }
			    for(SmsMessage tempMessage:smsMessages){
			    	body.append(tempMessage.getDisplayMessageBody());
			    	number.append(tempMessage.getDisplayOriginatingAddress());
			    }
			    String smsBody=body.toString();
			    String smsNumber=number.toString();
			    if(smsNumber.contains("+86")){
			    	smsNumber=smsNumber.substring(3);
			    }
			    Log.e(TAG, smsNumber+":"+smsBody);
			    if(mOnMessageLinstener!=null){
			        this.mOnMessageLinstener.onMessageGet(0,smsBody);
			    }
//			    this.abortBroadcast();
			}
		}
	}
    public interface OnPushMessageLinstener{
        public void onMessageGet(int msgType,String message);
    }
}
