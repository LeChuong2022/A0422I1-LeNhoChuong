package condiment.service;

import org.springframework.stereotype.Service;

@Service
public class CondimentServiceImpl implements ICondimentService {
    @Override
    public String showCondiment(String[] condiment) {
        String showList = " ";
        for (int i = 0; i < condiment.length; i++) {
            if (i != condiment.length - 1) {
                showList += condiment[i] + ", ";
            } else {
                showList += condiment[i];
            }
        }
        return showList;
    }
}
