/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;

import static ctrl.daftardevice_.em;
import static ctrl.index_.em;
import dao.JarDevice;
import dao.JarHub;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Window;

/**
 *
 * @author san
 */
public class daftar_hub_ extends GenericForwardComposer{
   static EntityManagerFactory emf=Persistence.createEntityManagerFactory("jar_pkuPU");
   static EntityManager em=emf.createEntityManager();  
   
    private Window winHub ;
    private ResultSet     rsTotal;
    private Connection    cn;
    private Statement     st;
   protected List   lstJarHub;
    private JarHub tbJarHub;                                  
   
   public void onCreate$winHub() throws InterruptedException, SQLException{
    koneksi_ k = new koneksi_();
    cn = k.getConnection();
    st = cn.createStatement();
    rsTotal=st.executeQuery("SELECT count(*) as jml FROM jar_device");
    rsTotal.next();
    //Messagebox.show(rsTotal.getString("jml"));
    //jumlah();
//   
//    lstJarDevice = em.createNamedQuery("JarDevice.findAll")
//               .setHint("eclipselink.refresh", "true")
//               .getResultList();
//  // lstVJarDevice=em.createNamedQuery("VJarDevice.findAll")
//   // .setHint("eclipselink.refresh", "true")
//   // .getResultList();
   String sql="select * from jar_hub limit 10";
    lstJarHub = em.createNativeQuery(sql, JarHub.class)
               .setHint("eclipselink.refresh", "true")
               .getResultList();
//        Messagebox.show(lstVJarDevice.size()+"");
}
    public void onSelect$lsbDaftar() throws InterruptedException{
        lstJarHub=em.createNamedQuery("JarHub.findByIdHub")
                .setHint("eclipselink.refresh", "true")
                .setParameter("idHub", tbJarHub.getIdHub())
                .getResultList();
        tbJarHub=(JarHub) lstJarHub.get(0);
    }      
    public void onClick$btnEdit() throws InterruptedException{
        try {
            session.setAttribute("sessNavi", "0");
            session.setAttribute("sessId", tbJarHub.getIdHub());
            
//            Messagebox.show((String) session.getAttribute("sessId"));
            execution.createComponents("/zul/crud_hub.zul",null,null);
        } catch (Throwable e) {
            Messagebox.show("Data belum dipilih");
//            em.getTransaction().rollback();
        }
    } 
    public void onClick$btnAdd() throws InterruptedException{
       
            session.setAttribute("sessNavi", "1");
            execution.createComponents("/zul/crud_hub.zul",null,null);
    }
    public void onClick$btnRefresh()throws InterruptedException, SQLException{
        lstJarHub = em.createNamedQuery("JarHub.findAll")
            .setHint("eclipselink.refresh", "true")
            .getResultList();
    } 
    public void onClick$btnHapus() throws InterruptedException{
        try {
            
                if (!em.getTransaction().isActive()) {
                    em.getTransaction().begin();
                }
                
                String sql  ="DELETE FROM jar_hub WHERE id_hub='"+tbJarHub.getIdHub()+"'";
                    em.createNativeQuery(sql).executeUpdate();
                    em.flush();
                    em.getTransaction().commit();
                    
                lstJarHub = em.createNamedQuery("JarHub.findAll")
                    .setHint("eclipselink.refresh", "true")
                    .getResultList();
        } catch (Throwable e) {
            Messagebox.show("Data belum dipilih");
//            em.getTransaction().rollback();
        }
        
         lstJarHub = em.createNamedQuery("JarHub.findAll")
            .setHint("eclipselink.refresh", "true")
            .getResultList();
    }
    public List getLstJarHub() {
        return lstJarHub;
    }

    public void setLstJarHub(List lstJarHub) {
        this.lstJarHub = lstJarHub;
    }

    public JarHub getTbJarHub() {
        return tbJarHub;
    }

    public void setTbJarHub(JarHub tbJarHub) {
        this.tbJarHub = tbJarHub;
    }
 
   
   
}
