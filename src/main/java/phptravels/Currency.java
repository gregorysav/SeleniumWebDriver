package phptravels;

public enum Currency {
    USD("USD"),
    GBP("GBP"),
    SAR("SAR"),
    EUR("EUR");

    private String currency;

    private Currency(String currency) {
        this.currency = currency;
    }
}
