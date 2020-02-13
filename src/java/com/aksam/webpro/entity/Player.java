/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aksam.webpro.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author ao475
 */
@Entity
@Table(name="player")
public class Player implements Serializable{
    
   @Id
   private String Id;
   
   @Column(name="name")
   private String Name;
   
   @Column(name="position")
   private String Position;
   
   @Column(name="salary")
   private Double Salary;
   
   
   
    


     private Set<Team> team = new HashSet<>();
   
  
    public Player() {
        
    }

    public Player(String Id, String Name, String Position, Double Salary) {
       
        this.Id = Id;
        this.Name = Name;
        this.Position = Position;
        this.Salary = Salary;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String Position) {
        this.Position = Position;
    }

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double Salary) {
        this.Salary = Salary;
    }
    
    
    @ManyToMany
   @JoinTable(name="teamPlayer",
           joinColumns= @JoinColumn(name="playerId", referencedColumnName="ID"),
           inverseJoinColumns= @JoinColumn(name="teamId", referencedColumnName="ID"))
    public Set<Team> getTeam() {
        return team;
    }

    public void setTeam(Set<Team> team) {
        this.team = team;
    }
    
    
    @Override
    public String toString() {
        return "Player{" + "Id=" + Id + ", Name=" + Name + ", Position=" + Position + ", Salary=" + Salary + '}';
    }
   
    
}
