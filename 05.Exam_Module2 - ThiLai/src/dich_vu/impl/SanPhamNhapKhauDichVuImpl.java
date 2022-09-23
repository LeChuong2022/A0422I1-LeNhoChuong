package dich_vu.impl;

import chung.DocVaViet;
import chuong_trinh_quan_ly.ChuongTrinhQuanLy;
import dich_vu.SanPhamNhapKhauDichVu;
import regex.NhapDauVao;
import regex.NotFoundProductException;
import regex.RegexData;
import san_pham.SanPhamNhapKhau;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

public class SanPhamNhapKhauDichVuImpl implements SanPhamNhapKhauDichVu {
    static Scanner scanner = new Scanner(System.in);

    static List<SanPhamNhapKhau> sanPhamNhapKhauDanhSach = ChuongTrinhQuanLy.sanPhamNhapKhauDanhSach;

    private String kiemTraTruongNhap() {
        String str = scanner.nextLine();
        return RegexData.kiemTraTruongNhap(str);
//
//        while (true) {
//            String str = scanner.nextLine();
//            if (!str.equals(""))
//                return str;
//            System.out.print("Vui lòng nhập dữ liệu: ");
//        }
    }

    private String nhapMaSanPham() {
        System.out.println("Mã sản phẩm: ");
        String nhapMa = "";
        boolean check = true;
        while (check) {
            nhapMa = kiemTraTruongNhap();
            if (sanPhamNhapKhauDanhSach.size() == 0)
                break;
            for (SanPhamNhapKhau so : sanPhamNhapKhauDanhSach) {
                if (nhapMa.equals(so.getMaSanPham())) {
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

    private String nhapTinhNhapKhau() {
        System.out.println("Nhập tỉnh nhập khẩu: ");
        return kiemTraTruongNhap();
    }

    private double nhapThueNhapKhau() {
        System.out.println("Nhập thuế nhập khẩu");
        return RegexData.nhapSoDuongDouble(Double.parseDouble(kiemTraTruongNhap()));

    }

    @Override
    public void themMoi() {

        System.out.println("Thêm mới sổ dài hạn: ");

        int id = sanPhamNhapKhauDanhSach.size() + 1;

        String maSanPham = nhapMaSanPham();

        String tenSanPham = nhapTenSanPham();

        System.out.println("Nhập giá bán: ");
        long giaBan = nhapGia();

        int soLuong = nhapSoLuong();

        String nhaSanXuat = nhapNhaSanXuat();

        System.out.println("Nhập giá nhập khẩu: ");
        long giaNhapKhau = nhapGia();

        String tinhNhapKhau = nhapTinhNhapKhau();

        double thueNhapKhau = nhapThueNhapKhau();


        SanPhamNhapKhau sanPhamNhapKhau = new SanPhamNhapKhau(id, maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat, giaNhapKhau, tinhNhapKhau, thueNhapKhau);

        sanPhamNhapKhauDanhSach.add(sanPhamNhapKhau);

        System.out.println("Đã thêm mới sản phẩm nhập khẩu");

        vietFile();

    }

    @Override
    public void xoaSanPham() {
        boolean check = true;

        while (check) {
            try {
                System.out.println("Sản phẩm muốn xóa: ");
                String maSanPhamXoa = kiemTraTruongNhap();
                for (int i = 0; i < sanPhamNhapKhauDanhSach.size(); i++) {
                    if (maSanPhamXoa.equals(sanPhamNhapKhauDanhSach.get(i).getMaSanPham())) {
                        System.out.println("Bạn có muốn xóa sản phẩm ko? Nếu muốn xóa chọn Y, Nếu không chọn N:");
                        String str = scanner.nextLine();
                        if (str.equals("Y")) {
                            sanPhamNhapKhauDanhSach.remove(i);
                            System.out.println("Đã xóa số thành công");
                            vietFile();
                            System.out.println(DocVaViet.docFile("D:\\07.Code\\01.A0422i1\\05.Exam_Module2 - ThiLai\\src\\du_lieu\\SanPhamNhapKhau.csv"));
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
        System.out.println(sanPhamNhapKhauDanhSach.toString());
//        System.out.println(DocVaViet.docFile("D:\\07.Code\\01.A0422i1\\05.Exam_Module2 - ThiLai\\src\\du_lieu\\SanPhamNhapKhau.csv"));
    }

    @Override
    public void timKiem() {
//        docFileGanVaoDanhSach("D:\\07.Code\\01.A0422i1\\05.Exam_Module2 - ThiLai\\src\\du_lieu\\SanPhamNhapKhau.csv", sanPhamNhapKhauDanhSach);
        System.out.println("Nhập mã hoặc tên sản phẩm muốn tìm: ");
        String maHoacTenSanPhamTim = kiemTraTruongNhap();
        for (int i = 0; i < sanPhamNhapKhauDanhSach.size(); i++) {
            if (maHoacTenSanPhamTim.equals(sanPhamNhapKhauDanhSach.get(i).getTenSanPham()) || maHoacTenSanPhamTim.equals(sanPhamNhapKhauDanhSach.get(i).getMaSanPham())) {
                sanPhamNhapKhauDanhSach.get(i).toString();
            }
        }
        System.out.println("Không có mã sản phẩm muốn tìm");
    }

    public void vietFile() {
        String hienThi = "\tidSanPham:, " + "\tMã San Pham:, " + "\tTen San Pham:, " +
                "\tGia Ban:, " + "\tSo Luong:, " + "\tNha San Xuat:, " + "Gia Nhap Khau:, " + "Tinh THanh Nhap:, " + "Thue Nhap Khau:, " + "\n";
        for (SanPhamNhapKhau sp : sanPhamNhapKhauDanhSach) {
            hienThi = hienThi + "\t" + sp.getIdSanPham() + ",\t" + sp.getMaSanPham() + ",\t" + sp.getTenSanPham() +
                    ",\t" + sp.getGiaBan() + ",\t" + sp.getSoLuong() + ",\t" + sp.getNhaSanXuat() + ",\t" + sp.getGiaNhapKhau() + ",\t" + sp.getTinhThanhNhap() + ",\t" + sp.getThueNhapKhau() + "\n";
        }

        DocVaViet.vietFile("D:\\07.Code\\01.A0422i1\\05.Exam_Module2 - ThiLai\\src\\du_lieu\\SanPhamNhapKhau.csv", hienThi);
    }

    public void docFileGanVaoDanhSach(String pathFile, List<SanPhamNhapKhau> sanPhamNhapKhauDanhSach) {
        sanPhamNhapKhauDanhSach.removeAll(sanPhamNhapKhauDanhSach);
        try {
            File file = new File(pathFile);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(pathFile));
            String line = "";
            String[] arrOfStr = new String[9];
            int count = 0;
            while ((line = br.readLine()) != null) {
                if (count == 0) {
                    count++;
                    continue;
                }
                arrOfStr = line.split(",", 9);
                SanPhamNhapKhau sanPhamNhapKhau = new SanPhamNhapKhau(Integer.parseInt(arrOfStr[0].trim()), arrOfStr[1].trim(), arrOfStr[2].trim(), Long.parseLong(arrOfStr[3].trim()), Integer.parseInt(arrOfStr[4].trim()),
                        arrOfStr[5].trim(), Long.parseLong(arrOfStr[6].trim()), arrOfStr[7].trim(), Double.parseDouble(arrOfStr[8].trim()));
                sanPhamNhapKhauDanhSach.add(sanPhamNhapKhau);
            }
            br.close();
        } catch (Exception e) {
            System.err.println("File does not exist");
        }
    }

}
