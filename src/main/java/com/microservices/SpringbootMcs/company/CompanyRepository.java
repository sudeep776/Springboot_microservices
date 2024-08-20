package com.microservices.SpringbootMcs.company;

import com.microservices.SpringbootMcs.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
