package so_tiet_kiem;

import chung.DocVaViet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SoNganHanKhongKyHan extends SoTietKiem {

    private static List<SoNganHanKhongKyHan> soNganHanKhongKyHanDanhScah = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    private String uuDai;

    public SoNganHanKhongKyHan() {
    }

    public SoNganHanKhongKyHan(String uuDai) {
        this.uuDai = uuDai;
    }

    public SoNganHanKhongKyHan(String maSoSo, String maKhachHang, String ngayMoSo, String thoiGianBatDauGui, long soTienGui, double laiSuat, String uuDai) {
        super(maSoSo, maKhachHang, ngayMoSo, thoiGianBatDauGui, soTienGui, laiSuat);
        this.uuDai = uuDai;
    }

    public String getUuDai() {
        return uuDai;
    }

    public void setUuDai(String uuDai) {
        this.uuDai = uuDai;
    }

//    @Override
//    public void themMoi() {
//        System.out.println("Thêm mới sổ ngắn hạn không kỳ hạn: ");
//        System.out.println("Mã số sổ: ");
//        String maSoSo = scanner.nextLine();
//        System.out.println("Mã khách hàng: ");
//        String maKhachHang = scanner.nextLine();
//        System.out.println("Ngày mở sổ: ");
//        String ngayMoSo = scanner.nextLine();
//        System.out.println("Thời gian bắt đầu gửi: ");
//        String thoiGianBatDauGui = scanner.nextLine();
//        System.out.println("Số tiền gửi: ");
//        long soTienGui = Long.parseLong(scanner.nextLine()) ;
//        System.out.println("Lãi suất: ");
//        double laiSuat = Double.parseDouble(scanner.nextLine()) ;
//        System.out.println("Ưu đãi: ");
//        String uuDai = scanner.nextLine();
//
//        SoNganHanKhongKyHan soNganHanKhongKyHan = new SoNganHanKhongKyHan( maSoSo,  maKhachHang,  ngayMoSo,  thoiGianBatDauGui,  soTienGui,  laiSuat,  uuDai);
//
//        soNganHanKhongKyHanDanhScah.add(soNganHanKhongKyHan);
//        System.out.println("Đã thêm mới sổ ngắn hạn không kì hạn");
//        DocVaViet.vietFile("D:\\07.Code\\01.A0422i1\\04.Exam_Module2\\src\\du_lieu\\soNganHanKhongKyHan.csv", soNganHanKhongKyHanDanhScah.toString());
//    }
//
//    @Override
//    public void xoaSo() {
//
//    }

    @Override
    public String toString() {
        return "SoNganHanKhongKyHan{" + super.toString() +
                ", uuDai='" + uuDai + '\'' +
                '}';
    }
}
