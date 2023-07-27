/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import models.KhuyenMai;
import repository.KhuyenMaiRepository;
import service.KhuyenMaiService;


public class KhuyenMaiServiceImpl implements KhuyenMaiService {

    private KhuyenMaiRepository repo = new KhuyenMaiRepository();
    @Override
    public List<KhuyenMai> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return repo.getAll();
    }

    @Override
    public KhuyenMai getByMa(String ma) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return repo.getByMa(ma);
    }

    @Override
    public KhuyenMai getByTen(String ten) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return repo.getByTen(ten);
    }
    
    @Override
    public List<KhuyenMai> getByTT(int tt) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return repo.getByTT(tt);
    }
    @Override
    public String add(KhuyenMai km) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        boolean add = repo.add(km);
        if(add){
            return "Thêm thành công";
        }else{
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(KhuyenMai km) {
        boolean update = repo.update(km);
        if(update){
            return "Cập nhật thành công";
        }else{
            return "Cập nhật thất bại";
        }
    }

    @Override
    public String delete(String ma) {
        boolean delete = repo.delete(ma);
        if(delete){
            return "Xóa thành công";
        }else{
            return "Xóa thất bại";
        }
    }
    
}
