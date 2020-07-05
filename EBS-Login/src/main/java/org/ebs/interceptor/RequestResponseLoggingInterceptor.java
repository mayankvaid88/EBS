package org.ebs.interceptor;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class RequestResponseLoggingInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        logRequest(httpRequest, bytes);
        ClientHttpResponse response = clientHttpRequestExecution.execute(httpRequest, bytes);
        logResponse(response);
        return response;
    }

    private void logResponse(ClientHttpResponse response) throws IOException {
        System.out.println(response.getStatusCode());
    }

    private void logRequest(HttpRequest httpRequest, byte[] bytes) throws UnsupportedEncodingException {
        System.out.println("URI "+ httpRequest.getURI());
        System.out.println("Method "+ httpRequest.getMethod());
        System.out.println("Request body "+ new String(bytes, StandardCharsets.UTF_8));
        System.out.println("Request header "+ httpRequest.getHeaders().toString());
    }
}
