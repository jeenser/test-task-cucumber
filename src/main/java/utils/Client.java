package utils;

import dtos.Product;
import io.cucumber.core.internal.com.fasterxml.jackson.core.type.TypeReference;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Slf4j
public class Client {

    private static final HttpClient  httpClient = HttpClient.newHttpClient();
    private static final String uri = "https://api.escuelajs.co/api/v1/products";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public static List<Product> getAllProducts()
    {
        var request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        log.info(response.body());
        return objectMapper.readValue(response.body(), new TypeReference<List<Product>>(){});
    }

    @SneakyThrows
    public static List<Product> getProductsWithOffsetAndLimit(int offset, int limit)
    {
        var request = HttpRequest.newBuilder()
                .uri(URI.create(uri + "?offset="+ offset + "&limit=" + limit))
                .GET()
                .build();
        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        log.info(response.body());
        return objectMapper.readValue(response.body(), new TypeReference<List<Product>>(){});
    }
}
