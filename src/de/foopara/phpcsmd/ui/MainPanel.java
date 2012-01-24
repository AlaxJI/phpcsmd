/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainPanel.java
 *
 * Created on 22.01.2012, 17:17:24
 */
package de.foopara.phpcsmd.ui;

import de.foopara.phpcsmd.generics.GenericOptionsPanel;

/**
 *
 * @author nspecht
 */
public class MainPanel extends GenericOptionsPanel {

    private static MainPanel instance = null;

    public static MainPanel getInstance() {
        return MainPanel.instance;
    }

    /** Creates new form MainPanel */
    public MainPanel() {
        initComponents();
        MainPanel.instance = this;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        generalOptionsPanel1 = new de.foopara.phpcsmd.ui.GeneralOptionsPanel();
        phpcsPanel1 = new de.foopara.phpcsmd.ui.phpcs.PhpcsPanel();
        jSeparator1 = new javax.swing.JSeparator();
        phpmdPanel1 = new de.foopara.phpcsmd.ui.phpmd.PhpmdPanel();
        jSeparator2 = new javax.swing.JSeparator();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(generalOptionsPanel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(phpcsPanel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jSeparator1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(phpmdPanel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jSeparator2, gridBagConstraints);

        jScrollPane1.setViewportView(jPanel1);

        add(jScrollPane1);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private de.foopara.phpcsmd.ui.GeneralOptionsPanel generalOptionsPanel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private de.foopara.phpcsmd.ui.phpcs.PhpcsPanel phpcsPanel1;
    private de.foopara.phpcsmd.ui.phpmd.PhpmdPanel phpmdPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void load() {
        this.generalOptionsPanel1.load();
        this.phpcsPanel1.load();
        this.phpmdPanel1.load();
    }

    @Override
    public void save() {
        this.generalOptionsPanel1.save();
        this.phpcsPanel1.save();
        this.phpmdPanel1.save();
    }

    @Override
    public boolean hasValidValues() {
        return true
                && this.generalOptionsPanel1.hasValidValues()
                && this.phpcsPanel1.hasValidValues()
                && this.phpmdPanel1.hasValidValues()
                ;
    }
}