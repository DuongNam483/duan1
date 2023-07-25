/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import models.NhanVien;
import repository.NhanVienRepository;
import service.NhanVienService;


public class NhanVienServiceImpl implements NhanVienService {

    private NhanVienRepository repo = new NhanVienRepository();
    
    @Override
    public List<NhanVien> getAllNV(){
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return repo.getAllNV();
    }

    @Override
    public NhanVien getNVByMa(String ma){
        return repo.getNVByMa(ma);
    }
//    @Override
//    public NhanVien getByTen(String ten){
//        return repo.getByTen(ten);
//    }
    @Override
    public String add(NhanVien c) {
        boolean add = repo.add(c);
        if(add){
            return "Thêm thành công";
        }else{
            return "Thêm không thành công";
        }
    }

    @Override
    public String update(NhanVien c) {
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
