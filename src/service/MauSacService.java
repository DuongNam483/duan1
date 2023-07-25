/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import models.MauSac;

/**
 *
 * @author duong
 */
public interface MauSacService {
    List<MauSac> getAll();
    MauSac getByMa(String ma);
    MauSac getByTen(String ten);
    String add(MauSac ms);
    String update(MauSac ms);
    String delete(String ma);
}
