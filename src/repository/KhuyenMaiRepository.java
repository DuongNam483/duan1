/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import models.KhuyenMai;
import utility.DBConnection;
import java.sql.*;
import java.time.LocalDate;

/**
 *
 * @author duong
 */
public class KhuyenMaiRepository {
    List<KhuyenMai> list;
    public KhuyenMaiRepository(){
        list = new ArrayList<>();
    }
    public List<KhuyenMai> getAll(){
        list = new ArrayList<>();
        KhuyenMai km = null;
        try {
            String sql = "select * from KhuyenMai";
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                int id = rs.getInt("ID");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                int ptg = rs.getInt("PhanTramGiam");
                Date d = rs.getDate("NgayBatDau");
                LocalDate ngBD = d.toLocalDate();
                Date d2 = rs.getDate("NgayKetThuc");
                LocalDate ngKT = d2.toLocalDate();
                String moTa = rs.getString("MoTa");
                int trangThai = rs.getInt("TinhTrang");
                System.out.println(id);
                System.out.println(ma);
                System.out.println(ngKT);
                km = new KhuyenMai(id, ma, ten, ptg, ngBD, ngKT, moTa, trangThai);
                list.add(km);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public KhuyenMai getByMa(String ma){
        KhuyenMai km = null;
        try {
            String sql = "select * from KhuyenMai where Ma = ?";
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.execute();
            
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                int id = rs.getInt(1);
                String maKM = rs.getString(2);
                String ten = rs.getString(3);
                int ptg = rs.getInt(4);
                Date d = rs.getDate(5);
                LocalDate ngBD = d.toLocalDate();
                Date d2 = rs.getDate(6);
                LocalDate ngKT = d.toLocalDate();
                String moTa = rs.getString(7);
                int trangThai = rs.getInt(8);
                km = new KhuyenMai(id, ma, ten, ptg, ngBD, ngKT, moTa, trangThai);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return km;
    }
    public KhuyenMai getByTen(String ten){
        KhuyenMai km = null;
        try {
            String sql = "select * from KhuyenMai where Ten = ?";
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ten);
            ps.execute();
            
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                int id = rs.getInt(1);
                String ma = rs.getString(2);
                String tenKM = rs.getString(3);
                int ptg = rs.getInt(4);
                Date d = rs.getDate(5);
                LocalDate ngBD = d.toLocalDate();
                Date d2 = rs.getDate(6);
                LocalDate ngKT = d.toLocalDate();
                String moTa = rs.getString(7);
                int trangThai = rs.getInt(8);
                km = new KhuyenMai(id, ma, tenKM, ptg, ngBD, ngKT, moTa, trangThai);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return km;
    } 
    public List<KhuyenMai> getByTT(int trangThai){
        KhuyenMai km = null;
        list = new ArrayList<>();
        try {
            String sql = "select * from KhuyenMai where TinhTrang = ?";
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, trangThai);
            ps.execute();
            
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                int id = rs.getInt(1);
                String ma = rs.getString(2);
                String tenKM = rs.getString(3);
                int ptg = rs.getInt(4);
                Date d = rs.getDate(5);
                LocalDate ngBD = d.toLocalDate();
                Date d2 = rs.getDate(6);
                LocalDate ngKT = d.toLocalDate();
                String moTa = rs.getString(7);
                int tt = rs.getInt(8);
                km = new KhuyenMai(id, ma, tenKM, ptg, ngBD, ngKT, moTa, tt);
                list.add(km);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    } 
    public boolean add(KhuyenMai km){
        String sql = "  insert into KhuyenMai(Ma, Ten, PhanTramGiam, NgayBatDau, NgayKetThuc, MoTa, TinhTrang) values (?, ?, ?, ?, ?, ?, ?)";
        try{
            
            DBConnection.ExcuteUpdate(sql, km.getMa(), km.getTen(), km.getPhanTramGiam(), km.getNgayBatDau(), km.getNgayKetThuc(), km.getMoTa(), km.getTrangThai());
            
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean update(KhuyenMai km){
        String sql = "  update KhuyenMai set Ma = ?, Ten = ?, PhanTramGiam = ?, NgayBatDau = ?, NgayKetThuc = ?, MoTa = ?, TinhTrang = ? where ID = ?";
        try{
            
            DBConnection.ExcuteUpdate(sql, km.getMa(), km.getTen(), km.getPhanTramGiam(), km.getNgayBatDau(), km.getNgayKetThuc(), km.getMoTa(), km.getTrangThai(), km.getId());
            
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean delete(String ma){
        String sql = "delete from KhuyenMai where Ma = ?";
        try {
            DBConnection.ExcuteUpdate(sql, ma);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
//    public List<KhuyenMai> getSelectBySQL(String sql, Object ... args){
//        try {
//            ResultSet rs = DBConnection.getDataFromQuery(sql, args);
//            while(rs.next()){
//                list.add(new KhuyenMai(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7),rs.getString(8), rs.getInt(9), rs.getString(10), rs.getDouble(11), rs.getDouble(12)));
//            }
//            return listDep;
//        } catch (SQLException ex) {
//            throw new RuntimeException();
//        }
//    }
}
