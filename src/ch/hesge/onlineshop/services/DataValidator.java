package ch.hesge.onlineshop.services;

import javax.inject.Singleton;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Singleton
public class DataValidator {

    //Source : https://stackoverflow.com/questions/5439529/determine-if-a-string-is-an-integer-in-java
    public Boolean isInt(String value) {
        if (value == null || value.isEmpty()) return false;
        for (int i = 0; i < value.length(); i++) {
            if (i == 0 && value.charAt(i) == '-') {
                if (value.length() == 1) return false;
                else continue;
            }
            if (Character.digit(value.charAt(i), 10) < 0) return false;
        }
        return true;
    }

    public Boolean isValidEmail(String email) {

        if (email == null || email.isEmpty()) {
            return false;
        }

        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    public Boolean isValidNumberCard(String numberCard) {
        if (numberCard == null || numberCard.isEmpty()) {
            return false;
        }

        Pattern pattern = Pattern.compile("^(?:4[0-9]{12}(?:[0-9]{3})?|[25][1-7][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})$");
        Matcher matcher = pattern.matcher(numberCard);
        return matcher.find();
    }

    public Boolean isValidMonth(String month) {

        if (month == null || month.isEmpty()) {
            return false;
        }

        Pattern pattern = Pattern.compile("^(0?[1-9]|1[012])$");
        Matcher matcher = pattern.matcher(month);
        return matcher.find();
    }

    public Boolean isValidYear(String year) {
        try {
            int y = Integer.parseInt(year);
            return y >= 19 && y < 100;
        } catch (Exception ex) {
            return false;
        }

    }
}
