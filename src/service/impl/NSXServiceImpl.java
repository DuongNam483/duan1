/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import models.NSX;
import repository.NSXRepository;
import service.NSXService;


public class NSXServiceImpl implements NSXService {

    private NSXRepository nsxDepRepo = new NSXRepository();
    
    @Override
    public List<NSX> getAll(){
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return nsxDepRepo.getAll();
    }

    @Override
    public NSX getByMa(String ma) {
        return nsxDepRepo.getByMa(ma);
    }

    @Override
    public NSX getByTen(String ten) {
        return nsxDepRepo.getByTen(ten);
    }

    @Override
    public String add(NSX nsx) {
        boolean add = nsxDepRepo.add(nsx);
        if(add){
            return "Thêm thành công";
        }else{
            return "Thêm không thành công";
        }
    }

    @Override
    public String update(NSX nsx) {
        boolean update = nsxDepRepo.update(nsx);
        if(update){
            return "Sửa thành công";
        }else{
            return "Sửa không thành công";
        }
    }

    @Override
    public String delete(String ma) {
        boolean delete = nsxDepRepo.delete(ma);
        if (delete) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }
    
}
