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
    }

