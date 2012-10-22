/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.foopara.phpcsmd.ui.phpcpd;

import de.foopara.phpcsmd.generics.GenericOptionsPanel;
import de.foopara.phpcsmd.option.PhpcpdOptions;
import org.openide.util.Lookup;

/**
 *
 * @author n.specht
 */
public class PhpcpdPropertyPanel extends GenericOptionsPanel {

    protected Lookup lkp;

    public PhpcpdPropertyPanel() {
        this(null);
    }
    /**
     * Creates new form PhpcpdPropertyPanel
     */
    public PhpcpdPropertyPanel(Lookup lkp) {
        super();
        this.lkp = lkp;
        initComponents();
        this.load();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        owMinLines = new javax.swing.JCheckBox();
        optMinLines = new javax.swing.JSpinner();
        owMinTokens = new javax.swing.JCheckBox();
        optMinTokens = new javax.swing.JSpinner();
        owSuffix = new javax.swing.JCheckBox();
        optSuffixes = new javax.swing.JTextField();
        owExclude = new javax.swing.JCheckBox();
        optExclude = new javax.swing.JTextField();

        setLayout(new java.awt.GridBagLayout());

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(PhpcpdPropertyPanel.class, "PhpcpdPropertyPanel.jLabel1.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 2, 2);
        add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 2, 2);
        add(jSeparator1, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(owMinLines, org.openide.util.NbBundle.getMessage(PhpcpdPropertyPanel.class, "PhpcpdPropertyPanel.owMinLines.text")); // NOI18N
        owMinLines.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                owActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        add(owMinLines, gridBagConstraints);

        optMinLines.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(5), Integer.valueOf(1), null, Integer.valueOf(1)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        add(optMinLines, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(owMinTokens, org.openide.util.NbBundle.getMessage(PhpcpdPropertyPanel.class, "PhpcpdPropertyPanel.owMinTokens.text")); // NOI18N
        owMinTokens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                owActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        add(owMinTokens, gridBagConstraints);

        optMinTokens.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(70), Integer.valueOf(1), null, Integer.valueOf(1)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        add(optMinTokens, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(owSuffix, org.openide.util.NbBundle.getMessage(PhpcpdPropertyPanel.class, "PhpcpdPropertyPanel.owSuffix.text")); // NOI18N
        owSuffix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                owActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        add(owSuffix, gridBagConstraints);

        optSuffixes.setText(org.openide.util.NbBundle.getMessage(PhpcpdPropertyPanel.class, "PhpcpdPropertyPanel.optSuffixes.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        add(optSuffixes, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(owExclude, org.openide.util.NbBundle.getMessage(PhpcpdPropertyPanel.class, "PhpcpdPropertyPanel.owExclude.text")); // NOI18N
        owExclude.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                owActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        add(owExclude, gridBagConstraints);

        optExclude.setText(org.openide.util.NbBundle.getMessage(PhpcpdPropertyPanel.class, "PhpcpdPropertyPanel.optExclude.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        add(optExclude, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void owActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_owActionPerformed
        this.updateForm();
    }//GEN-LAST:event_owActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField optExclude;
    private javax.swing.JSpinner optMinLines;
    private javax.swing.JSpinner optMinTokens;
    private javax.swing.JTextField optSuffixes;
    private javax.swing.JCheckBox owExclude;
    private javax.swing.JCheckBox owMinLines;
    private javax.swing.JCheckBox owMinTokens;
    private javax.swing.JCheckBox owSuffix;
    // End of variables declaration//GEN-END:variables

    @Override
    public void load() {
        owMinLines.setSelected(PhpcpdOptions.isOverwritten(PhpcpdOptions.Settings.MINLINES, this.lkp));
        optMinLines.setValue((Integer)PhpcpdOptions.load(PhpcpdOptions.Settings.MINLINES, this.lkp));
        owMinTokens.setSelected(PhpcpdOptions.isOverwritten(PhpcpdOptions.Settings.MINTOKENS, this.lkp));
        optMinTokens.setValue((Integer)PhpcpdOptions.load(PhpcpdOptions.Settings.MINTOKENS, this.lkp));
        owSuffix.setSelected(PhpcpdOptions.isOverwritten(PhpcpdOptions.Settings.SUFFIXES, this.lkp));
        optSuffixes.setText((String)PhpcpdOptions.load(PhpcpdOptions.Settings.SUFFIXES, this.lkp));
        owExclude.setSelected(PhpcpdOptions.isOverwritten(PhpcpdOptions.Settings.EXCLUDE, this.lkp));
        optExclude.setText((String)PhpcpdOptions.load(PhpcpdOptions.Settings.EXCLUDE, this.lkp));
        this.updateForm();
    }

    @Override
    public void save() {
        PhpcpdOptions.overwrite(PhpcpdOptions.Settings.MINLINES, owMinLines.isSelected() ? optMinLines.getValue() : null, this.lkp);
        PhpcpdOptions.overwrite(PhpcpdOptions.Settings.MINTOKENS, owMinTokens.isSelected() ? optMinTokens.getValue() : null, this.lkp);
        PhpcpdOptions.overwrite(PhpcpdOptions.Settings.SUFFIXES, owSuffix.isSelected() ? optSuffixes.getText() : null, this.lkp);
        PhpcpdOptions.overwrite(PhpcpdOptions.Settings.EXCLUDE, owExclude.isSelected() ? optExclude.getText() : null, this.lkp);
    }

    public void updateForm() {
        optMinLines.setEnabled(owMinLines.isSelected());
        optMinTokens.setEnabled(owMinTokens.isSelected());
        optSuffixes.setEnabled(owSuffix.isSelected());
        optExclude.setEnabled(owExclude.isSelected());
    }

    @Override
    public boolean hasValidValues() {
        return true;
    }
}
