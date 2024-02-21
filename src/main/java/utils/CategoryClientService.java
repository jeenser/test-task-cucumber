package utils;

import dtos.Category;
import dtos.Product;
import io.cucumber.core.internal.com.fasterxml.jackson.core.type.TypeReference;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.HttpResponseException;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.BasicHttpClientResponseHandler;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.util.List;

@Slf4j
public class CategoryClientService {

    private static final CloseableHttpClient httpClient = HttpClients.createDefault();
    private static final String uri = "https://api.escuelajs.co/api/v1/categories";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public static List<Category> getAllCategories()
    {
        var request = new HttpGet(uri);
        var response = httpClient.execute(request, new BasicHttpClientResponseHandler());
        log.info(response);
        return objectMapper.readValue(response, new TypeReference<List<Category>>(){});
    }

    @SneakyThrows
    public static Category postCreateCategory(Category category)
    {
        var body = objectMapper.writeValueAsString(category);

        var request = new HttpPost(uri);
        request.setEntity(new StringEntity(body));
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");

        var response = httpClient.execute(request, new BasicHttpClientResponseHandler());
        log.info(response);
        return objectMapper.readValue(response, new TypeReference<Category>(){});
    }


}
