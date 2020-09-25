package no.kristiania.http;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueryStringTest {

    @Test
    void shouldRetrieveStatusCode() {
        QueryString queryString = new QueryString("status=200"); //klasse som heter queryString med enkel eksempel
        assertEquals("200", queryString.getParameter("status")); // sjekke at jeg får 200 tilbake getParameter status altså verdien av status skal være 200
    }

    @Test
    void shouldRetrieveStatusCode_401() {
        QueryString queryString = new QueryString("status=401");
        assertEquals("401", queryString.getParameter("status"));
    }

}
