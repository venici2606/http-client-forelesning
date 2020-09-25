package no.kristiania.http;

import java.io.IOException;
import java.net.Socket;

public class HttpClient {
    public HttpClient(String hostname, int port, String requestTarget) {

    }

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("urlecho.appspot.com", 80);
/*
        String request = "GET /echo?status=200&body=Pause%20til%2014:25&hallo=there HTTP/1.1\r\n" +
                "Host: urlecho.appspot.com\r\n" +
                "Connection: close \r\n" + //connection close, da kjører den ikke videre
                "\r\n"; //string kopierte fra inspect
        // \r\n - ny linje CRLF - carrage return?
        socket.getOutputStream().write(request.getBytes()); //for å skrive til metoden og requesten
*/

        String request = "GET /echo?status=200&body=Kristiania HTTP/1.1\r\n" +
                "Host: urlecho.appspot.com\r\n" +
                "Connection: close \r\n" +
                "\r\n";
        socket.getOutputStream().write(request.getBytes());

        int c;
        while ((c = socket.getInputStream().read()) != -1) {
            System.out.print((char)c);
        }

    }

    public int getResponseCode() {
        return 0;
    }
}
