package com.example.pushclient.util;

import android.os.Parcel;
import android.os.Parcelable;

public class PushMessage implements Parcelable {
	//消息类型
	private int pushType;
	//消息内容
	private String content;
	//消息时间期限
	private String limitDate;
	public PushMessage(){}
	public PushMessage(Parcel msgParcel){
		this.pushType=msgParcel.readInt();
		this.content=msgParcel.readString();
		this.limitDate=msgParcel.readString();
	}
	
	public int getPushType() {
		return pushType;
	}

	public void setPushType(int pushType) {
		this.pushType = pushType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLimitDate() {
		return limitDate;
	}

	public void setLimitDate(String limitDate) {
		this.limitDate = limitDate;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeInt(pushType);
		dest.writeString(content);
		dest.writeString(limitDate);
	}
	public final static Parcelable.Creator<PushMessage> CREATOR=new Parcelable.Creator<PushMessage>() {

		@Override
		public PushMessage createFromParcel(Parcel source) {
			// TODO Auto-generated method stub
			return new PushMessage(source);
		}

		@Override
		public PushMessage[] newArray(int size) {
			// TODO Auto-generated method stub
			return new PushMessage[size];
		}
	};
	public void readFromParcel(Parcel _reply) {
		// TODO Auto-generated method stub
		
	}
   
}
