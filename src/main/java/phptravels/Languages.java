package phptravels;

public enum Languages {
    English("English"),
    Russian("Russian"),
    French("French"),
    Spanish("Spanish");

    private String language;

    private Languages(String language) {
        this.language = language;
    }
}