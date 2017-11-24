/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soapsoft.Service;

import com.soapsoft.Dao.TbEntradaMateriaPrimaDaoImpl;
import com.soapsoft.Model.TbEntradaMateriaPrima;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author PC
 */
@WebService(serviceName = "SVR_ENTRADAMATERIAPRIMA")
public class SVR_ENTRADAMATERIAPRIMA {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

     /**
     * Web service operation
     
     * @param creadoPor
     * @param creadoEn
     * @return 
     */
  
    @WebMethod(operationName = "fn_insertar_en_mat_prima")
    public String fn_insertar_en_mat_prima(@WebParam(name = "creadoPor") String creadoPor, @WebParam(name = "creadoEn") String creadoEn) {
        //TODO write your implementation code here:
     try
        {
            
      
            TbEntradaMateriaPrima obj=new TbEntradaMateriaPrima(creadoPor, new Date());
        
        TbEntradaMateriaPrimaDaoImpl dao=new TbEntradaMateriaPrimaDaoImpl();
        dao.create(obj);
        return "Se inserto con exito la cabecera de entrada de materia prima";
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        
        return null;
    }

      /**
     * Web service operation
     
     * @param ID
     * @param modificadoPor
     * @param modificadoEn
     * @return 
     */
    @WebMethod(operationName = "fn_update_ent_mat_prima")
    public String fn_update_ent_mat_prima(@WebParam(name = "ID") int ID,@WebParam(name = "modificadoPor") String modificadoPor, @WebParam(name = "modificadoEn") String modificadoEn) {
      try
      {
        
          
          TbEntradaMateriaPrimaDaoImpl dao=new TbEntradaMateriaPrimaDaoImpl();
        
          TbEntradaMateriaPrima obj=dao.findById(ID);
       
        if(obj !=null)
        {
            
            
            obj.setModificadoPor(modificadoPor);
            obj.setModificadoEn(new Date());
            
            
            dao.update(obj);
            return "Se Actualizo Correctamente La entrada Almacen Materia Prima";
        }else
        {
            return "La Entrada de materia prima no existe";
        }
          
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
    @WebMethod(operationName = "fn_eliminar_ent_mat_prima")
    public String fn_eliminar_ent_mat_prima(@WebParam(name = "ID") int ID) {
        //TODO write your implementation code here:
       try
      {
        
        TbEntradaMateriaPrimaDaoImpl dao=new TbEntradaMateriaPrimaDaoImpl();
        
        TbEntradaMateriaPrima obj=dao.findById(ID);
       
        if(obj !=null)
        {
            dao.delete(obj);
            return "Se elimino la entrada materia prima con exito";
        }else
        {
            return "La entrada materia prima no existe";
        }
          
        }catch(Exception e)
        {
           throw e;
        }
    }
}
