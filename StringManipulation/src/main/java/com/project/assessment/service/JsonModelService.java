package com.project.assessment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.assessment.entity.JsonModel;
import com.project.assessment.repository.JsonModelRepository;

@Service
public class JsonModelService {

    private static final String ORIGINAL_JSON = "{ \"menu\": { \"id\": \"file\", \"value\": \"File\", \"popup\": { \"menuitem\": [ { \"value\": \"New\", \"onclick\": \"CreateDoc()\" }, { \"value\": \"Open\", \"onclick\": \"OpenDoc()\" }, { \"value\": \"Save\", \"onclick\": \"SaveDoc()\" } ] } } } }";

    @Autowired
    private JsonModelRepository jsonModelRepository;

    public String manipulateJson(String inputs) {
        
        String[] pairs = inputs.split(",");
        String modifiedJson = ORIGINAL_JSON;

        for (String pair : pairs) {
            String[] keyValue = pair.split(":::");
            String key = keyValue[0].trim();
            String value = keyValue[1].trim();
            modifiedJson = modifiedJson.replace(key, value);
        }

        
        JsonModel jsonModel = new JsonModel();
        jsonModel.setJsonModel(modifiedJson);
        jsonModelRepository.save(jsonModel);

        return modifiedJson;
    }
}
