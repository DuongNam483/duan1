/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import models.HoaDonChiTiet;
import viewmodels.HoaDonChiTietViewModel;

/**
 *
 * @author duong
 */
public interface HoaDonChiTietService {
    List<HoaDonChiTiet> getAll();
    List<HoaDonChiTietViewModel> getAllGH();
    List<HoaDonChiTietViewModel> getGHByMa(String ma);
    HoaDonChiTiet getByMa(int idHDCT);
    String add(HoaDonChiTiet hd);
    String update(HoaDonChiTiet hd);
    String delete(int id);
    String deleteSP(int id, int  idSP);
}
