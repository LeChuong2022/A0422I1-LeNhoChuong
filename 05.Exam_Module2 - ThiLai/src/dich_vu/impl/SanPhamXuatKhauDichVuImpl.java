package dich_vu.impl;

import chung.DocVaViet;
import dich_vu.SanPhamXuatKhauDichVu;
import regex.NotFoundProductException;
import regex.RegexData;
import san_pham.SanPhamNhapKhau;
import san_pham.SanPhamXuatKhau;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class SanPhamXuatKhauDichVuImpl implements SanPhamXuatKhauDichVu {

    static Scanner scanner = new Scanner(System.in);

    List<SanPhamXuatKhau> sanPhamXuatKhauDanhSach = new ArrayList<>();

    private String kiemTraTruongNhap() {
        String str = scanner.nextLine();
        return RegexData.kiemTraTruongNhap(str);

    }

    private String nhapMaSanPham() {
        System.out.println("Mã sản phẩm: ");
        String nhapMa = "";
        boolean check = true;
        while (check) {
            nhapMa = kiemTraTruongNhap();
            if (sanPhamXuatKhauDanhSach.size() == 0)
                break;
            for (SanPhamXuatKhau sp : sanPhamXuatKhauDanhSach) {
                if (nhapMa.equals(sp.getMaSanPham())) {
                    System.out.println("Trùng mã sản phẩm. Vui lòng nhập lại: ");
                    check = true;
                    break;
                }
                check = false;
            }
        }
        return nhapMa;
    }

    private String nhapTenSanPham() {
        System.out.println("Nhập tên sản phẩm: ");
        return kiemTraTruongNhap();
    }

    private Long nhapGia() {
        return RegexData.nhapSoDuongLong(Long.parseLong(kiemTraTruongNhap()));
    }

    private int nhapSoLuong() {
        System.out.println("Nhập số lượng sản phẩm");
        return RegexData.nhapSoDuongInt(Integer.parseInt(kiemTraTruongNhap()));

    }

    private String nhapNhaSanXuat() {
        System.out.println("Nhập tên sản phẩm: ");
        return kiemTraTruongNhap();
    }

    private String nhapQuocGiaNhapKhau() {
        System.out.println("Nhập quốc gia nhập khẩu: ");
        return kiemTraTruongNhap();
    }

//    private double nhapThueNhapKhau() {
//        System.out.println("Nhập thuế nhập khẩu");
//        return RegexData.nhapSoDuongDouble(Double.parseDouble(kiemTraTruongNhap()));
//
//    }

    @Override
    public void themMoi() {

        System.out.println("Thêm mới sổ dài hạn: ");

        int id = sanPhamXuatKhauDanhSach.size() + 1;

        String maSanPham = nhapMaSanPham();

        String tenSanPham = nhapTenSanPham();

        System.out.println("Nhập giá bán: ");
        long giaBan = nhapGia();

        int soLuong = nhapSoLuong();

        String nhaSanXuat = nhapNhaSanXuat();

        System.out.println("Nhập giá xuất khẩu: ");
        long giaXuatKhau = nhapGia();

        String quocGiaNhapKhau = nhapQuocGiaNhapKhau();

            SanPhamXuatKhau sanPhamXuatKhau = new SanPhamXuatKhau(id, maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat, giaXuatKhau, quocGiaNhapKhau);

        sanPhamXuatKhauDanhSach.add(sanPhamXuatKhau);

        System.out.println("Đã thêm mới sản phẩm xuất khẩu");

        vietFile();

    }

    @Override
    public void xoaSanPham() {
        boolean check = true;

        while (check) {
            try {
                System.out.println("Sản phẩm muốn xóa: ");
                String maSanPhamXoa = kiemTraTruongNhap();
                for (int i = 0; i < sanPhamXuatKhauDanhSach.size(); i++) {
                    if (maSanPhamXoa.equals(sanPhamXuatKhauDanhSach.get(i).getMaSanPham())) {
                        System.out.println("Bạn có muốn xóa sản phẩm ko? Nếu muốn xóa chọn Y, Nếu không chọn N:");
                        String str = scanner.nextLine();
                        if (str.equals("Y")) {
                            sanPhamXuatKhauDanhSach.remove(i);
                            System.out.println("Đã xóa sản phẩm thành công");
                            vietFile();
                            System.out.println(DocVaViet.docFile("D:\\07.Code\\01.A0422i1\\05.Exam_Module2 - ThiLai\\src\\du_lieu\\SanPhamXuatKhau.csv"));
                            return;
                        } else if (str.equals("N")) {
                            System.out.println("Không thực hiện xóa sản phẩm");
                            return;
                        } else {
                            System.out.println("Vui lòng nhập Y/N");
                            break;
                        }
                    }
                    throw new NotFoundProductException("Vui lòng nhập lại tên hoặc mã sản phẩm");
                }
            } catch (NotFoundProductException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    @Override
    public void hienThi() {
        System.out.println("Sản phẩm nhập khẩu: ");
        System.out.println(sanPhamXuatKhauDanhSach.toString());
//        System.out.println(DocVaViet.docFile("D:\\07.Code\\01.A0422i1\\05.Exam_Module2 - ThiLai\\src\\du_lieu\\SanPhamNhapKhau.csv"));
    }

    @Override
    public void timKiem() {
//        docFileGanVaoDanhSach("D:\\07.Code\\01.A0422i1\\05.Exam_Module2 - ThiLai\\src\\du_lieu\\SanPhamNhapKhau.csv", sanPhamXuatKhauDanhSach);
//        System.out.println("Nhập mã hoặc tên sản phẩm muốn tìm: ");
//        String maHoacTenSanPhamTim = kiemTraTruongNhap();
//        for (int i = 0; i < sanPhamXuatKhauDanhSach.size(); i++) {
//            if (maHoacTenSanPhamTim.equals(sanPhamXuatKhauDanhSach.get(i).getTenSanPham()) || maHoacTenSanPhamTim.equals(sanPhamXuatKhauDanhSach.get(i).getMaSanPham())) {
//                sanPhamXuatKhauDanhSach.get(i).toString();
//            }
//        }
//        System.out.println("Không có mã sản phẩm muốn tìm");
    }

    public void vietFile() {
        String hienThi = "\tidSanPham:, " + "\tMã San Pham:, " + "\tTen San Pham:, " +
                "\tGia Ban:, " + "\tSo Luong:, " + "\tNha San Xuat:, " + "Gia Xuất Khau:, " + "Quoc gia nhập:, " + "\n";
        for (SanPhamXuatKhau sp : sanPhamXuatKhauDanhSach) {
            hienThi = hienThi + "\t" + sp.getIdSanPham() + ",\t" + sp.getMaSanPham() + ",\t" + sp.getTenSanPham() +
                    ",\t" + sp.getGiaBan() + ",\t" + sp.getSoLuong() + ",\t" + sp.getNhaSanXuat() + ",\t" + sp.getGiaXuatKhau() + ",\t" + sp.getQuocGiaNhap() + "\n";
        }

        DocVaViet.vietFile("D:\\07.Code\\01.A0422i1\\05.Exam_Module2 - ThiLai\\src\\du_lieu\\SanPhamNhapKhau.csv", hienThi);
    }

//    public void docFileGanVaoDanhSach(String pathFile, List<SanPhamXuatKhau> sanPhamXuatKhauDanhSach) {
//        sanPhamXuatKhauDanhSach.removeAll(sanPhamXuatKhauDanhSach);
//        try {
//            File file = new File(pathFile);
//            if (!file.exists()) {
//                throw new FileNotFoundException();
//            }
//            BufferedReader br = new BufferedReader(new FileReader(pathFile));
//            String line = "";
//            String[] arrOfStr = new String[8];
//            int count = 0;
//            while ((line = br.readLine()) != null) {
//                if (count == 0) {
//                    count++;
//                    continue;
//                }
//                arrOfStr = line.split(",", 8);
//                SanPhamXuatKhau sanPhamXuatKhau = new SanPhamXuatKhau(Integer.parseInt(arrOfStr[0].trim()), arrOfStr[1].trim(), arrOfStr[2].trim(), Long.parseLong(arrOfStr[3].trim()), Integer.parseInt(arrOfStr[4].trim()),
//                        arrOfStr[5].trim(), Long.parseLong(arrOfStr[6].trim()), arrOfStr[7].trim(), Double.parseDouble(arrOfStr[8].trim()));
//                sanPhamXuatKhauDanhSach.add(sanPhamNhapKhau);
//            }
//            br.close();
//        } catch (Exception e) {
//            System.err.println("File does not exist");
//        }
//    }

}


