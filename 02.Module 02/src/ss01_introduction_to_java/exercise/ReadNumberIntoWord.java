package ss01_introduction_to_java.exercise;

import java.util.Scanner;

public class ReadNumberIntoWord {
    public static String getValueIfNumberFromZeroThroughNine(int number) {
        switch (number) {
            case 0:
                return "zero";
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
        }
        return "";
    }

    public static String getValueIfNumberFromTenThroughTwenty(int number) {
        switch (number) {
            case 0:
                return "ten";
            case 1:
                return "eleven";
            case 2:
                return "twelve";
            case 3:
                return "thirteen";
            case 4:
                return "fourteen";
            case 5:
                return "fifteen";
            case 6:
                return "sixteen";
            case 7:
                return "seventeen";
            case 8:
                return "eighteen";
            case 9:
                return "nineteen";
        }
        return "";
    }

    public static String getTensDigit(int number) {
        switch (number) {
            case 2:
                return "twenty";
            case 3:
                return "thirty";
            case 4:
                return "forty";
            case 5:
                return "fifty";
            case 6:
                return "sixty";
            case 7:
                return "seventy";
            case 8:
                return "eighty";
            case 9:
                return "ninety";
        }
        return "";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter your number which you want to read: ");
        int number = scanner.nextInt();
        String numberIsRead = null;
        if (number >= 0 && number < 10) {
            numberIsRead = getValueIfNumberFromZeroThroughNine(number);
        } else if (number < 20) {
            int onesDigit = number % 10;
            numberIsRead = getValueIfNumberFromTenThroughTwenty(onesDigit);
        } else if (number < 100) {
            int tensDigit = number / 10;
            int onesDigit = number % 10;
            numberIsRead = getTensDigit(tensDigit);
            if (onesDigit != 0)
                numberIsRead += " " + getValueIfNumberFromZeroThroughNine(onesDigit);
        } else if (number < 1000) {
            int hundredsDigit = number / 100;
            int tensDigit = (number - hundredsDigit * 100) / 10;
            int onesDigit = number % 10;
            numberIsRead = getValueIfNumberFromZeroThroughNine(hundredsDigit) + " hundred";
            if (tensDigit == 0) {
                if (onesDigit != 0)
                    numberIsRead += " and " + getValueIfNumberFromZeroThroughNine(onesDigit);
            } else if (tensDigit == 1) {
                numberIsRead += " and " + getValueIfNumberFromTenThroughTwenty(onesDigit);
            } else {
                numberIsRead += " and " + getTensDigit(tensDigit);
                if (onesDigit != 0) {
                    numberIsRead += " " + getValueIfNumberFromZeroThroughNine(onesDigit);
                }
            }
        }
        System.out.printf(numberIsRead);
    }
}
