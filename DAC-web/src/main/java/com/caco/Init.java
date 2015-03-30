/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caco;

import com.caco.Entity.Personne;
import com.caco.Entity.stateless.EvenementFacadeLocal;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import com.caco.Entity.stateless.PersonneFacadeLocal;
import java.io.InputStream;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import org.yaml.snakeyaml.Yaml;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@WebListener
public class Init implements ServletContextListener{

    private static final Logger LOGGER = LogManager.getLogger(Init.class);
    
    @EJB
    private PersonneFacadeLocal personneFacade;
    @EJB
    private EvenementFacadeLocal evenementFacade;
    
    @Override
    public void contextInitialized(ServletContextEvent contextEvent) {
        // LOGGER.warn("Clearing database");
        // personneFacade.removeAll();
        // evenementFacade.removeAll();
        
        LOGGER.warn("Loading initial data into database");
        ServletContext context = contextEvent.getServletContext();
        Yaml yaml = new Yaml();
        InputStream input;
        
        LOGGER.debug("Loading personnes");
        input = context.getResourceAsStream("/WEB-INF/classes/init-personne.yml");
        Iterable<Object> personnes = yaml.loadAll(input);
        for (Object personne : personnes){
            personneFacade.createFromMap((Map<String, Object>) personne);
        }
        
        LOGGER.debug("Loading evenements");
        input = context.getResourceAsStream("/WEB-INF/classes/init-evenement.yml");
        Iterable<Object> evenements = yaml.loadAll(input);
        for (Object evenement : evenements){
            evenementFacade.createFromMap((Map<String, Object>) evenement);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent contextEvent) {
    }

}