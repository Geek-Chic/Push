package com.example.pushclient.aidl;
import com.example.pushclient.util.PushMessage;
interface IPushServerListener{
  void onPushMessage(out PushMessage pushMessage);
}
