package san_pham;

import java.io.Serializable;

public class SanPhamNhapKhau extends SanPham implements Serializable {
private long giaNhapKhau;
private String tinhThanhNhap;
private double thueNhapKhau;

    public SanPhamNhapKhau() {
    }

    public SanPhamNhapKhau(long giaNhapKhau, String tinhThanhNhap, double thueNhapKhau) {
        this.giaNhapKhau = giaNhapKhau;
        this.tinhThanhNhap = tinhThanhNhap;
        this.thueNhapKhau = thueNhapKhau;
    }

    public SanPhamNhapKhau(int idSanPham, String maSanPham, String tenSanPham, long giaBan, int soLuong, String nhaSanXuat, long giaNhapKhau, String tinhThanhNhap, double thueNhapKhau) {
        super(idSanPham, maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat);
        this.giaNhapKhau = giaNhapKhau;
        this.tinhThanhNhap = tinhThanhNhap;
        this.thueNhapKhau = thueNhapKhau;
    }

    public long getGiaNhapKhau() {
        return giaNhapKhau;
    }

    public void setGiaNhapKhau(long giaNhapKhau) {
        this.giaNhapKhau = giaNhapKhau;
    }

    public String getTinhThanhNhap() {
        return tinhThanhNhap;
    }

    public void setTinhThanhNhap(String tinhThanhNhap) {
        this.tinhThanhNhap = tinhThanhNhap;
    }

    public double getThueNhapKhau() {
        return thueNhapKhau;
    }

    public void setThueNhapKhau(double thueNhapKhau) {
        this.thueNhapKhau = thueNhapKhau;
    }

    @Override
    public String toString() {
        return "\nSanPhamNhapKhau{" + super.toString() +
                "giaNhapKhau=" + giaNhapKhau +
                ", tinhThanhNhap='" + tinhThanhNhap + '\'' +
                ", thueNhapKhau=" + thueNhapKhau +
                '}' + "\n";
    }
    /*
    private String kyHan;

    public SanPhamNhapKhau() {
    }

    public SanPhamNhapKhau(String maSoSo, String maKhachHang, String ngayMoSo, String thoiGianBatDauGui, long soTienGui, double laiSuat, String kyHan) {
        super(maSoSo, maKhachHang, ngayMoSo, thoiGianBatDauGui, soTienGui, laiSuat);
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
        return "SoDaiHan{" + super.toString() +
                ", kyHan='" + kyHan + '\'' +
                '}'+"\n";
    }

     */
}
