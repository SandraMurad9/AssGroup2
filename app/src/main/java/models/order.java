package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class order implements Serializable {
    private Item item;
    private String chosenColor;
    private int chosenSize;
    private int chosenQuantity;

    public static final ArrayList<order> orders = new ArrayList<order>();

    public order() {
    }

    public order(Item item, String chosenColor, int chosenSize, int chosenQuantity) {
        this.item = item;
        this.chosenColor = chosenColor;
        this.chosenSize = chosenSize;
        this.chosenQuantity = chosenQuantity;
    }

    public order(Item item, int quantities) {
        this.item = item;

        this.chosenQuantity = chosenQuantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getChosenColor() {
        return chosenColor;
    }

    public void setChosenColor(String chosenColor) {
        this.chosenColor = chosenColor;
    }

    public int getChosenSize() {
        return chosenSize;
    }

    public void setChosenSize(int chosenSize) {
        this.chosenSize = chosenSize;
    }

    public int getChosenQuantity() {
        return chosenQuantity;
    }

    public void setChosenQuantity(int chosenQuantity) {
        this.chosenQuantity = chosenQuantity;
    }

    public static ArrayList<order> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return "order{" +
                "item name=" + item.getName() +

                ", chosenQuantity=" + chosenQuantity +
                '}';
    }

    public double CalculateTotal() {
        double totalPrice = 0;
        for (int i = 0; i < orders.size(); i++) {
            totalPrice += orders.get(i).item.getPrice() * (orders.get(i).chosenQuantity);
        }
        return totalPrice;
    }

    public double tax(){
        double total = CalculateTotal();
        double tax ;
        tax = total * (0.14);
        return tax;
    }

    public double totalwithtax(){
        double total = CalculateTotal();
        double tax = tax();
        double totalTax = total + tax;
        return totalTax;
    }

}