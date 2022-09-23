package ss00_case_study.furama_resort.validate;

import ss00_case_study.furama_resort.exception.UserException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validator {
    public static Date validateBirthday(String birthdayAsString) throws UserException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        Date birthday = null;
        try {
            birthday = format.parse(birthdayAsString);
            Date now = new Date();
            if (now.getYear() - birthday.getYear() < 18) {
                throw new UserException(Message.AGE_LESS_THAN_18);
            }
            return birthday;
        } catch (ParseException e) {
            throw new UserException(Message.DATE_FORMAT);
        }
    }

    public static boolean validateName(String name) throws UserException {
        char begin = name.charAt(0);
        if (begin < 65 || begin > 90) {
            throw new UserException(Message.NAME_INCORRECT);
        }
        return true;
    }
}
