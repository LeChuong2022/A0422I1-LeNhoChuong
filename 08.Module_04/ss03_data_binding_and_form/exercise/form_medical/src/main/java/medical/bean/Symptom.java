package medical.bean;

public class Symptom {
    private int id;
    private Boolean fever;
    private Boolean cough;
    private Boolean shortnessOfBreath;
    private Boolean soreThroat;
    private Boolean nausea;
    private Boolean diarrhea;
    private Boolean skinHemorrhage;
    private Boolean skinRash;
    private Boolean travelEpidemicPlace;
    private Boolean closeContact;

    public Symptom() {
    }

    public Symptom(Boolean fever, Boolean cough, Boolean shortnessOfBreath, Boolean soreThroat, Boolean nausea, Boolean diarrhea, Boolean skinHemorrhage, Boolean skinRash, Boolean travelEpidemicPlace, Boolean closeContact) {
        this.fever = fever;
        this.cough = cough;
        this.shortnessOfBreath = shortnessOfBreath;
        this.soreThroat = soreThroat;
        this.nausea = nausea;
        this.diarrhea = diarrhea;
        this.skinHemorrhage = skinHemorrhage;
        this.skinRash = skinRash;
        this.travelEpidemicPlace = travelEpidemicPlace;
        this.closeContact = closeContact;
    }

    public Symptom(int id, Boolean fever, Boolean cough, Boolean shortnessOfBreath, Boolean soreThroat, Boolean nausea, Boolean diarrhea, Boolean skinHemorrhage, Boolean skinRash, Boolean travelEpidemicPlace, Boolean closeContact) {
        this.id = id;
        this.fever = fever;
        this.cough = cough;
        this.shortnessOfBreath = shortnessOfBreath;
        this.soreThroat = soreThroat;
        this.nausea = nausea;
        this.diarrhea = diarrhea;
        this.skinHemorrhage = skinHemorrhage;
        this.skinRash = skinRash;
        this.travelEpidemicPlace = travelEpidemicPlace;
        this.closeContact = closeContact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getFever() {
        return fever;
    }

    public void setFever(Boolean fever) {
        this.fever = fever;
    }

    public Boolean getCough() {
        return cough;
    }

    public void setCough(Boolean cough) {
        this.cough = cough;
    }

    public Boolean getShortnessOfBreath() {
        return shortnessOfBreath;
    }

    public void setShortnessOfBreath(Boolean shortnessOfBreath) {
        this.shortnessOfBreath = shortnessOfBreath;
    }

    public Boolean getSoreThroat() {
        return soreThroat;
    }

    public void setSoreThroat(Boolean soreThroat) {
        this.soreThroat = soreThroat;
    }

    public Boolean getNausea() {
        return nausea;
    }

    public void setNausea(Boolean nausea) {
        this.nausea = nausea;
    }

    public Boolean getDiarrhea() {
        return diarrhea;
    }

    public void setDiarrhea(Boolean diarrhea) {
        this.diarrhea = diarrhea;
    }

    public Boolean getSkinHemorrhage() {
        return skinHemorrhage;
    }

    public void setSkinHemorrhage(Boolean skinHemorrhage) {
        this.skinHemorrhage = skinHemorrhage;
    }

    public Boolean getSkinRash() {
        return skinRash;
    }

    public void setSkinRash(Boolean skinRash) {
        this.skinRash = skinRash;
    }

    public Boolean getTravelEpidemicPlace() {
        return travelEpidemicPlace;
    }

    public void setTravelEpidemicPlace(Boolean travelEpidemicPlace) {
        this.travelEpidemicPlace = travelEpidemicPlace;
    }

    public Boolean getCloseContact() {
        return closeContact;
    }

    public void setCloseContact(Boolean closeContact) {
        this.closeContact = closeContact;
    }
}
