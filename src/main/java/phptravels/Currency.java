package phptravels;

public enum Currency {
    USD("USD"),
    GBP("GBP"),
    SAR("SAR"),
    EUR("EUR");

    private String currency;

    Currency(String currency) {
        this.currency = currency;
    }
}
