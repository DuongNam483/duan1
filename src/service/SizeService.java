/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import models.Size;

/**
 *
 * @author duong
 */
public interface SizeService {
    List<Size> getAll();
    Size getByMa(String ma);
    Size getByTen(int ten);
    String add(Size s);
    String update(Size s);
    String delete(String ma);
}
