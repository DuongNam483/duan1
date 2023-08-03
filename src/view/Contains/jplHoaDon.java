package view.Contains;


import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import models.HoaDon;
import service.HoaDonChiTietService;
import service.HoaDonService;
import service.impl.HoaDonChiTietServiceImpl;
import service.impl.HoaDonServiceImpl;
import viewmodels.HoaDonChiTietViewModel;
import viewmodels.HoaDonViewModel;

public class jplHoaDon extends javax.swing.JPanel {

    
    private HoaDonChiTietService  ghService = new HoaDonChiTietServiceImpl();
    private HoaDonService hdService = new HoaDonServiceImpl();

    private DefaultTableModel dtmGH;
    private DefaultTableModel dtmHD;
    public jplHoaDon() {
        initComponents();
        dtmGH = (DefaultTableModel) tblGioHang.getModel();
        dtmHD = (DefaultTableModel) tblHoaDon.getModel();
        rdoAll.setSelected(true);
        fillTableHD();
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
    public void fillTableHDByTT(int tt){
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
    public void fillTableHD(){
        dtmHD.setRowCount(0);
        for(HoaDonViewModel x : hdService.getAllHDVMD()){
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        hoaDonChiTiet = new javax.swing.JDialog();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tienKhachDua = new javax.swing.JLabel();
        tienThua = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        kieuThanhToan = new javax.swing.JLabel();
        tienTraTruoc = new javax.swing.JLabel();
        tienThieu = new javax.swing.JLabel();
        maGD = new javax.swing.JLabel();
        lbMaHoaDon = new javax.swing.JLabel();
        lbNgayTao = new javax.swing.JLabel();
        lbNgayThanhToan = new javax.swing.JLabel();
        lbTongTien = new javax.swing.JLabel();
        lbTienGiam = new javax.swing.JLabel();
        lbKhachPhaiTra = new javax.swing.JLabel();
        lbTienKhachDua = new javax.swing.JLabel();
        lbTienThua = new javax.swing.JLabel();
        lbKieuThanhToan = new javax.swing.JLabel();
        lbTienTraTruoc = new javax.swing.JLabel();
        lbTienThieu = new javax.swing.JLabel();
        lbHinhThucThanhToan = new javax.swing.JLabel();
        lbMaGD = new javax.swing.JLabel();
        lbKhachHang = new javax.swing.JLabel();
        lbNhanVien = new javax.swing.JLabel();
        kieuThanhToan2 = new javax.swing.JLabel();
        lbKieuThanhToan2 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbPhieuGG = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        rdoAll = new javax.swing.JRadioButton();
        rdoChuaTT = new javax.swing.JRadioButton();
        rdoDaTT = new javax.swing.JRadioButton();
        btnXoa = new javax.swing.JButton();

        jMenuItem1.setText("Xem chi tiết");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jLabel7.setText("Mã hóa đơn:");

        jLabel8.setText("Ngày tạo:");

        jLabel9.setText("Ngày thanh toán:");

        jLabel10.setText("Tổng tiền:");

        jLabel11.setText("Số tiền được giảm:");

        jLabel12.setText("Khách phải trả:");

        tienKhachDua.setText("Tiền khách đưa:");

        tienThua.setText("Tiền thừa:");

        jLabel15.setText("Hình thức thanh toán:");

        jLabel16.setText("Khách hàng:");

        jLabel17.setText("Nhân viên:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setText("Chi Tiết Hóa Đơn");

        kieuThanhToan.setText("Kiểu thanh toán:");

        tienTraTruoc.setText("Tiền trả trước:");

        tienThieu.setText("Tiền thiếu:");

        maGD.setText("Mã giao dịch:");

        lbMaHoaDon.setText("Mã hóa đơn");

        lbNgayTao.setText("Mã hóa đơn");

        lbNgayThanhToan.setText("Mã hóa đơn");

        lbTongTien.setText("Mã hóa đơn");

        lbTienGiam.setText("Mã hóa đơn");

        lbKhachPhaiTra.setText("Mã hóa đơn");

        lbTienKhachDua.setText("Mã hóa đơn");

        lbTienThua.setText("Mã hóa đơn");

        lbKieuThanhToan.setText("Mã hóa đơn");

        lbTienTraTruoc.setText("Mã hóa đơn");

        lbTienThieu.setText("Mã hóa đơn");

        lbHinhThucThanhToan.setText("Mã hóa đơn");

        lbMaGD.setText("Mã hóa đơn");

        lbKhachHang.setText("Mã hóa đơn");

        lbNhanVien.setText("Mã hóa đơn");

        kieuThanhToan2.setText("Kiểu thanh toán:");

        lbKieuThanhToan2.setText("Mã hóa đơn");

        jLabel19.setText("Phiếu giảm giá:");

        lbPhieuGG.setText("Mã hóa đơn");

        javax.swing.GroupLayout hoaDonChiTietLayout = new javax.swing.GroupLayout(hoaDonChiTiet.getContentPane());
        hoaDonChiTiet.getContentPane().setLayout(hoaDonChiTietLayout);
        hoaDonChiTietLayout.setHorizontalGroup(
            hoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hoaDonChiTietLayout.createSequentialGroup()
                .addGroup(hoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hoaDonChiTietLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(hoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(hoaDonChiTietLayout.createSequentialGroup()
                                .addGroup(hoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(70, 70, 70)
                                .addGroup(hoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbMaHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                    .addComponent(lbNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbNgayThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(hoaDonChiTietLayout.createSequentialGroup()
                                .addGroup(hoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(kieuThanhToan2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(hoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tienThua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tienKhachDua, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(tienTraTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tienThieu, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kieuThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(69, 69, 69)
                                .addGroup(hoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbKieuThanhToan2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbTienThua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbKieuThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbTienTraTruoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(hoaDonChiTietLayout.createSequentialGroup()
                                        .addComponent(lbTienThieu)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(lbTienKhachDua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(hoaDonChiTietLayout.createSequentialGroup()
                                .addGroup(hoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(maGD, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addGroup(hoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lbHinhThucThanhToan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbMaGD, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(hoaDonChiTietLayout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(lbKhachPhaiTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(hoaDonChiTietLayout.createSequentialGroup()
                                .addGroup(hoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(61, 61, 61)
                                .addGroup(hoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbTienGiam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(hoaDonChiTietLayout.createSequentialGroup()
                                .addGroup(hoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(82, 82, 82)
                                .addGroup(hoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(hoaDonChiTietLayout.createSequentialGroup()
                                        .addComponent(lbPhieuGG, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(hoaDonChiTietLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        hoaDonChiTietLayout.setVerticalGroup(
            hoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hoaDonChiTietLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel18)
                .addGap(33, 33, 33)
                .addGroup(hoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbMaHoaDon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(hoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lbNgayTao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(hoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lbNgayThanhToan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(hoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbKhachHang)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(hoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNhanVien)
                    .addGroup(hoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(hoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbPhieuGG)
                    .addGroup(hoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(hoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lbTongTien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(hoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lbTienGiam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(hoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lbKhachPhaiTra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(hoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tienKhachDua)
                    .addComponent(lbTienKhachDua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(hoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tienThua)
                    .addComponent(lbTienThua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(hoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kieuThanhToan)
                    .addComponent(lbKieuThanhToan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(hoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tienTraTruoc)
                    .addComponent(lbTienTraTruoc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(hoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tienThieu)
                    .addComponent(lbTienThieu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(hoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kieuThanhToan2)
                    .addComponent(lbKieuThanhToan2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(hoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lbHinhThucThanhToan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(hoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maGD)
                    .addComponent(lbMaGD))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("HÓA ĐƠN");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa Đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

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
        tblHoaDon.setPreferredSize(new java.awt.Dimension(400, 80));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblHoaDon);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 873, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa Đơn Chi Tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanel6.setPreferredSize(new java.awt.Dimension(452, 204));

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
        tblGioHang.setPreferredSize(new java.awt.Dimension(100, 80));
        jScrollPane2.setViewportView(tblGioHang);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );

        buttonGroup1.add(rdoAll);
        rdoAll.setText("Tất cả");
        rdoAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoAllActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoChuaTT);
        rdoChuaTT.setText("Chưa thanh toán");
        rdoChuaTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoChuaTTActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoDaTT);
        rdoDaTT.setText("Đã thanh toán");
        rdoDaTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDaTTActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rdoAll)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addComponent(rdoChuaTT)
                        .addGap(68, 68, 68)
                        .addComponent(rdoDaTT)
                        .addGap(114, 114, 114)
                        .addComponent(btnXoa))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoAll)
                    .addComponent(rdoChuaTT)
                    .addComponent(rdoDaTT)
                    .addComponent(btnXoa))
                .addGap(19, 19, 19)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        int index = tblHoaDon.getSelectedRow();
        if(index <  0){
            return;
        }
        String ma = tblHoaDon.getValueAt(index, 0).toString();

        fillTableGH(ghService.getGHByMa(ma));
//        double tongTien = 0;
//        for(HoaDonChiTietViewModel x : ghService.getGHByMa(ma)){
//            tongTien += x.getDonGia() * x.getSl();
//        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void rdoAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoAllActionPerformed
        fillTableHD();
    }//GEN-LAST:event_rdoAllActionPerformed

    private void rdoChuaTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoChuaTTActionPerformed
        fillTableHDByTT(0);
    }//GEN-LAST:event_rdoChuaTTActionPerformed

    private void rdoDaTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDaTTActionPerformed
        fillTableHDByTT(1);
    }//GEN-LAST:event_rdoDaTTActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
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
        rdoAll.setSelected(true);
        fillTableHD();
    }//GEN-LAST:event_btnXoaActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JDialog hoaDonChiTiet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel kieuThanhToan;
    private javax.swing.JLabel kieuThanhToan2;
    private javax.swing.JLabel lbHinhThucThanhToan;
    private javax.swing.JLabel lbKhachHang;
    private javax.swing.JLabel lbKhachPhaiTra;
    private javax.swing.JLabel lbKieuThanhToan;
    private javax.swing.JLabel lbKieuThanhToan2;
    private javax.swing.JLabel lbMaGD;
    private javax.swing.JLabel lbMaHoaDon;
    private javax.swing.JLabel lbNgayTao;
    private javax.swing.JLabel lbNgayThanhToan;
    private javax.swing.JLabel lbNhanVien;
    private javax.swing.JLabel lbPhieuGG;
    private javax.swing.JLabel lbTienGiam;
    private javax.swing.JLabel lbTienKhachDua;
    private javax.swing.JLabel lbTienThieu;
    private javax.swing.JLabel lbTienThua;
    private javax.swing.JLabel lbTienTraTruoc;
    private javax.swing.JLabel lbTongTien;
    private javax.swing.JLabel maGD;
    private javax.swing.JRadioButton rdoAll;
    private javax.swing.JRadioButton rdoChuaTT;
    private javax.swing.JRadioButton rdoDaTT;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JLabel tienKhachDua;
    private javax.swing.JLabel tienThieu;
    private javax.swing.JLabel tienThua;
    private javax.swing.JLabel tienTraTruoc;
    // End of variables declaration//GEN-END:variables
}
