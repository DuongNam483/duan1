/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import models.ChiTietDep;
import viewmodels.SanPhamViewModel;
import java.sql.*;
import utility.DBConnection;

/**
 *
 * @author duong
 */
public class SanPhamRepository {
    private List<ChiTietDep> listDep;
    private List<SanPhamViewModel> listSP;
    public SanPhamRepository(){
        listDep = new ArrayList<>();
        listSP = new ArrayList<>();
    }
    public List<ChiTietDep> getAllSP(){
        listDep = new ArrayList<>();
        String sql = "Select * from ChiTietDep";
        return getSelectBySQL(sql);
    }
    public List<SanPhamViewModel> getAllSPVMD(){
        listSP = new ArrayList<>();
        String sql = "select ChiTietDep.id, ChiTietDep.Ma, Dep.Ten, LoaiDep.Ten, MauSac.MauSac, NSX.Ten, ChatLieu.Ten, Size.KichCo, ChiTietDep.SoLuong, ChiTietDep.MoTa, ChiTietDep.GiaNhap, ChiTietDep.GiaBan\n"
                + "from ChiTietDep, Dep, LoaiDep, MauSac, NSX, ChatLieu, Size where Dep.ID = ChiTietDep.IdDep and LoaiDep.ID = ChiTietDep.IdLoaiDep and MauSac.ID = ChiTietDep.IdMauSac and \n"
                + "NSX.ID = ChiTietDep.IdNSX and ChatLieu.ID = ChiTietDep.IdChatLieu and Size.ID = ChiTietDep.IdSize";
        return getSelectVMDBySQL(sql);
    }
    public ChiTietDep getByID(int id){
        ChiTietDep ctd = null;
        try {
            String sql = "select * from ChiTietDep where ID = ?";
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                int idSP = rs.getInt(1);
                int idD = rs.getInt(2);
                int idLD = rs.getInt(3);
                int idS = rs.getInt(4);
                int idMS = rs.getInt(5);
                int idCL = rs.getInt(6);
                int idNSX = rs.getInt(7);
                String maCTD = rs.getString(8);
                int sl = rs.getInt(9);
                String moTa = rs.getString(10);
                double giaNhap = rs.getDouble(11);
                double giaBan = rs.getDouble(12);
                ctd = new ChiTietDep(idSP, idD, idLD, idMS, idNSX, idCL, idS, maCTD, sl, moTa, giaNhap, giaBan);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return ctd;
    }
    public ChiTietDep getCTDByMa(String ma){
//        listDep = new ArrayList<>();
//        String sql = "select * from ChiTietDep where Ma = ?";
//        return getSelectBySQL(sql, ma).get(0);
        ChiTietDep ctd = null;
        try {
            String sql = "select * from ChiTietDep where Ma = ?";
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.execute();
            
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                int id = rs.getInt(1);
                int idD = rs.getInt(2);
                int idLD = rs.getInt(3);
                int idS = rs.getInt(4);
                int idMS = rs.getInt(5);
                int idCL = rs.getInt(6);
                int idNSX = rs.getInt(7);
                String maCTD = rs.getString(8);
                int sl = rs.getInt(9);
                String moTa = rs.getString(10);
                double giaNhap = rs.getDouble(11);
                double giaBan = rs.getDouble(12);
                ctd = new ChiTietDep(id, idD, idLD, idMS, idNSX, idCL, idS, ma, sl, moTa, giaNhap, giaBan);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return ctd;
    }
    public boolean updateSL(int sl, int id){
        String sql = "update ChiTietDep set SoLuong = ? where ID = ?";
        try {
            System.out.println("1." + id);
            System.out.println("2." + sl);
            DBConnection.ExcuteUpdate(sql, sl, id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public SanPhamViewModel getSPVMD(String ma){
        listSP = new ArrayList<>();
        String sql = "select ChiTietDep.id, ChiTietDep.Ma, Dep.Ten, LoaiDep.Ten, MauSac.MauSac, NSX.Ten, ChatLieu.Ten, Size.KichCo, ChiTietDep.SoLuong, ChiTietDep.MoTa, ChiTietDep.GiaNhap, ChiTietDep.GiaBan\n"
                + "from ChiTietDep, Dep, LoaiDep, MauSac, NSX, ChatLieu, Size where Dep.ID = ChiTietDep.IdDep and LoaiDep.ID = ChiTietDep.IdLoaiDep and MauSac.ID = ChiTietDep.IdMauSac and \n"
                + "NSX.ID = ChiTietDep.IdNSX and ChatLieu.ID = ChiTietDep.IdChatLieu and Size.ID = ChiTietDep.IdSize\n"
                + "and ChiTietDep.Ma = ?";
        return getSelectVMDBySQL(sql, ma).get(0);
    }
    
    public List<SanPhamViewModel> filterResponses(int idCL, int idD, int idLD, int idMS, int idNSX, int idSize) {
        listSP = new ArrayList<>();
        String sql = " select ChiTietDep.id, ChiTietDep.Ma, Dep.Ten, LoaiDep.Ten, MauSac.MauSac, NSX.Ten, ChatLieu.Ten, Size.KichCo, ChiTietDep.SoLuong, ChiTietDep.MoTa, ChiTietDep.GiaNhap, ChiTietDep.GiaBan\n"
                + "from ChiTietDep, Dep, LoaiDep, MauSac, NSX, ChatLieu, Size where Dep.ID = ChiTietDep.IdDep and LoaiDep.ID = ChiTietDep.IdLoaiDep and MauSac.ID = ChiTietDep.IdMauSac and \n"
                + "NSX.ID = ChiTietDep.IdNSX and ChatLieu.ID = ChiTietDep.IdChatLieu and Size.ID = ChiTietDep.IdSize\n"
                + "and ChatLieu.ID = ? and Dep.ID = ? and LoaiDep.ID = ? and MauSac.ID = ? and NSX.ID = ? and Size.ID = ?"; 
        return getSelectVMDBySQL(sql, idCL, idD, idLD, idMS, idNSX, idSize);


//        SanPhamViewModel sp = new SanPhamViewModel();
//        listSP = new ArrayList<>();
//            //PreparedStatement statement = null;
//        try {
//            
//            String sql = " select ChiTietDep.id, ChiTietDep.Ma, Dep.Ten, LoaiDep.Ten, MauSac.MauSac, NSX.Ten, ChatLieu.Ten, Size.KichCo, ChiTietDep.SoLuong, ChiTietDep.MoTa, ChiTietDep.GiaNhap, ChiTietDep.GiaBan\n"
//                + "from ChiTietDep, Dep, LoaiDep, MauSac, NSX, ChatLieu, Size where Dep.ID = ChiTietDep.IdDep and LoaiDep.ID = ChiTietDep.IdLoaiDep and MauSac.ID = ChiTietDep.IdMauSac and \n"
//                + "NSX.ID = ChiTietDep.IdNSX and ChatLieu.ID = ChiTietDep.IdChatLieu and Size.ID = ChiTietDep.IdSize\n"
//                + "and ChatLieu.ID = ? and Dep.ID = ? and LoaiDep.ID = ? and MauSac.ID = ? and NSX.ID = ? and Size.ID = ?";     
//            Connection conn = DBConnection.openDbConnection();
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setInt(1, idCL);
//            ps.setInt(2, idD);
//            ps.setInt(3, idLD);
//            ps.setInt(4, idMS);
//            ps.setInt(5, idMS);
//            ps.setInt(6, idMS);
//            ps.execute();
//            
//            ResultSet rs = ps.getResultSet();
//            while (rs.next()) {
//                int id = rs.getInt(1);
//                String ma = rs.getString(2);
//                String tenDep = rs.getString(3);
//                String tenLD = rs.getString(4);
//                String tenMS = rs.getString(5);
//                String tenNSX = rs.getString(6);
//                String tenCL = rs.getString(7);
//                int kc = rs.getInt(8);
//                int sl = rs.getInt(9);
//                String moTa = rs.getString(10);
//                double giaNhap = rs.getDouble(11);
//                double giaBan = rs.getDouble(12);
//                sp.setId(id);
//                sp.setMa(ma);
//                sp.setDep(tenDep);
//                sp.setLoaiDep(tenLD);
//                sp.setMauSac(tenMS);
//                sp.setNSX(tenNSX);
//                sp.setSize(kc);
//                sp.setSoLuong(sl);
//                sp.setMoTa(moTa);
//                sp.setGiaNhap(giaNhap);
//                sp.setGiaBan(giaBan);
//                listSP.add(sp);
////                listSP.add(new SanPhamViewModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getString(10), rs.getDouble(11), rs.getDouble(12)));
////                System.out.println("a");
//            }
//            
//        } catch (SQLException ex) {
//            throw new RuntimeException();
//        }
//        return listSP;
        
    }
    
    public boolean add(ChiTietDep ctd){
        String sql = "insert into ChiTietDep(IdDep, IdLoaiDep, IdSize, IdMauSac, IdChatLieu, IdNSX, Ma, SoLuong, MoTa, GiaNhap, GiaBan) values (?,?,?,?,?,?,?,?,?,?,?)";
        try{
            DBConnection.ExcuteUpdate(sql, ctd.getIdDep(), ctd.getIdLoaiDep(), ctd.getIdSize(), ctd.getIdMauSac(), ctd.getIdChatLieu(), ctd.getIdNSX(),
                ctd.getMa(), ctd.getSoLuong(), ctd.getMoTa(), ctd.getGiaNhap(), ctd.getGiaBan());
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        
    }
    public boolean update (ChiTietDep ctd){
        String sql = "update ChiTietDep set Ma = ?, IdDep = ?, IdLoaiDep = ?, IdMauSac = ?, IdNSX = ?, IdChatLieu = ?, IdSize = ?, SoLuong = ?, MoTa = ?, GiaNhap = ?, GiaBan = ? where ID = ?";
        try {
            DBConnection.ExcuteUpdate(sql, ctd.getMa(), ctd.getIdDep(), ctd.getIdLoaiDep(), ctd.getIdMauSac(), ctd.getIdNSX(), ctd.getIdChatLieu(), ctd.getIdSize(),  ctd.getSoLuong(), ctd.getMoTa(), ctd.getGiaNhap(), ctd.getGiaBan(), ctd.getId());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean delete(String ma){
        String sql = "delete from ChiTietDep where Ma = ?";
        try {
            DBConnection.ExcuteUpdate(sql, ma);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public List<ChiTietDep> getSelectBySQL(String sql, Object ... args){
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, args);
            while(rs.next()){
                listDep.add(new ChiTietDep(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7),rs.getString(8), rs.getInt(9), rs.getString(10), rs.getDouble(11), rs.getDouble(12)));
            }
            return listDep;
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
    }
    public List<SanPhamViewModel> getSelectVMDBySQL(String sql, Object ... args){
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, args);
            while(rs.next()){
                listSP.add(new SanPhamViewModel(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getString(10), rs.getDouble(11), rs.getDouble(12)));
                
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
        return listSP;
    }
}
