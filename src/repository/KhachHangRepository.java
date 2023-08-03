/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import models.KhachHang;
import utility.DBConnection;
import java.sql.*;
import java.time.LocalDate;
/**
 *
 * @author duong
 */
public class KhachHangRepository {
    List<KhachHang> list;
    public KhachHangRepository(){
        list = new ArrayList<>();
    }
    public List<KhachHang> getAll(){
        list = new ArrayList<>();
        KhachHang nv = null;
        try {
            String sql = "select * from KhachHang";
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.execute();
            
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                int id = rs.getInt("ID");
                String maCTD = rs.getString("Ma");
                String ten = rs.getString("Ten");
                Date d1 = rs.getDate("NgaySinh");
                LocalDate ngaySinh = d1.toLocalDate();
                String email = rs.getString("Email");
                String sdt = rs.getString("Sdt");
                boolean gioiTinh = rs.getBoolean("GioiTinh");
                String diaChi = rs.getString("DiaChi");
                int tt = rs.getInt("TrangThai");
                nv = new KhachHang(id,maCTD, ten, ngaySinh, gioiTinh, sdt, email, diaChi, tt);
                list.add(nv);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public KhachHang getNVByMa(String ma){
        KhachHang nv = null;
        list = new ArrayList<>();
        try {
            String sql = "select * from KhachHang where Ma = ?";
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.execute();
            
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                int id = rs.getInt("ID");
                String maCTD = rs.getString("Ma");
                String ten = rs.getString("Ten");
                Date d1 = rs.getDate("NgaySinh");
                LocalDate ngaySinh = d1.toLocalDate();
                String email = rs.getString("Email");
                String sdt = rs.getString("Sdt");
                boolean gioiTinh = rs.getBoolean("GioiTinh");
                String diaChi = rs.getString("DiaChi");
                int tt = rs.getInt("TrangThai");
                nv = new KhachHang(id,maCTD, ten, ngaySinh, gioiTinh, sdt, email, diaChi, tt);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nv;
    }
    public List<KhachHang> getByTen(String ten){
        KhachHang nv = null;
        list = new ArrayList<>();
        try {
            Connection conn = DBConnection.openDbConnection();
            String sql = "select * from KhachHang where Ten like ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + ten + "%");
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                int id = rs.getInt("ID");
                String maCTD = rs.getString("Ma");
                String tenKH = rs.getString("Ten");
                Date d1 = rs.getDate("NgaySinh");
                LocalDate ngaySinh = d1.toLocalDate();
                String email = rs.getString("Email");
                String sdt = rs.getString("Sdt");
                boolean gioiTinh = rs.getBoolean("GioiTinh");
                String diaChi = rs.getString("DiaChi");
                int tt = rs.getInt("TrangThai");
                nv = new KhachHang(id,maCTD, tenKH, ngaySinh, gioiTinh, sdt, email, diaChi, tt);
                list.add(nv);
            }
            
            
        } catch (Exception ex) {
            //Logger.getLogger(GradeRepository.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();   
        }
        return list;
    }
    
    public boolean add(KhachHang ctd){
        String sql = "  insert into KhachHang(Ma, Ten, NgaySinh, GioiTinh, Email, Sdt,  DiaChi) values (?, ?, ?, ?, ?, ?, ?)";
        try{
            System.out.println(ctd.getNgaySinh());
            System.out.println(ctd.getMa());
            System.out.println(ctd.getTen());
            System.out.println(ctd.isGioiTinh());
            System.out.println(ctd.getDiaChi());
            System.out.println(ctd.getEmail());
            System.out.println(ctd.getSdt());
            
            DBConnection.ExcuteUpdate(sql, ctd.getMa(), ctd.getTen(), ctd.getNgaySinh(), ctd.isGioiTinh(),ctd.getEmail(), ctd.getSdt(),
                 ctd.getDiaChi());
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        
    }
    
    public boolean update(KhachHang ctd){
        String sql = "update KhachHang set Ma = ?, Ten = ?, NgaySinh = ?, Email = ?, Sdt = ?, GioiTinh = ?, DiaChi = ? where ID = ?";
        try{
            DBConnection.ExcuteUpdate(sql, ctd.getMa(), ctd.getTen(), ctd.getNgaySinh(), ctd.getEmail(), ctd.getSdt(),
                ctd.isGioiTinh(), ctd.getDiaChi(), ctd.getId());
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        
    }
    public boolean delete(String ma){
        String sql = "delete from KhachHang where Ma = ?";
        try {
            DBConnection.ExcuteUpdate(sql, ma);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
