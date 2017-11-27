/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soapsoft.Service;

import com.soapsoft.Dao.TbEntradaProdTerminadoDaoImpl;
import com.soapsoft.Model.TbEntradaProdTerminado;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author PC
 */
@WebService(serviceName = "SRV_ENTRADAPRODTERMINADO")
public class SRV_ENTRADAPRODTERMINADO {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "fn_insertar_entrada_prod_terminado")
    public String fn_insertar_entrada_prod_terminado(@WebParam(name = "creadorPor") String creadorPor ) {
               
       
        TbEntradaProdTerminado obj=new TbEntradaProdTerminado(
                
                creadorPor,
                new Date()
                );        
         
        try {
          
            TbEntradaProdTerminadoDaoImpl dao=new TbEntradaProdTerminadoDaoImpl();
            dao.create(obj);
            
            return "Se inserto con exito la entrega del producto terminado ";
        
        }catch(Exception e)
        {
           throw e;
        }
       
    }
    
    @WebMethod(operationName = "fn_borrar_entrada_prod_terminado")
    public String fn_borrar_entrada_prod_terminado(@WebParam(name = "ID") int ID) {
        
        try {
          
            TbEntradaProdTerminadoDaoImpl dao=new TbEntradaProdTerminadoDaoImpl();
            
            TbEntradaProdTerminado obj= dao.findById(ID);
            
            if(obj != null){
                dao.delete(obj);
            }else{
                return "La entrega del producto terminado no existe";
            }            
            
            return "Se Elimino con exito la entrega del producto terminado ";
        
        }catch(Exception e)
        {
           throw e;
        }
    }
    
    @WebMethod(operationName = "fn_modificar_entrada_prod_terminado")
    public String fn_modificar_entrada_prod_terminado(@WebParam(name = "ID") int ID,
                                            @WebParam(name = "creadorPor") String creadorPor, 
                                            @WebParam(name = "modificadoPor") String modificadoPor){
               
       
       
        try {
            TbEntradaProdTerminadoDaoImpl dao=new TbEntradaProdTerminadoDaoImpl();
            TbEntradaProdTerminado obj_modificar = dao.findById(ID);
            
            if(obj_modificar != null){
                obj_modificar.setCreadorPor(creadorPor);
                obj_modificar.setModificadoPor(modificadoPor);
                obj_modificar.setModificadoEn(new Date());            

                dao.update(obj_modificar);
            }else{
                return "La entrega del producto terminado No existe";
            }
            

            
            return "Se Modifico con exito la entrega del producto terminado ";
        
        }catch(Exception e)
        {
           throw e;
        }
       
    }

}
