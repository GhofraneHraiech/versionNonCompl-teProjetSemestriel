/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.sousse.eniso.otce.projet1.main.model;

import java.util.Date;
import net.vpc.upa.config.Entity;
import net.vpc.upa.config.Field;
import net.vpc.upa.config.Id;
import net.vpc.upa.config.Sequence;
import net.vpc.upa.config.Table;
import net.vpc.upa.config.Unique;

/**
 *
 * @author ghofrane
 */
@Entity @Table("TBL_Name")
public class Personne {
    @Id @Sequence
    private int identifiant;
    @Field(min="2",max="10")
     private String firstName;
    @Field(precision=5,scale=2)
    private Double Salary;

    
    private String lastName;
    @Unique
    private String email;
   
    private Date birthDate;
    
   public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double Salary) {
        this.Salary = Salary;
    }
    
    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    
    
}
