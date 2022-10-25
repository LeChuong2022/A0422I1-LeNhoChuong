public class Calculator {
    public static float calculate(float firstOperand, float secondOperand, String cal) {
        switch (cal) {
            case "Add":
                return firstOperand + secondOperand;
            case "Sub":
                return firstOperand - secondOperand;
            case "Mul":
                return firstOperand * secondOperand;
            case "Div":
                if (secondOperand !=0){
                    return firstOperand / secondOperand;
                }
                else
                    throw new RuntimeException("Can't divide by zero");
            default:
                throw new RuntimeException("Invalid operation");
        }
    }
}
