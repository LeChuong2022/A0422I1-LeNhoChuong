package validate;

import exception.UserException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validator {
    public static Date validateDayOfBirth(String dayOfBirthAsString) throws UserException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
        format.setLenient(false);
        Date dayOfBirth = null;
        try {
            dayOfBirth = format.parse(dayOfBirthAsString);
            Date now = new Date();
            if (dayOfBirth.after(now))
                throw new UserException(Message.DATE_FORMAT);
            return dayOfBirth;
        } catch (ParseException e) {
            throw new UserException(Message.DATE_FORMAT);
        }
    }
}
