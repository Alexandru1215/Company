package com.company.framework.service;

import com.company.framework.dto.CompanyCreateDto;
import com.company.framework.dto.CompanyInfoDto;
import com.company.framework.dto.CompanyShortInfoDto;
import com.company.framework.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {

    CompanyInfoDto createCompany(CompanyCreateDto companyCreateDto);


    List<CompanyShortInfoDto> getAllCompanies();

    Optional<CompanyInfoDto> findCompanyByName(String name);

  //  void generateCompanies(List<Company> companies);

    void generateCompaines(List<Company> generateDummyCompanies);


}
