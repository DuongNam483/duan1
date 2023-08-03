/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.Contains;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.KhuyenMai;
import service.KhuyenMaiService;
import service.impl.KhuyenMaiServiceImpl;

/**
 *
 * @author duong
 */
public class jplKhuyenMai extends javax.swing.JPanel {

    /**
     * Creates new form jplKhuyenMai
     */
    private KhuyenMaiService sv = new KhuyenMaiServiceImpl();
    private List<KhuyenMai> list = new ArrayList<>();
    DefaultTableModel dtm ;
    public jplKhuyenMai() {
        initComponents();
        dtm = (DefaultTableModel) this.tblKhuyenMai.getModel();
        rdoAll.setSelected(true);
        updateTT();
        fillTable(sv.getAll());
        for(KhuyenMai km : sv.getAll()){
            System.out.println(km.getNgayBatDau());
            System.out.println(km.getNgayKetThuc());
        }
    }

    public void fillTable(List<KhuyenMai> list){
        dtm.setRowCount(0);
        for(KhuyenMai x : list){
            String tt = "";
            tt = switch (x.getTrangThai()) {
                case 0 -> "Sắp diễn ra";
                case 1 -> "Đang diễn ra";
                default -> "Đã kết thúc";
            };
            Object[] rowdata = new Object[]{
                x.getMa(),
                x.getTen(),
                x.getPhanTramGiam(),
                x.getNgayBatDau(),
                x.getNgayKetThuc(),
                x.getMoTa(),
                tt
            };
            dtm.addRow(rowdata);
        }
    }
    public String check(int id, String ma, String ten, int ptg, LocalDate nbd, LocalDate nkt, String moTa){
        if(ma.trim().isBlank()){
            return "Mã không được để trống";
        }else{
            KhuyenMai km = sv.getByMa(ma);
            if(km != null){
                if(id == 0){
                    return "Mã đã tồn tại";
                }else if(id > 0){
                    if(km.getId() != id){
                        return "Mã đã tồn tại";
                    }
                }
            }
        }
        if(ten.trim().isBlank()){
            return "Tên không được để trống";
        }
        if(ptg == 0){
            return "Phần trăm giảm không được để trống";
        }else if(ptg <= 0 || ptg >= 100){
            return "Phần trăm giảm phải lớn hơn 0 và nhỏ hơn 100";
        }
        if(nbd.compareTo(nkt) > 0){
            return "Ngày bắt đầu phải trước ngày kết thúc";
        }
        if(moTa.trim().isBlank()){
            return "Tên không được để trống";
        }
        return "";
    }
    public int getTrangThai(LocalDate nbd, LocalDate nkt){
        LocalDate now = LocalDate.now();
        if(nkt.compareTo(now) < 0){
            return 2;
        }else if(now.compareTo(nbd) >= 0 && now.compareTo(nkt) < 0 ){
            return 1;
        }else if(now.compareTo(nbd) < 0){
            return 0;
        }else {
            return 1;
        }
    }
    public void updateTT(){
        for(KhuyenMai x : sv.getAll()){
            
            int tt = 1;
            tt = getTrangThai(x.getNgayBatDau(), x.getNgayKetThuc());
            x.setTrangThai(tt);
            sv.update(x);
        }
    }
    public void clear(){
        rdoAll.setSelected(true);
        txtMa.setText("");
        txtTen.setText("");
        txtPTG.setText("");
        txtNBD.setDate(null);
        txtNKT.setDate(null);
        txtMoTa.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtPTG = new javax.swing.JTextField();
        txtNBD = new com.toedter.calendar.JDateChooser();
        txtNKT = new com.toedter.calendar.JDateChooser();
        txtMoTa = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhuyenMai = new javax.swing.JTable();
        rdoAll = new javax.swing.JRadioButton();
        rdoSDR = new javax.swing.JRadioButton();
        rdoDDR = new javax.swing.JRadioButton();
        rdoDKT = new javax.swing.JRadioButton();

        jPanel1.setPreferredSize(new java.awt.Dimension(907, 605));

        jLabel3.setText("Mã:");

        jLabel4.setText("Tên:");

        jLabel5.setText("Phần trăm giảm:");

        jLabel6.setText("Ngày bắt đầu:");

        jLabel7.setText("Ngày kết thúc:");

        jLabel8.setText("Mô tả:");

        txtMa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        txtTen.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        txtPTG.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        txtMoTa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

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

        btnNew.setText("Làm mới");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addGap(42, 42, 42)
                        .addComponent(btnSua)
                        .addGap(58, 58, 58)
                        .addComponent(btnXoa)
                        .addGap(49, 49, 49)
                        .addComponent(btnNew)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtPTG, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(149, 149, 149)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(31, 31, 31)
                                .addComponent(txtNBD, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNKT, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                                    .addComponent(txtMoTa))))
                        .addGap(76, 76, 76))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel6)
                                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtNKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(txtPTG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnNew))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jLabel2.setText("Quản lý khuyến mại");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách khuyến mại"));

        tblKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên", "Phần trăm giảm", "Ngày bắt đầu", "Ngày kết thúc", "Mô tả", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhuyenMaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhuyenMai);

        buttonGroup1.add(rdoAll);
        rdoAll.setText("Tất cả");
        rdoAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoAllActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoSDR);
        rdoSDR.setText("Sắp diễn ra");
        rdoSDR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoSDRActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoDDR);
        rdoDDR.setText("Đang diễn ra");
        rdoDDR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDDRActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoDKT);
        rdoDKT.setText("Đã kết thúc");
        rdoDKT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDKTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 882, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdoAll)
                .addGap(18, 18, 18)
                .addComponent(rdoSDR)
                .addGap(18, 18, 18)
                .addComponent(rdoDDR)
                .addGap(18, 18, 18)
                .addComponent(rdoDKT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoAll)
                    .addComponent(rdoSDR)
                    .addComponent(rdoDDR)
                    .addComponent(rdoDKT))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 210, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(17, 17, 17)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        String ma = this.txtMa.getText();
        String ten = txtTen.getText();
        int ptg = Integer.parseInt(txtPTG.getText());
        Date d1 = txtNBD.getDate();
        if(d1 == null){
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu không được để trống");
            return;
        }
        LocalDate nbd = d1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Date d2 = txtNKT.getDate();
        if(d2 == null){
            JOptionPane.showMessageDialog(this, "Ngày kết thúc không được để trống");
            return;
        }
        LocalDate nkt = d2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String moTa = txtMoTa.getText();
        String check = check(0, ma, ten, ptg, nbd, nkt, moTa);
        if(!check.equals("")){
            JOptionPane.showMessageDialog(this, check);
            return;
        }
        KhuyenMai km = new KhuyenMai(0, ma, ten, ptg, nbd, nkt, moTa, getTrangThai(nbd, nkt));
        
        String result = sv.add(km);
        JOptionPane.showMessageDialog(this, result);
        updateTT();
        fillTable(sv.getAll());
        clear();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int index = this.tblKhuyenMai.getSelectedRow();
        if(index < 0){
            return;
        }
        int id = sv.getAll().get(index).getId();
        String ma = this.txtMa.getText();
        String ten = txtTen.getText();
        int ptg = Integer.parseInt(txtPTG.getText());
        Date d1 = txtNBD.getDate();
        if(d1 == null){
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu không được để trống");
            return;
        }
        LocalDate nbd = d1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Date d2 = txtNKT.getDate();
        if(d2 == null){
            JOptionPane.showMessageDialog(this, "Ngày kết thúc không được để trống");
            return;
        }
        LocalDate nkt = d2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String moTa = txtMoTa.getText();
        String check = check(id, ma, ten, ptg, nbd, nkt, moTa);
        if(!check.equals("")){
            JOptionPane.showMessageDialog(this, check);
            return;
        }
        KhuyenMai km = new KhuyenMai(id, ma, ten, ptg, nbd, nkt, moTa, getTrangThai(nbd, nkt));
        String result = sv.update(km);
        JOptionPane.showMessageDialog(this, result);
        updateTT();
        fillTable(sv.getAll());
        clear();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void rdoDDRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDDRActionPerformed
        fillTable(sv.getByTT(1));
    }//GEN-LAST:event_rdoDDRActionPerformed

    private void rdoAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoAllActionPerformed
        fillTable(sv.getAll());
    }//GEN-LAST:event_rdoAllActionPerformed

    private void rdoSDRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoSDRActionPerformed
        fillTable(sv.getByTT(0));
    }//GEN-LAST:event_rdoSDRActionPerformed

    private void rdoDKTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDKTActionPerformed
        fillTable(sv.getByTT(2));
    }//GEN-LAST:event_rdoDKTActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int index = tblKhuyenMai.getSelectedRow();
        if(index < 0){
            return;
        }
        String ma = this.txtMa.getText();
        String result = sv.delete(ma);
        JOptionPane.showMessageDialog(this, result);
        fillTable(sv.getAll());
        clear();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        clear();
    }//GEN-LAST:event_btnNewActionPerformed

    private void tblKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhuyenMaiMouseClicked
        int index = this.tblKhuyenMai.getSelectedRow();
        if(index < 0 ){
            return;
        }
        list = new ArrayList<>();
        if(rdoAll.isSelected()){
            list = sv.getAll();
        }else if(rdoSDR.isSelected()){
            list = sv.getByTT(0);
        }else if(rdoDDR.isSelected()){
            list = sv.getByTT(1);
        }else if(rdoDKT.isSelected()){
            list = sv.getByTT(2);
        }
        KhuyenMai km = list.get(index);
        txtMa.setText(km.getMa());
        txtTen.setText(km.getTen());
        String ptg = String.valueOf(km.getPhanTramGiam());
        txtPTG.setText(ptg);
        //Date.from(listNV.get(index).getNgaySinh().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())
        txtNBD.setDate(Date.from(km.getNgayBatDau().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        txtNKT.setDate(Date.from(km.getNgayKetThuc().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        txtMoTa.setText(km.getMoTa());
    }//GEN-LAST:event_tblKhuyenMaiMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoAll;
    private javax.swing.JRadioButton rdoDDR;
    private javax.swing.JRadioButton rdoDKT;
    private javax.swing.JRadioButton rdoSDR;
    private javax.swing.JTable tblKhuyenMai;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMoTa;
    private com.toedter.calendar.JDateChooser txtNBD;
    private com.toedter.calendar.JDateChooser txtNKT;
    private javax.swing.JTextField txtPTG;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
