package com.microservices.SpringbootMcs.company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    List<Company> getAllCompanies();
    boolean updateCompany(Long id,Company company);

    boolean deleteCompanyById(Long id);

    void createCompany(Company company);

    Company getCompanyById(Long id);
}
