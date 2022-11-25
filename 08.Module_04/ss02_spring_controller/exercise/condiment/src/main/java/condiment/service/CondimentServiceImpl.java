package condiment.service;

import condiment.repository.IDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryServiceImpl implements IDictionaryService {
    @Autowired
    private IDictionaryRepository dictionaryRepository;

    @Override
    public String translateE(String inputE) {

        return dictionaryRepository.translateE(inputE);
    }
}
