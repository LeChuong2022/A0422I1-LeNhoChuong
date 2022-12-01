package setting_mail.bean;

public class Mail {
    private String mailName;
    private String subject;
    private boolean mailSpam;

    public Mail() {
    }

    public Mail(String mailName, String subject, boolean mailSpam) {
        this.mailName = mailName;
        this.subject = subject;
        this.mailSpam = mailSpam;
    }

    public String getMailName() {
        return mailName;
    }

    public void setMailName(String mailName) {
        this.mailName = mailName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public boolean isMailSpam() {
        return mailSpam;
    }

    public void setMailSpam(boolean mailSpam) {
        this.mailSpam = mailSpam;
    }
}
