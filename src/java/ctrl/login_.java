
package ctrl;

import converter_.string;
import dao.User;
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
 * @author esyeha
 */
public class login_ extends GenericForwardComposer{
    static EntityManagerFactory emf=Persistence.createEntityManagerFactory("Latihan1PU");
    static EntityManager em=emf.createEntityManager();
    
    protected List   lstUser;
    private User     tbUser;
    private Textbox  txtUser, txtPassword;
    private Window   winUtama;
    
           
    public void onClick$btnSubmit() throws InterruptedException {
        String sql="select id_user,user,password from user where user='"+txtUser.getValue()+"' "
                + "and password =md5('"+txtPassword.getValue()+"')";
        lstUser=em.createNativeQuery(sql, User.class)
                .setHint("eclipselink.refresh","true")
                .getResultList();
        if (lstUser.isEmpty()){
            Messagebox.show("Login Anda Salah");
        }else {
            tbUser=(User)lstUser.get(0);
            execution.createComponents("/zul/menu.zul",null,null);
            winUtama.detach();
          //  Messagebox.show("Selamat Datang"+tbUser.getUser());
        }
    
        }

    public List getLstUser() {
        return lstUser;
    }

    public void setLstUser(List lstUser) {
        this.lstUser = lstUser;
    }

    public User getTbUser() {
        return tbUser;
    }

    public void setTbUser(User tbUser) {
        this.tbUser = tbUser;
    }

    public Textbox getTxtUser() {
        return txtUser;
    }

    public void setTxtUser(Textbox txtUser) {
        this.txtUser = txtUser;
    }
   
    
            
}
