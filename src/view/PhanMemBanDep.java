/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Color;
import javax.swing.JPanel;
import models.NhanVien;
import view.Contains.jplBanHang;
import view.Contains.jplHoaDon;
import view.Contains.jplKhachHang;
import view.Contains.jplKhuyenMai;
import view.Contains.jplNhanVien;
import view.Contains.jplSanPham;

/**
 *
 * @author duong
 */
public class PhanMemBanDep extends javax.swing.JFrame {

    private JPanel panel;
    private JPanel panelBanHang;
    public PhanMemBanDep(NhanVien nv) {
        initComponents();
        setLocationRelativeTo(null);
        setQuyen(nv);
    }
    public PhanMemBanDep() {
        initComponents();
        setLocationRelativeTo(null);
    }
    public void setQuyen(NhanVien nv){
        lblTenNV.setText(nv.getTaiKhoan());
        panelBanHang = new jplBanHang(nv);
    }
    public PhanMemBanDep(JPanel panel){
        setPanel(panel);
    }
    private void setColor(JPanel p) {
        p.setBackground(new Color(170, 190, 255));
    }

    private void resetColor(JPanel p) {
        p.setBackground(new Color(51,204,255));
    }

    private void setPanel(JPanel p) {
        jplContain.removeAll();
        jplContain.add(p);
        jplContain.updateUI();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnBanHang = new javax.swing.JPanel();
        lblBanHang = new javax.swing.JLabel();
        btnSanPham = new javax.swing.JPanel();
        lblSanPham = new javax.swing.JLabel();
        btnHoaDon = new javax.swing.JPanel();
        lblHoaDon = new javax.swing.JLabel();
        btnKhuyenMai = new javax.swing.JPanel();
        lblKhuyenMai = new javax.swing.JLabel();
        btnKhachHang = new javax.swing.JPanel();
        lblKhachHang = new javax.swing.JLabel();
        btnNhanVien = new javax.swing.JPanel();
        lblNhanVien = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblTenNV = new javax.swing.JLabel();
        jplContain = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1137, 714));

        jPanel1.setPreferredSize(new java.awt.Dimension(2000, 714));

        jPanel2.setBackground(new java.awt.Color(51, 204, 255));

        jLabel1.setBackground(new java.awt.Color(51, 204, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(51, 204, 255));
        jPanel3.setLayout(new java.awt.GridLayout(6, 1));

        btnBanHang.setBackground(new java.awt.Color(51, 204, 255));
        btnBanHang.setLayout(new java.awt.GridLayout(1, 1));

        lblBanHang.setBackground(new java.awt.Color(51, 204, 255));
        lblBanHang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblBanHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/shopping-cart.png"))); // NOI18N
        lblBanHang.setText(" Bán hàng");
        lblBanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBanHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBanHangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBanHangMouseExited(evt);
            }
        });
        btnBanHang.add(lblBanHang);

        jPanel3.add(btnBanHang);

        btnSanPham.setBackground(new java.awt.Color(51, 204, 255));
        btnSanPham.setLayout(new java.awt.GridLayout(1, 1));

        lblSanPham.setBackground(new java.awt.Color(51, 204, 255));
        lblSanPham.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSanPham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boxes.png"))); // NOI18N
        lblSanPham.setText(" Sản phẩm");
        lblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSanPhamMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSanPhamMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSanPhamMouseExited(evt);
            }
        });
        btnSanPham.add(lblSanPham);

        jPanel3.add(btnSanPham);

        btnHoaDon.setBackground(new java.awt.Color(51, 204, 255));
        btnHoaDon.setLayout(new java.awt.GridLayout(1, 1));

        lblHoaDon.setBackground(new java.awt.Color(51, 204, 255));
        lblHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bill3.png"))); // NOI18N
        lblHoaDon.setText("Hóa đơn");
        lblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHoaDonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblHoaDonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblHoaDonMouseExited(evt);
            }
        });
        btnHoaDon.add(lblHoaDon);

        jPanel3.add(btnHoaDon);

        btnKhuyenMai.setBackground(new java.awt.Color(51, 204, 255));
        btnKhuyenMai.setLayout(new java.awt.GridLayout(1, 1));

        lblKhuyenMai.setBackground(new java.awt.Color(51, 204, 255));
        lblKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblKhuyenMai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/coupon.png"))); // NOI18N
        lblKhuyenMai.setText(" Khuyến mại");
        lblKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKhuyenMaiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblKhuyenMaiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblKhuyenMaiMouseExited(evt);
            }
        });
        btnKhuyenMai.add(lblKhuyenMai);

        jPanel3.add(btnKhuyenMai);

        btnKhachHang.setBackground(new java.awt.Color(51, 204, 255));
        btnKhachHang.setLayout(new java.awt.GridLayout(1, 1));

        lblKhachHang.setBackground(new java.awt.Color(51, 204, 255));
        lblKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/client.png"))); // NOI18N
        lblKhachHang.setText(" Khách hàng");
        lblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKhachHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblKhachHangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblKhachHangMouseExited(evt);
            }
        });
        btnKhachHang.add(lblKhachHang);

        jPanel3.add(btnKhachHang);

        btnNhanVien.setBackground(new java.awt.Color(51, 204, 255));
        btnNhanVien.setLayout(new java.awt.GridLayout(1, 1));

        lblNhanVien.setBackground(new java.awt.Color(51, 204, 255));
        lblNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/staff.png"))); // NOI18N
        lblNhanVien.setText(" Nhân viên");
        lblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNhanVienMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblNhanVienMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblNhanVienMouseExited(evt);
            }
        });
        btnNhanVien.add(lblNhanVien);

        jPanel3.add(btnNhanVien);

        jLabel2.setText("Xin chào:");

        lblTenNV.setText("jLabel3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblTenNV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jplContain.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jplContain.setPreferredSize(new java.awt.Dimension(1300, 2));
        jplContain.setLayout(new javax.swing.BoxLayout(jplContain, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jplContain, javax.swing.GroupLayout.DEFAULT_SIZE, 1035, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jplContain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1175, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 937, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSanPhamMouseClicked
        panel = new jplSanPham();
        setPanel(panel);
    }//GEN-LAST:event_lblSanPhamMouseClicked

    private void lblBanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBanHangMouseClicked
        
        setPanel(panelBanHang);
    }//GEN-LAST:event_lblBanHangMouseClicked

    private void lblBanHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBanHangMouseEntered
        setColor(btnBanHang);
    }//GEN-LAST:event_lblBanHangMouseEntered

    private void lblBanHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBanHangMouseExited
        resetColor(btnBanHang);
    }//GEN-LAST:event_lblBanHangMouseExited

    private void lblSanPhamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSanPhamMouseEntered
        setColor(btnSanPham);
    }//GEN-LAST:event_lblSanPhamMouseEntered

    private void lblSanPhamMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSanPhamMouseExited
        resetColor(btnSanPham);
    }//GEN-LAST:event_lblSanPhamMouseExited

    private void lblKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKhuyenMaiMouseClicked
        panel = new jplKhuyenMai();
        setPanel(panel);
    }//GEN-LAST:event_lblKhuyenMaiMouseClicked

    private void lblKhuyenMaiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKhuyenMaiMouseEntered
        setColor(btnKhuyenMai);
    }//GEN-LAST:event_lblKhuyenMaiMouseEntered

    private void lblKhuyenMaiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKhuyenMaiMouseExited
        resetColor(btnKhuyenMai);
    }//GEN-LAST:event_lblKhuyenMaiMouseExited

    private void lblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKhachHangMouseClicked
        panel = new jplKhachHang();
        setPanel(panel);
    }//GEN-LAST:event_lblKhachHangMouseClicked

    private void lblKhachHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKhachHangMouseEntered
        setColor(btnKhachHang);
    }//GEN-LAST:event_lblKhachHangMouseEntered

    private void lblKhachHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKhachHangMouseExited
        resetColor(btnKhachHang);
    }//GEN-LAST:event_lblKhachHangMouseExited

    private void lblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhanVienMouseClicked
        panel = new jplNhanVien();
        setPanel(panel);
    }//GEN-LAST:event_lblNhanVienMouseClicked

    private void lblNhanVienMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhanVienMouseEntered
        setColor(btnNhanVien);
    }//GEN-LAST:event_lblNhanVienMouseEntered

    private void lblNhanVienMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhanVienMouseExited
        resetColor(btnNhanVien);
    }//GEN-LAST:event_lblNhanVienMouseExited

    private void lblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoaDonMouseClicked
        panel = new jplHoaDon();
        setPanel(panel);
    }//GEN-LAST:event_lblHoaDonMouseClicked

    private void lblHoaDonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoaDonMouseEntered
        setColor(btnHoaDon);
    }//GEN-LAST:event_lblHoaDonMouseEntered

    private void lblHoaDonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoaDonMouseExited
        resetColor(btnHoaDon);
    }//GEN-LAST:event_lblHoaDonMouseExited

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PhanMemBanDep().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnBanHang;
    private javax.swing.JPanel btnHoaDon;
    private javax.swing.JPanel btnKhachHang;
    private javax.swing.JPanel btnKhuyenMai;
    private javax.swing.JPanel btnNhanVien;
    private javax.swing.JPanel btnSanPham;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jplContain;
    private javax.swing.JLabel lblBanHang;
    private javax.swing.JLabel lblHoaDon;
    private javax.swing.JLabel lblKhachHang;
    private javax.swing.JLabel lblKhuyenMai;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblSanPham;
    private javax.swing.JLabel lblTenNV;
    // End of variables declaration//GEN-END:variables
}
