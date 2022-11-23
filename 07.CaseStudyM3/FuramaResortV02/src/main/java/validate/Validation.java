package validate;

import java.util.Date;

public class Validation {
    public static boolean checkEmail(String email) {
//        String regexEmail = "^[a-z]+\\.\\w+\\@[a-z]{2,}\\.[a-z]{2,}$"; // của anh CHánh
//        String regexEmail = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
        String regexEmail = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return email.matches(regexEmail);
    }

    public static boolean checkPhone(String phone) {
        String regexPhone = "(090)[\\d]{7}|(091)[\\d]{7}|\\(84\\)\\+90[\\d]{7}|\\(84\\)\\+91[\\d]{7}";
        return phone.matches(regexPhone);
    }

    public static boolean checkIdCard(String idCard) {
        String regexIdCard = "[\\d]{9}|[\\d]{12}";  // 9 hoặc 12 số
        return idCard.matches(regexIdCard);
    }
//   public static boolean checkBirthday(Date birthday) {
//        String birthdayString = String.valueOf(birthday);
//        String regexBirthday = "^\\d{4}-\\d{2}-\\d{2}$";  // 9 hoặc 12 số
//        return birthdayString.matches(regexBirthday);
//    }


}
