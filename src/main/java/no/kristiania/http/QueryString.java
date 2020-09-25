package no.kristiania.http;

public class QueryString {
    private final String parameterValue;

    public QueryString(String queryString) {
        int equalPos = queryString.indexOf('='); //index og ser etter hvilke posisjon er = . status (0-5) neste er = (6.)
        parameterValue = queryString.substring(equalPos+1); //substring som starter på den posisjonen + 1 substring tar det som er etter =
    }

    public String getParameter(String status) {
        return parameterValue;
    }
}
