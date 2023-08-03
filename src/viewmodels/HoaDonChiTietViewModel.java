/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

/**
 *
 * @author duong
 */
public class HoaDonChiTietViewModel {
    private String maHD;
    private String maSP;
    private int sl;
    private double donGia;

    public HoaDonChiTietViewModel() {
    }

    public HoaDonChiTietViewModel(String maHD, String maSP, int sl, double donGia) {
        this.maHD = maHD;
        this.maSP = maSP;
        this.sl = sl;
        this.donGia = donGia;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    
}
