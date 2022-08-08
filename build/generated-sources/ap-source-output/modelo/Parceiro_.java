package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Agendamento;
import modelo.Vistoria;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-08T15:14:06")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-07-08T16:10:30")
>>>>>>> 791fa7302d8d5d97eeedd4be04da628588d96b96
@StaticMetamodel(Parceiro.class)
public class Parceiro_ { 

    public static volatile SingularAttribute<Parceiro, Long> codigo;
    public static volatile SingularAttribute<Parceiro, String> telefone;
    public static volatile ListAttribute<Parceiro, Vistoria> vistorias;
    public static volatile SingularAttribute<Parceiro, String> endereco;
    public static volatile ListAttribute<Parceiro, Agendamento> agendamentos;
    public static volatile SingularAttribute<Parceiro, String> nome;

}