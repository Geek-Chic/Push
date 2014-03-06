package com.example.pushclient.module.mail;

public class MailInfo
{
    private String title;
    private String Date;
    private String From;
    private String Content;
    private String receiveHost;
    public MailInfo(){
        
    }
    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public String getDate()
    {
        return Date;
    }
    public void setDate(String date)
    {
        Date = date;
    }
    public String getFrom()
    {
        return From;
    }
    public void setFrom(String from)
    {
        From = from;
    }
    public String getContent()
    {
        return Content;
    }
    public void setContent(String content)
    {
        Content = content;
    }
    public String getReceiveHost()
    {
        return receiveHost;
    }
    public void setReceiveHost(String receiveHost)
    {
        this.receiveHost = receiveHost;
    }
    
    
}
