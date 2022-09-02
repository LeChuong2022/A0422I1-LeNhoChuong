package ss19_string_and_regex.exericise.validate_do_dien_thoai;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidate {
    static final String PHONE_REGEX = "\\([\\d]{2}\\)-\\(0[\\d]{9}\\)$";

    public static void main(String[] args) {
        String[] validPhone = new String[]{"(84)-(0914325614)", "(84)-(0914325638)", "(12)-(0914325614)"};
        String[] invalidPhone = new String[]{"(84)-(1914325614)", "(84)-(09143256142)", "(a4)-(0914325614)"};
        for (String phone : validPhone) {
            boolean isValid = phoneRegex(phone);
            System.out.println("Phone: " + phone + " is valid " + isValid);
        }
        for (String phone : invalidPhone) {
            boolean isValid = phoneRegex(phone);
            System.out.println("Phone is " + phone + " is valid " + isValid);
        }
    }

    public static boolean phoneRegex(String regex) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}

