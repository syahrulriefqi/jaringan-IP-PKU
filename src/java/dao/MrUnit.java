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
 * @author san
 */
@Entity
@Table(name = "MR_UNIT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MrUnit.findAll", query = "SELECT m FROM MrUnit m"),
    @NamedQuery(name = "MrUnit.findByNama", query = "SELECT m FROM MrUnit m WHERE m.nama = :nama"),
    @NamedQuery(name = "MrUnit.findByNoUrut", query = "SELECT m FROM MrUnit m WHERE m.noUrut = :noUrut"),
    @NamedQuery(name = "MrUnit.findByJumlah", query = "SELECT m FROM MrUnit m WHERE m.jumlah = :jumlah"),
    @NamedQuery(name = "MrUnit.findByKel", query = "SELECT m FROM MrUnit m WHERE m.kel = :kel"),
    @NamedQuery(name = "MrUnit.findByKode", query = "SELECT m FROM MrUnit m WHERE m.kode = :kode"),
    @NamedQuery(name = "MrUnit.findByKdInap", query = "SELECT m FROM MrUnit m WHERE m.kdInap = :kdInap"),
    @NamedQuery(name = "MrUnit.findByAnggaran", query = "SELECT m FROM MrUnit m WHERE m.anggaran = :anggaran"),
    @NamedQuery(name = "MrUnit.findByNamaDinas", query = "SELECT m FROM MrUnit m WHERE m.namaDinas = :namaDinas"),
    @NamedQuery(name = "MrUnit.findByResiko", query = "SELECT m FROM MrUnit m WHERE m.resiko = :resiko"),
    @NamedQuery(name = "MrUnit.findByEmergensi", query = "SELECT m FROM MrUnit m WHERE m.emergensi = :emergensi"),
    @NamedQuery(name = "MrUnit.findByMrRuang", query = "SELECT m FROM MrUnit m WHERE m.mrRuang = :mrRuang"),
    @NamedQuery(name = "MrUnit.findByKdDiv", query = "SELECT m FROM MrUnit m WHERE m.kdDiv = :kdDiv"),
    @NamedQuery(name = "MrUnit.findByKdDivMnj", query = "SELECT m FROM MrUnit m WHERE m.kdDivMnj = :kdDivMnj"),
    @NamedQuery(name = "MrUnit.findByKdDivAsmen", query = "SELECT m FROM MrUnit m WHERE m.kdDivAsmen = :kdDivAsmen"),
    @NamedQuery(name = "MrUnit.findByIdKerusakan", query = "SELECT m FROM MrUnit m WHERE m.idKerusakan = :idKerusakan"),
    @NamedQuery(name = "MrUnit.findByAktifAnggaran", query = "SELECT m FROM MrUnit m WHERE m.aktifAnggaran = :aktifAnggaran"),
    @NamedQuery(name = "MrUnit.findByInfoTt", query = "SELECT m FROM MrUnit m WHERE m.infoTt = :infoTt"),
    @NamedQuery(name = "MrUnit.findByAktifUnit", query = "SELECT m FROM MrUnit m WHERE m.aktifUnit = :aktifUnit"),
    @NamedQuery(name = "MrUnit.findByLink", query = "SELECT m FROM MrUnit m WHERE m.link = :link")})
public class MrUnit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "nama")
    private String nama;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "no_urut")
    private Integer noUrut;
    @Column(name = "jumlah")
    private Integer jumlah;
    @Basic(optional = false)
    @Column(name = "kel")
    private String kel;
    @Basic(optional = false)
    @Column(name = "kode")
    private String kode;
    @Basic(optional = false)
    @Column(name = "kd_inap")
    private String kdInap;
    @Basic(optional = false)
    @Column(name = "anggaran")
    private String anggaran;
    @Basic(optional = false)
    @Column(name = "nama_dinas")
    private String namaDinas;
    @Basic(optional = false)
    @Column(name = "resiko")
    private int resiko;
    @Basic(optional = false)
    @Column(name = "emergensi")
    private int emergensi;
    @Column(name = "mr_ruang")
    private Integer mrRuang;
    @Column(name = "kd_div")
    private String kdDiv;
    @Column(name = "kd_div_mnj")
    private String kdDivMnj;
    @Column(name = "kd_div_asmen")
    private String kdDivAsmen;
    @Column(name = "id_kerusakan")
    private Integer idKerusakan;
    @Column(name = "aktif_anggaran")
    private Integer aktifAnggaran;
    @Column(name = "info_tt")
    private Integer infoTt;
    @Column(name = "aktif_unit")
    private Integer aktifUnit;
    @Column(name = "link")
    private String link;

    public MrUnit() {
    }

    public MrUnit(Integer noUrut) {
        this.noUrut = noUrut;
    }

    public MrUnit(Integer noUrut, String kel, String kode, String kdInap, String anggaran, String namaDinas, int resiko, int emergensi) {
        this.noUrut = noUrut;
        this.kel = kel;
        this.kode = kode;
        this.kdInap = kdInap;
        this.anggaran = anggaran;
        this.namaDinas = namaDinas;
        this.resiko = resiko;
        this.emergensi = emergensi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getNoUrut() {
        return noUrut;
    }

    public void setNoUrut(Integer noUrut) {
        this.noUrut = noUrut;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public String getKel() {
        return kel;
    }

    public void setKel(String kel) {
        this.kel = kel;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getKdInap() {
        return kdInap;
    }

    public void setKdInap(String kdInap) {
        this.kdInap = kdInap;
    }

    public String getAnggaran() {
        return anggaran;
    }

    public void setAnggaran(String anggaran) {
        this.anggaran = anggaran;
    }

    public String getNamaDinas() {
        return namaDinas;
    }

    public void setNamaDinas(String namaDinas) {
        this.namaDinas = namaDinas;
    }

    public int getResiko() {
        return resiko;
    }

    public void setResiko(int resiko) {
        this.resiko = resiko;
    }

    public int getEmergensi() {
        return emergensi;
    }

    public void setEmergensi(int emergensi) {
        this.emergensi = emergensi;
    }

    public Integer getMrRuang() {
        return mrRuang;
    }

    public void setMrRuang(Integer mrRuang) {
        this.mrRuang = mrRuang;
    }

    public String getKdDiv() {
        return kdDiv;
    }

    public void setKdDiv(String kdDiv) {
        this.kdDiv = kdDiv;
    }

    public String getKdDivMnj() {
        return kdDivMnj;
    }

    public void setKdDivMnj(String kdDivMnj) {
        this.kdDivMnj = kdDivMnj;
    }

    public String getKdDivAsmen() {
        return kdDivAsmen;
    }

    public void setKdDivAsmen(String kdDivAsmen) {
        this.kdDivAsmen = kdDivAsmen;
    }

    public Integer getIdKerusakan() {
        return idKerusakan;
    }

    public void setIdKerusakan(Integer idKerusakan) {
        this.idKerusakan = idKerusakan;
    }

    public Integer getAktifAnggaran() {
        return aktifAnggaran;
    }

    public void setAktifAnggaran(Integer aktifAnggaran) {
        this.aktifAnggaran = aktifAnggaran;
    }

    public Integer getInfoTt() {
        return infoTt;
    }

    public void setInfoTt(Integer infoTt) {
        this.infoTt = infoTt;
    }

    public Integer getAktifUnit() {
        return aktifUnit;
    }

    public void setAktifUnit(Integer aktifUnit) {
        this.aktifUnit = aktifUnit;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noUrut != null ? noUrut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MrUnit)) {
            return false;
        }
        MrUnit other = (MrUnit) object;
        if ((this.noUrut == null && other.noUrut != null) || (this.noUrut != null && !this.noUrut.equals(other.noUrut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.MrUnit[ noUrut=" + noUrut + " ]";
    }
    
}
