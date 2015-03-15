/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caco.servlet;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import com.caco.Entity.stateless.PersonneFacadeLocal;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import org.yaml.snakeyaml.Yaml;


public class Init implements ServletContextListener{

    private static final Logger LOGGER = Logger.getLogger(Init.class.getName());
    
    @EJB
    private PersonneFacadeLocal personneFacade;
    
    @Override
    public void contextInitialized(ServletContextEvent contextEvent) {
        InputStream input;
        try {
            input = new FileInputStream(new File("/home/dufourau/NetBeansProjects/DAC/DAC-web/src/init-data.yml"));
            Yaml yaml = new Yaml();
            Iterable<Object> personnes = (Iterable<Object>) yaml.loadAll(input);
            
            for(Object p : personnes){
                
                personneFacade.createFromObject(p);
                
            }
        } catch (FileNotFoundException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent contextEvent) {
         /* Do Shutdown stuff. */
    }

}