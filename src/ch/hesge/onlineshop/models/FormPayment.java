package ch.hesge.onlineshop.models;

public class FormPayment {

    private final String name;
    private final String email;
    private final String numberCard;
    private final String month;
    private final String year;

    private Boolean isValidName = true;
    private Boolean isValidEmail = true;
    private Boolean isValidNumberCard = true;
    private Boolean isValidMonth = true;
    private Boolean isValidYear = true;

    public FormPayment(String name, String email, String numberCard, String month, String year) {
        this.name = name;
        this.email = email;
        this.numberCard = numberCard;
        this.month = month;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNumberCard() {
        return numberCard;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public Boolean getValidName() {
        return isValidName;
    }

    public Boolean getValidEmail() {
        return isValidEmail;
    }

    public Boolean getValidNumberCard() {
        return isValidNumberCard;
    }

    public Boolean getValidMonth() {
        return isValidMonth;
    }

    public Boolean getValidYear() {
        return isValidYear;
    }

    public void setValidName(Boolean validName) {
        isValidName = validName;
    }

    public void setValidEmail(Boolean validEmail) {
        isValidEmail = validEmail;
    }

    public void setValidNumberCard(Boolean validNumberCard) {
        isValidNumberCard = validNumberCard;
    }

    public void setValidMonth(Boolean validMonth) {
        isValidMonth = validMonth;
    }

    public void setValidYear(Boolean validYear) {
        isValidYear = validYear;
    }
}
