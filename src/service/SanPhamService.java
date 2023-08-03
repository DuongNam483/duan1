/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import models.ChiTietDep;
import viewmodels.SanPhamViewModel;

/**
 *
 * @author duong
 */
public interface SanPhamService {
    List<ChiTietDep> getAll();
    List<SanPhamViewModel> getAllSPVMD();
    List<SanPhamViewModel> getFillterSPV(int idCL, int idD, int idLD, int idMS, int idNSX, int idSize);
    ChiTietDep getByID(int id);
    ChiTietDep getCTDByMa(String ma);
    String add(ChiTietDep ctd);
    String update(ChiTietDep ctd);
    String updateSL(int sl, int id);
    String delete(String ma);
    SanPhamViewModel getSPVMD(String ma);
}
