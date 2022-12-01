package medical.service;

import medical.bean.InformationPeople;
import medical.bean.Symptom;

import java.util.List;
import java.util.Map;

public interface IMedicalService {
    Map<String, String> save (InformationPeople informationPeople, Symptom symptom);

    List<InformationPeople> findInfoPeopleAll();

    List<Symptom> findSymptomAll();

}
