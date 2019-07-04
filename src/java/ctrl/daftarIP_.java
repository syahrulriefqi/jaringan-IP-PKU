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
import org.zkoss.zhtml.Messagebox;
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
   protected List   lstJarIpAddres, lstJarDevice, lstJarHub;
    private JarIpAddres tbJarIpAddres, tbJarDevice, tbJarHub;       
    
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
     public void onClick$btnAdd() throws InterruptedException{
    session.setAttribute("sessNavi", "1");
    execution.createComponents("/zul/crudIP.zul",null,null);
    
    }
     public void onClick$btnEdit() throws InterruptedException{
        try {
            session.setAttribute("sessNavi", "0");
            session.setAttribute("sessId", tbJarIpAddres.getIdIpAddress());
            
//            Messagebox.show((String) session.getAttribute("sessId"));
            execution.createComponents("/zul/crudIP.zul",null,null);
        } catch (Throwable e) {
            Messagebox.show("Data belum dipilih");
//            em.getTransaction().rollback();
        }
   
     
}

    public List getLstJarIpAddres() {
        return lstJarIpAddres;
    }

    public void setLstJarIpAddres(List lstJarIpAddres) {
        this.lstJarIpAddres = lstJarIpAddres;
    }

    public List getLstJarDevice() {
        return lstJarDevice;
    }

    public void setLstJarDevice(List lstJarDevice) {
        this.lstJarDevice = lstJarDevice;
    }

    public List getLstJarHub() {
        return lstJarHub;
    }

    public void setLstJarHub(List lstJarHub) {
        this.lstJarHub = lstJarHub;
    }

    public JarIpAddres getTbJarIpAddres() {
        return tbJarIpAddres;
    }

    public void setTbJarIpAddres(JarIpAddres tbJarIpAddres) {
        this.tbJarIpAddres = tbJarIpAddres;
    }

    public JarIpAddres getTbJarDevice() {
        return tbJarDevice;
    }

    public void setTbJarDevice(JarIpAddres tbJarDevice) {
        this.tbJarDevice = tbJarDevice;
    }

    public JarIpAddres getTbJarHub() {
        return tbJarHub;
    }

    public void setTbJarHub(JarIpAddres tbJarHub) {
        this.tbJarHub = tbJarHub;
    }
}