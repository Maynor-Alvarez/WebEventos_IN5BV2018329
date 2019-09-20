package com.maynoralvarez;

import com.maynoralvarez.Productos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-09-20T13:48:58")
@StaticMetamodel(Tipoproducto.class)
public class Tipoproducto_ { 

    public static volatile SingularAttribute<Tipoproducto, String> descripcion;
    public static volatile SingularAttribute<Tipoproducto, Integer> idtipoproducto;
    public static volatile ListAttribute<Tipoproducto, Productos> productosList;

}