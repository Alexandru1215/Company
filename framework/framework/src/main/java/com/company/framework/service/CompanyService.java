package com.company.framework.service;

import com.company.framework.dto.CompanyCreateDto;
import com.company.framework.dto.CompanyInfoDto;

public interface CompanyService {

     CompanyInfoDto createCompany(CompanyCreateDto companyCreateDto);

}
