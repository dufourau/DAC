/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caco.Entity.stateless;

import com.caco.Entity.Reservation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author pouzaudr
 */
@Local
public interface ReservationFacadeLocal {

    void create(Reservation reservation);

    void edit(Reservation reservation);

    void remove(Reservation reservation);

    Reservation find(Object id);

    List<Reservation> findAll();

    List<Reservation> findRange(int[] range);
    
    int count();
}