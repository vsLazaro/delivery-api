package com.trabalho.um.Repository;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class RepositoryCEP implements ICepRepository {

    @Override
    public String getCityNameByCep(String cep) {
        try {
            URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream is = connection.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

                StringBuilder jsonContent = new StringBuilder();
                String inputLine;
                while ((inputLine = br.readLine()) != null) {
                    jsonContent.append(inputLine);
                }

                Gson gson = new Gson();
                ViaCEPResponse cepObj = gson.fromJson(jsonContent.toString(), ViaCEPResponse.class);

                return cepObj.getLocalidade();
            }
            return "Cidade não encontrada";
        } catch (Exception e) {
                return "Erro ao buscar CEP";
        }
    }
}