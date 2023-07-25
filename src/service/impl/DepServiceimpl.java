/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import models.Dep;
import repository.DepRepository;
import service.DepService;

/**
 *
 * @author duong
 */
public class DepServiceimpl implements DepService {

    private DepRepository depRepo = new DepRepository();

    @Override
    public List<Dep> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return depRepo.getAll();
    }

    @Override
    public Dep getByMa(String ma) {
        return depRepo.getByMa(ma);
    }

    @Override
    public Dep getByTen(String ten) {
        return depRepo.getByTen(ten);
    }
    @Override
    public String add(Dep d) {
        boolean add = depRepo.add(d);
        if (add) {
            return "Thêm thành công";
        } else {
            return "Thêm không thành công";
        }
    }

    @Override
    public String update(Dep d) {
        boolean update = depRepo.update(d);
        if (update) {
            return "Sửa thành công";
        } else {
            return "Sửa không thành công";
        }
    }

    @Override
    public String delete(String ma) {
        boolean delete = depRepo.delete(ma);
        if (delete) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

}
