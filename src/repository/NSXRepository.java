/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import models.NSX;
import utility.DBConnection;
import java.sql.*;

/**
 *
 * @author duong
 */
public class NSXRepository {
    private ArrayList<NSX> list;
    public NSXRepository(){
        list = new ArrayList<>();
    }
    public List<NSX> getAll(){
        list = new ArrayList<>();
        String getAll = "select * from NSX";
        return getSelectBySQL(getAll);
    }
    public NSX getByMa(String ma){
        String sql = "select * from NSX where Ma = ?";
        NSX c = null;
        return getSelectBySQL(sql, ma).get(0);
    }
//    public NSX getByTen(String ten){
//        String sql = "select * from NSX where Ten = ?";
//        NSX c = null;
//        return getSelectBySQL(sql, ten).get(0);
//    }
    public NSX getByTen(String ten) {
        NSX cl = new NSX();
        try {
            Connection conn = DBConnection.openDbConnection();
            String sql = "select * from NSX where Ten = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ten);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
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
    public boolean add(NSX nsx){
        String sql = "insert into NSX(Ma, Ten) values (?,?)";
        try {
            DBConnection.ExcuteUpdate(sql, nsx.getMa(), nsx.getTen());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean update(NSX nsx){
        String sql = "update NSX set Ma = ?, Ten = ? where Id = ?";
        try {
            DBConnection.ExcuteUpdate(sql, nsx.getMa(), nsx.getTen(), nsx.getId() );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean delete(String ma){
        String sql = "delete from NSX where Ma = ?";
        try {
            DBConnection.ExcuteUpdate(sql, ma);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<NSX> getSelectBySQL(String sql, Object ... args){
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, args);
            while(rs.next()){
                list.add(new NSX(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
        
    }
}
