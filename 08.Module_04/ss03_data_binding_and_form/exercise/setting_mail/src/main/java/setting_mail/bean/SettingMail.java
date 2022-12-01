package setting_mail.bean;

public class SettingMail {
    private String language;
    private int amount;
    private boolean enableSpamsFilter;
    private String signature;

    public SettingMail() {
    }

    public SettingMail(String language, int amount, boolean enableSpamFilter, String signature) {
        this.language = language;
        this.amount = amount;
        this.enableSpamsFilter = enableSpamFilter;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isEnableSpamsFilter() {
        return enableSpamsFilter;
    }

    public void setEnableSpamsFilter(boolean enableSpamsFilter) {
        this.enableSpamsFilter = enableSpamsFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
