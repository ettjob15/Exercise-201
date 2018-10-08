package ex201;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class VelocityGUI extends javax.swing.JFrame {

    VelocityTableModel vtm;

    public VelocityGUI() {
        initComponents();
        this.setTitle("Geschwindigkeitsmessungen");
        this.setSize(600, 400);
        vtm = new VelocityTableModel();
        jTmeasures.setModel(vtm);
        jTmeasures.setDefaultRenderer(Object.class, new VelocityTableRenderer());
    }

    private JFileChooser createFileChooser() {
        JFileChooser fc = new JFileChooser();
        fc.setAcceptAllFileFilterUsed(false);
        fc.setFileFilter(new MyFileFilter());
        return fc;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        Hinzufügen = new javax.swing.JMenuItem();
        Löschen = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        Durchschnitt = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTmeasures = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();

        Hinzufügen.setText("Hinzufügen");
        Hinzufügen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onAddMeasure(evt);
            }
        });
        jPopupMenu1.add(Hinzufügen);

        Löschen.setText("Löschen");
        Löschen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onRemoveMeasure(evt);
            }
        });
        jPopupMenu1.add(Löschen);
        jPopupMenu1.add(jSeparator1);

        Durchschnitt.setText("Durchschnitt");
        Durchschnitt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onDisplayAverage(evt);
            }
        });
        jPopupMenu1.add(Durchschnitt);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setComponentPopupMenu(jPopupMenu1);

        jTmeasures.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTmeasures.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(jTmeasures);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Datei");

        jMenuItem1.setText("Speichern");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onSaveData(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Laden");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onLoadData(evt);
            }
        });
        jMenu1.add(jMenuItem2);
        jMenu1.add(jSeparator2);

        jMenuItem3.setText("Beendigung");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onExit(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onSaveData(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onSaveData
        JFileChooser fc = createFileChooser();

        int ok = fc.showSaveDialog(this);
        if (ok == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();

            try {
                vtm.save(f);
            } catch (IOException ex) {
                Logger.getLogger(VelocityGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_onSaveData

    private void onLoadData(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onLoadData
        JFileChooser fc = createFileChooser();

        int ok = fc.showOpenDialog(this);
        if (ok == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();

            try {
                vtm.load(f);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(VelocityGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_onLoadData

    private void onExit(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onExit
        System.exit(0);
    }//GEN-LAST:event_onExit

    private void onAddMeasure(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onAddMeasure
        VelocityDlg dlg = new VelocityDlg(this, true);
        dlg.setVisible(true);

        if (dlg.isOk()) {
            vtm.add(dlg.getData());
        } else {
            JOptionPane.showMessageDialog(null, "Hinzufügen hat nicht funktioniert!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_onAddMeasure

    private void onRemoveMeasure(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onRemoveMeasure
        int[] auswahl = jTmeasures.getSelectedRows();
        vtm.remove(auswahl);
    }//GEN-LAST:event_onRemoveMeasure

    private void onDisplayAverage(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onDisplayAverage
        try {
            JOptionPane.showMessageDialog(null, "Der Durchschnitt beträgt: " + vtm.average() + "km/h", "Durchschnitt", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Durchschnitt konnte nicht errechnet werden!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_onDisplayAverage

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
            java.util.logging.Logger.getLogger(VelocityGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VelocityGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VelocityGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VelocityGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VelocityGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Durchschnitt;
    private javax.swing.JMenuItem Hinzufügen;
    private javax.swing.JMenuItem Löschen;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTable jTmeasures;
    // End of variables declaration//GEN-END:variables
}
