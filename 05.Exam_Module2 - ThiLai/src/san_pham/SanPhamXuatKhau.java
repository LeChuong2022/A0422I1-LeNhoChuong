package san_pham;

public class SanPhamXuatKhau extends SanPham{

   private long giaXuatKhau;
   private String quocGiaNhap;

   public SanPhamXuatKhau() {
   }

   public SanPhamXuatKhau(long giaXuatKhau, String quocGiaNhap) {
      this.giaXuatKhau = giaXuatKhau;
      this.quocGiaNhap = quocGiaNhap;
   }

   public SanPhamXuatKhau(int idSanPham, String maSanPham, String tenSanPham, long giaBan, int soLuong, String nhaSanXuat, long giaXuatKhau, String quocGiaNhap) {
      super(idSanPham, maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat);
      this.giaXuatKhau = giaXuatKhau;
      this.quocGiaNhap = quocGiaNhap;
   }

   public long getGiaXuatKhau() {
      return giaXuatKhau;
   }

   public void setGiaXuatKhau(long giaXuatKhau) {
      this.giaXuatKhau = giaXuatKhau;
   }

   public String getQuocGiaNhap() {
      return quocGiaNhap;
   }

   public void setQuocGiaNhap(String quocGiaNhap) {
      this.quocGiaNhap = quocGiaNhap;
   }

   @Override
   public String toString() {
      return "SanPhamXuatKhau{" + super.toString() +
              "giaXuatKhau=" + giaXuatKhau +
              ", quocGiaNhap='" + quocGiaNhap + '\'' +
              '}';
   }
   /*
    private String kyHan;


    public SanPhamXuatKhau() {
    }

    public SanPhamXuatKhau(String kyHan) {
        this.kyHan = kyHan;
    }

    public SanPhamXuatKhau(String uuDai, String kyHan) {
        super(uuDai);
        this.kyHan = kyHan;
    }

    public SanPhamXuatKhau(String maSoSo, String maKhachHang, String ngayMoSo, String thoiGianBatDauGui, long soTienGui, double laiSuat, String uuDai, String kyHan) {
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

    */
}
