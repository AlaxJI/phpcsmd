package de.foopara.phpcsmd.threads;

import de.foopara.phpcsmd.debug.Logger;
import de.foopara.phpcsmd.generics.GenericHelper;
import de.foopara.phpcsmd.ui.reports.ScanReportTopComponent;
import java.io.File;
import java.io.IOException;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.Exceptions;

/**
 *
 * @author n.specht
 */
public class FileCountThread extends Thread {

    private FileObject fo = null;
    private boolean interupted = false;
    private ScanReportTopComponent component = null;

    public void setFileObject(FileObject fo) {
        this.fo = fo;
    }

    public void setTopComponent(ScanReportTopComponent c) {
        this.component = c;
    }

        /*
         * Nur damit Netbeans die Klappe hällt
         */
        @Override
    public void run() {
        this.count();
    }

    public void count() {
        File f = FileUtil.toFile(this.fo);
        this.count(f, 0);

    }

    private int count(File f, int fc) {
        for (File f2 : f.listFiles()) {
            try {
                if (GenericHelper.isDesirableFile(f2) && !GenericHelper.isSymlink(f2)) {
                    fc += 1;
                    this.component.setMaximumFilecount(fc);
                } else if (f2.isDirectory() && !GenericHelper.isSymlink(f2)) {
                    fc = this.count(f2, fc);
                }
            } catch (IOException ex) {
                Logger.getInstance().log(ex);
                Exceptions.printStackTrace(ex);
            }
        }
        return fc;
    }
}
