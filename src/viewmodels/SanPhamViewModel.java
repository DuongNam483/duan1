/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

/**
 *
 * @author duong
 */
public class SanPhamViewModel {
    private int id;
    private String ma;
    private String dep;
    private String loaiDep;
    private String mauSac;
    private String NSX;
    private String chatLieu;
    private int size;
    private int soLuong;
    private String moTa;
    private Double giaNhap;
    private Double giaBan;

    public SanPhamViewModel() {
    }

    public SanPhamViewModel(int id, String ma, String dep, String loaiDep, String mauSac, String NSX, String chatLieu, int size, int soLuong, String moTa, Double giaNhap, Double giaBan) {
        this.id = id;
        this.ma = ma;
        this.dep = dep;
        this.loaiDep = loaiDep;
        this.mauSac = mauSac;
        this.NSX = NSX;
        this.chatLieu = chatLieu;
        this.size = size;
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

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getLoaiDep() {
        return loaiDep;
    }

    public void setLoaiDep(String loaiDep) {
        this.loaiDep = loaiDep;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getNSX() {
        return NSX;
    }

    public void setNSX(String NSX) {
        this.NSX = NSX;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
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
