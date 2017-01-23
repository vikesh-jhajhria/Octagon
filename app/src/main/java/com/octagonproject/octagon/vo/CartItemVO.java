package com.octagonproject.octagon.vo;

/**
 * Created by Vikesh on 23-01-2017.
 */

public class CartItemVO {

    int _id;
    String _name;
    int _price, _quantity;

    // Empty constructor
    public CartItemVO(){

    }
    // constructor
    public CartItemVO(int id, String name, int price,int quantity){
        this._id = id;
        this._name = name;
        this._price = price;
        this._quantity = quantity;
    }

    // constructor
    public CartItemVO(String name, int price, int quantity){
        this._name = name;
        this._price = price;
        this._quantity = quantity;
    }

    public int getID(){
        return this._id;
    }

    public void setID(int id){
        this._id = id;
    }

    public String getName(){
        return this._name;
    }

    public void setName(String name){
        this._name = name;
    }

    public int getPrice(){
        return this._price;
    }

    public void setPrice(int price){
        this._price = price;
    }

    public int getQuantity(){
        return this._quantity;
    }

    public void setQuantity(int quantity){
        this._quantity = quantity;
    }
}
