package calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements ICalculatorService {
    @Override
    public double calculator(String cal, double number1, double number2) {
        double result = 0;
        switch (cal){
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
             result = number1 / number2;
             break;
        }
        return result;
    }
}
