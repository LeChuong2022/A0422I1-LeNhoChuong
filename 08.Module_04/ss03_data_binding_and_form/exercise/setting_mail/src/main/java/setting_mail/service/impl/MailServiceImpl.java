package setting_mail.service.impl;

import setting_mail.bean.Mail;
import setting_mail.bean.SettingMail;
import setting_mail.repository.IMailRepository;
import setting_mail.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MailServiceImpl implements IMailService {
    @Autowired
    IMailRepository mailRepository;

    @Override
    public List<Mail> findAll() {
        return mailRepository.findAll();
    }
}
