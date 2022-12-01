package medical.service;

import medical.bean.InformationPeople;
import medical.bean.Symptom;
import medical.repository.IMedicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MedicalServiceImpl implements IMedicalService {
    @Autowired
    private IMedicalRepository medicalRepository;

    @Override
    public Map<String, String> save(InformationPeople informationPeople, Symptom symptom) {
        //Kiểm tra dữ liệu
        Map<String, String> errorMap = new HashMap<>();
        if ("".equals(informationPeople.getName())) {
            errorMap.put("name", "name không được để trống");
        }
        if (informationPeople.getYearOfBirth() == null) {
            errorMap.put("yearOfBirth", "Năm sinh không được để trống");
        }
        if ("".equals(informationPeople.getGender())) {
            errorMap.put("gender", "Giới tính không được để trống");
        }
        if ("".equals(informationPeople.getNationality())){
            errorMap.put("nationality", "Quốc tịch không được để trống");
        }
        if ("".equals(informationPeople.getCreditId())){
            errorMap.put("creditId", "CMND(Hộ chiếu) không được để trống");
        }
        if (informationPeople.getVehicle() == null){
            errorMap.put("vehicle", "thông tin đi lại không được để trống");
        }
        if (informationPeople.getDayStart() == null){
            errorMap.put("dayStart", "Ngày khởi hành không được để trống");
        }
        if (informationPeople.getDayEnd() == null){
            errorMap.put("dayEnd", "Ngày kết thúc không được để trống");
        }
        if ("".equals(informationPeople.getCityTravel())){
            errorMap.put("cityTravel", "không được để trống");
        }
        if ("".equals(informationPeople.getCityAddress())){
            errorMap.put("cityAddress", "không được để trống");
        }
        if ("".equals(informationPeople.getDistrictAddress())){
            errorMap.put("districtAddress", "không được để trống");
        }
        if ("".equals(informationPeople.getWardAddress())){
            errorMap.put("wardAddress", "không được để trống");
        }
        if ("".equals(informationPeople.getAddress())){
            errorMap.put("address", "không được để trống");
        }
       if ("".equals(informationPeople.getPhone())){
            errorMap.put("phone", "không được để trống");
        }
       if (symptom.getFever() == null){
            errorMap.put("fever", "không được để trống");
        }
       if (symptom.getNausea() == null){
            errorMap.put("nausea", "không được để trống");
        }
       if (symptom.getCough() == null){
            errorMap.put("cough", "không được để trống");
        }
       if (symptom.getDiarrhea() == null){
            errorMap.put("diarrhea", "không được để trống");
        }
       if (symptom.getShortnessOfBreath() == null){
            errorMap.put("shortnessOfBreath", "không được để trống");
        }
       if (symptom.getSkinHemorrhage() == null){
            errorMap.put("skinHemorrhage", "không được để trống");
        }
       if (symptom.getSoreThroat() == null){
            errorMap.put("soreThroat", "không được để trống");
        }
       if (symptom.getSkinRash() == null){
            errorMap.put("skinRash", "không được để trống");
        }
       if (symptom.getTravelEpidemicPlace() == null){
            errorMap.put("travelEpidemicPlace", "không được để trống");
        }
       if (symptom.getCloseContact() == null){
            errorMap.put("closeContact", "không được để trống");
        }
        if (errorMap.isEmpty()) {
            medicalRepository.save(informationPeople, symptom);
        }
        return errorMap;
    }

    @Override
    public List<InformationPeople> findInfoPeopleAll() {
        return medicalRepository.findInfoPeopleAll();
    }

    @Override
    public List<Symptom> findSymptomAll() {
        return null;
    }


}
