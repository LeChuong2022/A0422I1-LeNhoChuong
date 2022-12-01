package setting_mail.service;

import setting_mail.bean.SettingMail;

public interface ISettingMailService {
    SettingMail find();
    void save (SettingMail settingMail);
}
