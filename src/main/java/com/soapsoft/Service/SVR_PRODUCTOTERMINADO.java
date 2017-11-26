/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soapsoft.Service;

import com.soapsoft.Dao.TbProductoTerminadoDaoImpl;
import com.soapsoft.Model.TbProductoTerminado;
import com.soapsoft.Model.TbUbicacion;
import com.soapsoft.util.Resultado;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author PC
 */
@WebService(serviceName = "SVR_PRODUCTOTERMINADO")
public class SVR_PRODUCTOTERMINADO {

    
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
    @WebMethod(operationName = "fn_insertar_productoterminado")
    public String fn_insertar_productoterminado(@WebParam(name = "referencia") String referencia, 
                                                @WebParam(name = "descripcion") String descripcion,
                                                @WebParam(name = "um") String um,
                                                @WebParam(name = "stock") int stock,
                                                @WebParam(name = "id_ubicacion") int id_ubicacion,
                                                @WebParam(name = "creadorPor") String creadorPor) {
        //TODO write your implementation code here:
        
        TbUbicacion obj=new TbUbicacion();
        obj.setId(id_ubicacion);
        
        TbProductoTerminado obj2=new TbProductoTerminado(obj,referencia,descripcion, um, stock, creadorPor, new Date());
        
        try
        {
        TbProductoTerminadoDaoImpl dao=new TbProductoTerminadoDaoImpl();
        dao.create(obj2);
        return "Se inserto con exito el producto terminado";
        }catch(Exception e)
        {
            System.out.println(e);
        }
       
        return null;
    }
    
   
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "fn_eliminar_productoterminado")
    public String fn_eliminar_productoterminado(@WebParam(name = "ID") int ID) {
        //TODO write your implementation code here:
      try
      {
        TbProductoTerminadoDaoImpl dao=new TbProductoTerminadoDaoImpl();
               
        TbProductoTerminado obj=dao.findById(ID);
       
        if(obj !=null)
        {
            dao.delete(obj);
            return "Se elimino el registro";
        }else
        {
            return "El registro no existe";
        }
          
        }catch(Exception e)
        {
           throw e;
        }

    }  
  
    
     /**
     * Web service operation
     */
    @WebMethod(operationName = "fn_modificar_productoterminado")
    public String fn_modificar_productoterminado(@WebParam(name = "ID") int ID,
                                                @WebParam(name = "referencia") String referencia, 
                                                @WebParam(name = "descripcion") String descripcion,
                                                @WebParam(name = "um") String um,
                                                @WebParam(name = "stock") int stock,
                                                @WebParam(name = "modificadoPor") String modificadoPor) {
        //TODO write your implementation code here:
      try
      {
        TbProductoTerminadoDaoImpl dao=new TbProductoTerminadoDaoImpl();  
        TbProductoTerminado obj=dao.findById(ID);
       
        if(obj !=null)
        {
            obj.setReferencia(referencia);
            obj.setDescripcion(descripcion);
            obj.setUm(um);
            obj.setStock(stock);
            obj.setModificadoPor(modificadoPor);
            obj.setModificadoEn(new Date());
            
            dao.update(obj);
            
            return "Se Actualizo Correctamente";
        }else
        {
            return "El registro no exite";
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
    @WebMethod(operationName = "consultar_productos")
    public List<TbProductoTerminado> consultar_productos() {
        
        
        TbProductoTerminadoDaoImpl dao=new TbProductoTerminadoDaoImpl();  
        
         return dao.fn_consultar_todos();
         
 
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "validar_stock_prod_terminado")
    public Resultado validar_stock_prod_terminado(@WebParam(name = "ID") int ID, @WebParam(name = "cantidad") int cantidad) {
        
        int stock=0;
        TbProductoTerminadoDaoImpl dao= new TbProductoTerminadoDaoImpl();
        TbProductoTerminado obj=dao.findById(ID);
        Resultado rest=new Resultado();
        boolean estado=false;
        String resultado="";
        
        if(obj !=null)
        {
            stock=obj.getStock();
            
            if(stock==0)
            {
                estado=false;
                resultado="El Stock del producto esta en cero";
                rest.setEstado(String.valueOf(estado));
                rest.setResultado(resultado);
                return rest;
                
            }
            else if( stock < cantidad)
            {
                estado=false;
                resultado="El Stock es menor que la cantidad solicitada Stock:" +  stock;
                rest.setEstado(String.valueOf(estado));
                rest.setResultado(resultado);
                return rest;
            }
            else if(stock > cantidad)
            {
                estado=true;
                resultado="Petición Aceptada";
                rest.setEstado(String.valueOf(estado));
                rest.setResultado(resultado);
                return rest;
            }
        }else
        
                estado=false;
                resultado="El producto no existe";
                rest.setEstado(String.valueOf(estado));
                rest.setResultado(resultado);
                return rest;
        
        
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "modificar_stock_prod_terminado")
    public String modificar_stock_prod_terminado(@WebParam(name = "ID") int ID, @WebParam(name = "cantidad") int cantidad) {
        
        int stock=0;
        int nuevostock=0;
        TbProductoTerminadoDaoImpl dao= new TbProductoTerminadoDaoImpl();
        TbProductoTerminado obj=dao.findById(ID);
        
        
        
        
        if(obj !=null)
        {
            stock=obj.getStock();
            nuevostock=stock - cantidad;
            
            obj.setStock(nuevostock);
            dao.update(obj);
            
            return "Stock Actualizado";
            
        }
        
        return null;
    }
    
}
