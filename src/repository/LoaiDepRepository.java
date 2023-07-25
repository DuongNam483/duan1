/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.LoaiDep;
import utility.DBConnection;

/**
 *
 * @author duong
 */
public class LoaiDepRepository {
    private ArrayList<LoaiDep> list;
    public LoaiDepRepository(){
        list = new ArrayList<>();
    }
    public List<LoaiDep> getAll(){
        list = new ArrayList<>();
        String getAll = "select * from LoaiDep";
        return getSelectBySQL(getAll);
    }
    public LoaiDep getByMa(String ma){
        String sql = "select * from LoaiDep where Ma = ?";
        LoaiDep c = null;
        return getSelectBySQL(sql, ma).get(0);
    }
//    public LoaiDep getByTen(String ten){
//        String sql = "select * from LoaiDep where Ten = ?";
//        LoaiDep c = null;
//        return getSelectBySQL(sql, ten).get(0);
//    }
    public LoaiDep getByTen(String ten){
        LoaiDep cl = new LoaiDep();
        try {
            Connection conn = DBConnection.openDbConnection();
            String sql = "select * from LoaiDep where Ten = ?";
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
    public boolean add(LoaiDep ld){
        String sql = "insert into LoaiDep(Ma, Ten) values (?,?)";
        try {
            DBConnection.ExcuteUpdate(sql, ld.getMa(), ld.getTen());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean update(LoaiDep ld){
        String sql = "update LoaiDep set Ma = ?, Ten = ? where Id = ?";
        try {
            DBConnection.ExcuteUpdate(sql, ld.getMa(), ld.getTen(), ld.getId() );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean delete(String ma){
        String sql = "delete from LoaiDep where Ma = ?";
        try {
            DBConnection.ExcuteUpdate(sql, ma);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<LoaiDep> getSelectBySQL(String sql, Object ... args){
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, args);
            while(rs.next()){
                list.add(new LoaiDep(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
        
    }
}
