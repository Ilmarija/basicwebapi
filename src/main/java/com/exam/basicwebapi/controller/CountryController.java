package com.exam.basicwebapi.controller;

import com.exam.basicwebapi.domain.Country;
import com.exam.basicwebapi.repository.CountryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("country")
public class CountryController {

    private final CountryRepository countryRepository;

    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping("/all")
    public List<Country> getAllCompanies() {
        return countryRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountry(@PathVariable("id") int id) {
        final var countryOptional = countryRepository.findById(id);
        return countryOptional
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Country postCountry(@RequestBody Country country) {
        return countryRepository.save(country);
    }

    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable("id") int id) {
        countryRepository.deleteById(id);
    }
}
