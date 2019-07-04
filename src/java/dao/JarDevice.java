/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author esyeha
 */
@Entity
@Table(name = "jar_device")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JarDevice.findAll", query = "SELECT j FROM JarDevice j"),
    @NamedQuery(name = "JarDevice.findByIdDevice", query = "SELECT j FROM JarDevice j WHERE j.idDevice = :idDevice"),
    @NamedQuery(name = "JarDevice.findByNamaDevice", query = "SELECT j FROM JarDevice j WHERE j.namaDevice LIKE :namaDevice"),
    @NamedQuery(name = "JarDevice.findByMacAddres", query = "SELECT j FROM JarDevice j WHERE j.macAddres = :macAddres"),
    @NamedQuery(name = "JarDevice.findByIdUnit", query = "SELECT j FROM JarDevice j WHERE j.idUnit = :idUnit"),
    @NamedQuery(name = "JarDevice.findByUser", query = "SELECT j FROM JarDevice j WHERE j.user = :user"),
    @NamedQuery(name = "JarDevice.findByPassword", query = "SELECT j FROM JarDevice j WHERE j.password = :password"),
    @NamedQuery(name = "JarDevice.findByLokasi", query = "SELECT j FROM JarDevice j WHERE j.lokasi = :lokasi"),
    @NamedQuery(name = "JarDevice.findByTanggal", query = "SELECT j FROM JarDevice j WHERE j.tanggal = :tanggal"),
    @NamedQuery(name = "JarDevice.findByJam", query = "SELECT j FROM JarDevice j WHERE j.jam = :jam")})
public class JarDevice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_device")
    private Integer idDevice;
    @Column(name = "nama_device")
    private String namaDevice;
    @Column(name = "mac_addres")
    private String macAddres;
    @Column(name = "id_unit")
    private Integer idUnit;
    @Column(name = "user")
    private String user;
    @Column(name = "password")
    private String password;
    @Column(name = "lokasi")
    private String lokasi;
    @Column(name = "tanggal")
    @Temporal(TemporalType.DATE)
    private Date tanggal;
    @Column(name = "jam")
    private String jam;
    @Lob
    @Column(name = "keterangan")
    private String keterangan;

    public JarDevice() {
    }

    public JarDevice(Integer idDevice) {
        this.idDevice = idDevice;
    }

    public Integer getIdDevice() {
        return idDevice;
    }

    public void setIdDevice(Integer idDevice) {
        this.idDevice = idDevice;
    }

    public String getNamaDevice() {
        return namaDevice;
    }

    public void setNamaDevice(String namaDevice) {
        this.namaDevice = namaDevice;
    }

    public String getMacAddres() {
        return macAddres;
    }

    public void setMacAddres(String macAddres) {
        this.macAddres = macAddres;
    }

    public Integer getIdUnit() {
        return idUnit;
    }

    public void setIdUnit(Integer idUnit) {
        this.idUnit = idUnit;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDevice != null ? idDevice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JarDevice)) {
            return false;
        }
        JarDevice other = (JarDevice) object;
        if ((this.idDevice == null && other.idDevice != null) || (this.idDevice != null && !this.idDevice.equals(other.idDevice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.JarDevice[ idDevice=" + idDevice + " ]";
    }

    public Date getTgl() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNama() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdStatus() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getIdHub() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
