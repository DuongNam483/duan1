/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import models.NhanVien;
import utility.DBConnection;
import java.sql.*;
import java.time.LocalDate;

/**
 *
 * @author duong
 */
public class NhanVienRepository {
    List<NhanVien> list;
    public NhanVienRepository(){
        list = new ArrayList<>();
    }
    public List<NhanVien> getAllNV(){
        list = new ArrayList<>();
        NhanVien nv = null;
        try {
            String sql = "select * from NhanVien";
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.execute();
            
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                int id = rs.getInt(1);
                int idCV = rs.getInt(2);
                String maCTD = rs.getString(3);
                String ten = rs.getString(4);
                Date d1 = rs.getDate(5);
                LocalDate ngaySinh = d1.toLocalDate();
                String email = rs.getString(6);
                String sdt = rs.getString(7);
                boolean gioiTinh = rs.getBoolean(8);
                String diaChi = rs.getString(9);
                String taiKhoan = rs.getString(10);
                String mk = rs.getString(11);
                nv = new NhanVien(id, idCV, maCTD, ten, ngaySinh, email, sdt, gioiTinh, diaChi,taiKhoan, mk);
                list.add(nv);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public NhanVien getNVByMa(String ma){
//        listDep = new ArrayList<>();
//        String sql = "select * from ChiTietDep where Ma = ?";
//        return getSelectBySQL(sql, ma).get(0);
        NhanVien nv = null;
        try {
            String sql = "select * from NhanVien where Ma = ?";
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.execute();
            
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                int id = rs.getInt(1);
                int idCV = rs.getInt(2);
                String maCTD = rs.getString(3);
                String ten = rs.getString(4);
                Date d1 = rs.getDate(5);
                LocalDate ngaySinh = d1.toLocalDate();
                String email = rs.getString(6);
                String sdt = rs.getString(7);
                boolean gioiTinh = rs.getBoolean(8);
                String diaChi = rs.getString(9);
                String taiKhoan = rs.getString(10);
                String mk = rs.getString(11);
                nv = new NhanVien(id, idCV, maCTD, ten, ngaySinh, email, sdt, gioiTinh, diaChi,taiKhoan, mk);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nv;
    }
        public NhanVien getByTen(String ten){
        NhanVien cl = null;
        try {
            Connection conn = DBConnection.openDbConnection();
            String sql = "select * from ChucVu where Ten = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ten);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                int id = rs.getInt("ID");
                String ma = rs.getString("Ma");
                String t = rs.getString("Ten");
                cl.setId(id);
                cl.setMa(ma);
                cl.setTen(t);
            }
            
            
        } catch (Exception ex) {
            //Logger.getLogger(GradeRepository.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();   
        }
        return cl;
    }
    
    public boolean add(NhanVien ctd){
        String sql = "  insert into NhanVien(IdCV, Ma, Ten, NgaySinh, Email, Sdt, GioiTinh, DiaChi,TaiKhoan, MatKhau) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            System.out.println(ctd.getNgaySinh());
            DBConnection.ExcuteUpdate(sql, ctd.getIdCV(), ctd.getMa(), ctd.getTen(), ctd.getNgaySinh(), ctd.getEmail(), ctd.getSdt(),
                ctd.isGioiTinh(), ctd.getDiaChi(),ctd.getTaiKhoan(), ctd.getMaKhau());
            System.out.println("Nam");
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        
    }
    
    public boolean update(NhanVien ctd){
        String sql = "update NhanVien set IdCV = ?,Ma = ?, Ten = ?, NgaySinh = ?, Email = ?, Sdt = ?, GioiTinh = ?, DiaChi = ?, TaiKhoan = ?, MatKhau = ? where ID = ?";
        try{
            DBConnection.ExcuteUpdate(sql, ctd.getIdCV(), ctd.getMa(), ctd.getTen(), ctd.getNgaySinh(), ctd.getEmail(), ctd.getSdt(),
                ctd.isGioiTinh(), ctd.getDiaChi(),ctd.getTaiKhoan(), ctd.getMaKhau(), ctd.getId());
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        
    }
    public boolean delete(String ma){
        String sql = "delete from NhanVien where Ma = ?";
        try {
            DBConnection.ExcuteUpdate(sql, ma);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
//    public List<NhanVien> getSelectBySQL(String sql, Object ... args){
//        try {
//            ResultSet rs = DBConnection.getDataFromQuery(sql, args);
//            while(rs.next()){
//                list.add(new NhanVien(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getBoolean(8), rs.getString(9), rs.getString(10), rs.getString(11)));
//            }
//            return list;
//        } catch (SQLException ex) {
//            throw new RuntimeException();
//        }
//    }
}
