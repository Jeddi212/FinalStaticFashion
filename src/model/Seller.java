package model;

import java.util.ArrayList;

public class Seller extends Member{
    String storeName;
    ArrayList<Product> listProducts = new ArrayList<>();

    public Seller() {
    }

    public Seller(String username, String password, String gender, String email, int day, int month, int year, String name, String address, double point, ArrayList<Transactions> listTransaction, String storeName, ArrayList<Product> listProducts) {
        super(username, password, gender, email, day, month, year, name, address, point, listTransaction);
        this.storeName = storeName;
        this.listProducts = listProducts;
    }

    private boolean addProduct(Product product) {
        boolean result = false;
        return result;
    }

    private boolean editStoreDiscount(Discount discount) {
        boolean result = false;
        return result;
    }

    private void editStore() {

    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public ArrayList<Product> getListProducts() {
        return listProducts;
    }

    public void setListProducts(ArrayList<Product> listProducts) {
        this.listProducts = listProducts;
    }
}
