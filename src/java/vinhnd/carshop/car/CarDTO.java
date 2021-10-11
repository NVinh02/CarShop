/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhnd.carshop.car;

/**
 *
 * @author Admin
 */
public class CarDTO {
    private String carID;
    private String carName;
    private int quantity;
    private double price;
    private double sale;
    private String categoryID;
    private boolean status; 

    public CarDTO() {
    }

    public CarDTO(String carID, String carName, int quantity, double price, double sale, String categoryID, boolean status) {
        this.carID = carID;
        this.carName = carName;
        this.quantity = quantity;
        this.price = price;
        this.sale = sale;
        this.categoryID = categoryID;
        this.status = status;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCarID() {
        return carID;
    }

    public String getCarName() {
        return carName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getSale() {
        return sale;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public boolean isStatus() {
        return status;
    }
    
}
