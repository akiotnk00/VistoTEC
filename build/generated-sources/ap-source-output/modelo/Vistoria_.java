package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Caixa;
import modelo.Cliente;
import modelo.Pagamento;
import modelo.Parceiro;
import modelo.Veiculo;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-07-08T16:10:30")
@StaticMetamodel(Vistoria.class)
public class Vistoria_ { 

    public static volatile SingularAttribute<Vistoria, Veiculo> veiculo;
    public static volatile SingularAttribute<Vistoria, Cliente> cliente;
    public static volatile SingularAttribute<Vistoria, String> motivo;
    public static volatile SingularAttribute<Vistoria, Character> resultado;
    public static volatile SingularAttribute<Vistoria, Long> kilometragem;
    public static volatile SingularAttribute<Vistoria, Caixa> caixa;
    public static volatile SingularAttribute<Vistoria, Parceiro> parceiro;
    public static volatile SingularAttribute<Vistoria, Long> id;
    public static volatile SingularAttribute<Vistoria, String> localpdf;
    public static volatile SingularAttribute<Vistoria, Date> datahora;
    public static volatile SingularAttribute<Vistoria, Pagamento> pagamento;

}