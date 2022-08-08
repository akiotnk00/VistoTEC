package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Caixa;
import modelo.Cliente;
import modelo.Parceiro;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-08T15:14:06")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-07-08T16:10:30")
>>>>>>> 791fa7302d8d5d97eeedd4be04da628588d96b96
@StaticMetamodel(Agendamento.class)
public class Agendamento_ { 

    public static volatile SingularAttribute<Agendamento, Cliente> cliente;
    public static volatile SingularAttribute<Agendamento, Long> codigo;
    public static volatile SingularAttribute<Agendamento, String> telefone;
    public static volatile SingularAttribute<Agendamento, String> observacao;
    public static volatile SingularAttribute<Agendamento, String> endereco;
    public static volatile SingularAttribute<Agendamento, Caixa> caixa;
    public static volatile SingularAttribute<Agendamento, Parceiro> parceiro;
    public static volatile SingularAttribute<Agendamento, String> tipoveiculo;
    public static volatile SingularAttribute<Agendamento, Date> dataagendamento;
    public static volatile SingularAttribute<Agendamento, Character> status;

}