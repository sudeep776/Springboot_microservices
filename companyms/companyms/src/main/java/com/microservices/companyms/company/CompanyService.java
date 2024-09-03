package com.microservices.companyms.company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    boolean updateCompany(Long id,Company company);

    boolean deleteCompanyById(Long id);

    void createCompany(Company company);

    Company getCompanyById(Long id);
}
