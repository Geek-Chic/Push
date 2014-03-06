package com.example.pushclient.module.mail;

public class EmailType {
	private Integer ID = 0;
	private String Value = "";

	public EmailType() {
		ID = 0;
		Value = "";
	}

	public EmailType(Integer _ID, String _Value) {
		ID = _ID;
		Value = _Value;
	}
	public String toString() {
		return Value;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getValue() {
		return Value;
	}

	public void setValue(String value) {
		Value = value;
	}


}
