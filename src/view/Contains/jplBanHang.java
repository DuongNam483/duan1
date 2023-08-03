/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.Contains;

import java.awt.Color;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import models.ChatLieu;
import models.ChiTietDep;
import models.Dep;
import models.HoaDon;
import models.HoaDonChiTiet;
import models.KhachHang;
import models.KhuyenMai;
import models.LoaiDep;
import models.MauSac;
import models.NSX;
import models.NhanVien;
import models.Size;
import service.ChatLieuService;
import service.DepService;
import service.HoaDonChiTietService;
import service.HoaDonService;
import service.KhachHangService;
import service.KhuyenMaiService;
import service.LoaiDepService;
import service.MauSacService;
import service.NSXService;
import service.SanPhamService;
import service.SizeService;
import service.impl.ChatLieuServiceImpl;
import service.impl.DepServiceimpl;
import service.impl.HoaDonChiTietServiceImpl;
import service.impl.HoaDonServiceImpl;
import service.impl.KhachHangServiceImpl;
import service.impl.KhuyenMaiServiceImpl;
import service.impl.LoaiDepServiceImpl;
import service.impl.MauSacServiceImpl;
import service.impl.NSXServiceImpl;
import service.impl.SanPhamServiceImpl;
import service.impl.SizeServiceImpl;
import viewmodels.HoaDonChiTietViewModel;
import viewmodels.HoaDonViewModel;
import viewmodels.SanPhamViewModel;

/**
 *
 * @author duong
 */
public class jplBanHang extends javax.swing.JPanel {
    private ChatLieuService clService = new ChatLieuServiceImpl();
    private DepService dService = new DepServiceimpl();
    private LoaiDepService ldService = new LoaiDepServiceImpl();
    private MauSacService msService = new MauSacServiceImpl();
    private NSXService nsxService = new NSXServiceImpl();
    private SizeService sizeService = new SizeServiceImpl();
    private List<ChiTietDep> listCTD = new ArrayList<>();
    
    private SanPhamService spService = new SanPhamServiceImpl();
    private HoaDonChiTietService  ghService = new HoaDonChiTietServiceImpl();
    private HoaDonService hdService = new HoaDonServiceImpl();
    private KhachHangService khService = new KhachHangServiceImpl();
    private KhuyenMaiService kmService = new KhuyenMaiServiceImpl();
    
    private NhanVien nvLv = new NhanVien();
    
    private DefaultComboBoxModel dfcbbcl;
    private DefaultComboBoxModel dfcbbd;
    private DefaultComboBoxModel dfcbbld;
    private DefaultComboBoxModel dfcbbms;
    private DefaultComboBoxModel dfcbbnsx;
    private DefaultComboBoxModel dfcbbsize;
    
//    private DefaultComboBoxModel dfcbbKH;
    
    private DefaultTableModel dtmSP;
    private DefaultTableModel dtmGH;
    private DefaultTableModel dtmHD;
    
    private List<SanPhamViewModel> listSPMD = new ArrayList<>();
    private List<HoaDonChiTietViewModel> listGH = new ArrayList<>();
    private List<HoaDonViewModel> listHD = new ArrayList<>();
    
   public jplBanHang(){
        initComponents();
        dfcbbcl = (DefaultComboBoxModel) cbbLocCL.getModel();
        List<ChatLieu> listCL = clService.getAll();
        listCL.forEach(h -> cbbLocCL.addItem(h.getTen()));

        dfcbbd = (DefaultComboBoxModel) cbbLocDep.getModel();
        List<Dep> listD = dService.getAll();
        listD.forEach(h -> cbbLocDep.addItem(h.getTen()));

        dfcbbld = (DefaultComboBoxModel) cbbLocLD.getModel();
        List<LoaiDep> listLD = ldService.getAll();
        listLD.forEach(h -> cbbLocLD.addItem(h.getTen()));

        dfcbbms = (DefaultComboBoxModel) cbbLocMau.getModel();
        List<MauSac> listMauSac = msService.getAll();
        listMauSac.forEach(h -> cbbLocMau.addItem(h.getMauSac()));

        dfcbbnsx = (DefaultComboBoxModel) cbbLocNSX.getModel();
        List<NSX> listNSX = nsxService.getAll();
        listNSX.forEach(h -> cbbLocNSX.addItem(h.getTen()));

        dfcbbsize = (DefaultComboBoxModel) cbbLocSize.getModel();
        List<Size> listSize = sizeService.getAll();
        listSize.forEach(h -> cbbLocSize.addItem(h.getKichCo()));
        
//        dfcbbKH = (DefaultComboBoxModel) cbbKH.getModel();
        List<KhachHang> listKH = khService.getAllNV();
        cbbKH.setModel(new DefaultComboBoxModel(listKH.toArray()));
        
        List<KhuyenMai> listKM = kmService.getAll();
        cbbKhuyenMai.setModel(new DefaultComboBoxModel(listKM.toArray()));
        cbbKhuyenMai.insertItemAt(null, 0);
        
        dtmSP = (DefaultTableModel) tblSanPham.getModel();
        dtmGH = (DefaultTableModel) tblGioHang.getModel();
        dtmHD = (DefaultTableModel) tblHoaDon.getModel();
        
        
        fillTableSP();
    }
    public jplBanHang(NhanVien nv) {
        initComponents();
        dfcbbcl = (DefaultComboBoxModel) cbbLocCL.getModel();
        List<ChatLieu> listCL = clService.getAll();
        listCL.forEach(h -> cbbLocCL.addItem(h.getTen()));

        dfcbbd = (DefaultComboBoxModel) cbbLocDep.getModel();
        List<Dep> listD = dService.getAll();
        listD.forEach(h -> cbbLocDep.addItem(h.getTen()));

        dfcbbld = (DefaultComboBoxModel) cbbLocLD.getModel();
        List<LoaiDep> listLD = ldService.getAll();
        listLD.forEach(h -> cbbLocLD.addItem(h.getTen()));

        dfcbbms = (DefaultComboBoxModel) cbbLocMau.getModel();
        List<MauSac> listMauSac = msService.getAll();
        listMauSac.forEach(h -> cbbLocMau.addItem(h.getMauSac()));

        dfcbbnsx = (DefaultComboBoxModel) cbbLocNSX.getModel();
        List<NSX> listNSX = nsxService.getAll();
        listNSX.forEach(h -> cbbLocNSX.addItem(h.getTen()));

        dfcbbsize = (DefaultComboBoxModel) cbbLocSize.getModel();
        List<Size> listSize = sizeService.getAll();
        listSize.forEach(h -> cbbLocSize.addItem(h.getKichCo()));
        
//        dfcbbKH = (DefaultComboBoxModel) cbbKH.getModel();
        List<KhachHang> listKH = khService.getAllNV();
        cbbKH.setModel(new DefaultComboBoxModel(listKH.toArray()));
        
        List<KhuyenMai> listKM = kmService.getAll();
        cbbKhuyenMai.setModel(new DefaultComboBoxModel(listKM.toArray()));
        cbbKhuyenMai.insertItemAt("Không áp dụng", 0);
        cbbKhuyenMai.setSelectedIndex(0);
        
        dtmSP = (DefaultTableModel) tblSanPham.getModel();
        dtmGH = (DefaultTableModel) tblGioHang.getModel();
        dtmHD = (DefaultTableModel) tblHoaDon.getModel();
        
        txtNhanVien.setText(nv.getTen());
        nvLv = nv;
        
        
        fillTableSP();
        fillTableHD(0);
//        fillTableGH(ghService.getAllGH());
    }
    

    public void fillTableSP() {
        listSPMD = spService.getAllSPVMD();
//        DefaultTableModel dtm = (DefaultTableModel) tblSanPham.getModel();
        dtmSP.setRowCount(0);
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
                x.getGiaBan()
            };
            dtmSP.addRow(rowdata);
        }
    }
    public void fillTableGH(List<HoaDonChiTietViewModel> list){
//        listGH = ghService.getAllGH();
        dtmGH.setRowCount(0);
        for(HoaDonChiTietViewModel x : list){
            Object[] rowdata = new Object[]{
                x.getMaHD(),
                x.getMaSP(), 
                x.getSl(),
                x.getDonGia()
            };
            dtmGH.addRow(rowdata);
        }
    }
    public void fillTableHD(int tt){
        dtmHD.setRowCount(0);
        for(HoaDonViewModel x : hdService.getHDVMDByTT(tt)){
            Object[] rowdata = new Object[]{
                x.getMa(),
                x.getTenKH(), 
                x.getTenNV(),
                x.getTongTien(),
                x.getTrangThai() == 0 ? "Chưa thanh toán" : "Đã thanh toán"
            };
            dtmHD.addRow(rowdata);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        txtTongTien = new javax.swing.JTextField();
        txtGiamGia = new javax.swing.JTextField();
        cbbKhuyenMai = new javax.swing.JComboBox<>();
        txtMaHD = new javax.swing.JTextField();
        cbbKH = new javax.swing.JComboBox<>();
        txtNhanVien = new javax.swing.JTextField();
        btnCreateHD = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtTienPhaiTra = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbbLocDep = new javax.swing.JComboBox<>();
        cbbLocLD = new javax.swing.JComboBox<>();
        cbbLocSize = new javax.swing.JComboBox<>();
        cbbLocMau = new javax.swing.JComboBox<>();
        cbbLocCL = new javax.swing.JComboBox<>();
        cbbLocNSX = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        btnAddToCart = new javax.swing.JButton();
        btnRemoveCart = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        jLabel2.setText("Nhân viên:");

        jLabel3.setText("Khách hàng:");

        jLabel4.setText("Mã hóa đơn:");

        jLabel5.setText("Khuyến mại:");

        jLabel7.setText("Giảm giá:");

        jLabel8.setText("Tổng tiền:");

        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnNew.setText("Hủy");
        btnNew.setPreferredSize(new java.awt.Dimension(90, 23));
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        txtTongTien.setEnabled(false);

        txtGiamGia.setEnabled(false);

        cbbKhuyenMai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbKhuyenMaiItemStateChanged(evt);
            }
        });

        txtNhanVien.setEnabled(false);

        btnCreateHD.setText("Tạo hóa đơn");
        btnCreateHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateHDActionPerformed(evt);
            }
        });

        jLabel6.setText("Tiền phải trả:");

        txtTienPhaiTra.setEnabled(false);

        jButton2.setText("Làm mới");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTienPhaiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNhanVien)
                                        .addComponent(txtMaHD)
                                        .addComponent(cbbKH, 0, 157, Short.MAX_VALUE))
                                    .addComponent(cbbKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCreateHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbbKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbbKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTienPhaiTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThanhToan)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreateHD)
                    .addComponent(jButton2))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Giỏ hàng"));
        jPanel3.setPreferredSize(new java.awt.Dimension(589, 150));

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Mã sản phẩm", "Số lượng", "Đơn giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGioHang.setPreferredSize(new java.awt.Dimension(150, 80));
        jScrollPane2.setViewportView(tblGioHang);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(241, 241, 241))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn"));
        jPanel4.setPreferredSize(new java.awt.Dimension(589, 156));

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã", "Khách hàng", "Nhân viên", "Tổng tiền", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblHoaDon);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản phẩm"));

        jLabel1.setText("Lọc sản phẩm");

        cbbLocDep.setPreferredSize(new java.awt.Dimension(170, 25));

        jButton1.setText("jButton1");

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Dép", "Loại dép", "Kích cỡ", "Màu sắc", "Chất liệu", "NSX", "Mô tả", "Số lượng", "Giá bán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        btnAddToCart.setText("Thêm vào giỏ hàng");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });

        btnRemoveCart.setText("Xóa giỏ hàng");
        btnRemoveCart.setPreferredSize(new java.awt.Dimension(132, 23));
        btnRemoveCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveCartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(btnAddToCart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRemoveCart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(cbbLocDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbLocLD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbLocSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbLocMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbLocCL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbLocNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbLocDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbLocLD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbLocSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbLocMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbLocCL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbLocNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddToCart)
                    .addComponent(btnRemoveCart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Bán hàng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(16, 16, 16)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        List<ChiTietDep> listSP = spService.getAll();
        HoaDonChiTiet hdct = new HoaDonChiTiet();
        int index = this.tblSanPham.getSelectedRow();
        if(index < 0){
            return;
        }
        try {
            String sl = JOptionPane.showInputDialog(this, "Mời bạn nhập số lượng", "Nhập", HIDE_ON_CLOSE);
            if (!sl.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Số lượng muốn mua phải lớn hơn 0");
                return;
            } else if (listSP.get(index).getSoLuong() < Integer.parseInt(sl)) {
                JOptionPane.showMessageDialog(this, "Số lượng sản phẩm tồn ít hơn số lượng sản phẩm muốn mua");
                return;
            } else if (Integer.parseInt(sl) <= 0) {
                JOptionPane.showMessageDialog(this, "Số lượng muốn mua phải lớn hơn 0");
                return;
            }

            HoaDon hd = hdService.getByMa(txtMaHD.getText());
            hdct.setIdHD(hd.getId());
//        System.out.println("1nam" +hdct.getId());
            ChiTietDep ctd = spService.getCTDByMa(this.tblSanPham.getValueAt(index, 0).toString());
            hdct.setIdCTD(ctd.getId());
            System.out.println("man" + spService.getCTDByMa(this.tblSanPham.getValueAt(index, 0).toString()).getId());
            hdct.setSoLuong(Integer.parseInt(sl));
            hdct.setDonGia((double) this.tblSanPham.getValueAt(index, 9));
            ghService.add(hdct);
            String slt = tblSanPham.getValueAt(index, 8).toString();
            int soLuong = Integer.parseInt(slt) - Integer.parseInt(sl);
            System.out.println("slt" + soLuong);
            //Update sl
            String result = spService.updateSL(soLuong, ctd.getId());
            JOptionPane.showMessageDialog(this, result);
            fillTableGH(ghService.getGHByMa(txtMaHD.getText()));
            fillTableSP();
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập số lượng");
        }
        
        double tongTien = 0;
        for(HoaDonChiTietViewModel x : ghService.getGHByMa(txtMaHD.getText())){
            tongTien += x.getDonGia() * x.getSl();
        }
        txtTongTien.setText(String.valueOf(tongTien));
        this.txtTienPhaiTra.setText(txtTongTien.getText());
    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void btnCreateHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateHDActionPerformed
        HoaDon hd = new HoaDon();
        String maHD = this.txtMaHD.getText();
        if(maHD.trim().isBlank()){
            JOptionPane.showMessageDialog(this, "Mã hóa đơn không được để trống");
            return;
        }else {
            for(HoaDon x : hdService.getAll()){
                if(maHD.equals(x.getMa())){
                    JOptionPane.showMessageDialog(this, "Mã hóa đơn đã tồn tại");
                    txtMaHD.setText("");
                    return;
            }
            }
        }
        int idNV = nvLv.getId();
        KhachHang kh = (KhachHang) cbbKH.getSelectedItem();
        int idKH = kh.getId();
        
        String tongTien = txtTongTien.getText();
        if(tongTien.equals("")){
            hd.setTongTien(0);
        }else{
            hd.setTongTien(Integer.parseInt(tongTien));
        }
        hd.setMa(maHD);
        hd.setIdNV(idNV);
        hd.setIdKH(idKH);
        hd.setTrangThai(0);
        String result = hdService.add(hd);
        JOptionPane.showMessageDialog(this, result);
        
        fillTableHD(0);
    }//GEN-LAST:event_btnCreateHDActionPerformed

        
            
    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        int index = tblHoaDon.getSelectedRow();
        if(index <  0){
            return;
        }
        String ma = tblHoaDon.getValueAt(index, 0).toString();
        txtMaHD.setText(ma);
        
        fillTableGH(ghService.getGHByMa(ma));
        double tongTien = 0;
        for(HoaDonChiTietViewModel x : ghService.getGHByMa(ma)){
            tongTien += x.getDonGia() * x.getSl();
        }
        txtTongTien.setText(String.valueOf(tongTien));
        this.txtTienPhaiTra.setText(txtTongTien.getText());
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        String ma = this.txtMaHD.getText();
        HoaDon hd = hdService.getByMa(ma);
        String result = hdService.updateStatus( Double.valueOf(txtTongTien.getText()),1, hd.getId());
        JOptionPane.showMessageDialog(this, result);
        fillTableHD(0);
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnRemoveCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveCartActionPerformed
        int index = this.tblGioHang.getSelectedRow();
        if(index < 0){
            return;
        }
        String sl = this.tblGioHang.getValueAt(index, 2).toString();
        HoaDon hd = hdService.getByMa(txtMaHD.getText());
        System.out.println(hd.getId());
        HoaDonChiTiet hdct = ghService.getByMa(hd.getId());
        
        ChiTietDep ctd = spService.getByID(hdct.getIdCTD());
        int soLuong = ctd.getSoLuong() + Integer.parseInt(sl);
        System.out.println(txtMaHD.getText());
        String result = spService.updateSL(soLuong, ctd.getId());
        JOptionPane.showMessageDialog(this, result);
        
        ghService.deleteSP(hdct.getId(), hdct.getIdCTD());
        fillTableSP();
        fillTableGH(ghService.getGHByMa(txtMaHD.getText()));
        
        double tongTien = 0;
        for(HoaDonChiTietViewModel x : ghService.getGHByMa(txtMaHD.getText())){
            tongTien += x.getDonGia() * x.getSl();
        }
        txtTongTien.setText(String.valueOf(tongTien));
        this.txtTienPhaiTra.setText(txtTongTien.getText());
    }//GEN-LAST:event_btnRemoveCartActionPerformed

    private void cbbKhuyenMaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbKhuyenMaiItemStateChanged
//        KhuyenMai km = (KhuyenMai) cbbKhuyenMai.getSelectedItem();
//        int ptg = km.getPhanTramGiam();
//        int gg = Integer.parseInt(txtTongTien.getText()) * ptg;
//        this.txtGiamGia.setText(String.valueOf(gg));
        Object selectedItem = cbbKhuyenMai.getSelectedItem();
        if (selectedItem instanceof KhuyenMai) {
            KhuyenMai km = (KhuyenMai) selectedItem;
            int ptg = km.getPhanTramGiam();
            double giaGoc = Double.valueOf(txtTongTien.getText());
//            System.out.println("ptg" + ptg);
//            System.out.println("giaGoc" + giaGoc);
            double gg = giaGoc * (ptg / 100.0);
//            System.out.println(gg);
            this.txtGiamGia.setText(String.valueOf(gg));
            double tpt = giaGoc - gg;
            this.txtTienPhaiTra.setText(String.valueOf(tpt));
        } else {
            this.txtGiamGia.setText("0");
            this.txtTienPhaiTra.setText(txtTongTien.getText());
        }
    }//GEN-LAST:event_cbbKhuyenMaiItemStateChanged

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        int index = this.tblHoaDon.getSelectedRow();
        if(index < 0){
            return;
        }
        String ma = this.tblHoaDon.getValueAt(index, 0).toString();
        HoaDon hd = hdService.getByMa(ma);
        System.out.println("kkkk" +hd.getId());
        ghService.delete(hd.getId());
        String result = hdService.delete(hd.getId());
        JOptionPane.showMessageDialog(this, result);
        listGH = new ArrayList<>();
        fillTableGH(listGH);
        fillTableHD(0);
    }//GEN-LAST:event_btnNewActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txtMaHD.setText("");
        cbbKhuyenMai.setSelectedIndex(0);
        cbbKH.setSelectedIndex(0);
        txtGiamGia.setText("");
        txtTienPhaiTra.setText("");
        tblGioHang.clearSelection();
        tblSanPham.clearSelection();
        tblHoaDon.clearSelection();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton btnCreateHD;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnRemoveCart;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JComboBox<String> cbbKH;
    private javax.swing.JComboBox<String> cbbKhuyenMai;
    private javax.swing.JComboBox<String> cbbLocCL;
    private javax.swing.JComboBox<String> cbbLocDep;
    private javax.swing.JComboBox<String> cbbLocLD;
    private javax.swing.JComboBox<String> cbbLocMau;
    private javax.swing.JComboBox<String> cbbLocNSX;
    private javax.swing.JComboBox<String> cbbLocSize;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtGiamGia;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNhanVien;
    private javax.swing.JTextField txtTienPhaiTra;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
