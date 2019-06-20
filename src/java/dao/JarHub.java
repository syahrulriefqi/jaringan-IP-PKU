/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author esyeha
 */
@Entity
@Table(name = "jar_hub")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JarHub.findAll", query = "SELECT j FROM JarHub j"),
    @NamedQuery(name = "JarHub.findByIdHub", query = "SELECT j FROM JarHub j WHERE j.idHub = :idHub"),
    @NamedQuery(name = "JarHub.findByNamaHub", query = "SELECT j FROM JarHub j WHERE j.namaHub = :namaHub"),
    @NamedQuery(name = "JarHub.findByLokasi", query = "SELECT j FROM JarHub j WHERE j.lokasi = :lokasi"),
    @NamedQuery(name = "JarHub.findByKeterangan", query = "SELECT j FROM JarHub j WHERE j.keterangan = :keterangan"),
    @NamedQuery(name = "JarHub.findByAsalLan", query = "SELECT j FROM JarHub j WHERE j.asalLan = :asalLan"),
    @NamedQuery(name = "JarHub.findByStatus", query = "SELECT j FROM JarHub j WHERE j.status = :status")})
public class JarHub implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_hub")
    private Integer idHub;
    @Column(name = "nama_hub")
    private String namaHub;
    @Column(name = "lokasi")
    private String lokasi;
    @Column(name = "keterangan")
    private String keterangan;
    @Column(name = "asal_lan")
    private String asalLan;
    @Column(name = "status")
    private Integer status;

    public JarHub() {
    }

    public JarHub(Integer idHub) {
        this.idHub = idHub;
    }

    public Integer getIdHub() {
        return idHub;
    }

    public void setIdHub(Integer idHub) {
        this.idHub = idHub;
    }

    public String getNamaHub() {
        return namaHub;
    }

    public void setNamaHub(String namaHub) {
        this.namaHub = namaHub;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getAsalLan() {
        return asalLan;
    }

    public void setAsalLan(String asalLan) {
        this.asalLan = asalLan;
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
        hash += (idHub != null ? idHub.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JarHub)) {
            return false;
        }
        JarHub other = (JarHub) object;
        if ((this.idHub == null && other.idHub != null) || (this.idHub != null && !this.idHub.equals(other.idHub))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.JarHub[ idHub=" + idHub + " ]";
    }
    
}
