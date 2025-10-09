package com.vovo.croche.service;

import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.vovo.croche.mappers.AddressMapper;
import com.vovo.croche.model.Address;
import com.vovo.croche.model.dto.address.AddressRequestDTO;
import com.vovo.croche.model.dto.address.AddressResponseDTO;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

@Service
public class AddressService {

    private final AddressMapper mapper;

    public AddressService(AddressMapper mapper) {
        this.mapper = mapper;
    }

    public List<AddressResponseDTO> searchForCepsThroughTheStreets(AddressRequestDTO dto) throws IOException,
            InterruptedException {

        String sensitiveLogradouro = dto.getLogradouro().toLowerCase(Locale.ROOT);
        String sensitiveLocalidade = dto.getLocalidade().toLowerCase(Locale.ROOT);
        try {
            Gson gson = new Gson();

            if (dto.getLogradouro().length() < 3 || dto.getLocalidade().length() < 3) {
                throw new IllegalArgumentException("Os campos cidade e logradouro devem ter no mínimo 3 caractéres.");
            }

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://viacep.com.br/ws/" + dto.getUf() + "/"
                            + URLEncoder.encode(sensitiveLocalidade, StandardCharsets.UTF_8).replace("+",
                            "%20")
                            + "/" + URLEncoder.encode(sensitiveLogradouro, StandardCharsets.UTF_8).replace("+",
                            "%20") + "/json/"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String responseBody = response.body();

            if (responseBody.startsWith("[")) {
                Type typeObjList = new TypeToken<List<Address>>() {
                }.getType();
                List<Address> objectsList = gson.fromJson(responseBody, typeObjList);

                return objectsList.stream().map(mapper::addressToAddressResponseDTO).toList();
            }

            return Collections.emptyList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
