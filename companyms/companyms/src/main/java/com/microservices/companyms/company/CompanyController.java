package com.microservices.companyms.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    private CompanyService companyService;


    @GetMapping
    public List<Company> getAllCompanies(){
        return companyService.getAllCompanies();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id,@RequestBody Company company){
        boolean flag = companyService.updateCompany(id,company);
        if(flag){
            return new ResponseEntity<String>("Updated successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<String>("Update unsuccessfull",HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("company added successfully",HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long id){
        boolean flag = companyService.deleteCompanyById(id);
        if(flag){
            return new ResponseEntity<String>("Deleted",HttpStatus.OK);
        }
        return new ResponseEntity<String>("Company not found",HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable Long id){
        return companyService.getCompanyById(id);
    }
}
