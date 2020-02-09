package enteties;

import java.util.Date;
 
public class Purchase{
    
    private String username, amount, purchaseId, teaId;
    private Date date;

    public Purchase(String purchaseId, String teaId, String username, String amount, Date date){
        this.purchaseId = purchaseId;
        this.teaId = teaId;
        this.username = username;
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getTeaId() {
        return teaId;
    }

    public void setTeaId(String teaId) {
        this.teaId = teaId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
