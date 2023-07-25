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
import models.NSX;
import models.Size;
import utility.DBConnection;

/**
 *
 * @author duong
 */
public class SizeRepository {
    private ArrayList<Size> list;
    public SizeRepository(){
        list = new ArrayList<>();
    }
    public List<Size> getAll(){
        list = new ArrayList<>();
        String getAll = "select * from Size";
        return getSelectBySQL(getAll);
    }
    public Size getByMa(String ma){
        String sql = "select * from Size where Ma = ?";
        Size c = null;
        return getSelectBySQL(sql, ma).get(0);
    }
//    public Size getByTen(int ten){
//        String sql = "select * from Size where KichCo = ?";
//        Size c = null;
//        return getSelectBySQL(sql, ten).get(0);
//    }
    public Size getByTen(int ten) {
        Size cl = new Size();
        try {
            Connection conn = DBConnection.openDbConnection();
            String sql = "select * from Size where KichCo = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ten);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String ma = rs.getString("Ma");
                String t = rs.getString("KichCo");
                cl.setId(id);
                cl.setMa(ma);
                cl.setKichCo(t);
            }

        } catch (Exception ex) {
            //Logger.getLogger(GradeRepository.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return cl;
    }
    public boolean add(Size s){
        String sql = "insert into Size(Ma, KichCo) values (?,?)";
        try {
            DBConnection.ExcuteUpdate(sql, s.getMa(), s.getKichCo());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean update(Size s){
        String sql = "update Size set Ma = ?, KichCo = ? where Id = ?";
        try {
            DBConnection.ExcuteUpdate(sql, s.getMa(), s.getKichCo(), s.getId() );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean delete(String ma){
        String sql = "delete from Size where Ma = ?";
        try {
            DBConnection.ExcuteUpdate(sql, ma);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<Size> getSelectBySQL(String sql, Object ... args){
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, args);
            while(rs.next()){
                list.add(new Size(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
        
    }
}
