/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import models.KhachHang;
import repository.KhachHangRepository;
import service.KhachHangService;


public class KhachHangServiceImpl implements KhachHangService {

    private KhachHangRepository repo = new KhachHangRepository();
    
    @Override
    public List<KhachHang> getAllNV(){
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return repo.getAll();
    }

    @Override
    public KhachHang getNVByMa(String ma){
        return repo.getNVByMa(ma);
    }
    
    @Override
    public List<KhachHang> getByTen(String ten){
        return repo.getByTen(ten);
    }
    
    @Override
    public String add(KhachHang c) {
        boolean add = repo.add(c);
        if(add){
            return "Thêm thành công";
        }else{
            return "Thêm không thành công";
        }
    }

    @Override
    public String update(KhachHang c) {
        boolean update = repo.update(c);
        if(update){
            return "Sửa thành công";
        }else{
            return "Sửa không thành công";
        }
    }

    @Override
    public String delete(String ma) {
        boolean delete = repo.delete(ma);
        if (delete) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }



    
}
