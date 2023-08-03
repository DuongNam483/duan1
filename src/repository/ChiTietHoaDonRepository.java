/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.HoaDonChiTiet;
import utility.DBConnection;
import viewmodels.HoaDonChiTietViewModel;
import java.sql.*;
/**
 *
 * @author duong
 */
public class ChiTietHoaDonRepository {
    List<HoaDonChiTiet> list;
    List<HoaDonChiTietViewModel> listHDCT;
    public ChiTietHoaDonRepository(){
        list = new ArrayList<>();
    }
    public List<HoaDonChiTiet> getAll(){
        String sql = "Select * from HoaDonChiTiet";
        return getSelectBySQL(sql);
    }
    public List<HoaDonChiTietViewModel> getAllGH(){
//        String sql = "select hd.Ma, ctd.Ma, hdct.SoLuong, ctd.GiaBan from HoaDonChiTiet hdct, HoaDon hd, ChiTietDep ctd where hdct.IdHD = hd.ID "
//                + "and hdct.IdCTD = ctd.ID";
        listHDCT = new ArrayList<>();
        HoaDonChiTietViewModel hdctmd = null;
        try {
            String sql = "select hd.Ma, ctd.Ma, hdct.SoLuong, ctd.GiaBan from HoaDonChiTiet hdct, HoaDon hd, ChiTietDep ctd where hdct.IdHD = hd.ID "
                + "and hdct.IdCTD = ctd.ID";
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.execute();

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String ma = rs.getString(1);
                String maCTD = rs.getString(2);
                int sl = rs.getInt(3);
                double tongTien = rs.getDouble(4);
                
                hdctmd = new HoaDonChiTietViewModel(ma, maCTD,  sl, tongTien);
                listHDCT.add(hdctmd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listHDCT;
    }
    public List<HoaDonChiTietViewModel> getGHByMa(String ma){
//        String sql = "select hd.Ma, ctd.Ma, hdct.SoLuong, ctd.GiaBan from HoaDonChiTiet hdct, HoaDon hd, ChiTietDep ctd where hdct.IdHD = hd.ID "
//                + "and hdct.IdCTD = ctd.ID and hd.Ma = ?";
        listHDCT = new ArrayList<>();
        HoaDonChiTietViewModel hdctmd = null;
        try {
            String sql = "select hd.Ma, ctd.Ma, hdct.SoLuong, ctd.GiaBan from HoaDonChiTiet hdct, HoaDon hd, ChiTietDep ctd where hdct.IdHD = hd.ID "
                + "and hdct.IdCTD = ctd.ID and hd.Ma = ?";
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String maHD = rs.getString(1);
                String maCTD = rs.getString(2);
                int sl = rs.getInt(3);
                double tongTien = rs.getDouble(4);
                
                hdctmd = new HoaDonChiTietViewModel(maHD, maCTD,  sl, tongTien);
                listHDCT.add(hdctmd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listHDCT;
    }
    public HoaDonChiTiet getByMa(int idHD){
//        String sql = "Select * from HoaDonChiTiet where ID = ?";
        HoaDonChiTiet hdct = null;
        try {
            String sql = "Select * from HoaDonChiTiet where IdHD = ?";
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idHD);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt(1);
                int idHDGH = rs.getInt(2);
                int idCTD = rs.getInt(3);
                int sl = rs.getInt(4);
                double donGia = rs.getDouble(5);
                
                hdct = new HoaDonChiTiet(id, idHDGH, idCTD, sl, donGia);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hdct;
    }
    public boolean add(HoaDonChiTiet hdct ){
        String sql = "insert into HoaDonChiTiet(IdHD, IdCTD, SoLuong, DonGia) values(?, ?, ?, ?)";
        try {
            DBConnection.ExcuteUpdate(sql, hdct.getIdHD(), hdct.getIdCTD(), hdct.getSoLuong(), hdct.getDonGia());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean update(HoaDonChiTiet hdct ){
        String sql = "update HoaDonChiTiet set IdHD = ?, IdCTD = ?, SoLuong = ?, DonGia = ? where ID = ?";
        try {
            DBConnection.ExcuteUpdate(sql, hdct.getIdHD(), hdct.getIdCTD(), hdct.getSoLuong(), hdct.getDonGia(), hdct.getId());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean delete(int id){
        String sql = "delete from HoaDonChiTiet where IdHD = ?";
        try {
            DBConnection.ExcuteUpdate(sql, id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean deleteSP(int id, int idSP){
        String sql = "delete from HoaDonChiTiet where ID = ? and IdCTD = ?";
        try {
            DBConnection.ExcuteUpdate(sql, id, idSP);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public List<HoaDonChiTiet> getSelectBySQL(String sql, Object ... args){
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, args);
            while(rs.next()){
                list.add(new HoaDonChiTiet(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDouble(5)));
            }
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
    }
    public List<HoaDonChiTietViewModel> getSelectHDCTBySQL(String sql, Object ... args){
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, args);
            while(rs.next()){
                listHDCT.add(new HoaDonChiTietViewModel(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4)));
            }
            return listHDCT;
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
    }
}
