package reprographicsinventorymanager;

import java.util.Date;

/**
 *
 * @author ADDO_a
 */
public class Account {
   private int id;
   private Date dateCreated;
   public String firstName, lastName;
   private String username, password;
   private AccountStatus status = AccountStatus.active;
   private AccountType type;
   
   public enum AccountStatus{
       active,
       disabled
   }
   
   public enum AccountType{
       admin,
       student,
       teachingStaff,
       cookingStaff,
       reprographicsStaff,
       medicalStaff,
       scienceTechnician,
       cleaningStaff,
       other
   }

    public int getId() {
        return id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public String getUsername() {
        return username;
    }

    public Account(int id, Date dateCreated, String username, String password, AccountType type) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.username = username;
        this.password = password;
        this.type = type;
    }
   
   
}
