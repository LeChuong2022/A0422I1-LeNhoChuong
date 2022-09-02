package ss19_string_and_regex.exericise.validate_ten_cua_lop_hoc;

public class ClassCheck {
    public static void main(String[] args) {
        String[] validClasses = new String[]{"C0318G"};
        String[] invalidClasses = new String[]{"M0318G", "P0323A", "P0323J", "AA9878"};
        ValidateClass validateClass = new ValidateClass();
        for (String className : validClasses) {
            boolean isValid = validateClass.validate(className);
            System.out.println("Name of class is " + className + " is valid " + isValid);
        }
        for (String className : invalidClasses) {
            boolean isValid = validateClass.validate(className);
            System.out.println("Name of class is " + className + " is valid " + isValid);
        }
    }
}
