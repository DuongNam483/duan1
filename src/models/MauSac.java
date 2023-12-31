/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author duong
 */
public class MauSac {
    private int id;
    private String ma;
    private String mauSac;

    public MauSac() {
    }

    public MauSac(int id, String ma, String mauSac) {
        this.id = id;
        this.ma = ma;
        this.mauSac = mauSac;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }
    
    @Override
    public String toString() {
        return mauSac;
    }
}
