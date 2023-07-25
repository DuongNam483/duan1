/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import models.ChucVu;
import repository.ChucVuRepository;
import service.ChucVuService;


public class ChucVuServiceImpl implements ChucVuService {

    private ChucVuRepository chucVuRepo = new ChucVuRepository();
    
    @Override
    public List<ChucVu> getAll(){
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return chucVuRepo.getAll();
    }

    @Override
    public ChucVu getByMa(String ma){
        return chucVuRepo.getByMa(ma);
    }
    @Override
    public ChucVu getByTen(String ten){
        return chucVuRepo.getByTen(ten);
    }
    @Override
    public String add(ChucVu c) {
        boolean add = chucVuRepo.add(c);
        if(add){
            return "Thêm thành công";
        }else{
            return "Thêm không thành công";
        }
    }

    @Override
    public String update(ChucVu c) {
        boolean update = chucVuRepo.update(c);
        if(update){
            return "Sửa thành công";
        }else{
            return "Sửa không thành công";
        }
    }

    @Override
    public String delete(String ma) {
        boolean delete = chucVuRepo.delete(ma);
        if (delete) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }
    
}
