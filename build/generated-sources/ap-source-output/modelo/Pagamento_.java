package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Vistoria;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-07-08T16:10:30")
@StaticMetamodel(Pagamento.class)
public class Pagamento_ { 

    public static volatile SingularAttribute<Pagamento, Date> datapagamento;
    public static volatile SingularAttribute<Pagamento, Long> codigo;
    public static volatile SingularAttribute<Pagamento, Vistoria> vistoria;
    public static volatile SingularAttribute<Pagamento, Double> valorcobrado;
    public static volatile SingularAttribute<Pagamento, String> formapagamento;

}