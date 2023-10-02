package za.ac.cput.service;

import za.ac.cput.domain.Company;
import java.util.List;

public interface CompanyService extends IService<Company, String> {

    List<Company> getAll();
}
