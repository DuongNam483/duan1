/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import models.NSX;

/**
 *
 * @author duong
 */
public interface NSXService {
    List<NSX> getAll();
    NSX getByMa(String ma);
    NSX getByTen(String ten);
    String add(NSX nsx);
    String update(NSX nsx);
    String delete(String ma);
}
