package regex;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexData {
    static Scanner scanner = new Scanner(System.in);

    public static String regexStr(String temp, String regex, String error) {
        boolean check = true;
        do {
            if (temp.matches(regex))
                check = false;
            else {
                System.out.println(error);
                temp = scanner.nextLine();
            }
        } while (check);
        return temp;
    }

    public static String regexDate(String temp, String regex) {
        boolean check = true;
        while (check) {
            try {
                if (Pattern.matches(regex, temp)) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate date = LocalDate.parse(temp, formatter);
                    LocalDate now = LocalDate.now();
                    if (date.isBefore(now))
                        check = false;
                    else
                        throw new NhapDauVao("Nhập ngày sai, sau thời gian thực tế");
//                    int current = Period.between(date, now).getYears();
                } else {
                    throw new NhapDauVao("Nhập ngày sai định dạng");
                }
            } catch (NhapDauVao e){
                System.out.println(e.getMessage());
                temp = scanner.nextLine();
            }
        }
        return temp;
    }

    public static Long nhapSoDuongLong(Long tien){
        boolean check = true;
        while (check) {
            try {
                if (tien >0) {
                        check = false;
                } else {
                    throw new NhapDauVao("Vui lòng nhập số dương");
                }
            } catch (NhapDauVao e){
                System.out.println(e.getMessage());
                tien = Long.parseLong(scanner.nextLine());
            }
        }
        return tien;
    }

    public static int nhapSoDuongInt(int soLuong){
        boolean check = true;
        while (check) {
            try {
                if (soLuong >0) {
                        check = false;
                } else {
                    throw new NhapDauVao("Vui lòng nhập số dương");
                }
            } catch (NhapDauVao e){
                System.out.println(e.getMessage());
                soLuong = Integer.parseInt(scanner.nextLine());
            }
        }
        return soLuong;
    }
     public static double nhapSoDuongDouble(double thue){
        boolean check = true;
        while (check) {
            try {
                if (thue >0) {
                        check = false;
                } else {
                    throw new NhapDauVao("Vui lòng nhập số dương");
                }
            } catch (NhapDauVao e){
                System.out.println(e.getMessage());
                thue = Double.parseDouble(scanner.nextLine());
            }
        }
        return thue;
    }


    public static String kiemTraTruongNhap(String temp){
        boolean check = true;
        while (check) {
            try {
                if (!temp.equals("")) {
                        check = false;
                } else {
                    throw new NhapDauVao("Vui lòng nhập dữ liệu:");
                }
            } catch (NhapDauVao e){
                System.out.println(e.getMessage());
                temp = scanner.nextLine();
            }
        }
        return temp;
    }
}
