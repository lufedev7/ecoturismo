package com.acapa.ecoturismo.dtos;
import java.util.Date;
public class ErrorDetails {
    private Date timeStamp;
    private String messague;
    private String details;
    public ErrorDetails(Date timeStamp, String messague, String details) {
        this.timeStamp = timeStamp;
        this.messague = messague;
        this.details = details;
    }
    public Date getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
    public String getMessague() {
        return messague;
    }
    public void setMessague(String messague) {
        this.messague = messague;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }

}
