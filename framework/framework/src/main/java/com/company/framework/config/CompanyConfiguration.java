package com.company.framework.config;


import com.company.framework.components.CustomFakerCompanyComponents;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CompanyConfiguration {


public CustomFakerCompanyComponents fakerCompanyComponents(){
    return new CustomFakerCompanyComponents();
}

}
