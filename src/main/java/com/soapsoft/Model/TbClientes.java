package com.soapsoft.Model;
// Generated 25/11/2017 12:56:23 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * TbClientes generated by hbm2java
 */
@Entity
@Table(name="tb_clientes"
    ,catalog="soap_soft"
    , uniqueConstraints = @UniqueConstraint(columnNames="nit") 
)
public class TbClientes  implements java.io.Serializable {


     private Integer id;
     private String nit;
     private String razonSocial;
     private String telefono;
     private String celular;
     private int contacto;
     private boolean estado;
     private String direccion;
     private String creadoPor;
     private Date creadoEn;
     private String modificadoPor;
     private Date modificadoEn;
     private Set tbFacturaVentas = new HashSet(0);

    public TbClientes() {
    }

	
    public TbClientes(String nit, String razonSocial, String telefono, String celular, int contacto, boolean estado, String direccion, String creadoPor, Date creadoEn) {
        this.nit = nit;
        this.razonSocial = razonSocial;
        this.telefono = telefono;
        this.celular = celular;
        this.contacto = contacto;
        this.estado = estado;
        this.direccion = direccion;
        this.creadoPor = creadoPor;
        this.creadoEn = creadoEn;
    }
    public TbClientes(String nit, String razonSocial, String telefono, String celular, int contacto, boolean estado, String direccion, String creadoPor, Date creadoEn, String modificadoPor, Date modificadoEn, Set tbFacturaVentas) {
       this.nit = nit;
       this.razonSocial = razonSocial;
       this.telefono = telefono;
       this.celular = celular;
       this.contacto = contacto;
       this.estado = estado;
       this.direccion = direccion;
       this.creadoPor = creadoPor;
       this.creadoEn = creadoEn;
       this.modificadoPor = modificadoPor;
       this.modificadoEn = modificadoEn;
       this.tbFacturaVentas = tbFacturaVentas;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ID", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="nit", unique=true, nullable=false, length=100)
    public String getNit() {
        return this.nit;
    }
    
    public void setNit(String nit) {
        this.nit = nit;
    }

    
    @Column(name="razon_social", nullable=false, length=100)
    public String getRazonSocial() {
        return this.razonSocial;
    }
    
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    
    @Column(name="telefono", nullable=false, length=10)
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    @Column(name="celular", nullable=false, length=10)
    public String getCelular() {
        return this.celular;
    }
    
    public void setCelular(String celular) {
        this.celular = celular;
    }

    
    @Column(name="contacto", nullable=false)
    public int getContacto() {
        return this.contacto;
    }
    
    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    
    @Column(name="estado", nullable=false)
    public boolean isEstado() {
        return this.estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
    @Column(name="direccion", nullable=false, length=100)
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    @Column(name="creadoPor", nullable=false, length=50)
    public String getCreadoPor() {
        return this.creadoPor;
    }
    
    public void setCreadoPor(String creadoPor) {
        this.creadoPor = creadoPor;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="creadoEn", nullable=false, length=19)
    public Date getCreadoEn() {
        return this.creadoEn;
    }
    
    public void setCreadoEn(Date creadoEn) {
        this.creadoEn = creadoEn;
    }

    
    @Column(name="modificadoPor", length=50)
    public String getModificadoPor() {
        return this.modificadoPor;
    }
    
    public void setModificadoPor(String modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="modificadoEn", length=19)
    public Date getModificadoEn() {
        return this.modificadoEn;
    }
    
    public void setModificadoEn(Date modificadoEn) {
        this.modificadoEn = modificadoEn;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tbClientes")
    public Set getTbFacturaVentas() {
        return this.tbFacturaVentas;
    }
    
    public void setTbFacturaVentas(Set tbFacturaVentas) {
        this.tbFacturaVentas = tbFacturaVentas;
    }




}


