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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.ChucVu;
import models.NhanVien;
import service.ChucVuService;
import service.NhanVienService;
import service.impl.ChucVuServiceImpl;
import service.impl.NhanVienServiceImpl;

/**
 *
 * @author duong
 */
public class jplNhanVien extends javax.swing.JPanel {

    private NhanVienService sv = new NhanVienServiceImpl();
    private DefaultComboBoxModel cvDF;
    private DefaultTableModel dtm;
    private ChucVuService cvSV = new ChucVuServiceImpl();
    List<NhanVien> listNV = new ArrayList<>();

    public jplNhanVien() {
        initComponents();
        cvDF = (DefaultComboBoxModel) cbbCV.getModel();
        List<ChucVu> listCV = cvSV.getAll();
        listCV.forEach(cv -> cbbCV.addItem(cv.getTen()));
        dtm = (DefaultTableModel) tblNhanVien.getModel();

        fillTable();
    }

    public void fillTable() {
        listNV = sv.getAllNV();
        dtm.setRowCount(0);
        for (NhanVien x : listNV) {
            Object[] rowdata = new Object[]{
                x.getMa(),
                x.getTen(),
                x.getNgaySinh(),
                x.getEmail(),
                x.getSdt(),
                x.isGioiTinh() == true ? "Nam" : "Nữ",
                x.getDiaChi(),
                x.getIdCV() == 1 ? "Quản lý" : "Nhân viên",
                x.getTaiKhoan(),
                x.getMaKhau()
            };
            dtm.addRow(rowdata);
        }
    }
//    public NhanVien getFormData(){
//        String ma = txtMa.getText();
//        String ten = txtTen.getText();
//        Date date1 = txtNgaySinh.getDate();
//        System.out.println(date1);
//        LocalDate ngaySinh = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//        String email = txtEmail.getText();
//        String sdt = txtSDT.getText();
//        int gioiTinh = rdoNam.isSelected() ? 1 : 0;
//        String diaChi = txtDiaChi.getText();
//        String taiKhoan = txtTaiKhoan.getText();
//        String mk = txtMK.getText();
//        
//    }

    public String validated(int id, String ma, String ten, String email, String sdt, String diaChi, String tk, String mk) {
        NhanVien nv = new NhanVien();
        if (ma.trim().isBlank()) {
            return "Mã không được để trống.";
        } else {
            nv = sv.getNVByMa(ma);
            System.out.println(id);
            if (nv != null) {
                if (id == 0) {
                    System.out.println("ha");
                    return "Mã đã tồn tại.";
                } else if (id > 0) {
                    if (nv.getId() == id) {
                        System.out.println("h1");
                        return "Mã đã tồn tại.";
                    }
                }
            }
        }
        if (ten.trim().isBlank()) {
            return "Tên không được để trống";
        }
        if (email.trim().isBlank()) {
            return "Email không được để trống.";
        }
        if (sdt.trim().isBlank()) {
            return "SĐT không được để trống.";
        }
        if (diaChi.trim().isBlank()) {
            return "Địa chỉ không được để trống.";
        }
        if (tk.trim().isBlank()) {
            return "Tài khoản không được để trống.";
        }
        if (mk.trim().isBlank()) {
            return "Mật khẩu không được để trống.";
        }
        return "";
    }

    public void clear() {
        txtMa.setText("");
        txtTen.setText("");
        txtNgaySinh.setDate(null);
        txtEmail.setText("");
        txtSDT.setText("");
        rdoNam.setSelected(true);
        txtDiaChi.setText("");
        cbbCV.setSelectedIndex(0);
        txtTaiKhoan.setText("");
        txtMK.setText("");
        txtTim.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtNgaySinh = new com.toedter.calendar.JDateChooser();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        txtDiaChi = new javax.swing.JTextField();
        txtTaiKhoan = new javax.swing.JTextField();
        txtMK = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cbbCV = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        txtTim = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jPanel1.setPreferredSize(new java.awt.Dimension(907, 605));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin"));

        jLabel1.setText("Mã:");

        jLabel3.setText("Họ tên:");

        jLabel4.setText("Ngày sinh:");

        jLabel5.setText("Email:");

        jLabel6.setText("SĐT");

        jLabel7.setText("Giới tính:");

        jLabel8.setText("Địa chỉ:");

        jLabel9.setText("Tài khoản:");

        jLabel10.setText("Mật khẩu:");

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        jLabel11.setText("Chức vụ:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMa)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(txtTen)
                    .addComponent(txtSDT)
                    .addComponent(txtEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rdoNam)
                        .addGap(43, 43, 43)
                        .addComponent(rdoNu))
                    .addComponent(txtTaiKhoan)
                    .addComponent(txtMK)
                    .addComponent(txtDiaChi)
                    .addComponent(cbbCV, 0, 176, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(cbbCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jLabel2.setText("Quản lý nhân viên");

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem)
                    .addComponent(btnXoa)
                    .addComponent(btnSua)
                    .addComponent(btnNew))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnThem)
                .addGap(18, 18, 18)
                .addComponent(btnSua)
                .addGap(24, 24, 24)
                .addComponent(btnXoa)
                .addGap(26, 26, 26)
                .addComponent(btnNew)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Họ tên", "Ngày sinh", "Email", "SĐT", "Giới tính", "Địa chỉ", "Chức vụ", "Tài khoản", "Mật khẩu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNhanVien.setPreferredSize(new java.awt.Dimension(100, 80));
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);

        jButton1.setText("jButton1");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtTim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(123, 123, 123))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
//        Date date1 = txtNgaySinh.getDate();
//        System.out.println(date1);
//        LocalDate ld1 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//        System.out.println(ld1);
        NhanVien nv = new NhanVien();
        String ma = txtMa.getText();
        String ten = txtTen.getText();
        Date date1 = txtNgaySinh.getDate();
        System.out.println(date1);
        LocalDate ngaySinh = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println(ngaySinh);
        String email = txtEmail.getText();
        String sdt = txtSDT.getText();
        boolean gioiTinh = rdoNam.isSelected() ? true : false;
        String diaChi = txtDiaChi.getText();
        String chucVu = cbbCV.getSelectedItem().toString();
        int idCV = cvSV.getByTen(cbbCV.getSelectedItem().toString()).getId();
        String tk = txtTaiKhoan.getText();
        String mk = txtMK.getText();
        String check = validated(0, ma, ten, email, sdt, diaChi, tk, mk);
        if (!check.equals("")) {
            JOptionPane.showMessageDialog(this, check);
            return;
        }
        nv.setMa(ma);
        nv.setTen(ten);
        nv.setNgaySinh(ngaySinh);
        nv.setEmail(email);
        nv.setSdt(sdt);
        nv.setGioiTinh(gioiTinh);
        nv.setDiaChi(diaChi);
        nv.setIdCV(idCV);
        nv.setTaiKhoan(tk);
        nv.setMaKhau(mk);
        String result = sv.add(nv);
        JOptionPane.showMessageDialog(this, result);
        fillTable();
        clear();
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        int index = tblNhanVien.getSelectedRow();
        listNV = sv.getAllNV();
        txtMa.setText(listNV.get(index).getMa());
        txtTen.setText(listNV.get(index).getTen());
        txtNgaySinh.setDate(Date.from(listNV.get(index).getNgaySinh().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        txtEmail.setText(listNV.get(index).getEmail());
        txtSDT.setText(listNV.get(index).getSdt());
        boolean gt = listNV.get(index).isGioiTinh();
        if (gt == true) {
            this.rdoNam.setSelected(true);
        } else if (gt == false) {
            this.rdoNu.setSelected(true);
        }
        txtDiaChi.setText(listNV.get(index).getDiaChi());
        int cv = listNV.get(index).getIdCV();
        String a = null;
        System.out.println(cv);
        if (cv == 2) {
            a = "Nhân viên";
        } else if (cv == 1) {
            a = "Quản lý";
        }
        System.out.println(a);
        cbbCV.setSelectedItem(a);
        System.out.println(listNV.get(index).getTen());
        txtTaiKhoan.setText(listNV.get(index).getTaiKhoan());
        txtMK.setText(listNV.get(index).getMaKhau());
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int index = tblNhanVien.getSelectedRow();
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?");

        if (index < 0) {
            return;
        }
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        String result = sv.delete(txtMa.getText());
        JOptionPane.showMessageDialog(this, result);
        fillTable();
        clear();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed

    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int index = tblNhanVien.getSelectedRow();
        if(index < 0){
            return;
        }
        listNV = sv.getAllNV();
        NhanVien nv = listNV.get(index);
        int id = nv.getId();
        System.out.println("Nam" + id);
        String maNV = nv.getMa();
        String ten = txtTen.getText();
        Date date1 = txtNgaySinh.getDate();
        System.out.println(date1);
        LocalDate ngaySinh = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println(ngaySinh);
        String email = txtEmail.getText();
        String sdt = txtSDT.getText();
        boolean gioiTinh = rdoNam.isSelected() ? true : false;
        String diaChi = txtDiaChi.getText();
        String chucVu = cbbCV.getSelectedItem().toString();
        int idCV = cvSV.getByTen(cbbCV.getSelectedItem().toString()).getId();
        String tk = txtTaiKhoan.getText();
        String mk = txtMK.getText();
        String check = validated(id, maNV, ten, email, sdt, diaChi, tk, mk);
        if (!check.equals("")) {
            JOptionPane.showMessageDialog(this, check);
            return;
        }
        nv.setId(id);
        nv.setMa(maNV);
        nv.setTen(ten);
        nv.setNgaySinh(ngaySinh);
        nv.setEmail(email);
        nv.setSdt(sdt);
        nv.setGioiTinh(gioiTinh);
        nv.setDiaChi(diaChi);
        nv.setIdCV(idCV);
        nv.setTaiKhoan(tk);
        nv.setMaKhau(mk);
        String result = sv.update(nv);
        JOptionPane.showMessageDialog(this, result);
        fillTable();
        clear();
    }//GEN-LAST:event_btnSuaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbCV;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMK;
    private javax.swing.JTextField txtMa;
    private com.toedter.calendar.JDateChooser txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTaiKhoan;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
