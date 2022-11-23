package currency_convert.service;

import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements ICurrencyService {
    @Override
    public double currencyConvert(double amount, String inputC, String outputC) {
        double result;
        if (inputC.equals("VND") && outputC.equals("USD")){
            result = amount / 23000;
        } else if (inputC.equals("USD") && outputC.equals("VND")){
            result = amount * 23000;
        } else {
            result = amount;
        }
        return result;
    }
}
