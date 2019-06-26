/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.zkoss.zk.ui.util.GenericForwardComposer;

/**
 *
 * @author esyeha
 */
public class daftarIP_ extends GenericForwardComposer{
   static EntityManagerFactory emf=Persistence.createEntityManagerFactory("jar_pkuPU");
    static EntityManager em=emf.createEntityManager();
    
}
