/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import models.KhuyenMai;

/**
 *
 * @author duong
 */
public interface KhuyenMaiService {
    List<KhuyenMai> getAll();
    KhuyenMai getByMa(String ma);
    KhuyenMai getByTen(String ten);
    List<KhuyenMai> getByTT(int tt);
    String add(KhuyenMai km);
    String update(KhuyenMai km);
    String delete(String ma);
}
