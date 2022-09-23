package chuong_trinh_quan_ly;

import dich_vu.impl.SoDaiHanDichVuImpl;
import dich_vu.impl.SoNganHanCoKyHanDichVuImpl;
import dich_vu.impl.SoNganHanKhongKyHanDichVuImpl;
import so_tiet_kiem.SoDaiHan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ChuongTrinhQuanLy {
    static Scanner scanner = new Scanner(System.in);

    public static List<SoDaiHan> soDaiHanDanhSach = new ArrayList<>();

    public static void main(String[] args) {
        int luaChon = 0;
        do {
            hienThiLuaChon();
            luaChon = kiemTraLuaChon();
            switch (luaChon) {
                case 1:
                    themSoTietKiem();
                    break;
                case 2:
                    xoaSoTietKiem();
                    break;
                case 3:
                    xemDanhSachSoTietKiem();
                    break;
                case 4:
                    docFile();
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

    public static void hienThiLuaChon() {
        System.out.println("\nCHƯƠNG TRÌNH QUẢN LÝ SỔ TIẾT KIỆM-" +
                "\nChọn chức năng theo số(để tiếp tục): ");
        System.out.println("\t1. Thêm mới sổ tiết kiệm");
        System.out.println("\t2. Xóa sổ tiết kiệm");
        System.out.println("\t3. Xem danh sách sổ tiết kiệm");
        System.out.println("\t4. Gán file csv vào chương trình");
        System.out.println("\t5. Thoát");
        System.out.println("\tChọn chức năng: ");
    }

    public static void themSoTietKiem() {
        int luaChon = 0;
        SoDaiHanDichVuImpl soDaiHanDichVu = new SoDaiHanDichVuImpl();
        do {
            System.out.println("Thêm sổ tiết kiệm, chọn sổ: ");
            hienThiSoTietKiem();
            luaChon = kiemTraLuaChon();
            switch (luaChon) {
                case 1:
                    soDaiHanDichVu.themMoi();
                    break;
                case 2:
                    themSoNganHan();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("vui long nhap so tu 1 den 4");
            }
        }
        while (luaChon != 3);
    }

    public static void themSoNganHan() {
        int luaChon = 0;
        SoNganHanCoKyHanDichVuImpl soNganHangCoKyHan = new SoNganHanCoKyHanDichVuImpl();
        SoNganHanKhongKyHanDichVuImpl soNganHanKhongKyHan = new SoNganHanKhongKyHanDichVuImpl();
        do {
            System.out.println("Thêm sổ tiết kiệm, chọn sổ: ");
            hienThiSoNganHan();
            luaChon = kiemTraLuaChon();
            switch (luaChon) {
                case 1:
                    soNganHangCoKyHan.themMoi();
                    break;
                case 2:
                    soNganHangCoKyHan.themMoi();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("vui long nhap so tu 1 den 3");
            }
        }
        while (luaChon != 4);
    }

    public static void xoaSoTietKiem(){
        int luaChon = 0;
        SoDaiHanDichVuImpl soDaiHanDichVu = new SoDaiHanDichVuImpl();

        do {
            System.out.println("Xóa sổ tiết kiệm, chọn sổ: ");
            hienThiDanhSachSoTietKiem();
            luaChon = kiemTraLuaChon();
            switch (luaChon) {
                case 1:
                    soDaiHanDichVu.xoaSo();
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
        while (luaChon != 4);
    }

    public static void xemDanhSachSoTietKiem() {
        int luaChon = 0;
        SoDaiHanDichVuImpl soDaiHanDichVu = new SoDaiHanDichVuImpl();

        do {
            hienThiDanhSachSoTietKiem();
            luaChon = kiemTraLuaChon();
            switch (luaChon) {
                case 1:
                    soDaiHanDichVu.hienThi();
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

    public static void docFile(){
        int luaChon = 0;
        SoDaiHanDichVuImpl soDaiHanDichVu = new SoDaiHanDichVuImpl();

        do {
            System.out.println("Đọc file gán vào chương trình");
            hienThiDanhSachSoTietKiem();
            luaChon = kiemTraLuaChon();
            switch (luaChon) {
                case 1:
                    soDaiHanDichVu.docFileGanVaoDanhSach("D:\\07.Code\\01.A0422i1\\04.Exam_Module2\\src\\du_lieu\\soDaiHan.csv", soDaiHanDanhSach);
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

    public static void hienThiSoTietKiem() {
        System.out.println("\t1. Sổ tiết kiệm dài hạn");
        System.out.println("\t2. Sổ tiết kiệm ngắn hạn");
        System.out.println("\t3. Quay trở lại");
        System.out.println("\tChọn chức năng: ");
    }

    public static void hienThiSoNganHan() {
        System.out.println("\t1. Sổ tiết kiệm ngắn hạn không thời hạn");
        System.out.println("\t2. Sổ tiết kiệm ngắn hạn có thời hạn");
        System.out.println("\t3. Quay trở lại");
        System.out.println("\tChọn chức năng: ");
    }

    public static void hienThiDanhSachSoTietKiem() {
        System.out.println("\t1. Sổ tiết kiệm dài hạn");
        System.out.println("\t2. Sổ tiết kiệm ngắn hạn không thời hạn");
        System.out.println("\t3. Sổ tiết kiệm ngắn hạn có thời hạn");
        System.out.println("\t4. Quay trở lại");
        System.out.println("\tChọn chức năng: ");
    }

}
