package org.maravilla.pruebatecnicasb.services;

import org.maravilla.pruebatecnicasb.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Value("${external.api.url}")
    private String externalApiUrl;

    private final RestTemplate restTemplate;

    public ProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public ProductDTO getProductById(Long id){
        String url = externalApiUrl + "/products/" + id;
        return restTemplate.getForObject(url, ProductDTO.class);
    }

    public List<ProductDTO> getAllProducts() {
        String url = externalApiUrl + "/products";
        ProductDTO[] products = restTemplate.getForObject(url, ProductDTO[].class);
        return Arrays.asList(products);
    }

    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        String url = externalApiUrl + "/products/" + id;
        HttpEntity<ProductDTO> request = new HttpEntity<>(productDTO);
        ResponseEntity<ProductDTO> response = restTemplate.exchange(url, HttpMethod.PUT, request, ProductDTO.class);
        return response.getBody();
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        String url = externalApiUrl + "/products";
        HttpEntity<ProductDTO> request = new HttpEntity<>(productDTO);
        return restTemplate.postForObject(url, request, ProductDTO.class);
    }

    public boolean deleteProduct(Long id) {
        String url = externalApiUrl + "/products/" + id;
        restTemplate.delete(url);
        return true;
    }
}

