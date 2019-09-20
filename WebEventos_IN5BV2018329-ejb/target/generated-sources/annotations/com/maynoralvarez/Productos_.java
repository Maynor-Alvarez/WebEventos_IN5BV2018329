package com.maynoralvarez;

import com.maynoralvarez.Detallecotizacion;
import com.maynoralvarez.Detallefactura;
import com.maynoralvarez.Tipoproducto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-09-20T13:48:58")
@StaticMetamodel(Productos.class)
public class Productos_ { 

    public static volatile SingularAttribute<Productos, String> descripcion;
    public static volatile SingularAttribute<Productos, Integer> idproductos;
    public static volatile ListAttribute<Productos, Detallecotizacion> detallecotizacionList;
    public static volatile ListAttribute<Productos, Detallefactura> detallefacturaList;
    public static volatile SingularAttribute<Productos, Double> precioventa;
    public static volatile SingularAttribute<Productos, Date> fechavencimiento;
    public static volatile SingularAttribute<Productos, Tipoproducto> tipoproductoIdtipoproducto;

}