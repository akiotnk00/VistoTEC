/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

/**
 *
 * @author akiot
 *
 */
import dao.AgendamentoDAO;
import dao.CaixaDAO;
import dao.VistoriaDAO;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Agendamento;
import modelo.Caixa;
import modelo.Parceiro;
import modelo.Usuario;
import modelo.Vistoria;

public class JanelaPrincipal extends javax.swing.JFrame {

    private final CaixaDAO caixaDAO;
    private final VistoriaDAO vistoriaDAO;
    private List<Vistoria> vistorias;
    private List<Agendamento> agendamentos;
    private final AgendamentoDAO agendamentoDAO;
    private Usuario usuariologado;
    private Caixa caixaAberto;

    /**
     * Creates new form JanelaPrincipal
     */
    public JanelaPrincipal() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/icones/icones_pequenos/icone.png")).getImage());
        vistoriaDAO = new VistoriaDAO();
        caixaDAO = new CaixaDAO();
        agendamentoDAO = new AgendamentoDAO();
        atualizaTabela(vistoriaDAO.findAllOrder());
        bloqueiaTudo();

        jDateChooserAgendamentos.getDateEditor().addPropertyChangeListener(
                new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                if ("date".equals(e.getPropertyName())) {
                    verificaAgendamentos(jDateChooserAgendamentos.getDate());
                }
            }
        });
    }

    public JanelaPrincipal(Usuario usuario) {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/icones/icones_pequenos/icone.png")).getImage());
        usuariologado = usuario;
        vistoriaDAO = new VistoriaDAO();
        agendamentoDAO = new AgendamentoDAO();
        caixaDAO = new CaixaDAO();
        atualizaTabela(vistoriaDAO.findAllOrder());
        jLabelTotalVistoriasHoje.setText("" + vistoriaDAO.findByData(new Date()).size());
        usuarioLogado.setText(usuario.getNome());
        usuarioLogado.setForeground(Color.green);
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        jDateChooserAgendamentos.setCalendar(c);
        verificaAgendamentos(new Date());
        jDateChooserAgendamentos.getDateEditor().addPropertyChangeListener(
                new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                if ("date".equals(e.getPropertyName())) {
                    verificaAgendamentos(jDateChooserAgendamentos.getDate());
                }
            }
        });
        bloqueiaTudo();

        // Recebe o nivel de acesso
        if (usuario.getNvacesso() > 0) {

            niveldeacesso.setText("Administrador");

            // Altera a cor da letra
            niveldeacesso.setForeground(Color.red);
        } else {
            niveldeacesso.setText("Funcionário");
        }

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        usuarioHorario.setText(dateFormat.format(usuario.getUltimoLogin()));
        usuarioHorario.setForeground(Color.green);

        if (usuario.getNvacesso() < 1) {
            jButtonFinanceiro.setEnabled(false);
            jButtonRelatorios.setEnabled(false);
            jButtonUsuarios.setEnabled(false);

        }

        if (verificaCaixaAberto()) {

            if (!caixaDAO.ultimasAberturas().isEmpty()) {
                caixaAberto = caixaDAO.ultimasAberturas().get(0);

                int op = JOptionPane.showConfirmDialog(null, "Existe um caixa aberto, deseja fazer o fechamento?");

                if (op == 0) {
                    fecharCaixa();

                } else {
                    // Altera as partes visuais.
                    // Muda o texto para Aberto.
                    jLabelStatusCaixa.setText("Aberto");

                    // Muda o texto do botão para Fechar Caixa.
                    jButtonAbrirFechar.setText("Fechar caixa");

                    // Altera a cor do texto para Verde.
                    jLabelStatusCaixa.setForeground(Color.green);

                    // Coloca o valor inicial na tela.
                    jLabelSaldo.setText("R$" + String.format("%.2f", caixaAberto.getValorinicial()));

                    // Libera os botões da janela principal.
                    liberaTudo();

                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelLogadoComo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        usuarioLogado = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        usuarioHorario = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        niveldeacesso = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jButtonRelatorios = new javax.swing.JButton();
        jButtonVistorias = new javax.swing.JButton();
        jButtonClientes = new javax.swing.JButton();
        jButtonVeiculos = new javax.swing.JButton();
        jButtonParceiros = new javax.swing.JButton();
        jButtonUsuarios = new javax.swing.JButton();
        jButtonFinanceiro = new javax.swing.JButton();
        jButtonAgendamentos = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabelUltimasVistorias = new javax.swing.JLabel();
        jButtonNovaVistoria = new javax.swing.JButton();
        jButtonUsuarios2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableAgendamentos = new javax.swing.JTable();
        jDateChooserAgendamentos = new com.toedter.calendar.JDateChooser();
        jLabelAgendamentos = new javax.swing.JLabel();
        jPanelSaldo = new javax.swing.JPanel();
        jLabelSaldo = new javax.swing.JLabel();
        jLabelStatusCaixa = new javax.swing.JLabel();
        jButtonAbrirFechar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabelTotalVistoriasHoje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("VistoTEC - Sistema para Empresa de Vistorias Veiculares");
        setBackground(new java.awt.Color(0, 102, 153));

        jPanelLogadoComo.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Raleway", 1, 12)); // NOI18N
        jLabel2.setText("Logado como:");

        usuarioLogado.setText("Usuario");

        jLabel3.setFont(new java.awt.Font("Raleway", 1, 12)); // NOI18N
        jLabel3.setText("Horário do acesso:");

        usuarioHorario.setText("Horario");

        jLabel6.setFont(new java.awt.Font("Raleway", 1, 12)); // NOI18N
        jLabel6.setText("Nivel de Acesso:");

        niveldeacesso.setText("Niveldeacesso");

        jLabel5.setText("Versão do Sistema: v2.0");

        javax.swing.GroupLayout jPanelLogadoComoLayout = new javax.swing.GroupLayout(jPanelLogadoComo);
        jPanelLogadoComo.setLayout(jPanelLogadoComoLayout);
        jPanelLogadoComoLayout.setHorizontalGroup(
            jPanelLogadoComoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLogadoComoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usuarioLogado)
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usuarioHorario)
                .addGap(28, 28, 28)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(niveldeacesso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 636, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );
        jPanelLogadoComoLayout.setVerticalGroup(
            jPanelLogadoComoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLogadoComoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLogadoComoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(usuarioHorario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelLogadoComoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(niveldeacesso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5))
                    .addGroup(jPanelLogadoComoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelLogadoComoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelLogadoComoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(usuarioLogado)
                                .addComponent(jLabel3))
                            .addComponent(jLabel6))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonRelatorios.setBackground(new java.awt.Color(0, 102, 153));
        jButtonRelatorios.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jButtonRelatorios.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/activity [#985].png"))); // NOI18N
        jButtonRelatorios.setText("Relatórios");
        jButtonRelatorios.setFocusable(false);
        jButtonRelatorios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRelatoriosActionPerformed(evt);
            }
        });

        jButtonVistorias.setBackground(new java.awt.Color(0, 102, 153));
        jButtonVistorias.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jButtonVistorias.setForeground(new java.awt.Color(255, 255, 255));
        jButtonVistorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fileboard [#1801].png"))); // NOI18N
        jButtonVistorias.setText("Vistorias");
        jButtonVistorias.setToolTipText("");
        jButtonVistorias.setFocusable(false);
        jButtonVistorias.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonVistorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVistoriasActionPerformed(evt);
            }
        });

        jButtonClientes.setBackground(new java.awt.Color(0, 102, 153));
        jButtonClientes.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jButtonClientes.setForeground(new java.awt.Color(255, 255, 255));
        jButtonClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/profile_minus [#1340].png"))); // NOI18N
        jButtonClientes.setText("Clientes");
        jButtonClientes.setFocusable(false);
        jButtonClientes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClientesActionPerformed(evt);
            }
        });

        jButtonVeiculos.setBackground(new java.awt.Color(0, 102, 153));
        jButtonVeiculos.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jButtonVeiculos.setForeground(new java.awt.Color(255, 255, 255));
        jButtonVeiculos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/car_front_view [#616].png"))); // NOI18N
        jButtonVeiculos.setText("Veiculos");
        jButtonVeiculos.setFocusable(false);
        jButtonVeiculos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVeiculosActionPerformed(evt);
            }
        });

        jButtonParceiros.setBackground(new java.awt.Color(0, 102, 153));
        jButtonParceiros.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jButtonParceiros.setForeground(new java.awt.Color(255, 255, 255));
        jButtonParceiros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/emoji_happy_circle [#540].png"))); // NOI18N
        jButtonParceiros.setText("Parceiros");
        jButtonParceiros.setFocusable(false);
        jButtonParceiros.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonParceiros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonParceirosActionPerformed(evt);
            }
        });

        jButtonUsuarios.setBackground(new java.awt.Color(0, 102, 153));
        jButtonUsuarios.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jButtonUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        jButtonUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/profile_minus [#1340].png"))); // NOI18N
        jButtonUsuarios.setText("Usuarios");
        jButtonUsuarios.setFocusable(false);
        jButtonUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUsuariosActionPerformed(evt);
            }
        });

        jButtonFinanceiro.setBackground(new java.awt.Color(0, 102, 153));
        jButtonFinanceiro.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jButtonFinanceiro.setForeground(new java.awt.Color(255, 255, 255));
        jButtonFinanceiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/dollar [#1189].png"))); // NOI18N
        jButtonFinanceiro.setText("Financeiro");
        jButtonFinanceiro.setFocusable(false);
        jButtonFinanceiro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonFinanceiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinanceiroActionPerformed(evt);
            }
        });

        jButtonAgendamentos.setBackground(new java.awt.Color(0, 102, 153));
        jButtonAgendamentos.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jButtonAgendamentos.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAgendamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/calendar [#1196].png"))); // NOI18N
        jButtonAgendamentos.setText("Agendamentos");
        jButtonAgendamentos.setFocusable(false);
        jButtonAgendamentos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonAgendamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgendamentosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVistorias, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAgendamentos)
                    .addComponent(jButtonParceiros, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonFinanceiro, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonAgendamentos, jButtonClientes, jButtonFinanceiro, jButtonParceiros, jButtonRelatorios, jButtonUsuarios, jButtonVeiculos, jButtonVistorias});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonVistorias)
                .addGap(4, 4, 4)
                .addComponent(jButtonClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonVeiculos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAgendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonParceiros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonFinanceiro, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonAgendamentos, jButtonClientes, jButtonFinanceiro, jButtonParceiros, jButtonRelatorios, jButtonUsuarios, jButtonVeiculos, jButtonVistorias});

        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.LINE_AXIS));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelUltimasVistorias.setBackground(new java.awt.Color(255, 255, 255));
        jLabelUltimasVistorias.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabelUltimasVistorias.setForeground(new java.awt.Color(0, 102, 153));
        jLabelUltimasVistorias.setText("Ultimas Vistorias Realizadas");

        jButtonNovaVistoria.setBackground(new java.awt.Color(51, 153, 0));
        jButtonNovaVistoria.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jButtonNovaVistoria.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNovaVistoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fileboard [#1801].png"))); // NOI18N
        jButtonNovaVistoria.setText("Nova Vistoria");
        jButtonNovaVistoria.setToolTipText("");
        jButtonNovaVistoria.setFocusable(false);
        jButtonNovaVistoria.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonNovaVistoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovaVistoriaActionPerformed(evt);
            }
        });

        jButtonUsuarios2.setBackground(new java.awt.Color(51, 51, 255));
        jButtonUsuarios2.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jButtonUsuarios2.setForeground(new java.awt.Color(255, 255, 255));
        jButtonUsuarios2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/calendar [#1196].png"))); // NOI18N
        jButtonUsuarios2.setText("Novo Agendamento");
        jButtonUsuarios2.setFocusable(false);
        jButtonUsuarios2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonUsuarios2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUsuarios2ActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Placa", "Modelo", "Motivo", "Data", "Hora", "Situação", "Valor Cobrado", "Parceiro", "Resultado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabela);

        jButton4.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jButton4.setText("Ver informações");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Agendamentos"));

        jTableAgendamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hora", "Endereço", "Tipo Veiculo", "Telefone", "Cliente", "Parceiro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTableAgendamentos);
        if (jTableAgendamentos.getColumnModel().getColumnCount() > 0) {
            jTableAgendamentos.getColumnModel().getColumn(0).setResizable(false);
            jTableAgendamentos.getColumnModel().getColumn(0).setPreferredWidth(8);
            jTableAgendamentos.getColumnModel().getColumn(1).setResizable(false);
            jTableAgendamentos.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTableAgendamentos.getColumnModel().getColumn(2).setResizable(false);
            jTableAgendamentos.getColumnModel().getColumn(2).setPreferredWidth(15);
            jTableAgendamentos.getColumnModel().getColumn(3).setResizable(false);
            jTableAgendamentos.getColumnModel().getColumn(3).setPreferredWidth(15);
            jTableAgendamentos.getColumnModel().getColumn(4).setResizable(false);
            jTableAgendamentos.getColumnModel().getColumn(4).setPreferredWidth(50);
            jTableAgendamentos.getColumnModel().getColumn(5).setResizable(false);
            jTableAgendamentos.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        jDateChooserAgendamentos.setDateFormatString("dd/MM/yy");
        jDateChooserAgendamentos.setMinSelectableDate(new java.util.Date(-62135755140000L));

        jLabelAgendamentos.setText("......");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jDateChooserAgendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(jLabelAgendamentos)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooserAgendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAgendamentos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelSaldo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Saldo"), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Raleway", 1, 11))); // NOI18N

        jLabelSaldo.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSaldo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabelSaldo.setForeground(new java.awt.Color(51, 102, 255));
        jLabelSaldo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanelSaldoLayout = new javax.swing.GroupLayout(jPanelSaldo);
        jPanelSaldo.setLayout(jPanelSaldoLayout);
        jPanelSaldoLayout.setHorizontalGroup(
            jPanelSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelSaldo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
        );
        jPanelSaldoLayout.setVerticalGroup(
            jPanelSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSaldoLayout.createSequentialGroup()
                .addComponent(jLabelSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabelStatusCaixa.setBackground(new java.awt.Color(0, 0, 0));
        jLabelStatusCaixa.setFont(new java.awt.Font("Raleway", 1, 36)); // NOI18N
        jLabelStatusCaixa.setForeground(new java.awt.Color(204, 0, 0));
        jLabelStatusCaixa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelStatusCaixa.setText("Fechado");

        jButtonAbrirFechar.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jButtonAbrirFechar.setText("Abrir caixa");
        jButtonAbrirFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton4)
                                    .addComponent(jLabelUltimasVistorias))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jButtonUsuarios2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonNovaVistoria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelStatusCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonAbrirFechar)
                                .addGap(72, 72, 72)))
                        .addComponent(jPanelSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelUltimasVistorias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonUsuarios2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonNovaVistoria, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabelStatusCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAbrirFechar)))
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonNovaVistoria, jButtonUsuarios2});

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total de Vistorias Hoje");

        jLabelTotalVistoriasHoje.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalVistoriasHoje.setFont(new java.awt.Font("RohnRounded-Black", 1, 48)); // NOI18N
        jLabelTotalVistoriasHoje.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTotalVistoriasHoje.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabelTotalVistoriasHoje)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelTotalVistoriasHoje, javax.swing.GroupLayout.PREFERRED_SIZE, 54, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanelLogadoComo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelLogadoComo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClientesActionPerformed
        ClienteVisao frame = new ClienteVisao();
        frame.setModal(true);
        frame.setVisible(true);
        atualizaTabela(vistoriaDAO.findAllOrder());
    }//GEN-LAST:event_jButtonClientesActionPerformed

    private void jButtonVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVeiculosActionPerformed
        VeiculoVisao frame = new VeiculoVisao();
        frame.setModal(true);
        frame.setVisible(true);
        atualizaTabela(vistoriaDAO.findAllOrder());
    }//GEN-LAST:event_jButtonVeiculosActionPerformed

    private void jButtonVistoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVistoriasActionPerformed
        VistoriaVisao frame = new VistoriaVisao(caixaAberto);
        frame.setModal(true);
        frame.setVisible(true);
        atualizaTabela(vistoriaDAO.findAllOrder());
        jLabelTotalVistoriasHoje.setText("" + vistoriaDAO.findByData(new Date()).size());
    }//GEN-LAST:event_jButtonVistoriasActionPerformed

    private void jButtonParceirosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonParceirosActionPerformed
        ParceiroVisao frame = new ParceiroVisao();
        frame.setModal(true);
        frame.setVisible(true);
        atualizaTabela(vistoriaDAO.findAllOrder());
    }//GEN-LAST:event_jButtonParceirosActionPerformed

    private void jButtonNovaVistoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovaVistoriaActionPerformed
        VistoriaVisao frame = new VistoriaVisao(true, caixaAberto);
        frame.setModal(true);
        frame.setVisible(true);
        atualizaTabela(vistoriaDAO.findAllOrder());
        jLabelTotalVistoriasHoje.setText("" + vistoriaDAO.findByData(new Date()).size());
    }//GEN-LAST:event_jButtonNovaVistoriaActionPerformed

    private void jButtonUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUsuariosActionPerformed
        UsuarioVisao frame = new UsuarioVisao();
        frame.setModal(true);
        frame.setVisible(true);
        atualizaTabela(vistoriaDAO.findAllOrder());
    }//GEN-LAST:event_jButtonUsuariosActionPerformed

    private void jButtonFinanceiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinanceiroActionPerformed
        Financeiro frame = new Financeiro();
        frame.setModal(true);
        frame.setVisible(true);
        atualizaTabela(vistoriaDAO.findAllOrder());
    }//GEN-LAST:event_jButtonFinanceiroActionPerformed

    private void jButtonRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRelatoriosActionPerformed
        JOptionPane.showMessageDialog(null, "Aguarde... Em breve.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButtonRelatoriosActionPerformed

    private void jButtonAgendamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgendamentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAgendamentosActionPerformed

    // Botão para um novo agendamento.
    private void jButtonUsuarios2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUsuarios2ActionPerformed
        // Verifica se existe algum agendamento para o dia marcado no jchooser.
        if (agendamentoDAO.buscaPorData(jDateChooserAgendamentos.getDate()).isEmpty()) {
            AgendamentoVisao frame = new AgendamentoVisao(caixaAberto, jDateChooserAgendamentos.getDate());
            frame.setModal(true);
            frame.setVisible(true);
        } // Caso existe já algum agendamento no dia selecionado.
        else {

            // Pega a linha selecionada na tabela pelo usuario.
            int linha = jTableAgendamentos.getSelectedRow();

            if (linha != -1) {

                // Pergunta exibida na tela do usuario.
                int op = JOptionPane.showConfirmDialog(null, "Deseja fazer um novo agendamento?");

                // Se a opção for SIM.
                if (op == 0) {

                    // Verifica se já está com os dados preenchido no agendamento, caso sim o horário já esta agendado.
                    if (agendamentos.get(linha).getCliente() == null) {
                        AgendamentoVisao frame = new AgendamentoVisao(caixaAberto, agendamentos.get(linha));
                        frame.setModal(true);
                        frame.setVisible(true);
                    } // Caso o usuario tenha selecionado um horário já agendado.
                    else {
                        JOptionPane.showMessageDialog(null, "Esse horário já está agendado!");
                    }
                }
            } // Se não houver linha selecionada.
            else {
                JOptionPane.showMessageDialog(null, "Selecione um horário na tabela!");
            }
        }
        verificaAgendamentos(jDateChooserAgendamentos.getDate());
    }//GEN-LAST:event_jButtonUsuarios2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int linha = tabela.getSelectedRow();

        Vistoria v = vistorias.get(linha);
        JOptionPane.showMessageDialog(null, v);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButtonAbrirFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirFecharActionPerformed
        // TODO add your handling code here:
        if ("Fechado".equals(jLabelStatusCaixa.getText())) {

            // Verifica se existe caixa aberto.
            //   if (verificaCaixaAberto()) {
            abrirCaixa();
            //  }

        } else {

            fecharCaixa();
        }

    }//GEN-LAST:event_jButtonAbrirFecharActionPerformed

    // Função que fecha o caixa.
    private void fecharCaixa() {

        if (verificaCaixaAberto()) {
            caixaAberto = caixaDAO.ultimasAberturas().get(0);
            caixaAberto.setFechamento(new Date());
            caixaDAO.merge(caixaAberto);
            jButtonAbrirFechar.setText("Abrir caixa");
            jLabelStatusCaixa.setText("Fechado");
            jLabelStatusCaixa.setForeground(Color.red);
            jLabelSaldo.setText("");
            bloqueiaTudo();

        } else {
            System.out.println("Não existe nenhum caixa aberto");
        }
    }

    // Função que abre um novo caixa.
    private void abrirCaixa() {

        if (verificaCaixaAberto()) {
            System.out.println("Existe um caixa aberto");
        } else {
            // Cria um novo caixa.
            Caixa caixaaberto = new Caixa();

            // Coloca a data e hora atual.
            System.out.println("" + Calendar.getInstance().getTime());
            caixaaberto.setAbertura(Calendar.getInstance().getTime());

            //Vincula o novo caixa com o usuario logado.
            caixaaberto.setUsuario(usuariologado);

            // Pega o valor através de um janela.
            Double valorinicial = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor inicial:"));

            // Seta o valor pego na janela anterior.
            caixaaberto.setValorinicial(valorinicial);

            //Salva no banco os dados anteriores.
            caixaDAO.merge(caixaaberto);

            // Altera as partes visuais.
            // Muda o texto para Aberto.
            jLabelStatusCaixa.setText("Aberto");

            // Muda o texto do botão para Fechar Caixa.
            jButtonAbrirFechar.setText("Fechar caixa");

            // Altera a cor do texto para Verde.
            jLabelStatusCaixa.setForeground(Color.green);

            // Coloca o valor inicial na tela.
            jLabelSaldo.setText(Double.toString(caixaaberto.getValorinicial()));

            caixaAberto = caixaDAO.ultimasAberturas().get(0); 
            
            // Libera os botões da janela principal.
            liberaTudo();
        }

    }

    // Verifica se existe caixa aberto, retorna TRUE ou FALSE.
    private boolean verificaCaixaAberto() {

        if (caixaDAO.ultimasAberturas().isEmpty()) {
            return false;
        } else {

            
            if(caixaDAO.ultimasAberturas().get(0).getFechamento()==null){
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    // Bloqueia botões e campos da janela principal.
    private void bloqueiaTudo() {
        jButtonVistorias.setEnabled(false);
        jButtonNovaVistoria.setEnabled(false);

        jPanelSaldo.setEnabled(false);
        jLabelSaldo.setEnabled(false);

    }

    // Desbloqueia botões e campos da janela principal.
    private void liberaTudo() {
        jButtonVistorias.setEnabled(true);
        jButtonNovaVistoria.setEnabled(true);

        jPanelSaldo.setEnabled(true);
        jLabelSaldo.setEnabled(true);

        jDateChooserAgendamentos.setDate(new Date());
        verificaAgendamentos(new Date());

    }

    // Atualiza a tabela de vistorias.
    private void atualizaTabela(List<Vistoria> lista) {
        DefaultTableModel dtm = (DefaultTableModel) tabela.getModel();
        dtm.setNumRows(0); // excluir os registros que estão na JTable
        vistorias = lista;
        DateFormat dateDia = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat dateHora = new SimpleDateFormat("HH:mm:ss");
        if (vistorias != null) {
            for (Vistoria v : vistorias) {
                dtm.addRow(new Object[]{v.getVeiculo().getPlaca(), v.getVeiculo().getModelo(), v.getMotivo(), dateDia.format(v.getDatahora()), dateHora.format(v.getDatahora()), verificaNullParceiro(v.getParceiro()), retornaResultado(v.getResultado())});
            }
        }

    }

    // Verifica e preenche a tabela de agendamentos
    private void verificaAgendamentos(Date datarecebida) {
        DefaultTableModel dtm = (DefaultTableModel) jTableAgendamentos.getModel();
        dtm.setNumRows(0); // excluir os registros que estão na JTable
        if (!agendamentoDAO.buscaPorData(datarecebida).isEmpty()) {
            agendamentos = agendamentoDAO.buscaPorData(datarecebida);
            DateFormat dateDia = new SimpleDateFormat("dd/MM/yyyy");
            DateFormat dateHora = new SimpleDateFormat("HH:mm:ss");

            for (Agendamento a : agendamentos) {
                dtm.addRow(new Object[]{a.getHorario(), a.getEndereco(), a.getTipoveiculo(), a.getTelefone(), a.getCliente(), verificaNullParceiro(a.getParceiro())});

            }
        } else {
            jLabelAgendamentos.setText("Não existem agendamentos para hoje.");
        }
    }

    private Object retornaResultado(char resultado) {
        if (resultado == 'a') {
            return "Aprovado";
        } else {
            return "Reprovado";
        }
    }

    // Verifica se o parceiro é "Null" e substitui por "Nenhuma" caso seja.
    private String verificaNullParceiro(Parceiro parceiro) {
        if (parceiro == null) {
            return "";
        } else {
            // Retorna o nome do parceiro.
            return parceiro.getNome();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonAbrirFechar;
    private javax.swing.JButton jButtonAgendamentos;
    private javax.swing.JButton jButtonClientes;
    private javax.swing.JButton jButtonFinanceiro;
    private javax.swing.JButton jButtonNovaVistoria;
    private javax.swing.JButton jButtonParceiros;
    private javax.swing.JButton jButtonRelatorios;
    private javax.swing.JButton jButtonUsuarios;
    private javax.swing.JButton jButtonUsuarios2;
    private javax.swing.JButton jButtonVeiculos;
    private javax.swing.JButton jButtonVistorias;
    private com.toedter.calendar.JDateChooser jDateChooserAgendamentos;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelAgendamentos;
    private javax.swing.JLabel jLabelSaldo;
    private javax.swing.JLabel jLabelStatusCaixa;
    private javax.swing.JLabel jLabelTotalVistoriasHoje;
    private javax.swing.JLabel jLabelUltimasVistorias;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelLogadoComo;
    private javax.swing.JPanel jPanelSaldo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableAgendamentos;
    private javax.swing.JLabel niveldeacesso;
    private javax.swing.JTable tabela;
    private javax.swing.JLabel usuarioHorario;
    private javax.swing.JLabel usuarioLogado;
    // End of variables declaration//GEN-END:variables
}
