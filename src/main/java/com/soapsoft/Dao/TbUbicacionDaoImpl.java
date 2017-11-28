/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soapsoft.Dao;

import com.soapsoft.Model.TbProductoTerminado;
import com.soapsoft.Model.TbUbicacion;
import com.soapsoft.util.LlaveValor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class TbUbicacionDaoImpl extends GenericDaoImpl<TbUbicacion, Integer> implements TbUbicacionDao {
    
   public List<TbUbicacion>  fn_consultar_todos_ub(){
          
            List<TbUbicacion> resultado = null;

            try{ 

                String query = "SELECT ID, descripcion FROM  tb_ubicacion ";

                ArrayList<LlaveValor> parametros = new ArrayList<>();

                resultado = this.Query(query, parametros,TbUbicacion.class);

                } catch (Exception e) {
                    throw e;
                }

            return resultado;
          
       }
    
}
