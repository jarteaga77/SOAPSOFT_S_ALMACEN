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

/**
 * TbSalidaProdTerminado generated by hbm2java
 */
@Entity
@Table(name="tb_salida_prod_terminado"
    ,catalog="soap_soft"
)
public class TbSalidaProdTerminado  implements java.io.Serializable {


     private Integer id;
     private String despachadorPara;
     private String observaciones;
     private String creadoPor;
     private Date creadoEn;
     private String modificadoPor;
     private Date modificadoEn;
     private Set tbDetalleSalidaProdTerms = new HashSet(0);

    public TbSalidaProdTerminado() {
    }

	
    public TbSalidaProdTerminado(String despachadorPara, String observaciones, String creadoPor, Date creadoEn) {
        this.despachadorPara = despachadorPara;
        this.observaciones = observaciones;
        this.creadoPor = creadoPor;
        this.creadoEn = creadoEn;
    }
    public TbSalidaProdTerminado(String despachadorPara, String observaciones, String creadoPor, Date creadoEn, String modificadoPor, Date modificadoEn, Set tbDetalleSalidaProdTerms) {
       this.despachadorPara = despachadorPara;
       this.observaciones = observaciones;
       this.creadoPor = creadoPor;
       this.creadoEn = creadoEn;
       this.modificadoPor = modificadoPor;
       this.modificadoEn = modificadoEn;
       this.tbDetalleSalidaProdTerms = tbDetalleSalidaProdTerms;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ID", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="despachadorPara", nullable=false, length=100)
    public String getDespachadorPara() {
        return this.despachadorPara;
    }
    
    public void setDespachadorPara(String despachadorPara) {
        this.despachadorPara = despachadorPara;
    }

    
    @Column(name="observaciones", nullable=false, length=100)
    public String getObservaciones() {
        return this.observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="tbSalidaProdTerminado")
    public Set getTbDetalleSalidaProdTerms() {
        return this.tbDetalleSalidaProdTerms;
    }
    
    public void setTbDetalleSalidaProdTerms(Set tbDetalleSalidaProdTerms) {
        this.tbDetalleSalidaProdTerms = tbDetalleSalidaProdTerms;
    }




}


