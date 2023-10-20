package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table
public class Company {
    @Id
    private String companyId;
    @Column(name = "company_name")
    private String companyName;
    @Column(name ="company_address")
    private String companyPhysicalAddress;
    @Column(name="company_email_address")
    private String companyEmail;

    public Company(){

    }

    public Company(Builder builder){

        this.companyId = builder.companyId;
        this.companyName = builder.companyName;
        this.companyPhysicalAddress = builder.companyPhysicalAddress;
        this.companyEmail = builder.companyEmail;

    }

    public String getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyPhysicalAddress() {
        return companyPhysicalAddress;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }



    @Override
    public String toString() {
        return "Company{" +
                "companyId='" + companyId + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyPhysicalAddress='" + companyPhysicalAddress + '\'' +
                ", companyEmail='" + companyEmail + '\'' +

                '}';
    }

    public static class Builder{

        private String companyId;
        private String companyName;
        private String companyPhysicalAddress;
        private String companyEmail;

        public Builder setCompanyId(String companyId) {
            this.companyId = companyId;
            return this;
        }

        public Builder setCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder setCompanyPhysicalAddress(String companyPhysicalAddress) {
            this.companyPhysicalAddress = companyPhysicalAddress;
            return this;
        }

        public Builder setCompanyEmail(String companyEmail) {
            this.companyEmail = companyEmail;
            return this;
        }


        //Setters:

        //copy:
        public Builder copy(Company company){
            this.companyId = company.companyId;
            this.companyName = company.companyEmail;
            this.companyPhysicalAddress = company.companyPhysicalAddress;
            this.companyEmail = company.companyEmail;

            return this;
        }

        //build:
        public Company build() {
            return new Company(this);
        }

    }

}
