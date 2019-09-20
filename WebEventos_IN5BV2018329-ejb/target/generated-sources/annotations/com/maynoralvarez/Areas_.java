package com.maynoralvarez;

import com.maynoralvarez.Reservacion;
import com.maynoralvarez.Sucursal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-09-20T13:48:58")
@StaticMetamodel(Areas.class)
public class Areas_ { 

    public static volatile SingularAttribute<Areas, String> descripcion;
    public static volatile ListAttribute<Areas, Sucursal> sucursalList;
    public static volatile SingularAttribute<Areas, Integer> idareas;
    public static volatile ListAttribute<Areas, Reservacion> reservacionList;

}