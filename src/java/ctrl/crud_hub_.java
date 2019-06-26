/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;

import dao.JarHub;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
 * @author san
 */
public class crud_hub_  extends GenericForwardComposer{
   static EntityManagerFactory emf=Persistence.createEntityManagerFactory("jar_pkuPU");
    static EntityManager em=emf.createEntityManager();  
    
    
    private Window winCrudHub ;
    private ResultSet     rsTotal;
    private Connection    cn;
    private Statement     st;
   protected List   lstJarHub;
    private JarHub tbJarHub;         
    
    private Textbox     txtNamaHub,txtLokasi,txtAsalLan,txtKeterangan;
   
    public void onCreate$winCrudHub() throws InterruptedException{
        if (session.getAttribute("sessNavi").toString()=="1") {
            winCrudHub.setTitle("Tambah Data HUB");
            
        }else{
            winCrudHub.setTitle("Edit HUB");
            lstJarHub=em.createNamedQuery("JarHub.findByIdHub")
                            .setHint("eclipselink.refresh", "true")
                            .setParameter("idHub", Integer.parseInt(session.getAttribute("sessId").toString()))
                            .getResultList();
            tbJarHub= (JarHub) lstJarHub.get(0);
            txtNamaHub.setValue(tbJarHub.getNamaHub());
            txtLokasi.setValue(tbJarHub.getLokasi());
            txtAsalLan.setValue(tbJarHub.getAsalLan());
            txtKeterangan.setValue(tbJarHub.getKeterangan());
        }
            
    }
    
    public void onClick$btnSimpan() throws InterruptedException{
        try {
            
              if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
              }
              String sql=null;
              
        if (session.getAttribute("sessNavi").toString()=="1") {
            sql="INSERT INTO jar_hub (nama_hub,lokasi,keterangan,asal_lan,status)"
                    + " VALUES ('"+
                    txtNamaHub.getValue()+"','"+
                    txtLokasi.getValue()+"','"+
                    txtKeterangan.getValue()+"','"+
                    txtAsalLan.getValue()+"','1')";
        }else{
            sql="UPDATE jar_hub SET "
                    + "`nama_hub` = '"+txtNamaHub.getValue()+"' , "
                    + "`lokasi` = '"+txtLokasi.getValue()+"' , "
                    + "`keterangan` = '"+txtKeterangan.getValue()+"' , "
                    + "`asal_lan` = '"+txtAsalLan.getValue()+"' "
                    + "WHERE `id_hub` = '"+session.getAttribute("sessId").toString()+"'; ";
        }
        
            em.createNativeQuery(sql).executeUpdate();
            em.flush();
            em.getTransaction().commit();
            winCrudHub.detach();
            Messagebox.show("Simpan Sukses","Informasi", Messagebox.OK,Messagebox.INFORMATION);
            
        } catch (Throwable e) {
            Messagebox.show(e.getMessage());
            em.getTransaction().rollback();
        }
        
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
