/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import models.ChatLieu;
import repository.ChatLieuRepository;
import service.ChatLieuService;


public class ChatLieuServiceImpl implements ChatLieuService {

    private ChatLieuRepository chatLieuRepo = new ChatLieuRepository();
    
    @Override
    public List<ChatLieu> getAll(){
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return chatLieuRepo.getAll();
    }

    @Override
    public ChatLieu getByMa(String ma){
        return chatLieuRepo.getByMa(ma);
    }
    @Override
    public ChatLieu getByTen(String ten){
        return chatLieuRepo.getByTen(ten);
    }
    @Override
    public String add(ChatLieu c) {
        boolean add = chatLieuRepo.add(c);
        if(add){
            return "Thêm thành công";
        }else{
            return "Thêm không thành công";
        }
    }

    @Override
    public String update(ChatLieu c) {
        boolean update = chatLieuRepo.update(c);
        if(update){
            return "Sửa thành công";
        }else{
            return "Sửa không thành công";
        }
    }

    @Override
    public String delete(String ma) {
        boolean delete = chatLieuRepo.delete(ma);
        if (delete) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }
    
}
