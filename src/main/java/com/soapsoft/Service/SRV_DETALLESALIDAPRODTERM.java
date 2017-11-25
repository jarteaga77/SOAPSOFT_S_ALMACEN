/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soapsoft.Service;

import com.soapsoft.Dao.TbDetalleSalidaProdTermDaoImpl;
import com.soapsoft.Model.TbDetalleSalidaProdTerm;
import com.soapsoft.Model.TbProductoTerminado;
import com.soapsoft.Model.TbSalidaProdTerminado;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author PC
 */
@WebService(serviceName = "SRV_DETALLESALIDAPRODTERM")
public class SRV_DETALLESALIDAPRODTERM {

    @WebMethod(operationName = "fn_insertar_detalle_salida_prod_term")
    public String fn_insertar_detalle_salida_prod_term(@WebParam(name = "id_producto_terminado") int id_producto_terminado, 
                                            @WebParam(name = "id_salida_prod_terminado") int id_salida_prod_terminado,
                                            @WebParam(name = "cantidad") int cantidad,
                                            @WebParam(name = "creadoPor") String creadoPor) {
        
        TbProductoTerminado tbProductoTerminado = new TbProductoTerminado();
        tbProductoTerminado.setId(id_producto_terminado);        
        
        TbSalidaProdTerminado tbSalidaProdTerminado = new TbSalidaProdTerminado();
        tbSalidaProdTerminado.setId(id_salida_prod_terminado);

        TbDetalleSalidaProdTerm obj=new TbDetalleSalidaProdTerm(
                tbProductoTerminado,
                tbSalidaProdTerminado,
                cantidad,
                creadoPor,
                new Date()
                );        
         
        try {
          
            TbDetalleSalidaProdTermDaoImpl dao=new TbDetalleSalidaProdTermDaoImpl();
            dao.create(obj);
            
            return "Se inserto con exito la Salida del Producto Terminado ";
        
        }catch(Exception e)
        {
           throw e;
        }
       
    }
    
    @WebMethod(operationName = "fn_borrar_detalle_salida_prod_term")
    public String fn_borrar_detalle_salida_prod_term(@WebParam(name = "ID") int ID) {
        
        try {
          
            TbDetalleSalidaProdTermDaoImpl dao=new TbDetalleSalidaProdTermDaoImpl();
            
            TbDetalleSalidaProdTerm obj= dao.findById(ID);
            
            if(obj != null){
                dao.delete(obj);
            }else{
                return "La Salida del Producto Terminado no existe";
            }            
            
            return "Se Elimino con exito La Salida del Producto Terminado ";
        
        }catch(Exception e)
        {
           throw e;
        }
    }
    
    
    @WebMethod(operationName = "fn_modificar_detalle_salida_prod_term")
    public String fn_modificar_detalle_salida_prod_term(@WebParam(name = "ID") int ID,
                                            @WebParam(name = "id_producto_terminado") int id_producto_terminado, 
                                            @WebParam(name = "id_salida_prod_terminado") int id_salida_prod_terminado,
                                            @WebParam(name = "cantidad") int cantidad,
                                            @WebParam(name = "modificadoPor") String modificadoPor){
         
        TbProductoTerminado tbProductoTerminado = new TbProductoTerminado();
        tbProductoTerminado.setId(id_producto_terminado);        
        
        TbSalidaProdTerminado tbSalidaProdTerminado = new TbSalidaProdTerminado();
        tbSalidaProdTerminado.setId(id_salida_prod_terminado);

       
        try {
            TbDetalleSalidaProdTermDaoImpl dao=new TbDetalleSalidaProdTermDaoImpl();
            TbDetalleSalidaProdTerm obj_modificar = dao.findById(ID);
            
            if(obj_modificar != null){
                obj_modificar.setTbProductoTerminado(tbProductoTerminado);
                obj_modificar.setTbSalidaProdTerminado(tbSalidaProdTerminado);
                obj_modificar.setCantidad(cantidad);
                obj_modificar.setModificadoPor(modificadoPor);
                obj_modificar.setModificadoEn(new Date());            

                dao.update(obj_modificar);
            }else{
                return "La materia prima No existe";
            }
            

            
            return "Se Modifico con exito La Salida del Producto Terminado ";
        
        }catch(Exception e)
        {
           throw e;
        }
       
    }
}
