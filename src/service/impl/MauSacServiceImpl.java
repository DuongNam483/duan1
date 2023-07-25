/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import models.MauSac;
import repository.MauSacRepository;
import service.MauSacService;

public class MauSacServiceImpl implements MauSacService {

    private MauSacRepository mauSacDepRepo = new MauSacRepository();

    @Override
    public List<MauSac> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return mauSacDepRepo.getAll();
    }

    @Override
    public MauSac getByMa(String ma) {
        return mauSacDepRepo.getByMa(ma);
    }

    @Override
    public MauSac getByTen(String ten) {
        return mauSacDepRepo.getByTen(ten);
    }

    @Override
    public String add(MauSac ms) {
        boolean add = mauSacDepRepo.add(ms);
        if (add) {
            return "Thêm thành công";
        } else {
            return "Thêm không thành công";
        }
    }

    @Override
    public String update(MauSac ms) {
        boolean update = mauSacDepRepo.update(ms);
        if (update) {
            return "Sửa thành công";
        } else {
            return "Sửa không thành công";
        }
    }

    @Override
    public String delete(String ma) {
        boolean delete = mauSacDepRepo.delete(ma);
        if (delete) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

}
