/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author duong
 */
public class ChiTietDep {
    private int id;
    private int idDep;
    private int idLoaiDep;
    private int idMauSac;
    private int idNSX;
    private int idChatLieu;
    private int idSize;
    private String ma;
    private int soLuong;
    private String moTa;
    private Double giaNhap;
    private Double giaBan;

    public ChiTietDep() {
    }

    public ChiTietDep(int id, int idDep, int idLoaiDep, int idMauSac, int idNSX, int idChatLieu, int idSize, String ma, int soLuong, String moTa, Double giaNhap, Double giaBan) {
        this.id = id;
        this.idDep = idDep;
        this.idLoaiDep = idLoaiDep;
        this.idMauSac = idMauSac;
        this.idNSX = idNSX;
        this.idChatLieu = idChatLieu;
        this.idSize = idSize;
        this.ma = ma;
        this.soLuong = soLuong;
        this.moTa = moTa;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDep() {
        return idDep;
    }

    public void setIdDep(int idDep) {
        this.idDep = idDep;
    }

    public int getIdLoaiDep() {
        return idLoaiDep;
    }

    public void setIdLoaiDep(int idLoaiDep) {
        this.idLoaiDep = idLoaiDep;
    }

    public int getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(int idMauSac) {
        this.idMauSac = idMauSac;
    }

    public int getIdNSX() {
        return idNSX;
    }

    public void setIdNSX(int idNSX) {
        this.idNSX = idNSX;
    }

    public int getIdChatLieu() {
        return idChatLieu;
    }

    public void setIdChatLieu(int idChatLieu) {
        this.idChatLieu = idChatLieu;
    }

    public int getIdSize() {
        return idSize;
    }

    public void setIdSize(int idSize) {
        this.idSize = idSize;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }

   
    
}
