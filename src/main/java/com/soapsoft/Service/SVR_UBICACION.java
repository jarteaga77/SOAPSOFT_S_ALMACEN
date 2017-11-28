/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soapsoft.Service;

import com.soapsoft.Dao.TbUbicacionDaoImpl;
import com.soapsoft.Model.TbUbicacion;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author PC
 */
@WebService(serviceName = "SVR_UBICACION")
public class SVR_UBICACION {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "fn_insertar")
    public String fn_insertar(@WebParam(name = "descripcion") String descripcion, @WebParam(name = "creadoPor") String creadoPor) {
        //TODO write your implementation code here:
        
        try
        {
            
      
        TbUbicacion obj=new TbUbicacion(descripcion, creadoPor, new Date());
        
        TbUbicacionDaoImpl dao=new TbUbicacionDaoImpl();
        dao.create(obj);
        return "Se inserto con exito la ubicación del Almacen";
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "fn_eliminar")
    public String fn_eliminar(@WebParam(name = "ID") int ID) {
        //TODO write your implementation code here:
      try
      {
        
        TbUbicacionDaoImpl dao=new TbUbicacionDaoImpl();
        
        TbUbicacion obj=dao.findById(ID);
       
        if(obj !=null)
        {
            dao.delete(obj);
            return "Se elimino la ubicación";
        }else
        {
            return "La Ubicación no existe";
        }
          
        }catch(Exception e)
        {
           throw e;
        }
        
        
    }
    
     @WebMethod(operationName = "fn_modificar")
    public String fn_modificar(@WebParam(name = "ID") int ID,@WebParam(name = "descripcion") String descripcion, @WebParam(name = "modificadoPor") String modificadoPor) {
        //TODO write your implementation code here:
      try
      {
        
          
        TbUbicacionDaoImpl dao=new TbUbicacionDaoImpl();
        
        TbUbicacion obj=dao.findById(ID);
       
        if(obj !=null)
        {
            
            obj.setDescripcion(descripcion);
            obj.setModificadoPor(modificadoPor);
            obj.setModificadoEn(new Date());
            
            
            dao.update(obj);
            return "Se Actualizo Correctamente";
        }else
        {
            return "La Ubicación no existe";
        }
          
        }catch(Exception e)
        {
           throw e;
        }
        
        
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "consultar_todos_ubicacion")
    public List<TbUbicacion> consultar_todos_ubicacion() {
          TbUbicacionDaoImpl dao=new TbUbicacionDaoImpl();  
        
         return dao.fn_consultar_todos_ub();
    }

    
}
