package com.project.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.assessment.service.JsonModelService;

@RestController
@RequestMapping("/api")
public class JsonModelController {

    @Autowired
    private JsonModelService jsonModelService;

    @PostMapping("/manipulate")
    public ResponseEntity<String> manipulateJson(@RequestParam String inputs) {
        try {
            String modifiedJson = jsonModelService.manipulateJson(inputs);
            return ResponseEntity.ok(modifiedJson);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
