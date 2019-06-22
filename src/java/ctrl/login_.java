/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;

import dao.VLogin;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;


/**
 *
 * @author san
 */
public class login_ extends GenericForwardComposer{
    
    static EntityManagerFactory emf= Persistence.createEntityManagerFactory("jar_pkuPU");
    static EntityManager em= emf.createEntityManager();

    
    protected List      lstVLogin;
    private VLogin        tbVLogin;
    private Textbox     txtUser,txtPassword;
    private Window      winUtamaLogin;
      
    
    
    public void onClick$btnLogin() throws InterruptedException{
        String sql  ="SELECT * FROM v_login WHERE nbm='"+txtUser.getValue()+"' AND password = MD5('"+txtPassword.getValue()+"')";
        lstVLogin=    em.createNativeQuery(sql,VLogin.class)
                    .setHint("eclipselink.refresh", "true")
                    .getResultList();
        if(lstVLogin.isEmpty()){
            Messagebox.show("Login gagal  "+ sql);
        }else{
            tbVLogin  = (VLogin) lstVLogin.get(0);
           Messagebox.show("Selamat datang "+tbVLogin.getNama());
            session.setAttribute("sessMenu", "1");
            execution.createComponents("/zul/menu.zul", null, null);
            winUtamaLogin.detach();
        }
    }
}