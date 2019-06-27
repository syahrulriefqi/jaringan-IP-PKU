/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;

import static ctrl.daftar_hub_.em;
import dao.JarHub;
import dao.JarIpAddres;
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
 * @author esyeha
 */
public class daftarIP_ extends GenericForwardComposer{
   static EntityManagerFactory emf=Persistence.createEntityManagerFactory("jar_pkuPU");
    static EntityManager em=emf.createEntityManager();
    
     private Window winIP ;
    private ResultSet     rsTotal;
    private Connection    cn;
    private Statement     st;
   protected List   lstJarIpAddres;
    private JarIpAddres tbJarIpAddres;       
    
    public void onCreate$winIP() throws InterruptedException, SQLException{
    koneksi_ k = new koneksi_();
    cn = k.getConnection();
    st = cn.createStatement(); 
    //Messagebox.show(rsTotal.getString("jml"));

   String sql="select * from jar_ip_addres limit 10";
    lstJarIpAddres = em.createNativeQuery(sql, JarIpAddres.class)
               .setHint("eclipselink.refresh", "true")
               .getResultList();
//        Messagebox.show(lstVJarDevice.size()+"");
}
     public void onSelect$lsbDaftar() throws InterruptedException{
        lstJarIpAddres=em.createNamedQuery("JarIpAddres.findByIdIpAddress")
                .setHint("eclipselink.refresh", "true")
                .setParameter("idIpAddres", tbJarIpAddres.getIdIpAddress())
                .getResultList();
        tbJarIpAddres=(JarIpAddres) lstJarIpAddres.get(0);
    }   

    public List getLstJarIpAddres() {
        return lstJarIpAddres;
    }

    public void setLstJarIpAddres(List lstJarIpAddres) {
        this.lstJarIpAddres = lstJarIpAddres;
    }

    public JarIpAddres getTbJarIpAddres() {
        return tbJarIpAddres;
    }

    public void setTbJarIpAddres(JarIpAddres tbJarIpAddres) {
        this.tbJarIpAddres = tbJarIpAddres;
    }
     
}
