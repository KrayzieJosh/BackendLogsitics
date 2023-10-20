package za.ac.cput.service;

import za.ac.cput.domain.Company;
import za.ac.cput.domain.DeliveryEvents;

import java.util.List;

public interface CompanyService extends IService<Company, String> {
Company create(Company company);
    Company read(String companyId);

    Company update (Company company);

    boolean delete(String companyId);
    List<Company> getAll();
}
