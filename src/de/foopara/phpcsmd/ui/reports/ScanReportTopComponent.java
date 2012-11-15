package de.foopara.phpcsmd.ui.reports;

import de.foopara.phpcsmd.generics.GenericHelper;
import de.foopara.phpcsmd.generics.GenericPokeRegistry;
import de.foopara.phpcsmd.generics.GenericTopComponent;
import de.foopara.phpcsmd.option.PhpcpdOptions;
import de.foopara.phpcsmd.option.PhpcsOptions;
import de.foopara.phpcsmd.option.PhpmdOptions;
import de.foopara.phpcsmd.threads.FileCountThread;
import de.foopara.phpcsmd.threads.RescanThread;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import org.netbeans.api.actions.Openable;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//de.foopara.phpcsmd.ui.reports//ScanReport//EN",
autostore = false)
@TopComponent.Description(preferredID = "ScanReportTopComponent",
iconBase = "de/foopara/phpcsmd/resources/icon.png",
persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "de.foopara.phpcsmd.ui.reports.ScanReportTopComponent")
@ActionReference(path = "Menu/Window" /*
 * , position = 333
 */)
@TopComponent.OpenActionRegistration(displayName = "#CTL_ScanReportAction",
preferredID = "ScanReportTopComponent")
@Messages({
    "CTL_ScanReportAction=ScanReport",
    "CTL_ScanReportTopComponent=ScanReport",
    "HINT_ScanReportTopComponent=This is a ScanReport window"
})
public final class ScanReportTopComponent extends GenericTopComponent {

    private FileObject fileObject;

    public ScanReportTopComponent() {
        initComponents();
        setName(Bundle.CTL_ScanReportTopComponent());
        setToolTipText(Bundle.HINT_ScanReportTopComponent());
        this.scanReportTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() > 1) {
                    openSelectedFile();
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        scanReportTable1 = new de.foopara.phpcsmd.ui.reports.ScanReportTable();
        jLabel3 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        optFullRescan = new javax.swing.JCheckBox();
        enablePhpcs = new javax.swing.JCheckBox();
        enablePhpmd = new javax.swing.JCheckBox();
        enablePhpcpd = new javax.swing.JCheckBox();

        setLayout(new java.awt.GridBagLayout());

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(ScanReportTopComponent.class, "ScanReportTopComponent.jLabel1.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        add(jLabel1, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(ScanReportTopComponent.class, "ScanReportTopComponent.jLabel2.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        add(jLabel2, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(ScanReportTopComponent.class, "ScanReportTopComponent.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 2, 2);
        add(jButton1, gridBagConstraints);

        jScrollPane1.setViewportView(scanReportTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        add(jScrollPane1, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 0, 10)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(ScanReportTopComponent.class, "ScanReportTopComponent.jLabel3.text")); // NOI18N
        jLabel3.setMaximumSize(new java.awt.Dimension(600, 13));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 10);
        add(jLabel3, gridBagConstraints);

        jProgressBar1.setMaximum(1);
        jProgressBar1.setFocusable(false);
        jProgressBar1.setMaximumSize(new java.awt.Dimension(70000, 35));
        jProgressBar1.setMinimumSize(new java.awt.Dimension(70, 35));
        jProgressBar1.setPreferredSize(new java.awt.Dimension(70, 35));
        jProgressBar1.setStringPainted(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 2, 2);
        add(jProgressBar1, gridBagConstraints);

        optFullRescan.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(optFullRescan, org.openide.util.NbBundle.getMessage(ScanReportTopComponent.class, "ScanReportTopComponent.optFullRescan.text")); // NOI18N
        optFullRescan.setMaximumSize(new java.awt.Dimension(80, 35));
        optFullRescan.setMinimumSize(new java.awt.Dimension(80, 35));
        optFullRescan.setPreferredSize(new java.awt.Dimension(80, 35));
        optFullRescan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optFullRescanActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 2, 2);
        add(optFullRescan, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(enablePhpcs, org.openide.util.NbBundle.getMessage(ScanReportTopComponent.class, "ScanReportTopComponent.enablePhpcs.text")); // NOI18N
        enablePhpcs.setMaximumSize(new java.awt.Dimension(80, 35));
        enablePhpcs.setMinimumSize(new java.awt.Dimension(80, 35));
        enablePhpcs.setPreferredSize(new java.awt.Dimension(80, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 2, 2);
        add(enablePhpcs, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(enablePhpmd, org.openide.util.NbBundle.getMessage(ScanReportTopComponent.class, "ScanReportTopComponent.enablePhpmd.text")); // NOI18N
        enablePhpmd.setMaximumSize(new java.awt.Dimension(80, 35));
        enablePhpmd.setMinimumSize(new java.awt.Dimension(80, 35));
        enablePhpmd.setPreferredSize(new java.awt.Dimension(80, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 2, 2);
        add(enablePhpmd, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(enablePhpcpd, org.openide.util.NbBundle.getMessage(ScanReportTopComponent.class, "ScanReportTopComponent.enablePhpcpd.text")); // NOI18N
        enablePhpcpd.setMaximumSize(new java.awt.Dimension(80, 35));
        enablePhpcpd.setMinimumSize(new java.awt.Dimension(80, 35));
        enablePhpcpd.setPreferredSize(new java.awt.Dimension(80, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 2, 2);
        add(enablePhpcpd, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.jProgressBar1.setValue(0);
        this.jProgressBar1.setMaximum(1);

        FileCountThread t1 = new FileCountThread(this.lkp);
        t1.setFileObject(this.fileObject);
        t1.setTopComponent(this);

        RescanThread t2 = new RescanThread(this.lkp);
        t2.setFileObject(this.fileObject);
        t2.setTopComponent(this);
        t2.setRetrieveValuesFromRegistry(!this.optFullRescan.isSelected());
        t2.enablePhpcs(this.enablePhpcs.isSelected());
        t2.enablePhpmd(this.enablePhpmd.isSelected());
        t2.enablePhpcpd(this.enablePhpcpd.isSelected());

        this.scanReportTable1.flushElements();
        this.jProgressBar1.setVisible(true);
        this.jButton1.setEnabled(false);
        this.optFullRescan.setEnabled(false);
        this.enablePhpcs.setEnabled(false);
        this.enablePhpmd.setEnabled(false);
        this.enablePhpcpd.setEnabled(false);
        this.jButton1.setVisible(false);
        this.optFullRescan.setVisible(false);
        this.enablePhpcs.setVisible(false);
        this.enablePhpmd.setVisible(false);
        this.enablePhpcpd.setVisible(false);

        t1.start();
        t2.start();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void optFullRescanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optFullRescanActionPerformed
        if (this.optFullRescan.isSelected()) {
            this.jButton1.setText("Rescan");
        } else {
            this.jButton1.setText("Refresh");
        }
    }//GEN-LAST:event_optFullRescanActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox enablePhpcpd;
    private javax.swing.JCheckBox enablePhpcs;
    private javax.swing.JCheckBox enablePhpmd;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox optFullRescan;
    private de.foopara.phpcsmd.ui.reports.ScanReportTable scanReportTable1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void componentOpened() {
        if (this.fileObject == null) {
            this.close();
            return;
        }
        GenericPokeRegistry.getInstance().register(this);
        this.toFront();
        this.setRescanDone();

        this.optFullRescan.setSelected(true);
        this.jButton1.setText("Rescan");
        this.enablePhpcs.setVisible(true);
        this.enablePhpmd.setVisible(true);
        this.enablePhpcpd.setVisible(true);
        this.enablePhpcs.setSelected((Boolean)PhpcsOptions.load(PhpcsOptions.Settings.ACTIVATED, this.lkp));
        this.enablePhpmd.setSelected((Boolean)PhpmdOptions.load(PhpmdOptions.Settings.ACTIVATED, this.lkp));
        this.enablePhpcpd.setSelected((Boolean)PhpcpdOptions.load(PhpcpdOptions.Settings.ACTIVATED, this.lkp) || (Boolean)PhpcpdOptions.load(PhpcpdOptions.Settings.ACTIVATEDFOLDER, this.lkp));
        this.enablePhpcs.setEnabled((Boolean)PhpcsOptions.load(PhpcsOptions.Settings.ACTIVATED, this.lkp));
        this.enablePhpmd.setEnabled((Boolean)PhpmdOptions.load(PhpmdOptions.Settings.ACTIVATED, this.lkp));
        this.enablePhpcpd.setEnabled((Boolean)PhpcpdOptions.load(PhpcpdOptions.Settings.ACTIVATED, this.lkp) || (Boolean)PhpcpdOptions.load(PhpcpdOptions.Settings.ACTIVATEDFOLDER, this.lkp));
        // add custom code on component opening
    }

    @Override
    public void componentClosed() {
        GenericPokeRegistry.getInstance().unregister(this);
        // add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // store your settings
    }

    void readProperties(java.util.Properties p) {
        //String version = p.getProperty("version");
        // read your settings according to their version
    }

    public void setRescanDone() {
        this.jProgressBar1.setVisible(false);
        this.optFullRescan.setSelected(false);
        this.jLabel3.setVisible(false);

        this.jButton1.setEnabled(true);
        this.optFullRescan.setEnabled(true);
        this.enablePhpcs.setEnabled((Boolean)PhpcsOptions.load(PhpcsOptions.Settings.ACTIVATED, this.lkp));
        this.enablePhpmd.setEnabled((Boolean)PhpmdOptions.load(PhpmdOptions.Settings.ACTIVATED, this.lkp));
        this.enablePhpcpd.setEnabled((Boolean)PhpcpdOptions.load(PhpcpdOptions.Settings.ACTIVATED, this.lkp) || (Boolean)PhpcpdOptions.load(PhpcpdOptions.Settings.ACTIVATEDFOLDER, this.lkp));
        this.jButton1.setVisible(true);
        this.optFullRescan.setVisible(true);
        this.enablePhpcs.setVisible(true);
        this.enablePhpmd.setVisible(true);
        this.enablePhpcpd.setVisible(true);
        this.printSummary();
    }

    public void setFileObject(FileObject fo) {
        this.fileObject = fo;
        this.jLabel2.setText(this.fileObject.getPath());
        this.scanReportTable1.setRootDirectory(fo);
        this.setDisplayName("ScanReport: " + fo.getName());
    }

    public void setMaximumFilecount(int fc) {
        this.jProgressBar1.setMaximum(fc);
        this.jProgressBar1.setString(this.jProgressBar1.getValue() + "/" + this.jProgressBar1.getMaximum());
    }

    public void setScannedFilecount(int fc) {
        fc = Math.min(fc, this.jProgressBar1.getMaximum());
        this.jProgressBar1.setValue(fc);
        this.jProgressBar1.setString(this.jProgressBar1.getValue() + "/" + this.jProgressBar1.getMaximum());
    }

    public void addElementToTable(FileObject fo) {
        this.scanReportTable1.addElement(fo);
    }

    public void poke(FileObject fo) {
        this.scanReportTable1.poke(fo);
        this.printSummary();
    }

    public void openSelectedFile() {
        String path = (String)this.scanReportTable1.getValueAt(this.scanReportTable1.getSelectedRow(), 0);
        path = this.fileObject.getPath() + path;
        FileObject fo = FileUtil.toFileObject(new File(path));
        if (!GenericHelper.isDesirableFile(fo)) {
            return;
        }

        Openable oc = GenericHelper.getFileLookup(fo).lookup(Openable.class);
        if (oc != null) {
            oc.open();
        }

    }

    private void printSummary() {
        if (this.scanReportTable1.getViolationCount() > 0) {
            this.jLabel3.setVisible(true);
            StringBuilder buf = new StringBuilder("<html><body style=\"font-size:8px\">");
            buf.append("<b>files:</b> ").append(this.scanReportTable1.getFilesCount());
            this.appendSummaryText(buf, "phpcs", this.scanReportTable1.getPhpcsErrorsCount(), this.scanReportTable1.getPhpcsWarningsCount());
            this.appendSummaryText(buf, "phpmd", this.scanReportTable1.getPhpmdErrorsCount(), this.scanReportTable1.getPhpmdWarningsCount());
            this.appendSummaryText(buf, "phpcpd", this.scanReportTable1.getPhpcpdErrorsCount(), this.scanReportTable1.getPhpcpdWarningsCount());
            buf.append("</body></html>");
            this.jLabel3.setText(buf.toString());
        }
    }

    private void appendSummaryText(StringBuilder buf, String caption, Integer errors, Integer warnings) {
        if (errors  +warnings > 0) {
            buf.append(" <b>").append(caption).append(":</b> ");
            if (errors > 0) {
                buf.append("<font style=\"color:#ff0000\">").append(errors).append("</font>");
                if (warnings > 0) buf.append(" / ");
            }
            if (warnings > 0) {
                buf.append("<font style=\"color:#cccc00\">").append(warnings).append("</font>");
            }
        }
    }

    @Override
    public void setCommandOutput(String output) {
    }
}
