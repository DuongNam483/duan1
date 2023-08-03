/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import models.HoaDon;
import viewmodels.HoaDonViewModel;

/**
 *
 * @author duong
 */
public interface HoaDonService {
    List<HoaDon> getAll();
    List<HoaDonViewModel> getAllHDVMD();
    List<HoaDonViewModel> getHDVMDByTT(int tt);
    HoaDon getByMa(String ma);
    String add(HoaDon hd);
    String update(HoaDon hd);
    String updateStatus(double tongTien, int tt, int id);
    String delete(int id);
}
