package com.company.framework.controller;

import com.company.framework.components.CustomFakerCompanyComponents;
import com.company.framework.dto.CompanyCreateDto;
import com.company.framework.dto.CompanyInfoDto;
import com.company.framework.dto.CompanyShortInfoDto;

import com.company.framework.service.CompanyService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/company")

public class CompanyController {
    private final CompanyService companyService;

    private final CustomFakerCompanyComponents fakerCompanyComponents;

    @Autowired
    public CompanyController(CompanyService companyService, CustomFakerCompanyComponents fakerCompanyComponents) {
        this.companyService = companyService;
        this.fakerCompanyComponents = fakerCompanyComponents;
    }




    @PostMapping("/create")
    public ResponseEntity<CompanyInfoDto> createCompany(@RequestBody @Valid CompanyCreateDto companyCreateDto) {
        CompanyInfoDto companyInfoDto = companyService.createCompany(companyCreateDto);
        return ResponseEntity.ok(companyInfoDto);
    }
    @GetMapping(path = "/getAllCompanies")
    public ResponseEntity<List<CompanyShortInfoDto>> getAllCompanies(){
        List<CompanyShortInfoDto> allCompanies = companyService.getAllCompanies();
        return ResponseEntity.ok(allCompanies);
    }

    @GetMapping("/findCompanyName")
    public ResponseEntity<CompanyInfoDto> getCompanyByName(@RequestParam String name) {
        Optional<CompanyInfoDto> companyInfoDto = companyService.findCompanyByName(name);

        return ResponseEntity.of(companyInfoDto);
    }
    @GetMapping(path = "/generateCompanies")
    public ResponseEntity<String> generateCompaines(){
        companyService.generateCompaines(fakerCompanyComponents.generateDummyCompanies());
        return ResponseEntity.ok("Companies  were generated!");
    }
}
