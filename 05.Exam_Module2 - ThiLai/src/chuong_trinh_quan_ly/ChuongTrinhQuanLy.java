package chuong_trinh_quan_ly;

import dich_vu.impl.SanPhamNhapKhauDichVuImpl;
import dich_vu.impl.SanPhamXuatKhauDichVuImpl;
import san_pham.SanPhamNhapKhau;
import san_pham.SanPhamXuatKhau;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ChuongTrinhQuanLy {
    static Scanner scanner = new Scanner(System.in);

    public static List<SanPhamNhapKhau> sanPhamNhapKhauDanhSach = new ArrayList<>();

    public static void main(String[] args) {
        SanPhamNhapKhauDichVuImpl soDaiHanDichVu = new SanPhamNhapKhauDichVuImpl();
        soDaiHanDichVu.docFileGanVaoDanhSach("D:\\07.Code\\01.A0422i1\\05.Exam_Module2 - ThiLai\\src\\du_lieu\\SanPhamNhapKhau.csv", sanPhamNhapKhauDanhSach);

//        SanPhamXuatKhauDichVuImpl sanPhamXuatKhau = new SanPhamNhapKhauDichVuImpl();



        int luaChon = 0;
        do {
            hienThiLuaChon();
            luaChon = kiemTraLuaChon();
            switch (luaChon) {
                case 1:
                    themSanPham();
                    break;
                case 2:
                    xoaSanPham();
                    break;
                case 3:
                    xemDanhSachSanPham();
                    break;
                case 4:
                    timKiemDanhSachSanPham();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("vui long nhap so tu 1 den 5");
            }
        }
        while (luaChon != 5);

    }

    public static int kiemTraLuaChon() {
        int choice = 0;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("You entered wrong format");
        }
        return choice;
    }
//ok
    public static void hienThiLuaChon() {
        System.out.println("\nCHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM-" +
                "\nChọn chức năng theo số(để tiếp tục): ");
        System.out.println("\t1. Thêm mới ");
        System.out.println("\t2. Xóa ");
        System.out.println("\t3. Xem danh sách sản phẩm");
        System.out.println("\t4. Tìm kiếm");
        System.out.println("\t5. Thoát");
        System.out.println("\tChọn chức năng: ");
    }
//ok

    public static void themSanPham() {
        int luaChon = 0;
        SanPhamNhapKhauDichVuImpl sanPhamNhauKhau = new SanPhamNhapKhauDichVuImpl();
        SanPhamXuatKhauDichVuImpl sanPhamXuatKhauDichVu = new SanPhamXuatKhauDichVuImpl();
        do {
            System.out.println("Thêm sản phẩm, chọn loại sản phẩm: ");
            hienThiSanPham();
            luaChon = kiemTraLuaChon();
            switch (luaChon) {
                case 1:
                    sanPhamNhauKhau.themMoi();
                    break;
                case 2:
                    sanPhamXuatKhauDichVu.themMoi();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("vui long nhap so tu 1 den 3");
            }
        }
        while (luaChon != 3);
    }

    public static void xoaSanPham(){
        int luaChon = 0;
        SanPhamNhapKhauDichVuImpl sanPhamNhapKhau = new SanPhamNhapKhauDichVuImpl();

        do {
            System.out.println("Xóa sản phẩm, chọn xóa sản phẩm: ");
            hienThiSanPham();
            luaChon = kiemTraLuaChon();
            switch (luaChon) {
                case 1:
                    sanPhamNhapKhau.xoaSanPham();
                    break;
                case 2:
//                    soNganHangCoKyHan.themMoi();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("vui long nhap so tu 1 den 3");
            }
        }
        while (luaChon != 3);
    }

    public static void xemDanhSachSanPham() {
        int luaChon = 0;
        SanPhamNhapKhauDichVuImpl sanPhamNhapKhau = new SanPhamNhapKhauDichVuImpl();
        SanPhamXuatKhauDichVuImpl sanPhamXuatKhauDichVu = new SanPhamXuatKhauDichVuImpl();

        do {
            hienThiSanPham();
            luaChon = kiemTraLuaChon();
            switch (luaChon) {
                case 1:
                    sanPhamNhapKhau.hienThi();
                    break;
                case 2:
                    sanPhamXuatKhauDichVu.hienThi();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("vui long nhap so tu 1 den 3");
            }
        }
        while (luaChon != 3);
    }
    public static void timKiemDanhSachSanPham() {
        int luaChon = 0;
        SanPhamNhapKhauDichVuImpl sanPhamNhapKhau = new SanPhamNhapKhauDichVuImpl();

        do {
            hienThiSanPham();
            luaChon = kiemTraLuaChon();
            switch (luaChon) {
                case 1:
                    sanPhamNhapKhau.timKiem();
                    break;
                case 2:
//                    soNganHangCoKyHan.themMoi();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("vui long nhap so tu 1 den 3");
            }
        }
        while (luaChon != 3);
    }

    public static void docFile(){
        int luaChon = 0;
        SanPhamNhapKhauDichVuImpl soDaiHanDichVu = new SanPhamNhapKhauDichVuImpl();

        do {
            System.out.println("Đọc file gán vào chương trình");
            hienThiSanPham();
            luaChon = kiemTraLuaChon();
            switch (luaChon) {
                case 1:
                    soDaiHanDichVu.docFileGanVaoDanhSach("D:\\07.Code\\01.A0422i1\\04.Exam_Module2\\src\\du_lieu\\SanPhamNhapKhau.csv", sanPhamNhapKhauDanhSach);
                    break;
                case 2:
//                    soNganHangCoKyHan.themMoi();
                    break;
                case 3:
                    break;
                case 4:
                    return;
                default:
                    System.out.println("vui long nhap so tu 1 den 4");
            }
        }
        while (luaChon != 4);
    }

    public static void hienThiSanPham() {
        System.out.println("\t1. Sản phẩm nhập khẩu");
        System.out.println("\t2. Sản phẩm xuất khẩu");
        System.out.println("\t3. Quay trở lại");
        System.out.println("\tChọn chức năng: ");
    }

//    public static void hienThiSoNganHan() {
//        System.out.println("\t1. Sổ tiết kiệm ngắn hạn không thời hạn");
//        System.out.println("\t2. Sổ tiết kiệm ngắn hạn có thời hạn");
//        System.out.println("\t3. Quay trở lại");
//        System.out.println("\tChọn chức năng: ");
//    }
//
//    public static void hienThiDanhSachSoTietKiem() {
//        System.out.println("\t1. Sổ tiết kiệm dài hạn");
//        System.out.println("\t2. Sổ tiết kiệm ngắn hạn không thời hạn");
//        System.out.println("\t3. Sổ tiết kiệm ngắn hạn có thời hạn");
//        System.out.println("\t4. Quay trở lại");
//        System.out.println("\tChọn chức năng: ");
//    }

}
