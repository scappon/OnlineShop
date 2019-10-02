package springxml.services;

public class ErrorLog implements Logging {
    public void writeToLog(String s){
        System.out.println("ERROR in: " + s);
    }
}
