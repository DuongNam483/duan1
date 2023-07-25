/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import models.ChiTietDep;
import repository.SanPhamRepository;
import service.SanPhamService;
import viewmodels.SanPhamViewModel;


public class SanPhamServiceImpl implements SanPhamService {
    private SanPhamRepository repo = new SanPhamRepository();
    
    @Override
    public List<ChiTietDep> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return repo.getAllSP();
    }

    @Override
    public List<SanPhamViewModel> getAllSPVMD() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return repo.getAllSPVMD();
    }
    
    @Override
    public ChiTietDep getCTDByMa(String ma){
        return repo.getCTDByMa(ma);
    }
    
    @Override
    public List<SanPhamViewModel> getFillterSPV(int idCL, int idD, int idLD, int idMS, int idNSX, int idSize){
        return repo.filterResponses(idCL, idD, idLD, idMS, idNSX, idSize);
    }

    @Override
    public String add(ChiTietDep ctd) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        boolean add = repo.add(ctd);
        if(add){
            return "Thêm thành công.";
        }else{
            return "Thêm không thành công.";
        }
    }

    @Override
    public String update(ChiTietDep ctd) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        boolean update = repo.update(ctd);
        if(update){
            return "Sửa thành công.";
        }else{
            return "Sửa không thành công.";
        }
    }

    @Override
    public String delete(String ma) {
        boolean delete = repo.delete(ma);
        if(delete){
            return "Xóa thành công.";
        }else{
            return "Xóa không thành công.";
        }
    }

    @Override
    public SanPhamViewModel getSPVMD(String ma) {
        return repo.getSPVMD(ma);
    }
    
}
