/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhnd.carshop.cart;

import java.util.HashMap;
import java.util.Map;
import vinhnd.carshop.car.CarDTO;

/**
 *
 * @author Admin
 */
public class CartDTO {

    private Map<String, CarDTO> cart;

    public CartDTO() {
        cart = new HashMap<>();
    }

    public CartDTO(Map<String, CarDTO> cart) {
        this.cart = cart;
    }

    public Map<String, CarDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, CarDTO> cart) {
        this.cart = cart;
    }

    public boolean add(CarDTO car) {
        boolean check = false;
        if (this.cart == null) {
            this.cart = new HashMap();
        }
        if (this.cart.containsKey(car.getCarID())) {
            int quantity = this.cart.get(car.getCarID()).getQuantity();
            car.setQuantity(quantity + car.getQuantity());
        }
        cart.put(car.getCarID(), car);
        check = true;
        return check;
    }

    public boolean delete(String carID) {
        boolean check = false;
        if (this.cart == null) {
            check = false;
        }
        if (this.cart.containsKey(carID)) {
            this.cart.remove(carID);
            check = true;
        }
        return check;
    }

    public boolean update(String carID, CarDTO car) {
        boolean check = false;
        if (this.cart == null) {
            check = false;
        }
        if (this.cart.containsKey(carID)) {
            this.cart.replace(carID, car);
            check = true;
        }
        return check;
    }
}
