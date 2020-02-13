/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aksam.webpro.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import static javax.persistence.InheritanceType.JOINED;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ao475
 */
@Entity
@Inheritance(strategy=JOINED)
@Table(name="league")
public abstract class League implements Serializable{
    
    @Id
    private String Id;
    
    @Column
    private String Dtype;
   
    @Column
    private String Name;
    
    @Column
    private String Sport;
    
    private Collection<Team> team;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getDtype() {
        return Dtype;
    }

    public void setDtype(String Dtype) {
        this.Dtype = Dtype;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSport() {
        return Sport;
    }

    public void setSport(String Sport) {
        this.Sport = Sport;
    }
    
    @OneToMany(mappedBy="league")    
    public Collection<Team> getTeam() {
        return team;
    }

    public void setTeam(Collection<Team> team) {
        this.team = team;
    }
    
    public void addTeam( Team team){
        
        this.getTeam().add(team);
        
    }
    
    
    public void removeTeam( Team team){
        
        this.getTeam().remove(team);
    }
}
