package com.example.Conversion.controllers;

import com.example.Conversion.models.Conversion;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversionController {

    @PostMapping("/conversions/ktoc")
    public Conversion conversionKtoc(@RequestBody Conversion inputConversion) {
        return new Conversion((inputConversion.getValue() - 273.15), "Celsius");
    }
    @PostMapping("/conversions/ctok")
    public Conversion conversionCtok(@RequestBody Conversion inputConversion) {
        return new Conversion((inputConversion.getValue() + 273.15), "Kelvin");
    }

    @PostMapping("/conversions/mtok/")
    public Conversion conversionMtok(@RequestBody Conversion newConversion) {
        return new Conversion((newConversion.getValue() / 0.6213711922), "Kilometres");
    }

    @PostMapping("/conversions/ktom/")
    public Conversion conversionKtom(@RequestBody Conversion newConversion) {
        return new Conversion((newConversion.getValue() * 0.6213711922), "Miles");
    }

}