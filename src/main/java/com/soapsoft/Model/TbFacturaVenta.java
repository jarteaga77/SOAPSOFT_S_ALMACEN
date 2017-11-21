package com.soapsoft.Model;
// Generated 21/11/2017 05:00:32 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TbFacturaVenta generated by hbm2java
 */
@Entity
@Table(name="tb_factura_venta"
    ,catalog="soap_soft"
)
public class TbFacturaVenta  implements java.io.Serializable {


     private Integer id;
     private TbClientes tbClientes;
     private String observacion;
     private String creadoPor;
     private Date creadoEn;
     private Date modificadoPor;
     private Date modificadoEn;
     private Set tbDetalleFacturaVentas = new HashSet(0);

    public TbFacturaVenta() {
    }

	
    public TbFacturaVenta(TbClientes tbClientes, String observacion, String creadoPor, Date creadoEn) {
        this.tbClientes = tbClientes;
        this.observacion = observacion;
        this.creadoPor = creadoPor;
        this.creadoEn = creadoEn;
    }
    public TbFacturaVenta(TbClientes tbClientes, String observacion, String creadoPor, Date creadoEn, Date modificadoPor, Date modificadoEn, Set tbDetalleFacturaVentas) {
       this.tbClientes = tbClientes;
       this.observacion = observacion;
       this.creadoPor = creadoPor;
       this.creadoEn = creadoEn;
       this.modificadoPor = modificadoPor;
       this.modificadoEn = modificadoEn;
       this.tbDetalleFacturaVentas = tbDetalleFacturaVentas;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ID", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_cliente", nullable=false)
    public TbClientes getTbClientes() {
        return this.tbClientes;
    }
    
    public void setTbClientes(TbClientes tbClientes) {
        this.tbClientes = tbClientes;
    }

    
    @Column(name="observacion", nullable=false, length=200)
    public String getObservacion() {
        return this.observacion;
    }
    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="modificadoPor", length=19)
    public Date getModificadoPor() {
        return this.modificadoPor;
    }
    
    public void setModificadoPor(Date modificadoPor) {
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="tbFacturaVenta")
    public Set getTbDetalleFacturaVentas() {
        return this.tbDetalleFacturaVentas;
    }
    
    public void setTbDetalleFacturaVentas(Set tbDetalleFacturaVentas) {
        this.tbDetalleFacturaVentas = tbDetalleFacturaVentas;
    }




}


