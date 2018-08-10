/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author Ignatius
 */
@Entity
@Table(name = "USERMANAGEMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usermanagement.findAll", query = "SELECT u FROM Usermanagement u")
    , @NamedQuery(name = "Usermanagement.findById", query = "SELECT u FROM Usermanagement u WHERE u.id = :id")
    , @NamedQuery(name = "Usermanagement.findByUsername", query = "SELECT u FROM Usermanagement u WHERE u.username = :username")
    , @NamedQuery(name = "Usermanagement.findByPassword", query = "SELECT u FROM Usermanagement u WHERE u.password = :password")
    , @NamedQuery(name = "Usermanagement.findByAccessuser", query = "SELECT u FROM Usermanagement u WHERE u.akses = :akses")})
public class Usermanagement implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "AKSES")
    private String akses;

    public Usermanagement() {
    }

    public Usermanagement(BigDecimal id) {
        this.id = id;
    }

    public Usermanagement(BigDecimal id, String username, String password, String akses) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.akses = akses;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccessuser() {
        return akses;
    }

    public void setAccessuser(String akses) {
        this.akses = akses;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usermanagement)) {
            return false;
        }
        Usermanagement other = (Usermanagement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Usermanagement[ id=" + id + " ]";
    }
    
}
