package medical.repository;

import medical.bean.InformationPeople;
import medical.bean.Symptom;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class MedicalRepositoryImpl implements IMedicalRepository{
    private static List<InformationPeople> informationPeopleList = new ArrayList<>();
    private static List<Symptom> symptomList = new ArrayList<>();

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
        return null;
    }

    @Override
    public List<Symptom> findSymptomAll() {
        return null;
    }
}
