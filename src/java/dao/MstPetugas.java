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
 * @author san
 */
@Entity
@Table(name = "MST_PETUGAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstPetugas.findAll", query = "SELECT m FROM MstPetugas m"),
    @NamedQuery(name = "MstPetugas.findByNoUrut", query = "SELECT m FROM MstPetugas m WHERE m.noUrut = :noUrut"),
    @NamedQuery(name = "MstPetugas.findByNbm", query = "SELECT m FROM MstPetugas m WHERE m.nbm = :nbm"),
    @NamedQuery(name = "MstPetugas.findByNama", query = "SELECT m FROM MstPetugas m WHERE m.nama = :nama"),
    @NamedQuery(name = "MstPetugas.findByUnit", query = "SELECT m FROM MstPetugas m WHERE m.unit = :unit"),
    @NamedQuery(name = "MstPetugas.findByNoCm", query = "SELECT m FROM MstPetugas m WHERE m.noCm = :noCm"),
    @NamedQuery(name = "MstPetugas.findByJabatan", query = "SELECT m FROM MstPetugas m WHERE m.jabatan = :jabatan"),
    @NamedQuery(name = "MstPetugas.findByKet", query = "SELECT m FROM MstPetugas m WHERE m.ket = :ket"),
    @NamedQuery(name = "MstPetugas.findByPin", query = "SELECT m FROM MstPetugas m WHERE m.pin = :pin"),
    @NamedQuery(name = "MstPetugas.findByBlok", query = "SELECT m FROM MstPetugas m WHERE m.blok = :blok"),
    @NamedQuery(name = "MstPetugas.findBySip", query = "SELECT m FROM MstPetugas m WHERE m.sip = :sip"),
    @NamedQuery(name = "MstPetugas.findByAlamat", query = "SELECT m FROM MstPetugas m WHERE m.alamat = :alamat"),
    @NamedQuery(name = "MstPetugas.findByTelp1", query = "SELECT m FROM MstPetugas m WHERE m.telp1 = :telp1"),
    @NamedQuery(name = "MstPetugas.findByTelp2", query = "SELECT m FROM MstPetugas m WHERE m.telp2 = :telp2"),
    @NamedQuery(name = "MstPetugas.findByTelp3", query = "SELECT m FROM MstPetugas m WHERE m.telp3 = :telp3"),
    @NamedQuery(name = "MstPetugas.findByTelp4", query = "SELECT m FROM MstPetugas m WHERE m.telp4 = :telp4"),
    @NamedQuery(name = "MstPetugas.findByKdDiv", query = "SELECT m FROM MstPetugas m WHERE m.kdDiv = :kdDiv"),
    @NamedQuery(name = "MstPetugas.findByTimAngg", query = "SELECT m FROM MstPetugas m WHERE m.timAngg = :timAngg"),
    @NamedQuery(name = "MstPetugas.findByBlokAngg", query = "SELECT m FROM MstPetugas m WHERE m.blokAngg = :blokAngg"),
    @NamedQuery(name = "MstPetugas.findByHapus", query = "SELECT m FROM MstPetugas m WHERE m.hapus = :hapus"),
    @NamedQuery(name = "MstPetugas.findByKdUnit", query = "SELECT m FROM MstPetugas m WHERE m.kdUnit = :kdUnit"),
    @NamedQuery(name = "MstPetugas.findBySex", query = "SELECT m FROM MstPetugas m WHERE m.sex = :sex"),
    @NamedQuery(name = "MstPetugas.findByTglLahir", query = "SELECT m FROM MstPetugas m WHERE m.tglLahir = :tglLahir"),
    @NamedQuery(name = "MstPetugas.findByTglMenikah", query = "SELECT m FROM MstPetugas m WHERE m.tglMenikah = :tglMenikah"),
    @NamedQuery(name = "MstPetugas.findByEmail", query = "SELECT m FROM MstPetugas m WHERE m.email = :email"),
    @NamedQuery(name = "MstPetugas.findByHakAkses", query = "SELECT m FROM MstPetugas m WHERE m.hakAkses = :hakAkses"),
    @NamedQuery(name = "MstPetugas.findByKdAsu", query = "SELECT m FROM MstPetugas m WHERE m.kdAsu = :kdAsu"),
    @NamedQuery(name = "MstPetugas.findByRekening", query = "SELECT m FROM MstPetugas m WHERE m.rekening = :rekening"),
    @NamedQuery(name = "MstPetugas.findByGoldar", query = "SELECT m FROM MstPetugas m WHERE m.goldar = :goldar"),
    @NamedQuery(name = "MstPetugas.findBySms", query = "SELECT m FROM MstPetugas m WHERE m.sms = :sms"),
    @NamedQuery(name = "MstPetugas.findByStatKary", query = "SELECT m FROM MstPetugas m WHERE m.statKary = :statKary"),
    @NamedQuery(name = "MstPetugas.findByMkel", query = "SELECT m FROM MstPetugas m WHERE m.mkel = :mkel"),
    @NamedQuery(name = "MstPetugas.findByPanTldn", query = "SELECT m FROM MstPetugas m WHERE m.panTldn = :panTldn"),
    @NamedQuery(name = "MstPetugas.findByPassword", query = "SELECT m FROM MstPetugas m WHERE m.password = :password"),
    @NamedQuery(name = "MstPetugas.findByKdgolpangkat", query = "SELECT m FROM MstPetugas m WHERE m.kdgolpangkat = :kdgolpangkat"),
    @NamedQuery(name = "MstPetugas.findByIdstatusnikah", query = "SELECT m FROM MstPetugas m WHERE m.idstatusnikah = :idstatusnikah"),
    @NamedQuery(name = "MstPetugas.findByJumlahAnak", query = "SELECT m FROM MstPetugas m WHERE m.jumlahAnak = :jumlahAnak"),
    @NamedQuery(name = "MstPetugas.findByIdjabatan", query = "SELECT m FROM MstPetugas m WHERE m.idjabatan = :idjabatan"),
    @NamedQuery(name = "MstPetugas.findByIdfungsional", query = "SELECT m FROM MstPetugas m WHERE m.idfungsional = :idfungsional"),
    @NamedQuery(name = "MstPetugas.findByIdprofesi", query = "SELECT m FROM MstPetugas m WHERE m.idprofesi = :idprofesi"),
    @NamedQuery(name = "MstPetugas.findByTempat", query = "SELECT m FROM MstPetugas m WHERE m.tempat = :tempat"),
    @NamedQuery(name = "MstPetugas.findByIdagama", query = "SELECT m FROM MstPetugas m WHERE m.idagama = :idagama"),
    @NamedQuery(name = "MstPetugas.findByIdkecamatan", query = "SELECT m FROM MstPetugas m WHERE m.idkecamatan = :idkecamatan"),
    @NamedQuery(name = "MstPetugas.findByIdkabupaten", query = "SELECT m FROM MstPetugas m WHERE m.idkabupaten = :idkabupaten"),
    @NamedQuery(name = "MstPetugas.findByIdbank", query = "SELECT m FROM MstPetugas m WHERE m.idbank = :idbank"),
    @NamedQuery(name = "MstPetugas.findByNomorrekening", query = "SELECT m FROM MstPetugas m WHERE m.nomorrekening = :nomorrekening"),
    @NamedQuery(name = "MstPetugas.findByNpwp", query = "SELECT m FROM MstPetugas m WHERE m.npwp = :npwp"),
    @NamedQuery(name = "MstPetugas.findByNamadirekening", query = "SELECT m FROM MstPetugas m WHERE m.namadirekening = :namadirekening"),
    @NamedQuery(name = "MstPetugas.findByHakAnggaran", query = "SELECT m FROM MstPetugas m WHERE m.hakAnggaran = :hakAnggaran"),
    @NamedQuery(name = "MstPetugas.findByIdTim", query = "SELECT m FROM MstPetugas m WHERE m.idTim = :idTim"),
    @NamedQuery(name = "MstPetugas.findByNik", query = "SELECT m FROM MstPetugas m WHERE m.nik = :nik"),
    @NamedQuery(name = "MstPetugas.findByIdAplikasi", query = "SELECT m FROM MstPetugas m WHERE m.idAplikasi = :idAplikasi"),
    @NamedQuery(name = "MstPetugas.findByGelarDepan", query = "SELECT m FROM MstPetugas m WHERE m.gelarDepan = :gelarDepan"),
    @NamedQuery(name = "MstPetugas.findByGelarBelakang", query = "SELECT m FROM MstPetugas m WHERE m.gelarBelakang = :gelarBelakang"),
    @NamedQuery(name = "MstPetugas.findByNoKtp", query = "SELECT m FROM MstPetugas m WHERE m.noKtp = :noKtp"),
    @NamedQuery(name = "MstPetugas.findByNamaFile", query = "SELECT m FROM MstPetugas m WHERE m.namaFile = :namaFile"),
    @NamedQuery(name = "MstPetugas.findByIdkalurahan", query = "SELECT m FROM MstPetugas m WHERE m.idkalurahan = :idkalurahan"),
    @NamedQuery(name = "MstPetugas.findByIdpropinsi", query = "SELECT m FROM MstPetugas m WHERE m.idpropinsi = :idpropinsi"),
    @NamedQuery(name = "MstPetugas.findByKodePos", query = "SELECT m FROM MstPetugas m WHERE m.kodePos = :kodePos"),
    @NamedQuery(name = "MstPetugas.findByGoFar", query = "SELECT m FROM MstPetugas m WHERE m.goFar = :goFar"),
    @NamedQuery(name = "MstPetugas.findByIdTelegram", query = "SELECT m FROM MstPetugas m WHERE m.idTelegram = :idTelegram")})
public class MstPetugas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "no_urut")
    private Integer noUrut;
    @Column(name = "nbm")
    private Integer nbm;
    @Column(name = "nama")
    private String nama;
    @Column(name = "unit")
    private String unit;
    @Column(name = "no_cm")
    private String noCm;
    @Column(name = "jabatan")
    private String jabatan;
    @Lob
    @Column(name = "passwd")
    private String passwd;
    @Column(name = "ket")
    private String ket;
    @Column(name = "pin")
    private String pin;
    @Column(name = "blok")
    private String blok;
    @Column(name = "sip")
    private String sip;
    @Column(name = "alamat")
    private String alamat;
    @Column(name = "telp1")
    private String telp1;
    @Column(name = "telp2")
    private String telp2;
    @Column(name = "telp3")
    private String telp3;
    @Column(name = "telp4")
    private String telp4;
    @Column(name = "kd_div")
    private String kdDiv;
    @Column(name = "tim_angg")
    private String timAngg;
    @Column(name = "blok_angg")
    private String blokAngg;
    @Column(name = "hapus")
    private String hapus;
    @Column(name = "kd_unit")
    private String kdUnit;
    @Column(name = "sex")
    private Integer sex;
    @Column(name = "tgl_lahir")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tglLahir;
    @Column(name = "tgl_menikah")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tglMenikah;
    @Column(name = "email")
    private String email;
    @Column(name = "hak_akses")
    private String hakAkses;
    @Column(name = "kd_asu")
    private String kdAsu;
    @Column(name = "rekening")
    private String rekening;
    @Column(name = "goldar")
    private String goldar;
    @Column(name = "sms")
    private String sms;
    @Column(name = "stat_kary")
    private String statKary;
    @Column(name = "mkel")
    private String mkel;
    @Column(name = "pan_tldn")
    private String panTldn;
    @Column(name = "password")
    private String password;
    @Column(name = "kdgolpangkat")
    private Integer kdgolpangkat;
    @Column(name = "idstatusnikah")
    private Integer idstatusnikah;
    @Column(name = "jumlah_anak")
    private Integer jumlahAnak;
    @Column(name = "idjabatan")
    private Integer idjabatan;
    @Column(name = "idfungsional")
    private Integer idfungsional;
    @Column(name = "idprofesi")
    private Integer idprofesi;
    @Column(name = "tempat")
    private String tempat;
    @Column(name = "idagama")
    private Integer idagama;
    @Column(name = "idkecamatan")
    private String idkecamatan;
    @Column(name = "idkabupaten")
    private String idkabupaten;
    @Column(name = "idbank")
    private Integer idbank;
    @Column(name = "nomorrekening")
    private String nomorrekening;
    @Column(name = "npwp")
    private String npwp;
    @Column(name = "namadirekening")
    private String namadirekening;
    @Column(name = "hak_anggaran")
    private Integer hakAnggaran;
    @Basic(optional = false)
    @Column(name = "id_tim")
    private int idTim;
    @Column(name = "nik")
    private String nik;
    @Column(name = "id_aplikasi")
    private Integer idAplikasi;
    @Column(name = "gelar_depan")
    private String gelarDepan;
    @Column(name = "gelar_belakang")
    private String gelarBelakang;
    @Column(name = "no_ktp")
    private String noKtp;
    @Column(name = "nama_file")
    private String namaFile;
    @Column(name = "idkalurahan")
    private String idkalurahan;
    @Column(name = "idpropinsi")
    private String idpropinsi;
    @Column(name = "kode_pos")
    private Integer kodePos;
    @Column(name = "go_far")
    private Integer goFar;
    @Column(name = "id_telegram")
    private String idTelegram;

    public MstPetugas() {
    }

    public MstPetugas(Integer noUrut) {
        this.noUrut = noUrut;
    }

    public MstPetugas(Integer noUrut, int idTim) {
        this.noUrut = noUrut;
        this.idTim = idTim;
    }

    public Integer getNoUrut() {
        return noUrut;
    }

    public void setNoUrut(Integer noUrut) {
        this.noUrut = noUrut;
    }

    public Integer getNbm() {
        return nbm;
    }

    public void setNbm(Integer nbm) {
        this.nbm = nbm;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getNoCm() {
        return noCm;
    }

    public void setNoCm(String noCm) {
        this.noCm = noCm;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getBlok() {
        return blok;
    }

    public void setBlok(String blok) {
        this.blok = blok;
    }

    public String getSip() {
        return sip;
    }

    public void setSip(String sip) {
        this.sip = sip;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelp1() {
        return telp1;
    }

    public void setTelp1(String telp1) {
        this.telp1 = telp1;
    }

    public String getTelp2() {
        return telp2;
    }

    public void setTelp2(String telp2) {
        this.telp2 = telp2;
    }

    public String getTelp3() {
        return telp3;
    }

    public void setTelp3(String telp3) {
        this.telp3 = telp3;
    }

    public String getTelp4() {
        return telp4;
    }

    public void setTelp4(String telp4) {
        this.telp4 = telp4;
    }

    public String getKdDiv() {
        return kdDiv;
    }

    public void setKdDiv(String kdDiv) {
        this.kdDiv = kdDiv;
    }

    public String getTimAngg() {
        return timAngg;
    }

    public void setTimAngg(String timAngg) {
        this.timAngg = timAngg;
    }

    public String getBlokAngg() {
        return blokAngg;
    }

    public void setBlokAngg(String blokAngg) {
        this.blokAngg = blokAngg;
    }

    public String getHapus() {
        return hapus;
    }

    public void setHapus(String hapus) {
        this.hapus = hapus;
    }

    public String getKdUnit() {
        return kdUnit;
    }

    public void setKdUnit(String kdUnit) {
        this.kdUnit = kdUnit;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }

    public Date getTglMenikah() {
        return tglMenikah;
    }

    public void setTglMenikah(Date tglMenikah) {
        this.tglMenikah = tglMenikah;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHakAkses() {
        return hakAkses;
    }

    public void setHakAkses(String hakAkses) {
        this.hakAkses = hakAkses;
    }

    public String getKdAsu() {
        return kdAsu;
    }

    public void setKdAsu(String kdAsu) {
        this.kdAsu = kdAsu;
    }

    public String getRekening() {
        return rekening;
    }

    public void setRekening(String rekening) {
        this.rekening = rekening;
    }

    public String getGoldar() {
        return goldar;
    }

    public void setGoldar(String goldar) {
        this.goldar = goldar;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    public String getStatKary() {
        return statKary;
    }

    public void setStatKary(String statKary) {
        this.statKary = statKary;
    }

    public String getMkel() {
        return mkel;
    }

    public void setMkel(String mkel) {
        this.mkel = mkel;
    }

    public String getPanTldn() {
        return panTldn;
    }

    public void setPanTldn(String panTldn) {
        this.panTldn = panTldn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getKdgolpangkat() {
        return kdgolpangkat;
    }

    public void setKdgolpangkat(Integer kdgolpangkat) {
        this.kdgolpangkat = kdgolpangkat;
    }

    public Integer getIdstatusnikah() {
        return idstatusnikah;
    }

    public void setIdstatusnikah(Integer idstatusnikah) {
        this.idstatusnikah = idstatusnikah;
    }

    public Integer getJumlahAnak() {
        return jumlahAnak;
    }

    public void setJumlahAnak(Integer jumlahAnak) {
        this.jumlahAnak = jumlahAnak;
    }

    public Integer getIdjabatan() {
        return idjabatan;
    }

    public void setIdjabatan(Integer idjabatan) {
        this.idjabatan = idjabatan;
    }

    public Integer getIdfungsional() {
        return idfungsional;
    }

    public void setIdfungsional(Integer idfungsional) {
        this.idfungsional = idfungsional;
    }

    public Integer getIdprofesi() {
        return idprofesi;
    }

    public void setIdprofesi(Integer idprofesi) {
        this.idprofesi = idprofesi;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }

    public Integer getIdagama() {
        return idagama;
    }

    public void setIdagama(Integer idagama) {
        this.idagama = idagama;
    }

    public String getIdkecamatan() {
        return idkecamatan;
    }

    public void setIdkecamatan(String idkecamatan) {
        this.idkecamatan = idkecamatan;
    }

    public String getIdkabupaten() {
        return idkabupaten;
    }

    public void setIdkabupaten(String idkabupaten) {
        this.idkabupaten = idkabupaten;
    }

    public Integer getIdbank() {
        return idbank;
    }

    public void setIdbank(Integer idbank) {
        this.idbank = idbank;
    }

    public String getNomorrekening() {
        return nomorrekening;
    }

    public void setNomorrekening(String nomorrekening) {
        this.nomorrekening = nomorrekening;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public String getNamadirekening() {
        return namadirekening;
    }

    public void setNamadirekening(String namadirekening) {
        this.namadirekening = namadirekening;
    }

    public Integer getHakAnggaran() {
        return hakAnggaran;
    }

    public void setHakAnggaran(Integer hakAnggaran) {
        this.hakAnggaran = hakAnggaran;
    }

    public int getIdTim() {
        return idTim;
    }

    public void setIdTim(int idTim) {
        this.idTim = idTim;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public Integer getIdAplikasi() {
        return idAplikasi;
    }

    public void setIdAplikasi(Integer idAplikasi) {
        this.idAplikasi = idAplikasi;
    }

    public String getGelarDepan() {
        return gelarDepan;
    }

    public void setGelarDepan(String gelarDepan) {
        this.gelarDepan = gelarDepan;
    }

    public String getGelarBelakang() {
        return gelarBelakang;
    }

    public void setGelarBelakang(String gelarBelakang) {
        this.gelarBelakang = gelarBelakang;
    }

    public String getNoKtp() {
        return noKtp;
    }

    public void setNoKtp(String noKtp) {
        this.noKtp = noKtp;
    }

    public String getNamaFile() {
        return namaFile;
    }

    public void setNamaFile(String namaFile) {
        this.namaFile = namaFile;
    }

    public String getIdkalurahan() {
        return idkalurahan;
    }

    public void setIdkalurahan(String idkalurahan) {
        this.idkalurahan = idkalurahan;
    }

    public String getIdpropinsi() {
        return idpropinsi;
    }

    public void setIdpropinsi(String idpropinsi) {
        this.idpropinsi = idpropinsi;
    }

    public Integer getKodePos() {
        return kodePos;
    }

    public void setKodePos(Integer kodePos) {
        this.kodePos = kodePos;
    }

    public Integer getGoFar() {
        return goFar;
    }

    public void setGoFar(Integer goFar) {
        this.goFar = goFar;
    }

    public String getIdTelegram() {
        return idTelegram;
    }

    public void setIdTelegram(String idTelegram) {
        this.idTelegram = idTelegram;
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
        if (!(object instanceof MstPetugas)) {
            return false;
        }
        MstPetugas other = (MstPetugas) object;
        if ((this.noUrut == null && other.noUrut != null) || (this.noUrut != null && !this.noUrut.equals(other.noUrut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.MstPetugas[ noUrut=" + noUrut + " ]";
    }
    
}
