/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aksam.webpro.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author ao475
 */
@Entity
@Table(name="summerLeague")
public class SummerLeague extends League implements Serializable {
    private String sport;
    private String name;
    private String id;

    public SummerLeague() {
    }

public SummerLeague(String id, String name, String sport)
throws IncorrectSportException {
this.id = id;
this.name = name;
if (sport.equalsIgnoreCase("swimming") ||
sport.equalsIgnoreCase("soccer") ||
sport.equalsIgnoreCase("basketball") ||
sport.equalsIgnoreCase("baseball")) {
this.sport = sport;
} else {
throw new IncorrectSportException("Sport is not a summer sport.");
}
}
   
    
    
    
}
