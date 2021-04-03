package main.java.pojo;

public class CustomerDetailsDBpojo {

    private String courseName;
    private String purchaseDate;
    private int amount;
    private String Location;

    public int getAmount() {
        return amount;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getLocation() {
        return Location;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

}
