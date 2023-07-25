/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import models.LoaiDep;
import repository.LoaiDepRepository;
import service.LoaiDepService;


public class LoaiDepServiceImpl implements LoaiDepService {

    private LoaiDepRepository loaiDepRepo = new LoaiDepRepository();
    
    @Override
    public List<LoaiDep> getAll(){
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return loaiDepRepo.getAll();
    }

    @Override
    public LoaiDep getByMa(String ma) {
        return loaiDepRepo.getByMa(ma);
    }

    @Override
    public LoaiDep getByTen(String ten) {
        return loaiDepRepo.getByTen(ten);
    }
    @Override
    public String add(LoaiDep ld) {
        boolean add = loaiDepRepo.add(ld);
        if(add){
            return "Thêm thành công";
        }else{
            return "Thêm không thành công";
        }
    }

    @Override
    public String update(LoaiDep ld) {
        boolean update = loaiDepRepo.update(ld);
        if(update){
            return "Sửa thành công";
        }else{
            return "Sửa không thành công";
        }
    }

    @Override
    public String delete(String ma) {
        boolean delete = loaiDepRepo.delete(ma);
        if (delete) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }
    
    
}
