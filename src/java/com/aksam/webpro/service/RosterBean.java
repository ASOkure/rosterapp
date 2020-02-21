/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aksam.webpro.service;

import com.aksam.webpro.entity.Player;
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
public class RosterBean {
  //CRUD Player

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("rosterappPU");
    EntityManager em = emf.createEntityManager();

    public void createPlayer(String id, String name, String position, double salary) {

        try {

            Player player = new Player(id, name, position, salary);

            em.persist(player);
        } catch (Exception e) {

        }

    }

    public Player findPlayer(String Id) {

        try {

            Player player = em.find(Player.class, Id);

            return player;

        } catch (Exception e) {

        }

   
    }

    public List findPlayerWithName(String name) {

        return em.createQuery("SELECT p From Player p  WHERE p.name LIKE :playerName")
                .setParameter("playerName", name).getResultList();
    }

    public void dropPlayer(String Id) {

        try {

            Player player = em.find(Player.class, Id);
            em.remove(player);
        } catch (Exception e) {

        }
    }
}

         //CRUD League
    //CRUD Team

