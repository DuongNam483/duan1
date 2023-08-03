/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import models.HoaDon;
import utility.DBConnection;
import java.sql.*;
import viewmodels.HoaDonViewModel;

/**
 *
 * @author duong
 */
public class HoaDonRepository {
    List<HoaDon> list;
    List<HoaDonViewModel> listHD;
    public HoaDonRepository(){
        list = new ArrayList<>();
    }
    public List<HoaDon> getAll(){
        String sql = "Select * from HoaDon";
        return getSelectBySQL(sql);
    }
    public HoaDon getByMa(String ma){
//        String sql = "Select * from HoaDon where Ma = ?";
        HoaDon hd = null;
        try {
            String sql = "Select * from HoaDon where Ma = ?";
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.execute();

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt(1);
                String maHD = rs.getString(2);
                int idNV  = rs.getInt(3);
                int idKH = rs.getInt(4);
                double tongTien = rs.getDouble(5);
                int trangThai = rs.getInt(6);
                hd = new HoaDon(id, maHD, idNV, idKH, tongTien, trangThai);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hd;
    }
//    public List<HoaDonViewModel> getAllHDVMD(){
//        String sql = "select hd.ID, hd.Ma, kh.Ten, nv.Ten, hd.TongTien, hd.TinhTrang from HoaDon hd, KhachHang kh, NhanVien nv"
//                + " where hd.IdNV = nv.ID and hd.IdKH = kh.ID";
//        return getSelectHDVBySQL(sql);
//    }
    public List<HoaDonViewModel> getAllHDVMD() {
        listHD = new ArrayList<>();
        HoaDonViewModel hdmd = null;
        try {
            String sql = "select hd.ID, hd.Ma, kh.Ten, nv.Ten, hd.TongTien, hd.TinhTrang from HoaDon hd, KhachHang kh, NhanVien nv"
                   + " where hd.IdNV = nv.ID and hd.IdKH = kh.ID";
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.execute();

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt(1);
                String maCTD = rs.getString(2);
                String tenKH = rs.getString(3);
                String tenNV = rs.getString(4);
                double tongTien = rs.getDouble(5);
                int trangThai = rs.getInt(6);
                hdmd = new HoaDonViewModel(id, maCTD, tenKH, tenNV, tongTien, trangThai);
                listHD.add(hdmd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listHD;
    }
    public List<HoaDonViewModel> getHDVMDByTT(int tt) {
        listHD = new ArrayList<>();
        HoaDonViewModel hdmd = null;
        try {
            String sql = "select hd.ID, hd.Ma, kh.Ten, nv.Ten, hd.TongTien, hd.TinhTrang from HoaDon hd, KhachHang kh, NhanVien nv"
                   + " where hd.IdNV = nv.ID and hd.IdKH = kh.ID and hd.TinhTrang = ?";
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, tt);
            ps.execute();

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt(1);
                String maCTD = rs.getString(2);
                String tenKH = rs.getString(3);
                String tenNV = rs.getString(4);
                double tongTien = rs.getDouble(5);
                int trangThai = rs.getInt(6);
                hdmd = new HoaDonViewModel(id, maCTD, tenKH, tenNV, tongTien, trangThai);
                listHD.add(hdmd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listHD;
    }
    
    public boolean add(HoaDon hd){
        String sql = "Insert into HoaDon(Ma, IdNV, IdKH, TongTien, TinhTrang) values(?,?,?,?,?)";
        String sql2 = "Insert into HoaDon(Ma, IdNV, IdKH, TinhTrang) values(?,?,?,?)";
        try {
            if(hd.getTongTien() == 0){
                System.out.println("nam");
                DBConnection.ExcuteUpdate(sql2, hd.getMa(), hd.getIdNV(), hd.getIdKH(), hd.getTrangThai());
            }else{
                
                DBConnection.ExcuteUpdate(sql, hd.getMa(), hd.getIdNV(), hd.getIdKH(), hd.getTongTien(), hd.getTrangThai());
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean update(HoaDon hd){
        String sql = "update HoaDon set Ma = ?, IdNV = ?, IdKH = ?, IdKM = ?, TongTien = ?, TinhTrang = ? where ID = ?";
        try {
            DBConnection.ExcuteUpdate(sql, hd.getMa(), hd.getIdNV(), hd.getIdKH(), hd.getTongTien(), hd.getTrangThai(), hd.getId());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean updateStatus(double tongTien, int tt, int id){
        String sql = "update HoaDon set TongTien = ?, TinhTrang = ? where ID = ?";
        try {
            DBConnection.ExcuteUpdate(sql,tongTien, tt , id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean delete(int id){
        String sql = "Delete from HoaDon where id = ?";
        try {
            DBConnection.ExcuteUpdate(sql, id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public List<HoaDon> getSelectBySQL(String sql, Object ... args){
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, args);
            while(rs.next()){
                list.add(new HoaDon(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getDouble(5), rs.getInt(6)));
            }
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
    }
    public List<HoaDonViewModel> getSelectHDVBySQL(String sql, Object ... args){
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, args);
            while(rs.next()){
                listHD.add(new HoaDonViewModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6)));
            }
            return listHD;
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
    }
}
