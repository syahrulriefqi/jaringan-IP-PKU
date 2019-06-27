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
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

/**
 *
 * @author esyeha
 */
public class perangkat_ extends GenericForwardComposer{
   static EntityManagerFactory emf=Persistence.createEntityManagerFactory("jar_pkuPU");
    static EntityManager em=emf.createEntityManager();  
    
    protected List lstJarDevice, lstVJarDevice;
    
    private VJarDevice tbVJarDevice; 
    private JarDevice tbJarDevice;
    private Textbox txtNama ;
    private Window winUtamaPerangkat ;
    private ResultSet     rsTotal;
    private Connection    cn;
    private Statement     st;
    private Label         lblJml;
    
public void onCreate$winUtamaPerangkat() throws InterruptedException, SQLException{
    koneksi_ k = new koneksi_();
    cn = k.getConnection();
    st = cn.createStatement();
    rsTotal=st.executeQuery("SELECT count(*) as jml FROM v_jar_device");
    rsTotal.next();
    //Messagebox.show(rsTotal.getString("jml"));
    //jumlah();

   String sql="select * from v_jar_device limit 10";
   lstVJarDevice=em.createNativeQuery(sql, VJarDevice.class)
           .setHint("eclipselink.refresh", "true")
           .getResultList();

}
public void onSelect$lsbDaftar() throws InterruptedException{
    lstJarDevice=em.createNamedQuery("VJarDevice.findByIdDevice")
            .setHint("eclipselink.refresh", "true")
            .setParameter("idDevice", tbVJarDevice.getIdDevice())
            .getResultList();
    tbVJarDevice=(VJarDevice) lstVJarDevice.get(0);
}
public void onOK$txtNama() throws InterruptedException {
   
      String sql="select * from v_jar_device where nama_device like '"+txtNama.getValue()+"%'";
   lstJarDevice=em.createNativeQuery(sql, JarDevice.class)
           .setHint("exlipselink.refresh", "true")
           .getResultList();
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

    public VJarDevice getTbVJarDevice() {
        return tbVJarDevice;
    }

    public void setTbVJarDevice(VJarDevice tbVJarDevice) {
        this.tbVJarDevice = tbVJarDevice;
    }

    public JarDevice getTbJarDevice() {
        return tbJarDevice;
    }

    public void setTbJarDevice(JarDevice tbJarDevice) {
        this.tbJarDevice = tbJarDevice;
    }

    
}
