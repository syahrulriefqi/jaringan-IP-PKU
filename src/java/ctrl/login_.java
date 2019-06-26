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
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Captcha;
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
    private Textbox     txtUser,txtPassword,txtCpa;
    private Window      winUtamaLogin; 
    private Captcha     chpTa;
    
    private void onCreate$winUtamaLogin() throws InterruptedException{
            session.setAttribute("sessMenu", "0");
            Messagebox.show((String) session.getAttribute("sessMenu"));
    }
   

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp); //To change body of generated methods, choose Tools | Templates.
        
            session.setAttribute("sessMenu", "0");
    }
    
    public void onClick$btnLogin() throws InterruptedException{
        if(txtUser.getText()==""){
            Messagebox.show("NMB tidak boleh kosong");
        }else if(txtPassword.getText()==""){
            Messagebox.show("Password masih kosong");
        }else if(txtPassword.getText()==""){
            Messagebox.show("Captcha harus diisi");
        }else if(!chpTa.getValue().equalsIgnoreCase(txtCpa.getValue())){
            Messagebox.show("Captcha tidak sesuai","Informasi",Messagebox.OK,Messagebox.INFORMATION);
        }else{
            
        
            String sql  ="SELECT * FROM v_login WHERE nbm='"+txtUser.getValue()+"' AND password = MD5('"+txtPassword.getValue()+"')";
            lstVLogin=    em.createNativeQuery(sql,VLogin.class)
                        .setHint("eclipselink.refresh", "true")
                        .getResultList();
            if(lstVLogin.isEmpty()){
                Messagebox.show("Login gagal  ");
            }else{
                tbVLogin  = (VLogin) lstVLogin.get(0);
    //           Messagebox.show("Selamat datang "+tbVLogin.getNama());
                session.setAttribute("sessMenu", "1");                
                session.setAttribute("sessNamaUser", tbVLogin.getNama());
                session.setAttribute("sessNoUrut", tbVLogin.getNoUrut());
                session.setAttribute("sessPassword", txtPassword.getValue());
                
//                Messagebox.show(session.getAttribute("sessNamaUser").toString());

                execution.createComponents("/zul/index.zul", null, null);
                winUtamaLogin.detach();
            }
        }
        
    }
    
     public void onClick$btnMasok() throws InterruptedException{
         
    //           Messagebox.show("Selamat datang "+tbVLogin.getNama());
                session.setAttribute("sessMenu", "1");                
                
//                Messagebox.show(session.getAttribute("sessNamaUser").toString());

                execution.createComponents("/zul/index.zul", null, null);
                winUtamaLogin.detach();
    }
}