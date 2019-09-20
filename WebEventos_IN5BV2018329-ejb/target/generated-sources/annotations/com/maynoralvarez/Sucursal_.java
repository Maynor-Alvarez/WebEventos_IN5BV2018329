package com.maynoralvarez;

import com.maynoralvarez.Areas;
import com.maynoralvarez.Reservacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-09-20T13:48:58")
@StaticMetamodel(Sucursal.class)
public class Sucursal_ { 

    public static volatile SingularAttribute<Sucursal, String> descripcion;
    public static volatile SingularAttribute<Sucursal, Areas> areasIdareas;
    public static volatile SingularAttribute<Sucursal, Integer> idsucursal;
    public static volatile ListAttribute<Sucursal, Reservacion> reservacionList;

}