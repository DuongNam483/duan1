/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import models.LoaiDep;

/**
 *
 * @author duong
 */
public interface LoaiDepService {
    List<LoaiDep> getAll();
    LoaiDep getByMa(String ma);
    LoaiDep getByTen(String ten);
    String add(LoaiDep ld);
    String update(LoaiDep ld);
    String delete(String ma);
}
