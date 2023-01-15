package com.company.framework.service.impl;


import com.company.framework.convertor.CompanyConvertor;
import com.company.framework.dto.CompanyCreateDto;
import com.company.framework.dto.CompanyInfoDto;
import com.company.framework.entity.Company;
import com.company.framework.repositories.CompanyRepository;
import com.company.framework.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    // @AutoWired field injection, not recomanded

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

}
