package model;


public class Orders {

    private String orderIds;
    private String mobileNumber;
    private String sizes;
    private int qty;
    private double amount;
    private int orderStatus;

    public Orders() {
    }

    public Orders(String orderIds, String mobileNumber, String sizes, int qty, double amount, int orderStatus) {
        this.orderIds = orderIds;
        this.mobileNumber = mobileNumber;
        this.sizes = sizes;
        this.qty = qty;
        this.amount = amount;
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
       return orderIds+"-"+mobileNumber+"-"+sizes+"-"+qty+"-"+amount+"-"+orderStatus;
    }

    public String getOrderIds() {
        return orderIds;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getSizes() {
        return sizes;
    }

    public int getQty() {
        return qty;
    }

    public double getAmount() {
        return amount;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }
    
    
}
