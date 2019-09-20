package com.maynoralvarez;

import com.maynoralvarez.Areas;
import com.maynoralvarez.Clientes;
import com.maynoralvarez.Cotizacion;
import com.maynoralvarez.Evento;
import com.maynoralvarez.Sucursal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-09-20T13:48:58")
@StaticMetamodel(Reservacion.class)
public class Reservacion_ { 

    public static volatile SingularAttribute<Reservacion, String> descripcion;
    public static volatile SingularAttribute<Reservacion, Date> fechainicio;
    public static volatile SingularAttribute<Reservacion, Evento> idevento;
    public static volatile ListAttribute<Reservacion, Cotizacion> cotizacionList;
    public static volatile SingularAttribute<Reservacion, Areas> areasIdareas;
    public static volatile SingularAttribute<Reservacion, Date> fechafin;
    public static volatile SingularAttribute<Reservacion, Sucursal> idsucursal;
    public static volatile SingularAttribute<Reservacion, Integer> idreservacion;
    public static volatile SingularAttribute<Reservacion, Clientes> idcliente;

}