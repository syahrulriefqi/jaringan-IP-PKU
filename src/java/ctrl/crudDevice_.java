/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;

import dao.JarDevice;
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
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Timebox;
import org.zkoss.zul.Window;

/**
 *
 * @author esyeha
 */
public class crudDevice_ extends GenericForwardComposer {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jar_pkuPU");
    static EntityManager em = emf.createEntityManager();

    protected List lstJarDevice, lstMrUnit;
    private JarDevice tbJarDevice;
    private MrUnit tbMrUnit;
    private Textbox txtNama, txtDevice, txtKeterangan, txtUser, txtLokasi, txtPassword;
    private Button btnSimpan;
    private Window winUtamaCrud;
    private Datebox dtTgl;
    private Combobox txtUnit;
    //private Timebox tmJam;
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    //final SimpleDateFormat sdfJam=new SimpleDateFormat("hh:mm:ss");

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        lstJarDevice = em.createNamedQuery("JarDevice.findAll")
            .setHint("eclipselink.refresh", "true")
            .getResultList();


        lstMrUnit = em.createNamedQuery("MrUnit.findAll")
            .setHint("eclipselink.refresh", "true")
            .getResultList();
         
            Messagebox.show(""+getTanggal(), "Informasi", Messagebox.OK, Messagebox.INFORMATION);
    }
    public void onCreate$winUtamaCrud() throws InterruptedException {
        
        if ("1".equals(session.getAttribute("sessNavi").toString())) {
            lstJarDevice = em.createNamedQuery("JarDevice.findAll")
                .setHint("eclipselink.refresh", "true")
                .setMaxResults(1)
                .getResultList();
            JarDevice baru = new JarDevice();
            lstJarDevice.add(baru);
            tbJarDevice = (JarDevice) lstJarDevice.get(lstJarDevice.size() - 1);

        } else {

            //            Messagebox.show(session.getAttribute("sessID").toString());

            lstJarDevice = em.createNamedQuery("JarDevice.findByIdDevice")
                .setHint("eclipselink.refresh", "true")
                .setParameter("idDevice", Integer.parseInt(session.getAttribute("sessID").toString()))
                .getResultList();
            tbJarDevice = (JarDevice) lstJarDevice.get(0);
            txtNama.setValue(tbJarDevice.getNamaDevice());

        }
    }
    public void onClick$btnSimpan() throws InterruptedException {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }

            String sql = null;
            if (session.getAttribute("sessNavi").toString() == "1") {
                sql = "insert into jar_device (nama_device,mac_addres,id_unit,user,password,lokasi,tanggal,jam,keterangan)" +
                    " values ('" +
                    txtNama.getValue() + "','" +
                    txtDevice.getValue() + "','" +
                    tbJarDevice.getIdUnit()+ "','" +
                    txtUser.getValue() + "','" +
                    txtPassword.getValue() + "','" +
                    txtLokasi.getValue() + "','" +
                    getTanggal() + "','"+
                    getWaktu()+"','"+
                    txtKeterangan.getValue() + "')";

            } else {
                sql = "UPDATE jar_device SET " +
                    "`nama_device` = '" + txtNama.getValue() + "' , " +
                    "`mac_addres` = '" + txtDevice.getValue() + "' , " +
                    "`id_unit` = '" + tbJarDevice.getIdUnit() + "' , " +
                    "`user` = '" + txtUser.getValue() + "' , " +
                    "`password` = '" + txtPassword.getValue() + "' , " +
                    "`lokasi` = '" + txtLokasi.getValue() + "' , " +
                    "`tanggal` = '" + getTanggal() + "', "+ 
                    "`jam` = '"+getWaktu()+"', "+
                    "`keterangan` = '" + txtKeterangan.getValue() + "'  " +
                    "WHERE `id_device` = '" + session.getAttribute("sessID").toString() + "' ";
            }
            em.createNativeQuery(sql).executeUpdate();
            em.flush();
            em.getTransaction().commit();
            winUtamaCrud.detach();
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
 
    public List getLstJarDevice() {
        return lstJarDevice;
    }

    public void setLstJarDevice(List lstJarDevice) {
        this.lstJarDevice = lstJarDevice;
    }

    public JarDevice getTbJarDevice() {
        return tbJarDevice;
    }

    public void setTbJarDevice(JarDevice tbJarDevice) {
        this.tbJarDevice = tbJarDevice;
    }

    public List getLstMrUnit() {
        return lstMrUnit;
    }

    public void setLstMrUnit(List lstMrUnit) {
        this.lstMrUnit = lstMrUnit;
    }

    public MrUnit getTbMrUnit() {
        return tbMrUnit;
    }

    public void setTbMrUnit(MrUnit tbMrUnit) {
        this.tbMrUnit = tbMrUnit;
    }
}