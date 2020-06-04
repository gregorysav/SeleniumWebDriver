package phptravels;

public enum Languages {
    English("English"),
    Russian("Russian"),
    French("French"),
    Spanish("Spanish"),
    Vietnamese("Vietnamese"),
    Arabic("Arabic"),
    Farsi("Farsi"),
    German("German");

    private String language;

    private Languages(String language) {
        this.language = language;
    }
}