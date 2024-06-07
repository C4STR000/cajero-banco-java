/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ventanas;

import cajero.Evento;
import cajero.Usuario;
import cajero.GestorCuenta;
import cajero.Hora;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 * Panel para crear una nueva cuenta de usuario.
 */
public class PanelCrearCuenta extends javax.swing.JPanel implements ItemListener {

    /**
     * Creates new form PanelCrearCuenta
     * 
     * @param gestionador     Objeto GestorCuenta que gestiona la cuenta del usuario
     * @param panelPrincipal  JFrame principal de la aplicación
     */
    public PanelCrearCuenta(GestorCuenta gestionador, JFrame panelPrincipal) {
        initComponents();

        // Ajustes en el panel principal
        panelPrincipal.getContentPane().removeAll();
        panelPrincipal.getContentPane().add(this, BorderLayout.PAGE_START);
        panelPrincipal.getContentPane().revalidate();
        panelPrincipal.getContentPane().repaint();
        panelPrincipal.pack();

        // Configuración inicial del número de cuenta
        lblNroCuenta.setText("" + gestionador.generarNumeroDeCuenta());

        // Acción del botón "Crear Cuenta"
        btnCrearCuenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreUsuario = jtfNombreUsuario.getText();
                String nombreTitular = jtfNombreCompleto.getText();
                char[] contrasena = jpwNuevaContrasena.getPassword();
                char[] confirmacionContrasena = jpwConfirmacionContrasena.getPassword();
                String nroCuenta = lblNroCuenta.getText();
                String divisa = (String) jcbTipoCuenta.getSelectedItem();
                boolean existeUsuario = gestionador.existeUsuario(nombreUsuario);
                boolean contrasenasCoinciden = gestionador.contrasenasCoinciden(String.copyValueOf(contrasena), String.copyValueOf(confirmacionContrasena));

                if (!existeUsuario) {
                    if (contrasenasCoinciden) {
                        String montoInicial = JOptionPane.showInputDialog(null, "Depositar Monto Inicial de billetes de 10" + "("+divisa+")", "Monto Inicial", JOptionPane.WARNING_MESSAGE);
                        if (montoInicial != null && Integer.parseInt(montoInicial) >= 10 && Integer.parseInt(montoInicial) % 10 == 0) {
                            gestionador.crearCuenta(new Usuario(nombreUsuario, nombreTitular, String.copyValueOf(contrasena), nroCuenta, divisa, montoInicial));
                            gestionador.crearEvento(new Evento(nroCuenta, "Se creó cuenta", montoInicial, montoInicial));
                            lblAviso.setText("Cuenta se creó exitosamente.");
                            lblAviso.setForeground(new Color(0, 153, 0));
                        } else {
                            lblAviso.setText("Pon un monto inicial válido.");
                            lblAviso.setForeground(new Color(204, 0, 0));
                        }

                    } else {
                        lblAviso.setText("Contraseñas no coinciden.");
                        lblAviso.setForeground(new Color(204, 0, 0));
                    }
                } else {
                    lblAviso.setText("El usuario ya existe.");
                    lblAviso.setForeground(new Color(204, 0, 0));
                }
            }
        });

        // Acción del botón "Salir"
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelSesionInicio principal = new PanelSesionInicio(gestionador, panelPrincipal);
                panelPrincipal.add(principal, BorderLayout.PAGE_START);
            }
        });

        // Evento del selector de tipo de cuenta
        jcbTipoCuenta.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                lblNroCuenta.setText("" + gestionador.generarNumeroDeCuenta());
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        btnCrearCuenta = new javax.swing.JButton();
        jtfNombreUsuario = new javax.swing.JTextField();
        jpwNuevaContrasena = new javax.swing.JPasswordField();
        jtfNombreCompleto = new javax.swing.JTextField();
        jpwConfirmacionContrasena = new javax.swing.JPasswordField();
        btnSalir = new javax.swing.JButton();
        lblNombreUsuario = new javax.swing.JLabel();
        lblNombreCompleto = new javax.swing.JLabel();
        lblNuevaContrasena = new javax.swing.JLabel();
        lblConfirmacionContrasena = new javax.swing.JLabel();
        jcbTipoCuenta = new javax.swing.JComboBox<>();
        lblTipoDeCuenta = new javax.swing.JLabel();
        lblNroCuenta = new javax.swing.JLabel();
        lblTituloNroCuenta = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblAviso = new javax.swing.JLabel();

        setBackground(new java.awt.Color(134, 190, 225));

        btnCrearCuenta.setBackground(new java.awt.Color(0, 174, 237));
        btnCrearCuenta.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        btnCrearCuenta.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearCuenta.setText("Crear Cuenta");

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N

        lblNombreUsuario.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        lblNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreUsuario.setText("Nombre Usuario");

        lblNombreCompleto.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        lblNombreCompleto.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreCompleto.setText("Nombre Completo");

        lblNuevaContrasena.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        lblNuevaContrasena.setForeground(new java.awt.Color(255, 255, 255));
        lblNuevaContrasena.setText("Contrasena");

        lblConfirmacionContrasena.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        lblConfirmacionContrasena.setForeground(new java.awt.Color(255, 255, 255));
        lblConfirmacionContrasena.setText("Confirma Contrasena");

        jcbTipoCuenta.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
        jcbTipoCuenta.setForeground(new java.awt.Color(51, 51, 51));
        jcbTipoCuenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bolivianos", "Dolares", "Euros" }));

        lblTipoDeCuenta.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        lblTipoDeCuenta.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoDeCuenta.setText("Tipo de Cuenta");

        lblNroCuenta.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
        lblNroCuenta.setForeground(new java.awt.Color(255, 255, 255));
        lblNroCuenta.setText("0000000000000000");
        lblNroCuenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        lblTituloNroCuenta.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        lblTituloNroCuenta.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloNroCuenta.setText("Nro. Cuenta");

        jPanel1.setBackground(new java.awt.Color(4, 86, 160));

        jLabel1.setFont(new java.awt.Font("Lucida Console", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Crear Cuenta");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        lblAviso.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        lblAviso.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(btnCrearCuenta)
                                .addGap(113, 113, 113))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAviso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(62, 62, 62)))
                        .addComponent(btnSalir)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTituloNroCuenta)
                            .addComponent(lblTipoDeCuenta)
                            .addComponent(lblConfirmacionContrasena)
                            .addComponent(lblNroCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                            .addComponent(jcbTipoCuenta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpwConfirmacionContrasena)
                            .addComponent(jpwNuevaContrasena)
                            .addComponent(jtfNombreCompleto)
                            .addComponent(lblNombreCompleto)
                            .addComponent(lblNuevaContrasena)
                            .addComponent(lblNombreUsuario)
                            .addComponent(jtfNombreUsuario))
                        .addContainerGap(129, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jtfNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombreUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(jtfNombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombreCompleto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(jpwNuevaContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNuevaContrasena)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(jpwConfirmacionContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblConfirmacionContrasena)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(lblTipoDeCuenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTituloNroCuenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAviso, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(btnCrearCuenta))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir)))
                .addGap(42, 42, 42))
        );
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    private javax.swing.JButton btnCrearCuenta;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jcbTipoCuenta;
    private javax.swing.JPasswordField jpwConfirmacionContrasena;
    private javax.swing.JPasswordField jpwNuevaContrasena;
    private javax.swing.JTextField jtfNombreCompleto;
    private javax.swing.JTextField jtfNombreUsuario;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblConfirmacionContrasena;
    private javax.swing.JLabel lblNombreCompleto;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblNroCuenta;
    private javax.swing.JLabel lblNuevaContrasena;
    private javax.swing.JLabel lblTipoDeCuenta;
    private javax.swing.JLabel lblTituloNroCuenta;
    // End of variables declaration                   

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
