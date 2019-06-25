/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;

import dao.JarDevice;
import dao.VJarDevice;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

/**
 *
 * @author esyeha
 */
public class daftardevice_ extends GenericForwardComposer{
   static EntityManagerFactory emf=Persistence.createEntityManagerFactory("jar_pkuPU");
    static EntityManager em=emf.createEntityManager();  
    
    private VJarDevice tbVJarDevice; 
     protected List   lstJarDevice, lstVJarDevice;
    private JarDevice tbJarDevice;
    private VJarDevice VJarDevice;
    private Textbox txtNama ;
    private Button btnTutup, btnRefresh;
    private Window winUtama ;
    private ResultSet     rsTotal;
    private Connection    cn;
    private Statement     st;
    private Label         lblJml;
    
    public void onCreate$winUtama() throws InterruptedException, SQLException{
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
   String sql="select * from jar_device limit 10";
    lstJarDevice = em.createNativeQuery(sql, JarDevice.class)
               .setHint("eclipselink.refresh", "true")
               .getResultList();
//        Messagebox.show(lstVJarDevice.size()+"");
}

//    private void jumlah() throws InterruptedException, SQLException{
//    rsTotal=st.executeQuery("SELECT count(*) as jml FROM jar_device");
//     rsTotal.next();
//     lblJml.setValue(rsTotal.getString("jml")+"");
//    }
    public void onSelect$lsbDaftar() throws InterruptedException{
    lstJarDevice=em.createNamedQuery("JarDevice.findById")
            .setHint("eclipselink.refresh", "true")
            .setParameter("id", tbJarDevice.getId())
            .getResultList();
    tbJarDevice=(JarDevice) lstJarDevice.get(0);
}

    public void onClick$btnAdd() throws InterruptedException{
    session.setAttribute("sessNavi", "1");
    execution.createComponents("/zul/crudDevice.zul",null,null);
    
    }
    
    public VJarDevice getTbVJarDevice() {
        return tbVJarDevice;
    }

    public void setTbVJarDevice(VJarDevice tbVJarDevice) {
        this.tbVJarDevice = tbVJarDevice;
    }

    public List getLstJarDevice() {
        return lstJarDevice;
    }

    public void setLstJarDevice(List lstJarDevice) {
        this.lstJarDevice = lstJarDevice;
    }

    public List getLstVJarDevice() {
        return lstVJarDevice;
    }

    public void setLstVJarDevice(List lstVJarDevice) {
        this.lstVJarDevice = lstVJarDevice;
    }

    public JarDevice getTbJarDevice() {
        return tbJarDevice;
    }

    public void setTbJarDevice(JarDevice tbJarDevice) {
        this.tbJarDevice = tbJarDevice;
    }
    
}
    

