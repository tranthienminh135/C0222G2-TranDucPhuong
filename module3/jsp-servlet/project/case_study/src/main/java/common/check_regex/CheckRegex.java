package common.check_regex;

public class CheckRegex {
    private static final String REGEX_PHONE = "^((09)|(849))[0-9]{7}$";
    private static final String REGEX_EMAIL = "^([a-z]|[A-Z])|([a-z]|[A-Z][0-9]){1,200}@gmail.com$";
    private static final String REGEX_ID_CARD = "^([1-9][0-9]{8})|([1-9][0-9]{11})$";

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
    public static boolean checkRegexIDCard(String value) {
        if (value.matches(REGEX_ID_CARD)) {
            return true;
        }
        return false;
    }
}
