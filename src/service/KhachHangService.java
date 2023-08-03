/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import models.KhachHang;

/**
 *
 * @author duong
 */
public interface KhachHangService {
    List<KhachHang> getAllNV();
    KhachHang getNVByMa(String ma);
    List<KhachHang> getByTen(String ten);
    String add(KhachHang ctd);
    String update(KhachHang ctd);
    String delete(String ma);
}
