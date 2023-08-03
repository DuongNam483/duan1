/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import models.HoaDonChiTiet;
import repository.ChiTietHoaDonRepository;
import service.HoaDonChiTietService;
import viewmodels.HoaDonChiTietViewModel;


public class HoaDonChiTietServiceImpl implements HoaDonChiTietService {

    private ChiTietHoaDonRepository repo = new ChiTietHoaDonRepository();
    
    @Override
    public List<HoaDonChiTiet> getAll() {
        return repo.getAll();
    }

    @Override
    public HoaDonChiTiet getByMa(int idHDCT) {
        return repo.getByMa(idHDCT);
    }

    @Override
    public List<HoaDonChiTietViewModel> getAllGH(){
        return repo.getAllGH();
    }
    
    @Override
    public List<HoaDonChiTietViewModel> getGHByMa(String ma){
        return repo.getGHByMa(ma);
    }
    
    @Override
    public String add(HoaDonChiTiet hd) {
        boolean add = repo.add(hd);
        if(add){
            return "Thêm thành công";
        }else{
            return "Thêm không thành công";
        }
    }

    @Override
    public String update(HoaDonChiTiet hd) {
        boolean update = repo.update(hd);
        if(update){
            return "Cập nhật thành công";
        }else{
            return "Cập nhật không thành công";
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
    
    @Override
    public String deleteSP(int id, int idSP) {
        boolean delete = repo.deleteSP(id, idSP);
        if(delete){
            return "Xóa sản phẩm thành công";
        }else{
            return "Xóa sản phẩm không thành công";
        }
    }
}
