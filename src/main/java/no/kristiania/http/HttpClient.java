package no.kristiania.http;

import java.io.IOException;
import java.net.Socket;

public class HttpClient {

    private final int responseCode;

    public HttpClient(String hostname, int port, String requestTarget) throws IOException {
        Socket socket = new Socket(hostname, port);

        String request = "GET " + requestTarget + " HTTP/1.1\r\n" +
                "Host: " + hostname + "\r\n" +
                "Connection: close \r\n" +
                "\r\n";
        socket.getOutputStream().write(request.getBytes());

        String responseLine = readLine(socket);
        String[] responseLineParts = responseLine.split(" ");
        responseCode = Integer.parseInt(responseLineParts[1]);

        String headerLine;
        while (!headerLine = readLine(socket)).isEmpty()) { //2t25min på video av forelesning 3 Pull request
            int colonPos = headerLine.indexOf(':');
            String fieldName = headerLine.substring(0, colonPos);
            String fieldValue = headerLine.substring(colonPos+1);

        }
    }

    private String readLine(Socket socket) throws IOException {
        StringBuilder line = new StringBuilder(); //ta vare på teksten internt (HTTP/1.1 ..) StrinBuilder er som en string men lr seg manipuleres.
        int c;
        while ((c = socket.getInputStream().read()) != -1) {
            if (c == '\n') {
                break; // går ut av while løkken
            }
            line.append((char)c);
        }
        return line.toString();
    }

    public static void main(String[] args) throws IOException {
        String hostname = "urlecho.appspot.com";
        int port = 80;
        String requestTarget = "/echo?status=200&body=Kristiania";
        new HttpClient(hostname, port, requestTarget); // hente de over

    }

    public int getResponseCode() {
        return responseCode;
    }


    public String getResponseHeader(String headerName) {
        return null;
    }
}
