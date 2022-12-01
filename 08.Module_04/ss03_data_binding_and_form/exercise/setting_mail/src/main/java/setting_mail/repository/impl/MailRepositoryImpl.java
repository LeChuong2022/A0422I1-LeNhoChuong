package setting_mail.repository.impl;

import setting_mail.bean.Mail;
import setting_mail.bean.SettingMail;
import setting_mail.repository.IMailRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MailRepositoryImpl implements IMailRepository {

    private static ArrayList<Mail> mailArrayList;

    static {
        mailArrayList = new ArrayList<>();
        mailArrayList.add(new Mail("name1", "tien nuoc 1", true));
        mailArrayList.add(new Mail("name1", "tien nuoc 2", true));
        mailArrayList.add(new Mail("name1", "tien nuoc 3", true));
        mailArrayList.add(new Mail("name1", "tien nuoc 4", true));
        mailArrayList.add(new Mail("name1", "tien nuoc 5", true));
        mailArrayList.add(new Mail("name1", "tien nuoc 6", false));
        mailArrayList.add(new Mail("name1", "tien nuoc 7", false));
        mailArrayList.add(new Mail("name1", "tien nuoc 8", true));
        mailArrayList.add(new Mail("name1", "tien nuoc 9", false));
        mailArrayList.add(new Mail("name1", "tien nuoc 10", false));
        mailArrayList.add(new Mail("name1", "tien nuoc 11", true));
        mailArrayList.add(new Mail("name1", "tien nuoc 12", false));
        mailArrayList.add(new Mail("name1", "tien nuoc 13", true));
        mailArrayList.add(new Mail("name1", "tien nuoc 14", false));
        mailArrayList.add(new Mail("name1", "tien nuoc 15", true));
        mailArrayList.add(new Mail("name1", "tien nuoc 16", false));
        mailArrayList.add(new Mail("name1", "tien nuoc 17", false));
        mailArrayList.add(new Mail("name1", "tien nuoc 18", true));
        mailArrayList.add(new Mail("name1", "tien nuoc 19", false));
        mailArrayList.add(new Mail("name1", "tien nuoc 20", false));
        mailArrayList.add(new Mail("name1", "tien nuoc 21", true));
        mailArrayList.add(new Mail("name1", "tien nuoc 22", false));
        mailArrayList.add(new Mail("name1", "tien nuoc 24", true));
        mailArrayList.add(new Mail("name1", "tien nuoc 25", false));
        mailArrayList.add(new Mail("name1", "tien nuoc 26", false));
        mailArrayList.add(new Mail("name1", "tien nuoc 27", true));
        mailArrayList.add(new Mail("name1", "tien nuoc 28", false));
        mailArrayList.add(new Mail("name1", "tien nuoc 29", true));
        mailArrayList.add(new Mail("name1", "tien nuoc 30", false));
        mailArrayList.add(new Mail("name1", "tien nuoc 31", false));
        mailArrayList.add(new Mail("name1", "tien nuoc 32", true));
        mailArrayList.add(new Mail("name1", "tien nuoc 33", false));
        mailArrayList.add(new Mail("name1", "tien nuoc 34", false));
        mailArrayList.add(new Mail("name1", "tien nuoc 35", false));
        mailArrayList.add(new Mail("name1", "tien nuoc 36", true));
        mailArrayList.add(new Mail("name1", "tien nuoc 37", false));
    }

    @Override
    public List<Mail> findAll() {
        return mailArrayList;
    }

}
