/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import models.NhanVien;

/**
 *
 * @author duong
 */
public interface NhanVienService {
    List<NhanVien> getAllNV();
    NhanVien getNVByMa(String ma);
    String add(NhanVien ctd);
    String update(NhanVien ctd);
    String delete(String ma);
}
