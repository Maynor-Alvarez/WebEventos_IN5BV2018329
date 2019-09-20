package com.maynoralvarez;

import com.maynoralvarez.Detallecotizacion;
import com.maynoralvarez.Facturacion;
import com.maynoralvarez.Reservacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-09-20T13:48:58")
@StaticMetamodel(Cotizacion.class)
public class Cotizacion_ { 

    public static volatile SingularAttribute<Cotizacion, Reservacion> reservacionIdreservacion;
    public static volatile SingularAttribute<Cotizacion, Integer> idcotizacion;
    public static volatile SingularAttribute<Cotizacion, Detallecotizacion> detallecotizacionIddetallecotizacion;
    public static volatile ListAttribute<Cotizacion, Facturacion> facturacionList;

}