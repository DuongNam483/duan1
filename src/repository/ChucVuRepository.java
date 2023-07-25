/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import models.ChucVu;
import utility.DBConnection;
import java.sql.*;

/**
 *
 * @author duong
 */
public class ChucVuRepository {
    private ArrayList<ChucVu> listMS;
    public ChucVuRepository(){
        listMS = new ArrayList<>();
    }
    public List<ChucVu> getAll(){
        listMS = new ArrayList<>();
        String getAll = "select * from ChucVu";
        return getSelectBySQL(getAll);
    }
    public ChucVu getByMa(String ma){
        String sql = "select * from ChucVu where Ten = ?";
        ChucVu c = null;
        return getSelectBySQL(sql, ma).get(0);
    }
//    public ChatLieu getByTen(String ten){
//        String sql = "select * from ChatLieu where Ten = ?" ;
//        ChatLieu c = null;
//        return getSelectBySQL(sql, ten).get(0);
//    }
    public ChucVu getByTen(String ten){
        ChucVu cl = new ChucVu();
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
    public boolean add(ChucVu cl){
        String sql = "insert into ChucVu(Ma, Ten) values (?,?)";
        try {
            DBConnection.ExcuteUpdate(sql, cl.getMa(), cl.getTen());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean update(ChucVu cl){
        String sql = "update ChucVu set Ma = ?, Ten = ? where Id = ?";
        try {
            DBConnection.ExcuteUpdate(sql, cl.getMa(), cl.getTen(), cl.getId() );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean delete(String ma){
        String sql = "delete from ChucVu where Ma = ?";
        try {
            DBConnection.ExcuteUpdate(sql, ma);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<ChucVu> getSelectBySQL(String sql, Object ... args){
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, args);
            while(rs.next()){
                listMS.add(new ChucVu(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            return listMS;
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
    }
}
