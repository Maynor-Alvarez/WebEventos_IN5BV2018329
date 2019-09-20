package com.maynoralvarez;

import com.maynoralvarez.Reservacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-09-20T13:48:58")
@StaticMetamodel(Clientes.class)
public class Clientes_ { 

    public static volatile SingularAttribute<Clientes, String> apellidos;
    public static volatile SingularAttribute<Clientes, String> correo;
    public static volatile SingularAttribute<Clientes, String> celular;
    public static volatile SingularAttribute<Clientes, Integer> idclientes;
    public static volatile ListAttribute<Clientes, Reservacion> reservacionList;
    public static volatile SingularAttribute<Clientes, String> nombres;

}