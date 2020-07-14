package com.example.Conversion.controllers;

import com.example.Conversion.models.Conversion;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversionController {

    @PostMapping("/conversions/ktoc")
    public Conversion conversionKtoc(@RequestBody Conversion inputConversion) {
        return new Conversion((inputConversion.getValue() + 273.15), "Celsius");
    }
    @PostMapping("/conversions/ctok")
    public Conversion conversionCtok(@RequestBody Conversion inputConversion) {
        return new Conversion((inputConversion.getValue() - 273.15), "Kelvin");
    }

    
}