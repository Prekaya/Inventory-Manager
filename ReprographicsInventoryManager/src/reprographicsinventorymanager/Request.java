package reprographicsinventorymanager;

import java.util.Date;
import java.util.Map;

/**
 * This is a class to represent a request from a user
 * @author ADDO_a
 */
public class Request {
    private int id, senderId;
    public Status status = Status.newRequest;
    private RequestType type;
    private MaintenanceType maintenanceType;
    public int invoiceID;
    public String metadata;
    private Date dueDate;
    private String purpose, patron;
    
    public String getPatron() {
        return patron;
    }
    
    
    public enum Status {
        newRequest,
        workInPorgress,
        completed,
        declined    
    }
    
    public enum RequestType {
        supplyRequest,
        maintenanceRequest
    }
    
        
    public enum MaintenanceType {
        hostel,
        college, 
        staffResidence,
        other
    }
    
    public Request(int id, int senderID, RequestType type, String purpose, String patron){
        this.id = id;
        this.senderId = senderID;
        this.type = type;
        this.purpose = purpose;
        this.patron = patron;
    }

    public int getId() {
        return id;
    }

    public int getSenderId() {
        return senderId;
    }

    public RequestType getType() {
        return type;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public String getPurpose() {
        return purpose;
    }
}
