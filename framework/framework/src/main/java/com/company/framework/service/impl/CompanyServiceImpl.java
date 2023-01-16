package com.company.framework.service.impl;


import com.company.framework.convertor.CompanyConvertor;
import com.company.framework.dto.CompanyCreateDto;
import com.company.framework.dto.CompanyInfoDto;
import com.company.framework.dto.CompanyShortInfoDto;
import com.company.framework.entity.Company;
import com.company.framework.repositories.CompanyRepository;
import com.company.framework.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    // @AutoWired field injection, not recomanded
    // encapsulate*

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    public CompanyInfoDto createCompany(CompanyCreateDto companyCreateDto) {
        Company company = companyRepository.save(CompanyConvertor.convertDtoEntity(companyCreateDto));
        CompanyInfoDto companyInfoDto = CompanyConvertor.convertEntityToInfoDto(company);
        CompanyConvertor.convertEntityToInfoDto(company);
        return companyInfoDto;
        //return CompanyConvertor.convertEntityToInfoDto(companyRepository.save(CompanyConvertor.convertDtoEntity(companyCreateDto)));
    }


    @Override// metoda convert CompanyShortInfo - getAll
    public List<CompanyShortInfoDto> getAllCompanies() {
        List<CompanyShortInfoDto> companyShortInfoDtos = new ArrayList<>();
        companyRepository.findAll().forEach(company -> companyShortInfoDtos.add(CompanyConvertor.enityToShortInfoDto(company)));
        return companyShortInfoDtos;
    }


    @Override
    public Optional<CompanyInfoDto> findCompanyByName(String name) {
        Optional<Company> company = companyRepository.findByName(name);
        CompanyInfoDto companyInfoDto = null;
        if (company.isPresent()) {
            companyInfoDto = CompanyConvertor.convertEntityToInfoDto(company.get());
        }
        return Optional.ofNullable(companyInfoDto);
    }

    @Override
    public void generateCompaines(List<Company> generateDummyCompanies) {
        companyRepository.saveAll(generateDummyCompanies);
        System.out.println(generateDummyCompanies.size() + "companies were generate");
    }
}

//    @Override
//    public void generateCompaines(List<Company> generateDummyCompanies) {
//
//    }
//}


//    @Override
//    public void generateCompanies(List<Company> companies) {
//        companyRepository.saveAll(companies);
//        System.out.println(companies.size() + "companies were generate");
//    }

