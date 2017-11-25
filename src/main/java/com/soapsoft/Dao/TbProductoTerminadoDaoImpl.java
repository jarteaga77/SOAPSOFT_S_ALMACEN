/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soapsoft.Dao;

import com.soapsoft.Model.TbClientes;
import com.soapsoft.Model.TbProductoTerminado;
import com.soapsoft.util.LlaveValor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class TbProductoTerminadoDaoImpl  extends GenericDaoImpl<TbProductoTerminado,Integer> implements TbProductoTerminadoDao {
   
          
       public List<TbProductoTerminado>  fn_consultar_todos(){
          
            List<TbProductoTerminado> resultado = null;

            try{ 

                String query = "SELECT Id, descripcion as Descripcion, stock as Stock  FROM  tb_producto_terminado ";

                ArrayList<LlaveValor> parametros = new ArrayList<>();

                resultado = this.Query(query, parametros,TbProductoTerminado.class);

                } catch (Exception e) {
                    throw e;
                }

            return resultado;
          
       }
}
