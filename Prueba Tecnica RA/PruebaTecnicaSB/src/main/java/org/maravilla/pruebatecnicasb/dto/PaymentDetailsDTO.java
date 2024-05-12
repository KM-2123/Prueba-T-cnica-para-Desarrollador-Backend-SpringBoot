package org.maravilla.pruebatecnicasb.dto;

public class PaymentDetailsDTO {
    private String cardNumber;
    private String cardHolderNumber;
    private int expirationMonth;
    private int expirationYear;
    private String cvv;

    private double amount;

    //Constructor, getter y setter

    public PaymentDetailsDTO(String cardNumber, String cardHolderNumber, int expirationMonth, int expirationYear, String cvv, double amount) {
        this.cardNumber = cardNumber;
        this.cardHolderNumber = cardHolderNumber;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
        this.cvv = cvv;
        this.amount = amount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolderNumber() {
        return cardHolderNumber;
    }

    public void setCardHolderNumber(String cardHolderNumber) {
        this.cardHolderNumber = cardHolderNumber;
    }

    public int getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(int expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public int getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return 0;
    }
}
