package so_tiet_kiem;

import chung.DocVaViet;
import regex.RegexData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SoDaiHan extends SoTietKiem implements Serializable {

//    public static final String REGEX_MA_SO_TIET_KIEM = "(STK)[-][\\d]{4}";
//    private static final String REGEX_NGAY = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";
//
//
//    private static List<SoDaiHan> soDaiHanDanhSach = new ArrayList<>();
//    private Scanner scanner = new Scanner(System.in);

    private String kyHan;

    public SoDaiHan() {
    }

    public SoDaiHan(String maSoSo, String maKhachHang, String ngayMoSo, String thoiGianBatDauGui, long soTienGui, double laiSuat, String kyHan) {
        super(maSoSo, maKhachHang, ngayMoSo, thoiGianBatDauGui, soTienGui, laiSuat);
        this.kyHan = kyHan;
    }

    public String getKyHan() {
        return kyHan;
    }

    public void setKyHan(String kyHan) {
        this.kyHan = kyHan;
    }
//    @Override
//    public void themMoi() {
//        System.out.println("Thêm mới sổ dài hạn: ");
//
//        String maSoSo = nhapMaSoSo();
//
//        System.out.println("Mã khách hàng: ");
//        String maKhachHang = scanner.nextLine();
//        System.out.println("Ngày mở sổ: ");
//        String ngayMoSo = scanner.nextLine();
//        System.out.println("Thời gian bắt đầu gửi: ");
//        String thoiGianBatDauGui = RegexData.regexAge(scanner.nextLine(), REGEX_NGAY);
//
//        System.out.println("Số tiền gửi: ");
//        long soTienGui = 0;
//        do {
//            soTienGui = Long.parseLong(scanner.nextLine());
//            if (soTienGui <= 1000000)
//                System.out.println("Vui lòng gửi nhiều hơn 1 triệu đồng");
//        } while (soTienGui > 1000000);
//
//
//        System.out.println("Lãi suất: ");
//        double laiSuat = Double.parseDouble(scanner.nextLine());
//        System.out.println("Kỳ hạn: ");
//        String kyHan = scanner.nextLine();
//
//        SoDaiHan soDaiHan = new SoDaiHan(maSoSo, maKhachHang, ngayMoSo, thoiGianBatDauGui, soTienGui, laiSuat, kyHan);
//
//        soDaiHanDanhSach.add(soDaiHan);
//        System.out.println("Đã thêm mới sổ dài hạn");
//        DocVaViet.vietFile("D:\\07.Code\\01.A0422i1\\04.Exam_Module2\\src\\du_lieu\\soDaiHan.csv", soDaiHanDanhSach.toString());
//    }
//
//    private String nhapMaSoSo() {
//        System.out.println("Mã số sổ: ");
//        return RegexData.regexStr(scanner.nextLine(), REGEX_MA_SO_TIET_KIEM, "Bạn nhập sai định dạng, định dạng STK-XXXX");
//
//    }
//
////    private
//
//    @Override
//    public void xoaSo() {
//
//    }

    @Override
    public String toString() {
        return "SoDaiHan{" + super.toString() +
                ", kyHan='" + kyHan + '\'' +
                '}'+"\n";
    }
}
