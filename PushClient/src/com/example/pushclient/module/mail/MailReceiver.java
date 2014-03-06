package com.example.pushclient.module.mail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

public class MailReceiver
{
    private final static String TAG="MailReceiver";
    private String user;
    private String pasword;
    private String receiveHost;
    public MailReceiver(String user,String password,String receiveHost)
    {
        this.user=user;
        this.pasword=password;
        this.receiveHost=receiveHost;
    }
    private void ReveiveMail() throws MessagingException{
        Properties properties=new Properties();
        Session session=Session.getDefaultInstance(properties);
        Store store=session.getStore("pop3");
        store.connect(receiveHost,user,pasword);
        Folder folder=store.getFolder("INBOX");
        Message message[]=folder.getMessages();
        ArrayList<HashMap<String, String>> messageLists=new ArrayList<HashMap<String,String>>();
        for(int i=0;i<message.length;i++){
        }
    }
    
}
