package ch.hesge.onlineshop.models;

public class FormPayment {

    private String name;
    private String email;
    private String numberCard;
    private String month;
    private String year;

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
}
