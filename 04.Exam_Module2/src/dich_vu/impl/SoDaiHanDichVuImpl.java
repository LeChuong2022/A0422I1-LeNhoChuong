package dich_vu.impl;

import chung.DocVaViet;
import chung.DocVaVietFileNhiPhan;
import chuong_trinh_quan_ly.ChuongTrinhQuanLy;
import dich_vu.SoDaiHanDichVu;
import regex.NhapDauVao;
import regex.RegexData;
import regex.Validate;
import so_tiet_kiem.SoDaiHan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class SoDaiHanDichVuImpl implements SoDaiHanDichVu {
    static Scanner scanner = new Scanner(System.in);

    static List<SoDaiHan> soDaiHanDanhSach = ChuongTrinhQuanLy.soDaiHanDanhSach;

    private String kiemTraTruongNhap() {
        while (true) {
            String str = scanner.nextLine();
            if (!str.equals(""))
                return str;
            System.out.print("Vui lòng nhập dữ liệu: ");
        }
    }

    private String nhapMaSoSo() {
        System.out.println("Mã số sổ: ");
        String nhapMaSoSo = "";
        boolean check = true;
        while (check) {
            nhapMaSoSo = kiemTraTruongNhap();
            if (soDaiHanDanhSach.size() == 0)
                break;
            for (SoDaiHan so : soDaiHanDanhSach) {
                if (nhapMaSoSo.equals(so.getMaSoSo())) {
                    System.out.println("Trùng mã số sổ tiết kiệm. Vui lòng nhập lại: ");
                    check = true;
                    break;
                }
                check = false;
            }
        }
        return RegexData.regexStr(nhapMaSoSo, Validate.REGEX_MA_SO_TIET_KIEM, "Bạn nhập sai định dạng, định dạng STK-XXXX");
    }

    private String nhapMaKhachHang() {
        System.out.println("Mã khách hàng: ");
        return kiemTraTruongNhap();
    }

    private String nhapNgayMoSo() {
        System.out.println("Ngày mở sổ: ");
        return RegexData.regexDate(kiemTraTruongNhap(), Validate.REGEX_NGAY);
    }

    private String nhapThoiGianBanDauGui() {
        System.out.println("Thời gian bắt đầu gửi: ");
        return RegexData.regexDate(kiemTraTruongNhap(), Validate.REGEX_NGAY);
    }

    private Long nhapSoTienGui() {
        System.out.println("Số tiền gửi: ");
        return RegexData.tienToiThieu(Long.parseLong(kiemTraTruongNhap()));
    }

    private String nhapLaiSuat() {
        System.out.println("Lãi suất: ");
        return kiemTraTruongNhap();
    }

    private String nhapKyHan() {
        System.out.println("Kỳ hạn: ");
        return kiemTraTruongNhap();
    }

    @Override
    public void themMoi() {
//        soDaiHanDanhSach = (List<SoDaiHan>) DocVaVietFileNhiPhan.read("D:\\07.Code\\01.A0422i1\\04.Exam_Module2\\src\\du_lieu\\soDaiHanNhiPhan.dat");

        System.out.println("Thêm mới sổ dài hạn: ");

        String maSoSo = nhapMaSoSo();

        String maKhachHang = nhapMaKhachHang();

        String ngayMoSo = nhapNgayMoSo();

        String thoiGianBatDauGui = nhapThoiGianBanDauGui();

        long soTienGui = nhapSoTienGui();

        double laiSuat = Double.parseDouble(nhapLaiSuat());

        String kyHan = nhapKyHan();

        SoDaiHan soDaiHan = new SoDaiHan(maSoSo, maKhachHang, ngayMoSo, thoiGianBatDauGui, soTienGui, laiSuat, kyHan);

        soDaiHanDanhSach.add(soDaiHan);

        System.out.println("Đã thêm mới sổ dài hạn");

        vietFile();

    }

    @Override
    public void xoaSo() {
        System.out.println("Sổ muốn xóa: ");
        String maSoSoMuonXoa = nhapMaSoSo();
        for (int i = 0; i < soDaiHanDanhSach.size(); i++) {
            if (maSoSoMuonXoa.equals(soDaiHanDanhSach.get(i).getMaSoSo())) {
                soDaiHanDanhSach.remove(i);
                System.out.println("Đã xóa số thành công");
                vietFile();
                return;
            }
        }
        System.out.println("Không có mã số sổ muốn xóa");
        return;

    }

    @Override
    public void hienThi() {
        System.out.println("Sổ dài hạn: ");
        System.out.println(DocVaViet.docFile("D:\\07.Code\\01.A0422i1\\04.Exam_Module2\\src\\du_lieu\\soDaiHan.csv"));
    }

    public void vietFile() {
        String hienThi = "\tMã số sổ:, " + "\tMã khách hàng:, " + "\tNgày mở sổ:, " +
                "\tThời gian bắt đầu gửi:, " + "\tSố tiền gửi:, " + "\tLãi suất:, " + "%\tKỳ hạn:, " + "\n";
        for (SoDaiHan so : soDaiHanDanhSach) {
            hienThi = hienThi + "\t" + so.getMaSoSo() + ",\t" + so.getMaKhachHang() + ",\t" + so.getNgayMoSo() +
                    ",\t" + so.getThoiGianBatDauGui() + ",\t" + so.getSoTienGui() + ",\t" + so.getLaiSuat() + ",\t" + so.getKyHan() + "\n";
        }

        DocVaViet.vietFile("D:\\07.Code\\01.A0422i1\\04.Exam_Module2\\src\\du_lieu\\soDaiHan.csv", hienThi);
    }

    public void docFileGanVaoDanhSach(String pathFile, List<SoDaiHan> soDaiHanDanhSach) {
        soDaiHanDanhSach.removeAll(soDaiHanDanhSach);
        try {
            File file = new File(pathFile);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(pathFile));
            String line = "";
            String[] arrOfStr = new String[7];
            int count = 0;
            while ((line = br.readLine()) != null) {
                if (count == 0) {
                    count++;
                    continue;
                }
                arrOfStr = line.split(",", 7);
                SoDaiHan soDaiHan = new SoDaiHan(arrOfStr[0].trim(), arrOfStr[1].trim(), arrOfStr[2].trim(), arrOfStr[3].trim(), Long.parseLong(arrOfStr[4].trim()), Double.parseDouble(arrOfStr[5].trim()), arrOfStr[6].trim());
                soDaiHanDanhSach.add(soDaiHan);
            }
            br.close();
        } catch (Exception e) {
            System.err.println("File does not exist");
        }
    }

}
