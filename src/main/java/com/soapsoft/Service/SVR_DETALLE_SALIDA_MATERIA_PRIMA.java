/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soapsoft.Service;

import com.soapsoft.Dao.TbDetalleSalidaMateriaPrimaDaoImpl;
import com.soapsoft.Model.TbDetalleSalidaMateriaPrima;
import com.soapsoft.Model.TbMateriaPrima;
import com.soapsoft.Model.TbSalidaMateriaPrima;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author PC
 */
@WebService(serviceName = "SVR_DETALLE_SALIDA_MATERIA_PRIMA")
public class SVR_DETALLE_SALIDA_MATERIA_PRIMA {

   
   @WebMethod(operationName = "fn_insertar_detalleSMP")
    public String fn_insertar_detalleSMP(@WebParam(name = "id_salida_materia_prima") int id_salida_materia_prima, 
                                         @WebParam(name = "id_materia_prima") int id_materia_prima, 
                                         @WebParam(name = "cantidad") int cantidad, 
                                         @WebParam(name = "creadoPor") String creadoPor) {
        
        TbSalidaMateriaPrima tbSalidaMateriaPrima=new TbSalidaMateriaPrima();
        tbSalidaMateriaPrima.setId(id_salida_materia_prima);
        
        TbMateriaPrima tbMateriaPrima=new TbMateriaPrima();
        tbMateriaPrima.setId(id_materia_prima);
        
        TbDetalleSalidaMateriaPrima obj=new TbDetalleSalidaMateriaPrima(tbMateriaPrima, tbSalidaMateriaPrima, cantidad, creadoPor,new Date());

        try {
            TbDetalleSalidaMateriaPrimaDaoImpl dao=new TbDetalleSalidaMateriaPrimaDaoImpl();
            dao.create(obj);
            return "La insercion fue exitosa";
        } catch (Exception e) {
             throw e;
        }

        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "fn_delete_dtlle_salida_MP")
    public String fn_delete_dtlle_salida_MP(@WebParam(name = "ID") int ID) {
        //TODO write your implementation code here:
       try
      {
        
        TbDetalleSalidaMateriaPrimaDaoImpl dao=new TbDetalleSalidaMateriaPrimaDaoImpl();
        
        TbDetalleSalidaMateriaPrima obj=dao.findById(ID);
       
        if(obj !=null)
        {
            dao.delete(obj);
            return "Se elimino la linea de detalle";
        }else
        {
            return "La linea de detalle no existe";
        }
          
        }catch(Exception e)
        {
           throw e;
        }
     
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "fn_update_dtlle_salida_materia_prima")
    public String fn_update_dtlle_salida_materia_prima(@WebParam(name = "ID") int ID,@WebParam(name = "id_materia_prima") int id_materia_prima, @WebParam(name = "cantidad") int cantidad, @WebParam(name = "modificadoPor") String modificadoPor) {
        
        
        
        TbMateriaPrima objMateriaPrima= new TbMateriaPrima();
        objMateriaPrima.setId(id_materia_prima);
        
          try {
            TbDetalleSalidaMateriaPrimaDaoImpl dao=new TbDetalleSalidaMateriaPrimaDaoImpl();
            TbDetalleSalidaMateriaPrima obj_modificar = dao.findById(ID);
        
        if(obj_modificar != null){
                obj_modificar.setTbMateriaPrima(objMateriaPrima);
                obj_modificar.setCantidad(cantidad);
                obj_modificar.setModificadoPor(modificadoPor);
                obj_modificar.setModificadoEn(new Date());            

                dao.update(obj_modificar);
                
                return "Se Modifico con exito la linea de detalle";
            }else{
                return "Se actualizo la linea de detalle";
            }
            
        
        }catch(Exception e)
        {
           throw e;
        }

        
        
        
        
        
        
}
}
