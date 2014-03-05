package com.example.pushclient.aidl;
import com.example.pushclient.aidl.IPushServerListener;
import com.example.pushclient.module.mail.MailAccount;
interface IAIDLPushService{
   void registerSMS(String uuid,in String[] phoneNumbers,in IPushServerListener pushServerListener);
   void registerMail(String uuid,in MailAccount mailAccounts,in IPushServerListener pushServerListener);
   void registerNet(String uuid,in IPushServerListener pushServerListener);
   boolean removePushListener(String uuid,in int Type);
   void test();
}