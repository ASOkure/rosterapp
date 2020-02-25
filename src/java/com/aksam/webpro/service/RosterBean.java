/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aksam.webpro.service;

import com.aksam.webpro.entity.Player;
import com.aksam.webpro.entity.Team;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Query;


/**
 *
 * @author ao475
 */
public class RosterBean implements Roster, Serializable {
  //CRUD Player

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("rosterappPU");
    EntityManager em = emf.createEntityManager();

    //create Player
    public void createPlayer(String id, String name, String position, double salary) {

        try {

            Player player = new Player(id, name, position, salary);

            em.persist(player);
        } catch (Exception e) {

        }

    }

    // find player
    public Player findPlayer(String Id) {

        try {

            Player player = em.find(Player.class, Id);

           

        return player;
        
        
        } catch (Exception e) {

        }
        return null;
    }
   
    
// find Player
    public List findPlayerWithName(String name) {

        return em.createQuery("SELECT p From Player p  WHERE p.name LIKE :playerName")
                .setParameter("playerName", name).getResultList();
    }
    
    // delete player

    public void dropPlayer(String Id) {

        try {

            Player player = em.find(Player.class, Id);
            em.remove(player);
        } catch (Exception e) {

        }
    }
    
    public List<Player> getPlayerTeam(String Id) {

        List<Player> playerList = null;

        try {

            Team team = em.find(Team.class, Id);

            playerList = this.copyPlayerDetails((List<Player>) team.getPlayer());

        }
        catch( Exception e){
            
            
        }
        return null;

    }

    private List<Player> copyPlayerDetails(List<Player> players) {

        List<Player> playerdetails = new ArrayList<Player>();

        Iterator<Player> iterator = players.iterator();

        while (iterator.hasNext()) {
            Player player = (Player) iterator.next();

            Player details = new Player(player.getId(), player.getName(), player.getPosition(), player.getSalary());

            playerdetails.add(details);

        }

        return playerdetails;
    }

}
         //CRUD League
//CRUD Team

