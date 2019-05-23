package ch.hesge.onlineshop.models;

public class CreditCard {

    private String name;
    private String email;
    private String cardNumber;
    private int month;
    private int year;

    public CreditCard(String name, String email, String cardNumber, int month, int year) {
        this.name = name;
        this.email = email;
        this.cardNumber = cardNumber;
        this.month = month;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }


}
