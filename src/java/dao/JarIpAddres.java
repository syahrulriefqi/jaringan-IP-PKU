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
@Table(name = "jar_ip_addres")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JarIpAddres.findAll", query = "SELECT j FROM JarIpAddres j"),
    @NamedQuery(name = "JarIpAddres.findByIdIpAddress", query = "SELECT j FROM JarIpAddres j WHERE j.idIpAddress = :idIpAddress"),
    @NamedQuery(name = "JarIpAddres.findByIpAddress", query = "SELECT j FROM JarIpAddres j WHERE j.ipAddress = :ipAddress"),
    @NamedQuery(name = "JarIpAddres.findByTanggal", query = "SELECT j FROM JarIpAddres j WHERE j.tanggal = :tanggal"),
    @NamedQuery(name = "JarIpAddres.findByJam", query = "SELECT j FROM JarIpAddres j WHERE j.jam = :jam"),
    @NamedQuery(name = "JarIpAddres.findByPosisi", query = "SELECT j FROM JarIpAddres j WHERE j.posisi = :posisi"),
    @NamedQuery(name = "JarIpAddres.findByIdDevice", query = "SELECT j FROM JarIpAddres j WHERE j.idDevice = :idDevice"),
    @NamedQuery(name = "JarIpAddres.findByIdHub", query = "SELECT j FROM JarIpAddres j WHERE j.idHub = :idHub"),
    @NamedQuery(name = "JarIpAddres.findByStatus", query = "SELECT j FROM JarIpAddres j WHERE j.status = :status")})
public class JarIpAddres implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ip_address")
    private Integer idIpAddress;
    @Column(name = "ip_address")
    private String ipAddress;
    @Column(name = "tanggal")
    @Temporal(TemporalType.DATE)
    private Date tanggal;
    @Column(name = "jam")
    private String jam;
    @Column(name = "posisi")
    private Integer posisi;
    @Lob
    @Column(name = "keterangan")
    private String keterangan;
    @Column(name = "id_device")
    private Integer idDevice;
    @Column(name = "id_hub")
    private Integer idHub;
    @Column(name = "status")
    private Integer status;

    public JarIpAddres() {
    }

    public JarIpAddres(Integer idIpAddress) {
        this.idIpAddress = idIpAddress;
    }

    public Integer getIdIpAddress() {
        return idIpAddress;
    }

    public void setIdIpAddress(Integer idIpAddress) {
        this.idIpAddress = idIpAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
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

    public Integer getPosisi() {
        return posisi;
    }

    public void setPosisi(Integer posisi) {
        this.posisi = posisi;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Integer getIdDevice() {
        return idDevice;
    }

    public void setIdDevice(Integer idDevice) {
        this.idDevice = idDevice;
    }

    public Integer getIdHub() {
        return idHub;
    }

    public void setIdHub(Integer idHub) {
        this.idHub = idHub;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIpAddress != null ? idIpAddress.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JarIpAddres)) {
            return false;
        }
        JarIpAddres other = (JarIpAddres) object;
        if ((this.idIpAddress == null && other.idIpAddress != null) || (this.idIpAddress != null && !this.idIpAddress.equals(other.idIpAddress))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.JarIpAddres[ idIpAddress=" + idIpAddress + " ]";
    }
    
}
