package calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements ICalculatorService {
    @Override
    public String calculator(String cal, double number1, double number2) {
        double result = 0;
        switch (cal) {
            case "Addition(+)":
                result = number1 + number2;
                break;
            case "Subtraction(-)":
                result = number1 - number2;
                break;
            case "Multiplication(*)":
                result = number1 * number2;
                break;
            case "Division(/)":
                if (number2 == 0) {
                    return "Không thực hiện phép chia cho 0";
                }
                result = number1 / number2;
                break;
        }
        return result + "";
    }
}
