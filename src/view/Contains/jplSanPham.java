/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.Contains;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.ChatLieu;
import models.ChiTietDep;
import models.Dep;
import models.LoaiDep;
import models.MauSac;
import models.NSX;
import models.Size;
import service.ChatLieuService;
import service.DepService;
import service.LoaiDepService;
import service.MauSacService;
import service.NSXService;
import service.SanPhamService;
import service.SizeService;
import service.impl.ChatLieuServiceImpl;
import service.impl.DepServiceimpl;
import service.impl.LoaiDepServiceImpl;
import service.impl.MauSacServiceImpl;
import service.impl.NSXServiceImpl;
import service.impl.SanPhamServiceImpl;
import service.impl.SizeServiceImpl;
import viewmodels.SanPhamViewModel;
import views.Contains.Sanpham.ThemChatLieu;
import views.Contains.Sanpham.ThemDep;
import views.Contains.Sanpham.ThemLoaiDep;
import views.Contains.Sanpham.ThemMauSac;
import views.Contains.Sanpham.ThemNSX;
import views.Contains.Sanpham.ThemSize;

/**
 *
 * @author duong
 */
public class jplSanPham extends javax.swing.JPanel {

    private ChatLieuService clService = new ChatLieuServiceImpl();
    private DepService dService = new DepServiceimpl();
    private LoaiDepService ldService = new LoaiDepServiceImpl();
    private MauSacService msService = new MauSacServiceImpl();
    private NSXService nsxService = new NSXServiceImpl();
    private SanPhamService spService = new SanPhamServiceImpl();
    private SizeService sizeService = new SizeServiceImpl();
    private List<ChiTietDep> listCTD = new ArrayList<>();
    private List<SanPhamViewModel> listSPMD = new ArrayList<>();
    private SanPhamService sv = new SanPhamServiceImpl();
    private DefaultComboBoxModel dfcbbcl;
    private DefaultComboBoxModel dfcbbd;
    private DefaultComboBoxModel dfcbbld;
    private DefaultComboBoxModel dfcbbms;
    private DefaultComboBoxModel dfcbbnsx;
    private DefaultComboBoxModel dfcbbsize;
    private DefaultTableModel dtm;

    public jplSanPham() {
        initComponents();
//        List<ChatLieu> listCL = clService.getAll();
//        cbbChatLieu.setModel(new DefaultComboBoxModel(listCL.toArray()));
//        for(ChatLieu x : listCL){
//            cbbChatLieu.addItem(x.getTen());
//        }
//        List<Dep> listD = dService.getAll();
//        cbbDep.setModel(new DefaultComboBoxModel(listD.toArray()));
//        List<LoaiDep> listLD = ldService.getAll();
//        cbbLoaiDep.setModel(new DefaultComboBoxModel(listLD.toArray()));
//        List<MauSac> listMS = msService.getAll();
//        cbbMauSac.setModel(new DefaultComboBoxModel(listMS.toArray()));
//        List<NSX> listNSX = nsxService.getAll();
//        cbbNSX.setModel(new DefaultComboBoxModel(listNSX.toArray()));
//        List<Size> listSize= sizeService.getAll();
//        cbbSize.setModel(new DefaultComboBoxModel(listSize.toArray()));
        dfcbbcl = (DefaultComboBoxModel) cbbChatLieu.getModel();
        List<ChatLieu> listCL = clService.getAll();
        listCL.forEach(h -> cbbChatLieu.addItem(h.getTen()));
        listCL.forEach(h -> cbbLocCL.addItem(h.getTen()));

        dfcbbd = (DefaultComboBoxModel) cbbDep.getModel();
        List<Dep> listD = dService.getAll();
        listD.forEach(h -> cbbDep.addItem(h.getTen()));
        listD.forEach(h -> cbbLocDep.addItem(h.getTen()));

        dfcbbld = (DefaultComboBoxModel) cbbLoaiDep.getModel();
        List<LoaiDep> listLD = ldService.getAll();
        listLD.forEach(h -> cbbLoaiDep.addItem(h.getTen()));
        listLD.forEach(h -> cbbLocLD.addItem(h.getTen()));

        dfcbbms = (DefaultComboBoxModel) cbbMauSac.getModel();
        List<MauSac> listMauSac = msService.getAll();
        listMauSac.forEach(h -> cbbMauSac.addItem(h.getMauSac()));
        listMauSac.forEach(h -> cbbLocMau.addItem(h.getMauSac()));

        dfcbbnsx = (DefaultComboBoxModel) cbbNSX.getModel();
        List<NSX> listNSX = nsxService.getAll();
        listNSX.forEach(h -> cbbNSX.addItem(h.getTen()));
        listNSX.forEach(h -> cbbLocNSX.addItem(h.getTen()));

        dfcbbsize = (DefaultComboBoxModel) cbbSize.getModel();
        List<Size> listSize = sizeService.getAll();
        listSize.forEach(h -> cbbSize.addItem(h.getKichCo()));
        listSize.forEach(h -> cbbLocSize.addItem(h.getKichCo()));

        dtm = (DefaultTableModel) tblSanPham.getModel();

        fillTable();
    }

    public void fillTable() {
        listSPMD = spService.getAllSPVMD();
//        DefaultTableModel dtm = (DefaultTableModel) tblSanPham.getModel();
        dtm.setRowCount(0);
        for (SanPhamViewModel x : listSPMD) {
            Object[] rowdata = new Object[]{
                x.getMa(),
                x.getDep(),
                x.getLoaiDep(),
                x.getSize(),
                x.getMauSac(),
                x.getChatLieu(),
                x.getNSX(),
                x.getMoTa(),
                x.getSoLuong(),
                x.getGiaNhap(),
                x.getGiaBan()
            };
            dtm.addRow(rowdata);
        }
    }

    public void fillTable1(List<SanPhamViewModel> list) {
        //DefaultTableModel dtm = (DefaultTableModel) tblSanPham.getModel();
//        dtm = (DefaultTableModel) tblSanPham.getModel();
        dtm.setRowCount(0);
        for (SanPhamViewModel x : list) {
            Object[] rowdata = new Object[]{
                x.getMa(),
                x.getDep(),
                x.getLoaiDep(),
                x.getSize(),
                x.getMauSac(),
                x.getChatLieu(),
                x.getNSX(),
                x.getMoTa(),
                x.getSoLuong(),
                x.getGiaNhap(),
                x.getGiaBan()
            };
            dtm.addRow(rowdata);
        }
    }

    public String check(int id, String ma, String sl, String moTa, String giaNhap, String giaBan) {
        listSPMD = sv.getAllSPVMD();

        if (ma.isBlank()) {
            return "Mã không được để trống.";
        } else {
            ChiTietDep ctd = sv.getCTDByMa(ma);
            System.out.println(ctd);
            if (ctd != null) {
                if (id == 0) {
                    return "Mã đã tồn tại.";
                } else if (id > 0) {
                    if (ctd.getId() != id) {
                        return "Mã đã tồn tại.";
                    }
                }
            }
        }

        if (sl.isBlank()) {
            return "Số lượng không được để trống.";
        } else if (moTa.isBlank()) {
            return "Mô tả không được để trống.";
        } else if (giaNhap.isBlank()) {
            return "Giá nhập không được để trống.";
        } else if (giaBan.isBlank()) {
            return "Giá bán không được để trống.";
        }
//        for(SanPhamViewModel sp : listSPMD){
//            if(ma.equals(sp.getMa())){
//                return "Mã đã tồn tại.";
//            }
//        }
        if (!sl.matches("[0-9]+")) {
            return "Số lượng phải là số nguyên lớn hơn 0.";
        }
        if (!giaBan.matches("^[1-9]\\d*(\\.\\d+)?$")) {
            return "Giá bán phải lớn hơn 0";
        }
        if (!giaNhap.matches("^[1-9]\\d*(\\.\\d+)?$")) {
            return "Giá nhập phải lớn hơn 0";
        }
        return "";
    }

    public void clear() {
        txtMa.setText("");
        txtSL.setText("");
        txtMoTa.setText("");
        txtGiaBan.setText("");
        txtGiaNhap.setText("");
        cbbChatLieu.setSelectedIndex(0);
        cbbDep.setSelectedIndex(0);
        cbbLoaiDep.setSelectedIndex(0);
        cbbMauSac.setSelectedIndex(0);
        cbbNSX.setSelectedIndex(0);
        cbbSize.setSelectedIndex(0);
        txtTim.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();
        cbbLocDep = new javax.swing.JComboBox<>();
        cbbLocLD = new javax.swing.JComboBox<>();
        cbbLocSize = new javax.swing.JComboBox<>();
        cbbLocCL = new javax.swing.JComboBox<>();
        cbbLocMau = new javax.swing.JComboBox<>();
        cbbLocNSX = new javax.swing.JComboBox<>();
        btnLoc = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        btnTim = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        cbbLoaiDep = new javax.swing.JComboBox<>();
        btnLoaiDep = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        cbbDep = new javax.swing.JComboBox<>();
        btnThemDep = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        cbbSize = new javax.swing.JComboBox<>();
        btnSize = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        cbbMauSac = new javax.swing.JComboBox<>();
        btnMauSac = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        cbbNSX = new javax.swing.JComboBox<>();
        btnNSX = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        cbbChatLieu = new javax.swing.JComboBox<>();
        btnChatLieu = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        txtSL = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtGiaNhap = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMoTa = new javax.swing.JTextField();

        jLabel2.setText("Tìm kiếm:");

        txtTim.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimActionPerformed(evt);
            }
        });

        btnLoc.setText("Lọc");
        btnLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocActionPerformed(evt);
            }
        });

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Dép", "Loại dép", "Kích cỡ", "Màu sắc", "Chất liệu", "NSX", "Mô tả", "Số lượng", "Giá nhập", "Giá bán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTim))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cbbLocDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbbLocLD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbbLocSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbbLocMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbbLocCL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbbLocNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLoc)))
                        .addGap(0, 26, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbLocDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbLocLD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbLocSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbLocMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbLocCL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbLocNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Loại dép"));

        btnLoaiDep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editing.png"))); // NOI18N
        btnLoaiDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoaiDepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnLoaiDep, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(cbbLoaiDep, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbLoaiDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLoaiDep)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Dép"));

        btnThemDep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editing.png"))); // NOI18N
        btnThemDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbbDep, 0, 106, Short.MAX_VALUE)
                    .addComponent(btnThemDep, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThemDep)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Kích cỡ\n"));

        btnSize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editing.png"))); // NOI18N
        btnSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbSize, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSize, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSize)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Màu sắc"));

        btnMauSac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editing.png"))); // NOI18N
        btnMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMauSacActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMauSac, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(cbbMauSac, 0, 106, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMauSac)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhà sản xuất"));

        btnNSX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editing.png"))); // NOI18N
        btnNSX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNSXActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNSX, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(cbbNSX, 0, 106, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNSX)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Chất liệu"));

        btnChatLieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editing.png"))); // NOI18N
        btnChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChatLieuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnChatLieu, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(cbbChatLieu, 0, 106, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnChatLieu)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(126, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(494, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(156, Short.MAX_VALUE)))
        );

        jLabel1.setText("Mã:");

        txtMa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaActionPerformed(evt);
            }
        });

        jLabel3.setText("Số lượng");

        btnNew.setText("Mới");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        txtSL.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel4.setText("Giá nhập:");

        txtGiaNhap.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel5.setText("Giá bán:");

        txtGiaBan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel6.setText("Mô tả:");

        txtMoTa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btnSua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                .addComponent(btnXoa))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btnNew)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnThem)))
                        .addGap(16, 16, 16))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtMoTa)
                            .addComponent(txtGiaNhap, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMa, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnNew))
                .addGap(60, 60, 60)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua)
                    .addComponent(btnXoa))
                .addGap(111, 111, 111))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimActionPerformed

    private void txtMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
//        ChatLieu cl = (ChatLieu) cbbChatLieu.getSelectedItem();
//        Dep d = (Dep) cbbDep.getSelectedItem();
//        LoaiDep ld = (LoaiDep) cbbLoaiDep.getSelectedItem();
//        MauSac ms = (MauSac) cbbMauSac.getSelectedItem();
//        NSX nsx = (NSX) cbbNSX.getSelectedItem();
//        Size s = (Size) cbbSize.getSelectedItem();

        ChatLieu cl = clService.getByTen((String) cbbChatLieu.getSelectedItem());
        Dep d = dService.getByTen((String) cbbDep.getSelectedItem());
        LoaiDep ld = ldService.getByTen((String) cbbLoaiDep.getSelectedItem());
        MauSac ms = msService.getByTen((String) cbbMauSac.getSelectedItem());
        NSX nsx = nsxService.getByTen((String) cbbNSX.getSelectedItem());
        String kichCo = cbbSize.getSelectedItem().toString();
        int a = Integer.parseInt(kichCo);
        Size s = sizeService.getByTen(a);
        System.out.println(s);
        String ma = txtMa.getText();
        String sl = txtSL.getText();
        String moTa = txtMoTa.getText();
        String giaNhap = txtGiaNhap.getText();
        String giaBan = txtGiaBan.getText();
        String check = check(0, ma, sl, moTa, giaNhap, giaBan);
        System.out.println(ma);
        if (!check.equals("")) {
            JOptionPane.showMessageDialog(this, check);
            return;
        }
//        System.out.println(ma);
        ChiTietDep ctd = new ChiTietDep();
        ctd.setIdChatLieu(cl.getId());
        ctd.setIdDep(d.getId());
        ctd.setIdLoaiDep(ld.getId());
        ctd.setIdMauSac(ms.getId());
        ctd.setIdNSX(nsx.getId());
        ctd.setIdSize(s.getId());
        ctd.setMa(ma);
        ctd.setSoLuong(Integer.parseInt(sl));
        ctd.setMoTa(moTa);
        ctd.setGiaNhap(Double.valueOf(giaNhap));
        ctd.setGiaBan(Double.valueOf(giaBan));
        String insert = sv.add(ctd);
        JOptionPane.showMessageDialog(this, insert);
        fillTable();
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        int index = tblSanPham.getSelectedRow();
        if (index < 0) {
            return;
        }
        listSPMD = sv.getAllSPVMD();
        SanPhamViewModel sp = listSPMD.get(index);
//        System.out.println(sp.getChatLieu());
//        System.out.println(clService.getByTen(sp.getChatLieu()));
        cbbChatLieu.setSelectedItem(sp.getChatLieu());
//        System.out.println(sp.getDep());
//        System.out.println(dService.getByTen(sp.getDep()));
        cbbDep.setSelectedItem(sp.getDep());
        cbbLoaiDep.setSelectedItem(sp.getLoaiDep());
        cbbMauSac.setSelectedItem(sp.getMauSac());
        cbbNSX.setSelectedItem(sp.getNSX());
        cbbSize.setSelectedItem(sp.getSize());
        txtMa.setText(sp.getMa());
        txtSL.setText(String.valueOf(sp.getSoLuong()));
        txtMoTa.setText(sp.getMoTa());
        txtGiaNhap.setText(String.valueOf(sp.getGiaNhap()));
        txtGiaBan.setText(String.valueOf(sp.getGiaBan()));

    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        clear();
        fillTable();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int index = this.tblSanPham.getSelectedRow();
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?");
        
        
        if (index == -1) {
            return;
        }
        if(confirm != JOptionPane.YES_OPTION){
            return;
        }
        String ma = txtMa.getText();
        String result = sv.delete(ma);
        JOptionPane.showMessageDialog(this, result);
        fillTable();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int index = tblSanPham.getSelectedRow();
        if (index < 0) {
            return;
        }
        listSPMD = sv.getAllSPVMD();
        SanPhamViewModel sp = listSPMD.get(index);
        ChatLieu cl = clService.getByTen((String) cbbChatLieu.getSelectedItem());
        Dep d = dService.getByTen((String) cbbDep.getSelectedItem());
        LoaiDep ld = ldService.getByTen((String) cbbLoaiDep.getSelectedItem());
        MauSac ms = msService.getByTen((String) cbbMauSac.getSelectedItem());
        NSX nsx = nsxService.getByTen((String) cbbNSX.getSelectedItem());
        String kichCo = cbbSize.getSelectedItem().toString();
        int a = Integer.parseInt(kichCo);
        Size s = sizeService.getByTen(a);
        System.out.println(s);
        String ma = txtMa.getText();
        int id = sp.getId();
//        if(ma.isBlank()){
//            JOptionPane.showMessageDialog(this, "Mã không được để trống");
//        }
        String sl = txtSL.getText();
        String moTa = txtMoTa.getText();
        String giaNhap = txtGiaNhap.getText();
        String giaBan = txtGiaBan.getText();
        String check = check(id, ma, sl, moTa, giaNhap, giaBan);
        if (!check.equals("")) {
            JOptionPane.showMessageDialog(this, check);
            return;
        }
//        System.out.println(ma);
        ChiTietDep ctd = new ChiTietDep();
        ctd.setId(sp.getId());
        ctd.setIdChatLieu(cl.getId());
        ctd.setIdDep(d.getId());
        ctd.setIdLoaiDep(ld.getId());
        ctd.setIdMauSac(ms.getId());
        ctd.setIdNSX(nsx.getId());
        ctd.setIdSize(s.getId());
        ctd.setMa(ma);
        ctd.setSoLuong(Integer.parseInt(sl));
        ctd.setMoTa(moTa);
        ctd.setGiaNhap(Double.valueOf(giaNhap));
        ctd.setGiaBan(Double.valueOf(giaBan));
        String result = sv.update(ctd);
        JOptionPane.showMessageDialog(this, result);
        fillTable();
        clear();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocActionPerformed
        ChatLieu cl = clService.getByTen((String) cbbLocCL.getSelectedItem());
        Dep d = dService.getByTen((String) cbbLocDep.getSelectedItem());
        LoaiDep ld = ldService.getByTen((String) cbbLocLD.getSelectedItem());
        MauSac ms = msService.getByTen((String) cbbLocMau.getSelectedItem());
        NSX nsx = nsxService.getByTen((String) cbbLocNSX.getSelectedItem());
        String kichCo = cbbLocSize.getSelectedItem().toString();
        int a = Integer.parseInt(kichCo);
        Size s = sizeService.getByTen(a);
        listSPMD = sv.getFillterSPV(cl.getId(), d.getId(), ld.getId(), ms.getId(), nsx.getId(), s.getId());
        System.out.println(cl.getId());
        System.out.println(d.getId());
        System.out.println(ld.getId());
        System.out.println(ms.getId());
        System.out.println(nsx.getId());
        System.out.println(s.getId());
        
        System.out.println(listCTD);
//        for(SanPhamViewModel x : listSPMD){
//            System.out.println(x.getMa());
//        }
//        fillTable1(listSPMD);
//        DefaultTableModel dtm = (DefaultTableModel) tblSanPham.getModel();
//        dtm = (DefaultTableModel) tblSanPham.getModel();
        dtm.setRowCount(0);
        for (SanPhamViewModel x : listSPMD) {
            Object[] rowdata = new Object[]{
                x.getMa(),
                x.getDep(),
                x.getLoaiDep(),
                x.getSize(),
                x.getMauSac(),
                x.getChatLieu(),
                x.getNSX(),
                x.getMoTa(),
                x.getSoLuong(),
                x.getGiaNhap(),
                x.getGiaBan()
            };
            dtm.addRow(rowdata);
        }
    }//GEN-LAST:event_btnLocActionPerformed

    private void btnThemDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDepActionPerformed
        new ThemDep().setVisible(true);
    }//GEN-LAST:event_btnThemDepActionPerformed

    private void btnLoaiDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoaiDepActionPerformed
        new ThemLoaiDep().setVisible(true);
    }//GEN-LAST:event_btnLoaiDepActionPerformed

    private void btnSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSizeActionPerformed
        new ThemSize().setVisible(true);
    }//GEN-LAST:event_btnSizeActionPerformed

    private void btnMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMauSacActionPerformed
        new ThemMauSac().setVisible(true);
    }//GEN-LAST:event_btnMauSacActionPerformed

    private void btnChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatLieuActionPerformed
        new ThemChatLieu().setVisible(true);
    }//GEN-LAST:event_btnChatLieuActionPerformed

    private void btnNSXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNSXActionPerformed
        new ThemNSX().setVisible(true);
    }//GEN-LAST:event_btnNSXActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        String ma = txtTim.getText();
        if(ma.isBlank()){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã dép muốn tìm.");
        }
        SanPhamViewModel sp = new SanPhamViewModel();
        sp = sv.getSPVMD(ma);
        dtm.setRowCount(0);
        Object[] rowdata = new Object[]{
            sp.getMa(),
            sp.getDep(),
            sp.getLoaiDep(),
            sp.getSize(),
            sp.getMauSac(),
            sp.getChatLieu(),
            sp.getNSX(),
            sp.getMoTa(),
            sp.getSoLuong(),
            sp.getGiaNhap(),
            sp.getGiaBan()
        };
        dtm.addRow(rowdata);
    }//GEN-LAST:event_btnTimActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChatLieu;
    private javax.swing.JButton btnLoaiDep;
    private javax.swing.JButton btnLoc;
    private javax.swing.JButton btnMauSac;
    private javax.swing.JButton btnNSX;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSize;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemDep;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbChatLieu;
    private javax.swing.JComboBox<String> cbbDep;
    private javax.swing.JComboBox<String> cbbLoaiDep;
    private javax.swing.JComboBox<String> cbbLocCL;
    private javax.swing.JComboBox<String> cbbLocDep;
    private javax.swing.JComboBox<String> cbbLocLD;
    private javax.swing.JComboBox<String> cbbLocMau;
    private javax.swing.JComboBox<String> cbbLocNSX;
    private javax.swing.JComboBox<String> cbbLocSize;
    private javax.swing.JComboBox<String> cbbMauSac;
    private javax.swing.JComboBox<String> cbbNSX;
    private javax.swing.JComboBox<String> cbbSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtSL;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
