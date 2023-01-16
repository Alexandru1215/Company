package com.company.framework.convertor;

import com.company.framework.dto.CompanyCreateDto;
import com.company.framework.dto.CompanyInfoDto;
import com.company.framework.dto.CompanyShortInfoDto;
import com.company.framework.entity.Company;

public class CompanyConvertor {

    public static Company convertDtoEntity(CompanyCreateDto companyCreateDto) {
        Company company = new Company();
        company.setName(companyCreateDto.getName());
        company.setAddress(companyCreateDto.getAddress());
        company.setEmail(companyCreateDto.getEmail());
        company.setPhoneNumber(companyCreateDto.getPhoneNumber());
        company.setRegisterNumber(companyCreateDto.getRegisterNumber());
        return company;
    }

    public static CompanyInfoDto convertEntityToInfoDto(Company company) {
        CompanyInfoDto companyInfoDto = new CompanyInfoDto();
        companyInfoDto.setId(company.getId());
        companyInfoDto.setName(company.getName());
        companyInfoDto.setAddress(company.getAddress());
        companyInfoDto.setEmail(company.getEmail());
        companyInfoDto.setPhoneNumber(company.getPhoneNumber());
        companyInfoDto.setRegisterNumber(company.getRegisterNumber());
        return companyInfoDto;
    }

    //metoda de convert
    public static CompanyShortInfoDto enityToShortInfoDto(Company company) {
        CompanyShortInfoDto infoDto = new CompanyShortInfoDto();
        infoDto.setName(company.getName());
        infoDto.setRegisterNumber(company.getRegisterNumber());
        return infoDto;
    }

}
