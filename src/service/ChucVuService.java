/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import models.ChucVu;

/**
 *
 * @author duong
 */
public interface ChucVuService {
    List<ChucVu> getAll();
    ChucVu getByMa(String ma);
    ChucVu getByTen(String ten);
    String add(ChucVu c);
    String update(ChucVu c);
    String delete(String ma);
}
