package com.example.pushclient.module.base;

import java.util.Map;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.pushclient.util.PushMessage;

public abstract class BasePushMessageObserver
{
   protected String uuid;
   protected String[] phoneNumbers;
   protected Map<String,String> mailAccounts;
   public abstract void onMessageNotify(PushMessage pushMessage);
}
