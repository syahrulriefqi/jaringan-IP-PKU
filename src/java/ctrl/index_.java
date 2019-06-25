/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;

import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;


/**
 *
 * @author esyeha
 */
public class index_  extends GenericForwardComposer{
   static EntityManagerFactory emf=Persistence.createEntityManagerFactory("jar_pkuPU");
    static EntityManager em=emf.createEntityManager();  
 
    private Window      winUtama;
    private Iframe      ifrMenu;
     

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp); //To change body of generated methods, choose Tools | Templates.
        if(session.getAttribute("sessMenu")=="0"){
            
            session.invalidate();
            execution.sendRedirect("/");
        } 
    } 
    
    
    public void onClick$btnLogout() throws InterruptedException{
        session.invalidate();
        winUtama.detach();
        execution.sendRedirect("/");
        
    }
}
