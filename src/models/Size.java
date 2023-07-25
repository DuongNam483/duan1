/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author duong
 */
public class Size {
    private int id;
    private String ma;
    private String kichCo;

    public Size() {
    }

    public Size(int id, String ma, String kichCo) {
        this.id = id;
        this.ma = ma;
        this.kichCo = kichCo;
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

    public String getKichCo() {
        return kichCo;
    }

    public void setKichCo(String kichCo) {
        this.kichCo = kichCo;
    }

    @Override
    public String toString() {
        return kichCo;
    }
}
