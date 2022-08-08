package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Agendamento;
import modelo.Movimentacao;
import modelo.Usuario;
import modelo.Vistoria;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-08T15:14:06")
@StaticMetamodel(Caixa.class)
public class Caixa_ { 

    public static volatile SingularAttribute<Caixa, Date> fechamento;
    public static volatile SingularAttribute<Caixa, Double> valorinicial;
    public static volatile ListAttribute<Caixa, Movimentacao> movimentacoes;
    public static volatile SingularAttribute<Caixa, Long> codigo;
    public static volatile ListAttribute<Caixa, Vistoria> vistorias;
    public static volatile ListAttribute<Caixa, Agendamento> agendamentos;
    public static volatile SingularAttribute<Caixa, Date> abertura;
    public static volatile SingularAttribute<Caixa, Usuario> usuario;

}