package dich_vu.impl;

import chung.DocVaViet;
import dich_vu.SoNganHanCoKyHanDichVu;
import regex.NhapDauVao;
import regex.RegexData;
import regex.Validate;
import so_tiet_kiem.SoNganHangCoKyHan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SoNganHanCoKyHanDichVuImpl implements SoNganHanCoKyHanDichVu {

    static Scanner scanner = new Scanner(System.in);

    List<SoNganHangCoKyHan> soNganHangCoKyHanDanhSach = new ArrayList<>();

    private String kiemTraTruongNhap(){
        while (true){
            String str = scanner.nextLine();
            if (str != "")
                return str;
        }
    }

    private String nhapMaSoSo() {
        System.out.println("Mã số sổ: ");
        return RegexData.regexStr(kiemTraTruongNhap(), Validate.REGEX_MA_SO_TIET_KIEM, "Bạn nhập sai định dạng, định dạng STK-XXXX");
    }

    private String nhapMaKhachHang(){
        System.out.println("Mã khách hàng: ");
        return kiemTraTruongNhap();
    }

    private String nhapNgayMoSo(){
        System.out.println("Ngày mở sổ: ");
        return RegexData.regexDate(kiemTraTruongNhap(), Validate.REGEX_NGAY);
    }

    private String nhapThoiGianBanDauGui(){
        System.out.println("Thời gian bắt đầu gửi: ");
        return RegexData.regexDate(kiemTraTruongNhap(), Validate.REGEX_NGAY);
    }

    private Long nhapSoTienGui() {
        System.out.println("Số tiền gửi: ");
        return RegexData.tienToiThieu(Long.parseLong(kiemTraTruongNhap()));
    }

    private String nhapLaiSuat(){
        System.out.println("Lãi suất: ");
        return kiemTraTruongNhap();
    }

    private String nhapUuDai(){
        System.out.println("Ưu đãi: ");
        return kiemTraTruongNhap();
    }

    private String nhapKyHan(){
        System.out.println("Kỳ hạn: ");
        return kiemTraTruongNhap();
    }

    @Override
    public void themMoi() {
        System.out.println("Thêm mới sổ ngắn hạn có kỳ hạn: ");

        String maSoSo = nhapMaSoSo();

        String maKhachHang = nhapMaKhachHang();

        String ngayMoSo = nhapNgayMoSo();

        String thoiGianBatDauGui = nhapThoiGianBanDauGui();

        long soTienGui = nhapSoTienGui() ;

        double laiSuat = Double.parseDouble(nhapLaiSuat()) ;

        String uuDai = scanner.nextLine();

        String kyHan = nhapKyHan();

        SoNganHangCoKyHan soNganHangCoKyHan = new SoNganHangCoKyHan( maSoSo,  maKhachHang,  ngayMoSo,  thoiGianBatDauGui,  soTienGui,  laiSuat,  uuDai, kyHan);

        soNganHangCoKyHanDanhSach.add(soNganHangCoKyHan);
        System.out.println("Đã thêm mới sổ ngắn hạn không kì hạn");
        DocVaViet.vietFile("D:\\07.Code\\01.A0422i1\\04.Exam_Module2\\src\\du_lieu\\soNganHanCoKyHan.csv", soNganHangCoKyHanDanhSach.toString());
    }

    @Override
    public void xoaSo() {

    }

    @Override
    public void hienThi() {

    }
}
