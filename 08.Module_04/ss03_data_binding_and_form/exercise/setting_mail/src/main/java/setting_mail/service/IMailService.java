package setting_mail.service;

import setting_mail.bean.Mail;

import java.util.List;

public interface IMailService {
    List<Mail> findAll();
}
