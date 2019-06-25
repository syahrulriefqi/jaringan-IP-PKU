/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;

import static ctrl.login_.em;
import dao.JarDevice;
import dao.MstPetugas;
import dao.VLogin;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

/**
 *
 * @author san
 */
public class crud_ganti_password_ extends GenericForwardComposer{
   static EntityManagerFactory emf=Persistence.createEntityManagerFactory("jar_pkuPU");
    static EntityManager em=emf.createEntityManager();  

    protected List      lstVLogin;
   
    private MstPetugas tbMstPetugas;
    private Textbox     txtPasswordLama,txtPasswordBaru,txtRePassword;
    
    public void onCreate$winGantiPassword() throws InterruptedException, SQLException{
//        txtPasswordLama.setValue(session.getAttribute("sessPassword").toString());
        
    } 
    
    
    public void onClick$btnSimpan() throws InterruptedException{
        if(!txtPasswordLama.getValue().equalsIgnoreCase(session.getAttribute("sessPassword").toString())){
            Messagebox.show("Password lama tidak sesuai");
            txtPasswordLama.setFocus(true);
        }else if(!txtPasswordBaru.getValue().equalsIgnoreCase(txtRePassword.getValue())){
            Messagebox.show("Password baru tidak sama"); 
            txtPasswordBaru.setFocus(true);
        }else if(txtPasswordBaru.getValue().equalsIgnoreCase("")||txtRePassword.getValue().equalsIgnoreCase("")){
            Messagebox.show("Password baru masih kosong"); 
            txtPasswordBaru.setFocus(true);
        }else{
            try {
                if (!em.getTransaction().isActive()) {
                    em.getTransaction().begin();
                }
                String sql  ="UPDATE MST_PETUGAS SET password = MD5('"+txtPasswordBaru.getValue()+"') WHERE `no_urut` = '"+session.getAttribute("sessNoUrut")+"'";

                em.createNativeQuery(sql).executeUpdate();
                em.flush();
                em.getTransaction().commit();
                Messagebox.show("Password berhasil di ubah","Informasi", Messagebox.OK,Messagebox.INFORMATION);
            } catch (Throwable e) {
                Messagebox.show(e.getMessage());
                em.getTransaction().rollback();
            }
        }
       
        
    }

    public List getLstVLogin() {
        return lstVLogin;
    }

    public void setLstVLogin(List lstVLogin) {
        this.lstVLogin = lstVLogin;
    }

    public MstPetugas getTbMstPetugas() {
        return tbMstPetugas;
    }

    public void setTbMstPetugas(MstPetugas tbMstPetugas) {
        this.tbMstPetugas = tbMstPetugas;
    }
    
}
