/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Dep;
import utility.DBConnection;
import java.sql.*;

/**
 *
 * @author duong
 */
public class DepRepository {
    private ArrayList<Dep> list;
    public DepRepository(){
        list = new ArrayList<>();
    }
    public List<Dep> getAll(){
        list = new ArrayList<>();
        String getAll = "select * from Dep";
        return getSelectBySQL(getAll);
    }
    public Dep getByMa(String ma){
        String sql = "select * from Dep where Ma = ?";
        Dep c = null;
        return getSelectBySQL(sql, ma).get(0);
    }
//    public Dep getByTen(String ten){
//        String sql = "select * from Dep where Ten = ?";
//        Dep c = null;
//        return getSelectBySQL(sql, ten).get(0);
//    }
    public Dep getByTen(String ten){
        Dep cl = new Dep();
        try {
            Connection conn = DBConnection.openDbConnection();
            String sql = "select * from Dep where Ten = ?";
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
    public boolean add(Dep dep){
        String sql = "insert into Dep(Ma, Ten) values (?,?)";
        try {
            DBConnection.ExcuteUpdate(sql, dep.getMa(), dep.getTen());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean update(Dep dep){
        String sql = "update Dep set Ma = ?, Ten = ? where Id = ?";
        try {
            DBConnection.ExcuteUpdate(sql, dep.getMa(), dep.getTen(), dep.getId() );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean delete(String ma){
        String sql = "delete from Dep where Ma = ?";
        try {
            DBConnection.ExcuteUpdate(sql, ma);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<Dep> getSelectBySQL(String sql, Object ... args){
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, args);
            while(rs.next()){
                list.add(new Dep(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
        
    }
}
