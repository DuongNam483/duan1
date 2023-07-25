/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import java.util.ArrayList;
import models.MauSac;
import java.sql.*;
import utility.DBConnection;

/**
 *
 * @author duong
 */
public class MauSacRepository {

    private ArrayList<MauSac> listMS;

    public MauSacRepository() {
        listMS = new ArrayList<>();
    }

    public List<MauSac> getAll() {
        listMS = new ArrayList<>();
        String getAll = "select * from MauSac";
        return getSelectBySQL(getAll);
    }

    public MauSac getByMa(String ma) {
        String sql = "select * from MauSac where Ma = ?";
        MauSac c = null;
        return getSelectBySQL(sql, ma).get(0);
    }

    public MauSac getByTen(String ten) {
        MauSac cl = new MauSac();
        try {
            Connection conn = DBConnection.openDbConnection();
            String sql = "select * from MauSac where MauSac = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ten);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String ma = rs.getString("Ma");
                String t = rs.getString("MauSac");
                cl.setId(id);
                cl.setMa(ma);
                cl.setMauSac(t);
            }

        } catch (Exception ex) {
            //Logger.getLogger(GradeRepository.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return cl;
    }

    public boolean add(MauSac ms) {
        String sql = "insert into MauSac(Ma, MauSac) values (?,?)";
        try {
            DBConnection.ExcuteUpdate(sql, ms.getMa(), ms.getMauSac());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(MauSac ms) {
        String sql = "update MauSac set Ma = ?, MauSac = ? where Id = ?";
        try {
            DBConnection.ExcuteUpdate(sql, ms.getMa(), ms.getMauSac(), ms.getId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String ma) {
        String sql = "delete from MauSac where Ma = ?";
        try {
            DBConnection.ExcuteUpdate(sql, ma);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<MauSac> getSelectBySQL(String sql, Object... args) {
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, args);
            while (rs.next()) {
                listMS.add(new MauSac(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            return listMS;
        } catch (SQLException ex) {
            throw new RuntimeException();
        }

    }
}
