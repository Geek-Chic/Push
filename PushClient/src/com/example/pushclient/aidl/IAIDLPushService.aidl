package com.example.pushclient.aidl;
import com.example.pushclient.aidl.IPushServerListener;
interface IAIDLPushService{
   void addPushListener(in IPushServerListener pushServerListener);
   boolean removePushListener();
   void test();
}