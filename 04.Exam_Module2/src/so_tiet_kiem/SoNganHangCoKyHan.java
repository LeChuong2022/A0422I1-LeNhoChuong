package so_tiet_kiem;

import chung.DocVaViet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SoNganHangCoKyHan extends SoNganHanKhongKyHan{
    private String kyHan;


    public SoNganHangCoKyHan() {
    }

    public SoNganHangCoKyHan(String kyHan) {
        this.kyHan = kyHan;
    }

    public SoNganHangCoKyHan(String uuDai, String kyHan) {
        super(uuDai);
        this.kyHan = kyHan;
    }

    public SoNganHangCoKyHan(String maSoSo, String maKhachHang, String ngayMoSo, String thoiGianBatDauGui, long soTienGui, double laiSuat, String uuDai, String kyHan) {
        super(maSoSo, maKhachHang, ngayMoSo, thoiGianBatDauGui, soTienGui, laiSuat, uuDai);
        this.kyHan = kyHan;
    }

    public String getKyHan() {
        return kyHan;
    }

    public void setKyHan(String kyHan) {
        this.kyHan = kyHan;
    }

    @Override
    public String toString() {
        return "SoNganHangCoKyHan{" +super.toString() +
                "kyHan='" + kyHan + '\'' +
                '}';
    }
}
