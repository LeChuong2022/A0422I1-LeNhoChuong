package setting_mail.repository;

import setting_mail.bean.Mail;
import setting_mail.bean.SettingMail;

import java.util.List;

public interface IMailRepository {
    List<Mail> findAll();

}
