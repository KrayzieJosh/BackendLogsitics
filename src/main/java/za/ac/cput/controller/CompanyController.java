package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Company;
import za.ac.cput.domain.ProjectManager;
import za.ac.cput.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
@Autowired
    private CompanyService companyService;
@PostMapping("/create")
public Company create(@RequestBody Company company){
    return companyService.create(company);

}
    @GetMapping("/read/{companyID}")
    public Company read(@PathVariable String companyID)
    {

        return companyService.read(companyID);
    }
    @PostMapping("/update")
    public Company update(@RequestBody Company company){
        return companyService.update(company);

    }
    @DeleteMapping("/delete/{companyID}")
    public boolean delete(@PathVariable String companyID){
        return companyService.delete(companyID);

    }
    @GetMapping("/getall")
    public List<Company> getAll(){
        return companyService.getAll();
    }

}
