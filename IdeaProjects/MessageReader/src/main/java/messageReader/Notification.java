package messageReader;


import java.util.Date;
import java.util.Map;

public class Notification {

    private Map<String, String> messageDetails;
    private Date timeStamp;
    private boolean isActive;
    private String endProcessingTime;

    public Notification(Map<String, String> messageDetails) {
        this.messageDetails = messageDetails;
        timeStamp = new Date();
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Map<String, String> getMessageDetails() {
        return messageDetails;
    }

    public void setMessageDetails(Map<String, String> messageDetails) {
        this.messageDetails = messageDetails;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getEndProcessingTime() {
        return endProcessingTime;
    }

    public void setEndProcessingTime(String endProcessingTime) {
        this.endProcessingTime = endProcessingTime;
    }
}
