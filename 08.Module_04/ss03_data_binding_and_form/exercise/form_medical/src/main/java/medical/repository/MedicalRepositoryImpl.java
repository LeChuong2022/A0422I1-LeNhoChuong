package medical.repository;

import com.sun.javafx.iio.gif.GIFImageLoaderFactory;
import medical.bean.InformationPeople;
import medical.bean.Symptom;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Repository
public class MedicalRepositoryImpl implements IMedicalRepository {
    private static List<InformationPeople> informationPeopleList = new ArrayList<>();
    private static List<Symptom> symptomList = new ArrayList<>();



    static {
        Date date1 = null;
        Date date2 = null;
        Date date3 = null;
        Date date4 = null;
        try {
            date1 = new SimpleDateFormat("dd-MM-yyyy").parse("15-11-2020");
            date2 = new SimpleDateFormat("dd-MM-yyyy").parse("20-11-2020");
            date3 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-11-1");
            date4 = new SimpleDateFormat("dd-MM-yyyy").parse("11-11-2020");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        informationPeopleList.add(new InformationPeople(1, "Thành", Year.parse("1990"), "Nam", "Việt Nam", "201444222", "Ô tô", "14208", "41208", date1, date1, "Đà Nẵng", "Đà Nẵng", "Hải Châu", "Thanh Bình", "24 Bế Văn Đàn", "093123099", "thanh@gmail.com"));
        informationPeopleList.add(new InformationPeople(2, "Long", Year.parse("1991"), "Nam", "Việt Nam", "201444222", "Ô tô", "14208", "41208", date2, date2, "Đà Nẵng", "Đà Nẵng", "Hải Châu", "Thanh Bình", "24 Bế Văn Đàn", "093123099", "thanh@gmail.com"));
        informationPeopleList.add(new InformationPeople(3, "Trung", Year.parse("1992"), "Nam", "Việt Nam", "201444222", "Ô tô", "14208", "41208", date3, date3, "Đà Nẵng", "Đà Nẵng", "Hải Châu", "Thanh Bình", "24 Bế Văn Đàn", "093123099", "thanh@gmail.com"));
        informationPeopleList.add(new InformationPeople(4, "Nghĩa", Year.parse("1993"), "Nam", "Việt Nam", "201444222", "Ô tô", "14208", "41208", date4, date4, "Đà Nẵng", "Đà Nẵng", "Hải Châu", "Thanh Bình", "24 Bế Văn Đàn", "093123099", "thanh@gmail.com"));

        symptomList.add(new Symptom(1, true, false, true, true, false, true, false, true, false, true));
        symptomList.add(new Symptom(2, false, false, true, true, false, true, false, true, false, true));
        symptomList.add(new Symptom(3, true, true, true, true, false, true, false, true, false, true));
        symptomList.add(new Symptom(4, false, false, false, false, false, true, false, true, false, true));
    }

    @Override
    public void save(InformationPeople informationPeople, Symptom symptom) {
        int code = (int) Math.floor(((Math.random() * 899999) + 100000));
        informationPeople.setId(code);
        symptom.setId(code);
        informationPeopleList.add(informationPeople);
        symptomList.add(symptom);
    }

    @Override
    public List<InformationPeople> findInfoPeopleAll() {
        return informationPeopleList;
    }

    @Override
    public List<Symptom> findSymptomAll() {
        return symptomList;
    }

    @Override
    public InformationPeople findInfoPeopleById(int id) {
        for (int i = 0; i < informationPeopleList.size(); i++) {
            if (informationPeopleList.get(i).getId()== id)
                return informationPeopleList.get(i);
        }
        return null;
    }
    @Override
    public Symptom findSymptomById(int id) {
        for (int i = 0; i < symptomList.size(); i++) {
            if (symptomList.get(i).getId()== id)
                return symptomList.get(i);
        }
        return null;
    }

    @Override
    public void update(InformationPeople informationPeople, Symptom symptom) {
        for (int i = 0; i < informationPeopleList.size(); i++) {
            if (informationPeopleList.get(i).getId() == informationPeople.getId()){
                informationPeopleList.get(i).setName(informationPeople.getName());
                informationPeopleList.get(i).setYearOfBirth(informationPeople.getYearOfBirth());
                informationPeopleList.get(i).setGender(informationPeople.getGender());
                informationPeopleList.get(i).setNationality(informationPeople.getNationality());
                informationPeopleList.get(i).setCreditId(informationPeople.getCreditId());
                informationPeopleList.get(i).setVehicle(informationPeople.getVehicle());
                informationPeopleList.get(i).setNumberVehicle(informationPeople.getNumberVehicle());
                informationPeopleList.get(i).setNumberLocate(informationPeople.getNumberLocate());
                informationPeopleList.get(i).setDayStart(informationPeople.getDayStart());
                informationPeopleList.get(i).setDayEnd(informationPeople.getDayEnd());
                informationPeopleList.get(i).setCityTravel(informationPeople.getCityTravel());
                informationPeopleList.get(i).setAddress(informationPeople.getAddress());
                informationPeopleList.get(i).setPhone(informationPeople.getPhone());
                informationPeopleList.get(i).setEmail(informationPeople.getEmail());
            }
        }
        for (int i = 0; i < symptomList.size(); i++) {
            if (symptomList.get(i).getId() == symptom.getId()){
                symptomList.get(i).setFever(symptom.getFever());
                symptomList.get(i).setCough(symptom.getCough());
                symptomList.get(i).setShortnessOfBreath(symptom.getShortnessOfBreath());
                symptomList.get(i).setSoreThroat(symptom.getSoreThroat());
                symptomList.get(i).setNausea(symptom.getNausea());
                symptomList.get(i).setDiarrhea(symptom.getDiarrhea());
                symptomList.get(i).setSkinHemorrhage(symptom.getSkinHemorrhage());
                symptomList.get(i).setSkinRash(symptom.getSkinRash());
                symptomList.get(i).setTravelEpidemicPlace(symptom.getTravelEpidemicPlace());
                symptomList.get(i).setCloseContact(symptom.getCloseContact());
            }

        }
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < informationPeopleList.size(); i++) {
            if (informationPeopleList.get(i).getId()==id){
                informationPeopleList.remove(i);
            }
        }
        for (int i = 0; i < symptomList.size(); i++) {
            if (symptomList.get(i).getId()==id){
                symptomList.remove(i);
            }
        }
    }

}
