/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import models.ChatLieu;

/**
 *
 * @author duong
 */
public interface ChatLieuService {
    List<ChatLieu> getAll();
    ChatLieu getByMa(String ma);
    ChatLieu getByTen(String ten);
    String add(ChatLieu c);
    String update(ChatLieu c);
    String delete(String ma);
}
