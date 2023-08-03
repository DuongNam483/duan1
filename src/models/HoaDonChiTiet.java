/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author duong
 */
public class HoaDonChiTiet {
    private int id;
    private int idHD;
    private int idCTD;
    private int soLuong;
    private double donGia;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int id, int idHD, int idCTD, int soLuong, double donGia) {
        this.id = id;
        this.idHD = idHD;
        this.idCTD = idCTD;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHD() {
        return idHD;
    }

    public void setIdHD(int idHD) {
        this.idHD = idHD;
    }

    public int getIdCTD() {
        return idCTD;
    }

    public void setIdCTD(int idCTD) {
        this.idCTD = idCTD;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    
}
