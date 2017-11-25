package com.soapsoft.Model;
// Generated 25/11/2017 12:56:23 AM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TbDetalleFacturaVenta generated by hbm2java
 */
@Entity
@Table(name="tb_detalle_factura_venta"
    ,catalog="soap_soft"
)
public class TbDetalleFacturaVenta  implements java.io.Serializable {


     private Integer id;
     private TbFacturaVenta tbFacturaVenta;
     private TbProductoTerminado tbProductoTerminado;
     private int cantidad;
     private int vlorIva;
     private String tipoIva;
     private int vlorUnitario;
     private int vlorTotal;
     private String creadoPor;
     private Date creadoEn;
     private String modificadoPor;
     private Date modificadoEn;

    public TbDetalleFacturaVenta() {
    }

	
    public TbDetalleFacturaVenta(TbFacturaVenta tbFacturaVenta, TbProductoTerminado tbProductoTerminado, int cantidad, int vlorIva, String tipoIva, int vlorUnitario, int vlorTotal, String creadoPor, Date creadoEn) {
        this.tbFacturaVenta = tbFacturaVenta;
        this.tbProductoTerminado = tbProductoTerminado;
        this.cantidad = cantidad;
        this.vlorIva = vlorIva;
        this.tipoIva = tipoIva;
        this.vlorUnitario = vlorUnitario;
        this.vlorTotal = vlorTotal;
        this.creadoPor = creadoPor;
        this.creadoEn = creadoEn;
    }
    public TbDetalleFacturaVenta(TbFacturaVenta tbFacturaVenta, TbProductoTerminado tbProductoTerminado, int cantidad, int vlorIva, String tipoIva, int vlorUnitario, int vlorTotal, String creadoPor, Date creadoEn, String modificadoPor, Date modificadoEn) {
       this.tbFacturaVenta = tbFacturaVenta;
       this.tbProductoTerminado = tbProductoTerminado;
       this.cantidad = cantidad;
       this.vlorIva = vlorIva;
       this.tipoIva = tipoIva;
       this.vlorUnitario = vlorUnitario;
       this.vlorTotal = vlorTotal;
       this.creadoPor = creadoPor;
       this.creadoEn = creadoEn;
       this.modificadoPor = modificadoPor;
       this.modificadoEn = modificadoEn;
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
    @JoinColumn(name="id_factura_venta", nullable=false)
    public TbFacturaVenta getTbFacturaVenta() {
        return this.tbFacturaVenta;
    }
    
    public void setTbFacturaVenta(TbFacturaVenta tbFacturaVenta) {
        this.tbFacturaVenta = tbFacturaVenta;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_producto", nullable=false)
    public TbProductoTerminado getTbProductoTerminado() {
        return this.tbProductoTerminado;
    }
    
    public void setTbProductoTerminado(TbProductoTerminado tbProductoTerminado) {
        this.tbProductoTerminado = tbProductoTerminado;
    }

    
    @Column(name="cantidad", nullable=false)
    public int getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    @Column(name="vlor_iva", nullable=false)
    public int getVlorIva() {
        return this.vlorIva;
    }
    
    public void setVlorIva(int vlorIva) {
        this.vlorIva = vlorIva;
    }

    
    @Column(name="tipo_iva", nullable=false, length=10)
    public String getTipoIva() {
        return this.tipoIva;
    }
    
    public void setTipoIva(String tipoIva) {
        this.tipoIva = tipoIva;
    }

    
    @Column(name="vlor_unitario", nullable=false)
    public int getVlorUnitario() {
        return this.vlorUnitario;
    }
    
    public void setVlorUnitario(int vlorUnitario) {
        this.vlorUnitario = vlorUnitario;
    }

    
    @Column(name="vlor_total", nullable=false)
    public int getVlorTotal() {
        return this.vlorTotal;
    }
    
    public void setVlorTotal(int vlorTotal) {
        this.vlorTotal = vlorTotal;
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




}


