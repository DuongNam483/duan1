/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import models.Dep;

/**
 *
 * @author duong
 */
public interface DepService {
    List<Dep> getAll();
    Dep getByMa(String ma);
    Dep getByTen(String ten);
    String add(Dep d);
    String update(Dep d);
    String delete(String ma);
}
