package com.soapsoft.Model;
// Generated 21/11/2017 05:00:32 AM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TbNotificacionesAlmacen generated by hbm2java
 */
@Entity
@Table(name="tb_notificaciones_almacen"
    ,catalog="soap_soft"
)
public class TbNotificacionesAlmacen  implements java.io.Serializable {


     private Integer id;
     private String tipoNotificacion;
     private String descripcion;
     private String creadoPor;
     private Date creadoEn;
     private String modificadoPor;
     private Date modificadoEn;
     private boolean estado;

    public TbNotificacionesAlmacen() {
    }

	
    public TbNotificacionesAlmacen(String tipoNotificacion, String descripcion, String creadoPor, Date creadoEn, boolean estado) {
        this.tipoNotificacion = tipoNotificacion;
        this.descripcion = descripcion;
        this.creadoPor = creadoPor;
        this.creadoEn = creadoEn;
        this.estado = estado;
    }
    public TbNotificacionesAlmacen(String tipoNotificacion, String descripcion, String creadoPor, Date creadoEn, String modificadoPor, Date modificadoEn, boolean estado) {
       this.tipoNotificacion = tipoNotificacion;
       this.descripcion = descripcion;
       this.creadoPor = creadoPor;
       this.creadoEn = creadoEn;
       this.modificadoPor = modificadoPor;
       this.modificadoEn = modificadoEn;
       this.estado = estado;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ID", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="tipo_notificacion", nullable=false, length=50)
    public String getTipoNotificacion() {
        return this.tipoNotificacion;
    }
    
    public void setTipoNotificacion(String tipoNotificacion) {
        this.tipoNotificacion = tipoNotificacion;
    }

    
    @Column(name="descripcion", nullable=false, length=200)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    
    @Column(name="estado", nullable=false)
    public boolean isEstado() {
        return this.estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }




}


