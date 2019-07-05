/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;

import static ctrl.daftar_hub_.em;
import dao.JarHub;
import dao.VJarData;
import dao.VJarIp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Window;

/**
 *
 * @author san
 */
public class daftar_perangkat_  extends GenericForwardComposer{
   static EntityManagerFactory emf=Persistence.createEntityManagerFactory("jar_pkuPU");
   static EntityManager em=emf.createEntityManager();  
   
    private Window winPerangkat ;
    private ResultSet     rsTotal;
    private Connection    cn;
    private Statement     st;
   protected List   lstVJarData;
    private VJarData tbVJarData;                              
    
    
    
   public void onCreate$winPerangkat() throws InterruptedException, SQLException{
    koneksi_ k = new koneksi_();
    cn = k.getConnection();
    st = cn.createStatement();
    rsTotal=st.executeQuery("SELECT count(*) as jml FROM jar_device");
    rsTotal.next();
    
   String sql="select * from v_jar_data";
    lstVJarData = em.createNativeQuery(sql, VJarIp.class)
               .setHint("eclipselink.refresh", "true")
               .getResultList();
//        Messagebox.show(lstVJarDevice.size()+"");
    }

    public List getLstVJarData() {
        return lstVJarData;
    }

    public void setLstVJarData(List lstVJarData) {
        this.lstVJarData = lstVJarData;
    }

    public VJarData getTbVJarData() {
        return tbVJarData;
    }

    public void setTbVJarData(VJarData tbVJarData) {
        this.tbVJarData = tbVJarData;
    }

   
   
}
