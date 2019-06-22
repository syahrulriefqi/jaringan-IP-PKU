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
@Table(name = "v_login")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VLogin.findAll", query = "SELECT v FROM VLogin v"),
    @NamedQuery(name = "VLogin.findByNoUrut", query = "SELECT v FROM VLogin v WHERE v.noUrut = :noUrut"),
    @NamedQuery(name = "VLogin.findByNbm", query = "SELECT v FROM VLogin v WHERE v.nbm = :nbm"),
    @NamedQuery(name = "VLogin.findByNama", query = "SELECT v FROM VLogin v WHERE v.nama = :nama"),
    @NamedQuery(name = "VLogin.findByPassword", query = "SELECT v FROM VLogin v WHERE v.password = :password")})
public class VLogin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "no_urut")
    @Id
    private int noUrut;
    @Column(name = "nbm")
    private Integer nbm;
    @Column(name = "nama")
    private String nama;
    @Column(name = "PASSWORD")
    private String password;

    public VLogin() {
    }

    public int getNoUrut() {
        return noUrut;
    }

    public void setNoUrut(int noUrut) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
