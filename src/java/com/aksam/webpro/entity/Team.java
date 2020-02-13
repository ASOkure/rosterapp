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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ao475
 */
@Entity
@Table(name="team")
public class Team implements Serializable{
   
    @Id
    private  String Id;
    
    @Column(name="city")
    private String City;
    
    @Column(name="name")
    private String Name;
    
   
    private League league;
    
    private Set<Player> players = new HashSet<>();
    
    
    
    @ManyToMany 
    @JoinTable(name="teamPlayer",
    joinColumns= @JoinColumn(name="teamId", referencedColumnName="ID"),
    inverseJoinColumns= @JoinColumn(name="PLAYER_ID", referencedColumnName="ID"))
    public Set<Player> getPlayer() {
        return players;
    }

    public void setPlayer(Set<Player> player) {
        this.players = player;
    }

    public Team() {
    }

    public Team(String Id, String City, String Name) {
        this.Id = Id;
        this.City = City;
        this.Name = Name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    @ManyToOne
    @JoinColumn( name=" leagueId")
    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }
    
    
    
    
    @Override
    public String toString() {
        return "Team{" + "Id=" + Id + ", City=" + City + ", Name=" + Name + '}';
    }
    
    
}
