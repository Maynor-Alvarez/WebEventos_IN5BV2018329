/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maynoralvarez.sessionsbeans;

import com.maynoralvarez.Detallecotizacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author programacion
 */
@Local
public interface DetallecotizacionFacadeLocal {

    void create(Detallecotizacion detallecotizacion);

    void edit(Detallecotizacion detallecotizacion);

    void remove(Detallecotizacion detallecotizacion);

    Detallecotizacion find(Object id);

    List<Detallecotizacion> findAll();

    List<Detallecotizacion> findRange(int[] range);

    int count();
    
}
