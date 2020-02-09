package enteties;
public class UserPurchase {
    private String username, title, amount, date, img, mProductId;

    private float mTotalPrice;

    public UserPurchase(String username, String title, String img,
                                String amount, float mTotalPrice, String date, String mProductId){
        this.mProductId = mProductId;
        this.username = username;
        this.title = title;
        this.img = img;
        this.amount = amount;
        this.date = date;
        this.mTotalPrice = mTotalPrice;
    }

    public String getmProductId() {
        return mProductId;
    }

    public void setmProductId(String mProductId) {
        this.mProductId = mProductId;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getmTotalPrice() {
        return mTotalPrice;
    }

    public void setmTotalPrice(float mTotalPrice) {
        this.mTotalPrice = mTotalPrice;
    }
    
}
