package springxml.services;


import java.sql.Timestamp;


public class TimeLog implements Logging{
    public void writeToLog(String s){
        Timestamp now = new Timestamp(new java.util.Date().getTime());

        System.out.println(now + " " + s);
    }
}
