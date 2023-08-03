/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import models.HoaDon;
import repository.HoaDonRepository;
import service.HoaDonService;
import viewmodels.HoaDonViewModel;


public class HoaDonServiceImpl implements HoaDonService {
    
    private HoaDonRepository repo = new HoaDonRepository();
    
    @Override
    public List<HoaDon> getAll() {
        return repo.getAll();
    }

    @Override
    public HoaDon getByMa(String ma) {
        return repo.getByMa(ma);
    }
    
    @Override
    public List<HoaDonViewModel> getAllHDVMD(){
        return repo.getAllHDVMD();
    }
    
    @Override
    public List<HoaDonViewModel> getHDVMDByTT(int tt){
        return repo.getHDVMDByTT(tt);
    }
    
    @Override
    public String add(HoaDon hd) {
        boolean add = repo.add(hd);
        if(add){
            return "Thêm thành công";
        }else{
            return "Thêm không thành công";
        }
    }

    @Override
    public String update(HoaDon hd) {
        boolean update = repo.update(hd);
        if(update){
            return "Cập nhật thành công";
        }else{
            return "Cập nhật không thành công";
        }
    }

    @Override
    public String updateStatus(double tongTien, int tt, int id) {
        boolean updateStatus = repo.updateStatus(tongTien, tt, id);
        if(updateStatus){
            return "Thanh toán thành công";
        }else{
            return "Thanh toán không thành công";
        }
    }

    @Override
    public String delete(int id) {
        boolean delete = repo.delete(id);
        if(delete){
            return "Xóa thành công";
        }else{
            return "Xóa không thành công";
        }
    }
    
}
