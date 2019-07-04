/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;

import static ctrl.crudDevice_.em;
import dao.JarDevice;
import dao.JarHub;
import dao.JarIpAddres;
import dao.MrUnit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

/**
 *
 * @author esyeha
 */
public class crudIP_ extends GenericForwardComposer {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jar_pkuPU");
    static EntityManager em = emf.createEntityManager();

    protected List lstJarIpAddres, lstJarDevice, lstJarHub;
    private JarIpAddres tbJarIpAddres;
    private JarDevice tbJarDevice;
    private JarHub tbJarHub;
    private Textbox txtNama, txtUser, txtPosisi, txtKeterangan, txtIdDevice, txtIdHub, txtStatus;
    private Button btnSimpan;
    private Window winUtamaIP;
    private Datebox dtTgl;
    private Combobox txtUnit;
    //private Timebox tmJam;
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    //final SimpleDateFormat sdfJam=new SimpleDateFormat("hh:mm:ss");

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        lstJarIpAddres = em.createNamedQuery("JarIpAddres.findAll")
            .setHint("eclipselink.refresh", "true")
            .getResultList();
    
        lstJarDevice = em.createNamedQuery("JarDevice.findAll")
            .setHint("eclipselink.refresh", "true")
            .getResultList();
         
            Messagebox.show(""+getTanggal(), "Informasi", Messagebox.OK, Messagebox.INFORMATION);
}
    public void onCreate$winUtamaIP() throws InterruptedException {
        
        if ("1".equals(session.getAttribute("sessNavi").toString())) {
            lstJarIpAddres = em.createNamedQuery("JarIpAddres.findAll")
                .setHint("eclipselink.refresh", "true")
                .setMaxResults(1)
                .getResultList();
            JarDevice baru = new JarDevice();
            lstJarIpAddres.add(baru);
            tbJarIpAddres= (JarIpAddres) lstJarIpAddres.get(lstJarIpAddres.size() - 1);


} else {

            //            Messagebox.show(session.getAttribute("sessID").toString());

            lstJarIpAddres = em.createNamedQuery("JarIpAddres.findByIdIpAddress")
                .setHint("eclipselink.refresh", "true")
                .setParameter("idIpAddress", Integer.parseInt(session.getAttribute("sessID").toString()))
                .getResultList();
            tbJarIpAddres = (JarIpAddres) lstJarIpAddres.get(0);
            txtNama.setValue(tbJarIpAddres.getIpAddress());

        }
    }
    public void onClick$btnSimpan() throws InterruptedException {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }

            String sql = null;
            if (session.getAttribute("sessNavi").toString() == "1") {
                sql = "insert into jar_ip_addres (ip_address,tanggal,jam,posisi,keterangan,id_device,id_hub,status)" +
                    " values ('" +
                    txtNama.getValue() + "','" +
                    getTanggal() + "','"+
                    getWaktu()+"','"+
                    txtPosisi.getValue() + "','" +
                    txtKeterangan.getValue() + "','" +
                    tbJarDevice.getIdDevice()+ "','" +
                    tbJarHub.getIdHub()+ "','" +
                    txtUser.getValue() + "','" +  
                    txtStatus.getValue() + "')";

            } else {
                sql = "UPDATE jar_ip_addres SET " +
                    "`ip_address` = '" + txtNama.getValue() + "' , " +
                    "`tanggal` = '" + getTanggal() + "', "+ 
                     "`jam` = '"+getWaktu()+"', "+
                    "`posisi` = '" + txtPosisi.getValue() + "' , " +
                     "`keterangan` = '" + txtKeterangan.getValue() + "' , " +
                    "`id_device` = '" + tbJarDevice.getIdDevice() + "' , " +
                     "`id_hub` = '" + tbJarHub.getIdHub() + "' , " +                  
                    "`status` = '" + txtStatus.getValue() + "'  " +
                    "WHERE `id_ip_addres` = '" + session.getAttribute("sessID").toString() + "' ";
            }
            em.createNativeQuery(sql).executeUpdate();
            em.flush();
            em.getTransaction().commit();
            winUtamaIP.detach();
            Messagebox.show("Simpan sukses", "Informasi", Messagebox.OK, Messagebox.INFORMATION);
        } catch (WrongValueException e) {
            Messagebox.show(e.getMessage());
            em.getTransaction().rollback();
        } catch (InterruptedException e) {
            Messagebox.show(e.getMessage());
            em.getTransaction().rollback();
        }

    }

 private String getTanggal() {  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        Date date = new Date();
        String strDate = dateFormat.format(date);  
                        
        return strDate;  
    }  
 private String getWaktu() {  
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");  
        Date date = new Date();  
        return dateFormat.format(date);  
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

    public JarDevice getTbJarDevice() {
        return tbJarDevice;
    }

    public void setTbJarDevice(JarDevice tbJarDevice) {
        this.tbJarDevice = tbJarDevice;
    }

    public JarHub getTbJarHub() {
        return tbJarHub;
    }

    public void setTbJarHub(JarHub tbJarHub) {
        this.tbJarHub = tbJarHub;
    }

  

 
}