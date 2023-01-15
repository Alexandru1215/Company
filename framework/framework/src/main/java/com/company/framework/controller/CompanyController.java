package com.company.framework.controller;

import com.company.framework.dto.CompanyCreateDto;
import com.company.framework.dto.CompanyInfoDto;
import com.company.framework.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {
    private final CompanyService companyService;


    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/create")
    public ResponseEntity<CompanyInfoDto> createCompany(@RequestBody CompanyCreateDto companyCreateDto) {
        CompanyInfoDto companyInfoDto = companyService.createCompany(companyCreateDto);
        return ResponseEntity.ok(companyInfoDto);
    }

}
