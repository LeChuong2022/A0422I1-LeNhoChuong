package codegym.vn.validate;

public class Validation {
    public static boolean checkName(String name) {
        String regexName = "(\\w|\\s)*\\.(mp3|wav|ogg|mp4)";
        return name.matches(regexName);
    }

}
