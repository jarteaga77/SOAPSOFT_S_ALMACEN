/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soapsoft.Service;

import com.soapsoft.Dao.TbDetalleEntradaProdTermDaoImpl;
import com.soapsoft.Model.TbDetalleEntradaProdTerm;
import com.soapsoft.Model.TbEntradaProdTerminado;
import com.soapsoft.Model.TbProductoTerminado;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author PC
 */
@WebService(serviceName = "SRV_DETALLEENTRADAPRODTERM")
public class SRV_DETALLEENTRADAPRODTERM {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "fn_insertar_detalle_entrada_prod_term")
    public String fn_insertar_detalle_entrada_prod_term(@WebParam(name = "id_entrada_prod_term") int id_entrada_prod_term, 
                                            @WebParam(name = "id_producto_terminado") int id_producto_terminado,
                                            @WebParam(name = "cantidad") int cantidad,
                                            @WebParam(name = "creadoPor") String creadoPor) {
        
               
        
        TbEntradaProdTerminado tbEntradaProdTerminado = new TbEntradaProdTerminado();
        tbEntradaProdTerminado.setId(id_entrada_prod_term);
        
        TbProductoTerminado tbProductoTerminado = new TbProductoTerminado();
        tbProductoTerminado.setId(id_producto_terminado); 

        TbDetalleEntradaProdTerm obj=new TbDetalleEntradaProdTerm(
                tbEntradaProdTerminado,
                tbProductoTerminado,
                cantidad,
                creadoPor,
                new Date()
                );        
         
        try {
          
            TbDetalleEntradaProdTermDaoImpl dao=new TbDetalleEntradaProdTermDaoImpl();
            dao.create(obj);
            
            return "Se inserto con exito el detalle de la entrada del Producto Terminado ";
        
        }catch(Exception e)
        {
           throw e;
        }
       
    }
    
    @WebMethod(operationName = "fn_borrar_detalle_entrada_prod_term")
    public String fn_borrar_detalle_entrada_prod_term(@WebParam(name = "ID") int ID) {
        
        try {
          
            TbDetalleEntradaProdTermDaoImpl dao=new TbDetalleEntradaProdTermDaoImpl();
            
            TbDetalleEntradaProdTerm obj= dao.findById(ID);
            
            if(obj != null){
                dao.delete(obj);
            }else{
                return " Detalle de la entrada del Producto Terminado";
            }            
            
            return "Se Elimino con exito el detalle de la entrada del Producto Terminado ";
        
        }catch(Exception e)
        {
           throw e;
        }
    }
    
    @WebMethod(operationName = "fn_modificar_detalle_entrada_prod_term")
    public String fn_modificar_detalle_entrada_prod_term(@WebParam(name = "ID") int ID,
                                            @WebParam(name = "id_entrada_prod_term") int id_entrada_prod_term, 
                                            @WebParam(name = "id_producto_terminado") int id_producto_terminado,
                                            @WebParam(name = "cantidad") int cantidad,
                                            @WebParam(name = "modificadoPor") String modificadoPor){
         
              
        
        TbEntradaProdTerminado tbEntradaProdTerminado = new TbEntradaProdTerminado();
        tbEntradaProdTerminado.setId(id_entrada_prod_term);
        
        TbProductoTerminado tbProductoTerminado = new TbProductoTerminado();
        tbProductoTerminado.setId(id_producto_terminado); 

       
        try {
            TbDetalleEntradaProdTermDaoImpl dao=new TbDetalleEntradaProdTermDaoImpl();
            TbDetalleEntradaProdTerm obj_modificar = dao.findById(ID);
            
            if(obj_modificar != null){
                obj_modificar.setTbEntradaProdTerminado(tbEntradaProdTerminado);
                obj_modificar.setTbProductoTerminado(tbProductoTerminado);
                obj_modificar.setCantidad(cantidad);
                obj_modificar.setModificadoPor(modificadoPor);
                obj_modificar.setModificadoEn(new Date());            

                dao.update(obj_modificar);
            }else{
                return "El detalle de la entrada del Producto Terminado No existe";
            }
            

            
            return "Se Modifico con exito el detalle de la entrada del Producto Terminado ";
        
        }catch(Exception e)
        {
           throw e;
        }
       
    }
}
