package com.exam.basicwebapi.controller;

import com.exam.basicwebapi.domain.Contract;
import com.exam.basicwebapi.repository.ContractRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contract")
public class ContractController {

    private final ContractRepository contractRepository;

    public ContractController(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @GetMapping("/all")
    public List<Contract> getAllCompanies() {
        return contractRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contract> getContract(@PathVariable("id") int id) {
        final var contractOptional = contractRepository.findById(id);
        return contractOptional
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Contract postContract(@RequestBody Contract contract) {
        return contractRepository.save(contract);
    }

    @DeleteMapping("/{id}")
    public void deleteContract(@PathVariable("id") int id) {
        contractRepository.deleteById(id);
    }

    @GetMapping
    public List<Contract> getContractWithCompanyAndCountry(
            @RequestParam("companyId") Integer companyId,
            @RequestParam("countryId") Integer countryId
    ) {
        return contractRepository.findByCountryIdAndCompanyId(countryId, companyId);
    }

    @GetMapping("/filter")
    public List<Contract> filterContractWithCompanyOrCountry(
            @RequestParam(value = "companyId", required = false) Integer companyId,
            @RequestParam(value = "countryId", required = false) Integer countryId
    ) {
        return contractRepository.findByCountryIdOrCompanyId(countryId, companyId);
    }
}
