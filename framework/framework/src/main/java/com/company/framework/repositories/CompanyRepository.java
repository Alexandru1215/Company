package com.company.framework.repositories;

import org.springframework.stereotype.Repository;


import com.company.framework.entity.Company;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Integer> {
    Optional<Company> findByName (String name);
}
