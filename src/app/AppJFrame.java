package app;

import java.util.*;
import javax.swing.*;
import model.*;

/**
 *
 * @author FJRUS
 */

public class AppJFrame extends javax.swing.JFrame {

    List<Integer> listaIdEquipos;
    List<Integer> listaIdJugadores;

    /**
     * Creates new form App
     */
    public AppJFrame() {
        initComponents();
        listaIdEquipos = new ArrayList<>();
        listaIdJugadores = new ArrayList<>();
    }

    public void actualizarListaEquipos() {
        // Obtener cadena de búsqueda
        String busqueda = jTextFieldBuscarEquipos.getText();
        // Crear modelo para la lista
        DefaultListModel<String> listModelEquipos = new DefaultListModel<>();
        // Obtener el orden seleccionado
        int orden = (jRadioButtonOrdenNombre.isSelected()) ? Equipo.ORDEN_NOMBRE : Equipo.ORDEN_PAIS;
        //Obtener equipos
        List<Equipo> listaEquipo = Equipo.obtenerEquipos(busqueda, orden);

        // vaciar la lista de ids de equiopos
        listaIdEquipos.clear();

        // añadir cadenas al modelo e ir guardando los id de los equipos
        for (Equipo e : listaEquipo) {
            listModelEquipos.addElement(String.format("%s - %s (%s)",
                    e.getNombre(), e.getCiudad(), e.getPais()));
            listaIdEquipos.add(e.getId());

        }

        // Establecer el modelo en la lista para que se visualice.
        jListEquipos.setModel(listModelEquipos);
    }

    public void actualizarListaJugadores() {
        
        // Para actualizar la lista de jugadores de la segunda pestaña
       String busqueda = jTextFieldBuscarJugadores.getText();
        DefaultListModel<String> listModelJugador = new DefaultListModel<>();

        List<Jugador> listaJugadores = Jugador.obtenerJugadores(busqueda, jRadioButton1.isSelected(), jRadioButton2.isSelected(), jRadioButton3.isSelected());
        listaIdJugadores.clear();

        for (Jugador j : listaJugadores) {
            listModelJugador.addElement(String.format("%s %s - %d años (%s)", j.getNombre(), j.getApellidos(), j.getEdad(), j.getIdEquipo()));
            listaIdJugadores.add(j.getId());
        }
        jListJugadores.setModel(listModelJugador);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupOrden = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListEquipos = new javax.swing.JList<>();
        jButtonAnnandirEquipo = new javax.swing.JButton();
        jButtonEditarEquipo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListJugadoresEquipo = new javax.swing.JList<>();
        jLabelLBuscar = new javax.swing.JLabel();
        jTextFieldBuscarEquipos = new javax.swing.JTextField();
        jRadioButtonOrdenNombre = new javax.swing.JRadioButton();
        jRadioButtonOrdenPais = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonEliminarEquipo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButtonAnnandirJugadorEquipo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListJugadores = new javax.swing.JList<>();
        jButtonEditarJugador = new javax.swing.JButton();
        jButtonAnnandir = new javax.swing.JButton();
        jLabelLBuscarJugador = new javax.swing.JLabel();
        jTextFieldBuscarJugadores = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jListEquipos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListEquipos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListEquipos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListEquiposValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jListEquipos);

        jButtonAnnandirEquipo.setText("Añadir");
        jButtonAnnandirEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnandirEquipoActionPerformed(evt);
            }
        });

        jButtonEditarEquipo.setText("Editar");
        jButtonEditarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarEquipoActionPerformed(evt);
            }
        });

        jListJugadoresEquipo.setBackground(new java.awt.Color(224, 224, 224));
        jScrollPane2.setViewportView(jListJugadoresEquipo);

        jLabelLBuscar.setText("Buscar");

        jTextFieldBuscarEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBuscarEquiposActionPerformed(evt);
            }
        });

        buttonGroupOrden.add(jRadioButtonOrdenNombre);
        jRadioButtonOrdenNombre.setSelected(true);
        jRadioButtonOrdenNombre.setText("Nombre");
        jRadioButtonOrdenNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonOrdenNombreActionPerformed(evt);
            }
        });

        buttonGroupOrden.add(jRadioButtonOrdenPais);
        jRadioButtonOrdenPais.setText("Pais");
        jRadioButtonOrdenPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonOrdenPaisActionPerformed(evt);
            }
        });

        jLabel1.setText("Orden:");

        jButtonEliminarEquipo.setText("Eliminar");
        jButtonEliminarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarEquipoActionPerformed(evt);
            }
        });

        jLabel2.setText("Jugadores del equipo:");

        jButtonAnnandirJugadorEquipo.setText("Añadir Jugador a Equipo");
        jButtonAnnandirJugadorEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnandirJugadorEquipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelLBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldBuscarEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonOrdenNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonOrdenPais))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonAnnandirEquipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEditarEquipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEliminarEquipo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jButtonAnnandirJugadorEquipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLBuscar)
                    .addComponent(jTextFieldBuscarEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonOrdenNombre)
                    .addComponent(jRadioButtonOrdenPais)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAnnandirJugadorEquipo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAnnandirEquipo)
                    .addComponent(jButtonEditarEquipo)
                    .addComponent(jButtonEliminarEquipo))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Equipos", jPanel1);

        jListJugadores.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jListJugadores);

        jButtonEditarJugador.setText("Editar");

        jButtonAnnandir.setText("Añadir");

        jLabelLBuscarJugador.setText("Buscar");

        jTextFieldBuscarJugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBuscarJugadoresActionPerformed(evt);
            }
        });

        jLabel3.setText("Categoría");

        jRadioButton1.setText("Junior");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("Class");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setText("Master");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButtonAnnandir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonEditarJugador))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabelLBuscarJugador)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldBuscarJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton1)
                                    .addComponent(jRadioButton2)
                                    .addComponent(jRadioButton3))))
                        .addGap(0, 149, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jRadioButton1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelLBuscarJugador)
                            .addComponent(jTextFieldBuscarJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAnnandir)
                    .addComponent(jButtonEditarJugador))
                .addGap(11, 11, 11))
        );

        jTabbedPane1.addTab("Jugadores", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        actualizarListaEquipos();
        actualizarListaJugadores();
    }//GEN-LAST:event_formWindowOpened

    private void jListEquiposValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListEquiposValueChanged
        if (evt.getValueIsAdjusting()) { // Un evento transitorio en seleccion múltiple
            return; // no nos interesa
        }
        int indice = jListEquipos.getSelectedIndex();
        Equipo e = new Equipo(indice);
        e.retrieve();
        if (indice >= 0) {
            DefaultListModel<String> listModelJugadores = new DefaultListModel<>();
            List<Jugador> listaJugadores = e.getJugadores();
            for (Jugador j : listaJugadores) {
                listModelJugadores.addElement(String.format("%s, %s (%d)",
                        j.getApellidos(), j.getNombre(), j.getEdad()));
            }
            jListJugadoresEquipo.setModel(listModelJugadores);
        }
    }//GEN-LAST:event_jListEquiposValueChanged

    private void jRadioButtonOrdenNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonOrdenNombreActionPerformed
        actualizarListaEquipos();
    }//GEN-LAST:event_jRadioButtonOrdenNombreActionPerformed

    private void jButtonAnnandirEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnandirEquipoActionPerformed
        Equipo e = new Equipo();
        EquipoJDialog dialogoEquipo = new EquipoJDialog(this, e);
        dialogoEquipo.setVisible(true);
    }//GEN-LAST:event_jButtonAnnandirEquipoActionPerformed

    private void jButtonEditarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarEquipoActionPerformed
        int indice = jListEquipos.getSelectedIndex();
        if (indice >= 0) {
            int id = listaIdEquipos.get(indice);
            Equipo e = new Equipo(id);
            e.retrieve();
            EquipoJDialog dialogoEquipo = new EquipoJDialog(this, e);
            dialogoEquipo.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un equipo", "Atención", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jButtonEditarEquipoActionPerformed

    private void jButtonAnnandirJugadorEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnandirJugadorEquipoActionPerformed
        int indice = jListEquipos.getSelectedIndex();
        if (indice >= 0) {
            int id = listaIdEquipos.get(indice);
            Jugador j = new Jugador();
            j.setIdEquipo(id);
            JugadorJDialog dialogoJugador = new JugadorJDialog(this, j);
            dialogoJugador.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un equipo", "Atención", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAnnandirJugadorEquipoActionPerformed

    private void jButtonEliminarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarEquipoActionPerformed
        int indice = jListEquipos.getSelectedIndex();
        if (indice >= 0) {
            if (JOptionPane.showConfirmDialog(this, "¿Está seguro?", "Confirmación", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
                int id = listaIdEquipos.get(indice);
                Equipo e = new Equipo(id);
                e.delete();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un equipo", "Atención", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jButtonEliminarEquipoActionPerformed

    private void jRadioButtonOrdenPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonOrdenPaisActionPerformed
        // TODO add your handling code here:
        actualizarListaEquipos();
    }//GEN-LAST:event_jRadioButtonOrdenPaisActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        actualizarListaEquipos();
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        actualizarListaEquipos();
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        actualizarListaEquipos();
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jTextFieldBuscarJugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBuscarJugadoresActionPerformed
        // TODO add your handling code here:
        actualizarListaEquipos();
    }//GEN-LAST:event_jTextFieldBuscarJugadoresActionPerformed

    private void jTextFieldBuscarEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBuscarEquiposActionPerformed
        // TODO add your handling code here:
        actualizarListaEquipos();
    }//GEN-LAST:event_jTextFieldBuscarEquiposActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AppJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupOrden;
    private javax.swing.JButton jButtonAnnandir;
    private javax.swing.JButton jButtonAnnandirEquipo;
    private javax.swing.JButton jButtonAnnandirJugadorEquipo;
    private javax.swing.JButton jButtonEditarEquipo;
    private javax.swing.JButton jButtonEditarJugador;
    private javax.swing.JButton jButtonEliminarEquipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelLBuscar;
    private javax.swing.JLabel jLabelLBuscarJugador;
    private javax.swing.JList<String> jListEquipos;
    private javax.swing.JList<String> jListJugadores;
    private javax.swing.JList<String> jListJugadoresEquipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButtonOrdenNombre;
    private javax.swing.JRadioButton jRadioButtonOrdenPais;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextFieldBuscarEquipos;
    private javax.swing.JTextField jTextFieldBuscarJugadores;
    // End of variables declaration//GEN-END:variables
}
