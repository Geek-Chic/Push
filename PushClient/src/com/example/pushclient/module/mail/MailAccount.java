package com.example.pushclient.module.mail;

import com.example.pushclient.util.PushMessage;

import android.os.Parcel;
import android.os.Parcelable;

public class MailAccount implements Parcelable
{
    private String mailAddress;
    private String mailPassword;
    private String receiverServer;
    private String sendServer;
    public MailAccount(Parcel account){
        this.mailAddress=account.readString();
        this.mailPassword=account.readString();
        this.receiverServer=account.readString();
        this.sendServer=account.readString();
    }
    @Override
    public int describeContents()
    {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(mailAddress);
        dest.writeString(mailPassword);
        dest.writeString(receiverServer);
        dest.writeString(sendServer);
    }
    public final static Parcelable.Creator<MailAccount> CREATOR=new Parcelable.Creator<MailAccount>() {

        @Override
        public MailAccount createFromParcel(Parcel source) {
            // TODO Auto-generated method stub
            return new MailAccount(source);
        }

        @Override
        public MailAccount[] newArray(int size) {
            // TODO Auto-generated method stub
            return new MailAccount[size];
        }
    };
}
