/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.sousse.eniso.otce.projet1.main.model;

import net.vpc.upa.config.Entity;

/**
 *
 * @author ghofrane
 */
@Entity
public class User extends Personne{
    private String Login;
         private String Passeword;


    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getPasseword() {
        return Passeword;
    }

    public void setPasseword(String Passeword) {
        this.Passeword = Passeword;
    }
}
