/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import models.Size;
import repository.SizeRepository;
import service.SizeService;


public class SizeServiceImpl implements SizeService {

    private SizeRepository sizeDepRepo = new SizeRepository();
    
    @Override
    public List<Size> getAll(){
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return sizeDepRepo.getAll();
    }

    @Override
    public Size getByMa(String ma) {
        return sizeDepRepo.getByMa(ma);
    }

    @Override
    public Size getByTen(int ten) {
        return sizeDepRepo.getByTen(ten);
    }

    @Override
    public String add(Size s) {
        boolean add = sizeDepRepo.add(s);
        if(add){
            return "Thêm thành công";
        }else{
            return "Thêm không thành công";
        }
    }

    @Override
    public String update(Size s) {
        boolean update = sizeDepRepo.update(s);
        if(update){
            return "Sửa thành công";
        }else{
            return "Sửa không thành công";
        }
    }

    @Override
    public String delete(String ma) {
        boolean delete = sizeDepRepo.delete(ma);
        if (delete) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }
    
}
