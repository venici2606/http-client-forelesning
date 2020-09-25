package no.kristiania.http;

public class QueryString {
    private final String parameterValue;
    private final String parameterName;

    public QueryString(String queryString) {
        int equalPos = queryString.indexOf('='); //index og ser etter hvilke posisjon er = . status (0-5) neste er = (6.)
        parameterName = queryString.substring(0, equalPos);
        parameterValue = queryString.substring(equalPos+1); //substring som starter på den posisjonen + 1 substring tar det som er etter =
    }

    public String getParameter(String status) {
        if (status.equals(parameterName)) { //hvis status er lik parametername så skal value bli vist == sjekker om to objekter er like derfor skal du ha equals
            return parameterValue;
        } else {
            return null;
        }

    }
}
