package com.maynoralvarez;

import com.maynoralvarez.Facturacion;
import com.maynoralvarez.Productos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-09-20T13:48:58")
@StaticMetamodel(Detallefactura.class)
public class Detallefactura_ { 

    public static volatile SingularAttribute<Detallefactura, String> descripcion;
    public static volatile SingularAttribute<Detallefactura, Double> precio;
    public static volatile SingularAttribute<Detallefactura, Productos> productosIdproductos;
    public static volatile SingularAttribute<Detallefactura, Integer> cantidad;
    public static volatile ListAttribute<Detallefactura, Facturacion> facturacionList;
    public static volatile SingularAttribute<Detallefactura, Integer> iddetallefactura;

}