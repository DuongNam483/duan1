/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import models.ChatLieu;
import utility.DBConnection;
import java.sql.*;

/**
 *
 * @author duong
 */
public class ChatLieuRepository {
    private ArrayList<ChatLieu> listMS;
    public ChatLieuRepository(){
        listMS = new ArrayList<>();
    }
    public List<ChatLieu> getAll(){
        listMS = new ArrayList<>();
        String getAll = "select * from ChatLieu";
        return getSelectBySQL(getAll);
    }
    public ChatLieu getByMa(String ma){
        String sql = "select * from ChatLieu where Ten = ?";
        ChatLieu c = null;
        return getSelectBySQL(sql, ma).get(0);
    }
//    public ChatLieu getByTen(String ten){
//        String sql = "select * from ChatLieu where Ten = ?" ;
//        ChatLieu c = null;
//        return getSelectBySQL(sql, ten).get(0);
//    }
    public ChatLieu getByTen(String ten){
        ChatLieu cl = new ChatLieu();
        try {
            Connection conn = DBConnection.openDbConnection();
            String sql = "select * from ChatLieu where Ten = ?";
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
    public boolean add(ChatLieu cl){
        String sql = "insert into ChatLieu(Ma, Ten) values (?,?)";
        try {
            DBConnection.ExcuteUpdate(sql, cl.getMa(), cl.getTen());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean update(ChatLieu cl){
        String sql = "update ChatLieu set Ma = ?, Ten = ? where Id = ?";
        try {
            DBConnection.ExcuteUpdate(sql, cl.getMa(), cl.getTen(), cl.getId() );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean delete(String ma){
        String sql = "delete from ChatLieu where Ma = ?";
        try {
            DBConnection.ExcuteUpdate(sql, ma);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<ChatLieu> getSelectBySQL(String sql, Object ... args){
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, args);
            while(rs.next()){
                listMS.add(new ChatLieu(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            return listMS;
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
    }
//     public ChatLieu getSelectByMa(String sql, Object ... args){
//        ChatLieu c = null;
//         try {
//            ResultSet rs = DBConnection.getDataFromQuery(sql, args);
//            while(rs.next()){
//                c = new ChatLieu(rs.getInt(1), rs.getString(2), rs.getString(3));
//            }
//            return c;
//        } catch (SQLException ex) {
//            throw new RuntimeException();
//        }
//        
//    }
}
