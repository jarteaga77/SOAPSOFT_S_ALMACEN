/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soapsoft.Service;

import com.soapsoft.Dao.TbMateriaPrimaDaoImpl;
import com.soapsoft.Model.TbMateriaPrima;
import com.soapsoft.Model.TbUbicacion;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author PC
 */
@WebService(serviceName = "SVR_MATERIAPRIMA")
public class SVR_MATERIAPRIMA {


  
    @WebMethod(operationName = "fn_insertar_materia_prima")
    public String fn_insertar_materia_prima(@WebParam(name = "referencia") String referencia, 
                                            @WebParam(name = "descripcion") String descripcion,
                                            @WebParam(name = "um") String um,
                                            @WebParam(name = "stock") float stock,
                                            @WebParam(name = "id_ubicacion") int id_ubicacion,
                                            @WebParam(name = "creadorPor") String creadorPor) {
               
        TbUbicacion tbUbicacion = new TbUbicacion();
        tbUbicacion.setId(id_ubicacion);

        TbMateriaPrima obj=new TbMateriaPrima(
                tbUbicacion,
                referencia,
                descripcion,
                um,
                stock,
                creadorPor,
                new Date()
                );        
         
        try {
          
            TbMateriaPrimaDaoImpl dao=new TbMateriaPrimaDaoImpl();
            dao.create(obj);
            
            return "Se inserto con exito la materia prima ";
        
        }catch(Exception e)
        {
           throw e;
        }
       
    }

    /**
     * Web service operation
     * @param ID
     * @return 
     */
    @WebMethod(operationName = "fn_borrar_materia_prima")
    public String fn_borrar_materia_prima(@WebParam(name = "ID") int ID) {
        
        try {
          
            TbMateriaPrimaDaoImpl dao=new TbMateriaPrimaDaoImpl();
            
            TbMateriaPrima obj= dao.findById(ID);
            
            if(obj != null){
                dao.delete(obj);
            }else{
                return "La materia prima no existe";
            }            
            
            return "Se Elimino con exito la materia prima ";
        
        }catch(Exception e)
        {
           throw e;
        }
    }
 
    
    @WebMethod(operationName = "fn_modificar_materia_prima")
    public String fn_modificar_materia_prima(@WebParam(name = "ID") int ID,
                                            @WebParam(name = "referencia") String referencia, 
                                            @WebParam(name = "descripcion") String descripcion,
                                            @WebParam(name = "um") String um,
                                            @WebParam(name = "stock") float stock,
                                            @WebParam(name = "id_ubicacion") int id_ubicacion,
                                            @WebParam(name = "modificadoPor") String modificadoPor){
               
        TbUbicacion tbUbicacion = new TbUbicacion();
        tbUbicacion.setId(id_ubicacion);

       
        try {
            TbMateriaPrimaDaoImpl dao=new TbMateriaPrimaDaoImpl();
            TbMateriaPrima obj_modificar = dao.findById(ID);
            
            if(obj_modificar != null){
                obj_modificar.setTbUbicacion(tbUbicacion);
                obj_modificar.setReferencia(referencia);
                obj_modificar.setDescripcion(descripcion);
                obj_modificar.setUm(um);
                obj_modificar.setStock(stock);
                obj_modificar.setModificadoPor(modificadoPor);
                obj_modificar.setModificadoEn(new Date());            

                dao.update(obj_modificar);
            }else{
                return "La materia prima No existe";
            }
            

            
            return "Se Modifico con exito la materia prima ";
        
        }catch(Exception e)
        {
           throw e;
        }
       
    }
}
