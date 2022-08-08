package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Caixa;
import modelo.ContaAPagar;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-08T15:14:06")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-07-08T16:10:30")
>>>>>>> 791fa7302d8d5d97eeedd4be04da628588d96b96
@StaticMetamodel(Movimentacao.class)
public class Movimentacao_ { 

    public static volatile SingularAttribute<Movimentacao, Long> codigo;
    public static volatile SingularAttribute<Movimentacao, String> tipo;
    public static volatile SingularAttribute<Movimentacao, Date> data;
    public static volatile SingularAttribute<Movimentacao, Caixa> caixa;
    public static volatile SingularAttribute<Movimentacao, ContaAPagar> contaapagar;
    public static volatile SingularAttribute<Movimentacao, Double> valor;
    public static volatile SingularAttribute<Movimentacao, String> origem;
    public static volatile SingularAttribute<Movimentacao, String> descricao;

}