package medical.repository;

import medical.bean.InformationPeople;
import medical.bean.Symptom;

import java.util.List;

public interface IMedicalRepository {
    void save (InformationPeople informationPeople, Symptom symptom);

    List<InformationPeople> findInfoPeopleAll();
    List<Symptom> findSymptomAll();
    InformationPeople findInfoPeopleById(int id);
    Symptom findSymptomById(int id);
    void update(InformationPeople informationPeople, Symptom symptom);
    void remove(int id);
}
