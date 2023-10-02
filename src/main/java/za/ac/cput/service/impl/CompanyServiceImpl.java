package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Company;
import za.ac.cput.domain.ProjectManager;
import za.ac.cput.repository.CompanyRepository;
import za.ac.cput.service.CompanyService;

import java.io.Serializable;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService, Serializable {

    private CompanyRepository repository;

    @Autowired
    private CompanyServiceImpl(CompanyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Company create(Company company) { return this.repository.save(company); }

    @Override
    public Company read(String companyID){
        return this.repository.findById(companyID).orElse(null);

    }

    @Override
    public Company update(Company company) {
        if(this.repository.existsById(company.getCompanyId())){
            return this.repository.save(company);
        }
        return null;
    }
    @Override
    public boolean delete(String companyID){
        if (this.repository.existsById(companyID)){
            this.repository.deleteById(companyID);
            return true;
        }
        return false;
    }
    @Override
    public List<Company> getAll(){
        return this.repository.findAll();
    }


}
