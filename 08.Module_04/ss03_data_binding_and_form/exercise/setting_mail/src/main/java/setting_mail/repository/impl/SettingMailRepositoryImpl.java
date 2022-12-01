package setting_mail.repository.impl;

import org.springframework.stereotype.Repository;
import setting_mail.bean.Mail;
import setting_mail.bean.SettingMail;
import setting_mail.repository.IMailRepository;
import setting_mail.repository.ISettingMailRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SettingMailRepositoryImpl implements ISettingMailRepository {

    private static SettingMail settingMail = new SettingMail("English", 5, true, "Thor \nKing, Asgard");

    @Override
    public SettingMail find() {
        return settingMail;
    }

    @Override
    public void save(SettingMail s) {
        settingMail.setLanguage(s.getLanguage());
        settingMail.setAmount(s.getAmount());
        settingMail.setEnableSpamsFilter(s.isEnableSpamsFilter());
        settingMail.setSignature(s.getSignature());
    }
}
