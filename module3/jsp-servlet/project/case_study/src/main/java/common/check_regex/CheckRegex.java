package common.check_regex;

public class CheckRegex {
    private static final String REGEX_PHONE = "^((09)|(849))[0-9]{7}$";
    private static final String REGEX_EMAIL = "^([a-z]|[A-Z])|([a-z]|[A-Z][0-9]){1,200}@gmail.com$";

    public static boolean checkRegexPhone(String value) {
        if (value.matches(REGEX_PHONE)) {
            return true;
        }
        return false;
    }

    public static boolean checkRegexEmail(String value) {
        if (value.matches(REGEX_EMAIL)) {
            return true;
        }
        return false;
    }
}
