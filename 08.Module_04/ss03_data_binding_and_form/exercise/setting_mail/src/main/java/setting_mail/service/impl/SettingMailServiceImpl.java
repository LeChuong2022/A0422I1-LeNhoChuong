package setting_mail.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import setting_mail.bean.Mail;
import setting_mail.bean.SettingMail;
import setting_mail.repository.IMailRepository;
import setting_mail.repository.ISettingMailRepository;
import setting_mail.service.IMailService;
import setting_mail.service.ISettingMailService;

import java.util.List;

@Service
public class SettingMailServiceImpl implements ISettingMailService {
    @Autowired
    ISettingMailRepository settingMailRepository;


    @Override
    public SettingMail find() {
        return settingMailRepository.find();
    }

    @Override
    public void save(SettingMail settingMail) {
        settingMailRepository.save(settingMail);
    }
}
