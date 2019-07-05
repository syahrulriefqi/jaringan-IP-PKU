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
 * @author san
 */
@Entity
@Table(name = "v_jar_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VJarData.findAll", query = "SELECT v FROM VJarData v"),
    @NamedQuery(name = "VJarData.findByIdDevice", query = "SELECT v FROM VJarData v WHERE v.idDevice = :idDevice"),
    @NamedQuery(name = "VJarData.findByNamaDevice", query = "SELECT v FROM VJarData v WHERE v.namaDevice = :namaDevice"),
    @NamedQuery(name = "VJarData.findByMacAddres", query = "SELECT v FROM VJarData v WHERE v.macAddres = :macAddres"),
    @NamedQuery(name = "VJarData.findByTanggal", query = "SELECT v FROM VJarData v WHERE v.tanggal = :tanggal"),
    @NamedQuery(name = "VJarData.findByJam", query = "SELECT v FROM VJarData v WHERE v.jam = :jam"),
    @NamedQuery(name = "VJarData.findByIpAddress", query = "SELECT v FROM VJarData v WHERE v.ipAddress = :ipAddress"),
    @NamedQuery(name = "VJarData.findByNamaUnit", query = "SELECT v FROM VJarData v WHERE v.namaUnit = :namaUnit"),
    @NamedQuery(name = "VJarData.findByNamaHub", query = "SELECT v FROM VJarData v WHERE v.namaHub = :namaHub")})
public class VJarData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "id_device")
    private int idDevice;
    @Column(name = "nama_device")
    private String namaDevice;
    @Column(name = "mac_addres")
    private String macAddres;
    @Column(name = "tanggal")
    @Temporal(TemporalType.DATE)
    private Date tanggal;
    @Column(name = "jam")
    private String jam;
    @Column(name = "ip_address")
    @Id
    private String ipAddress;
    @Lob
    @Column(name = "keterangan")
    private String keterangan;
    @Column(name = "nama_unit")
    private String namaUnit;
    @Column(name = "nama_hub")
    private String namaHub;

    public VJarData() {
    }

    public int getIdDevice() {
        return idDevice;
    }

    public void setIdDevice(int idDevice) {
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

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getNamaUnit() {
        return namaUnit;
    }

    public void setNamaUnit(String namaUnit) {
        this.namaUnit = namaUnit;
    }

    public String getNamaHub() {
        return namaHub;
    }

    public void setNamaHub(String namaHub) {
        this.namaHub = namaHub;
    }
    
}
