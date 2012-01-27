/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.foopara.phpcsmd.generics;

import de.foopara.phpcsmd.ViolationRegistry;
import de.foopara.phpcsmd.exec.phpcs.Phpcs;
import de.foopara.phpcsmd.exec.phpmd.Phpmd;
import java.util.ArrayList;
import org.openide.filesystems.FileObject;

/**
 *
 * @author n.specht
 */
public class QAThread extends Thread {
        private static ArrayList<QAThread> instances = new ArrayList<QAThread>();

        private FileObject fo =null;

        private boolean interupted = false;

        public void setFileObject(FileObject fo) {
            this.fo = fo;
        }

        public boolean isThreadFor(FileObject fo) {
            return fo.getPath().compareTo(fo.getPath()) == 0;
        }

        /*
         * Nur damit Netbeans die Klappe hällt
         */
        @Override
        public void run() {
            this.qarun();
        }

        public void qarun() {
            for (QAThread t : QAThread.instances) {
                if (t.isThreadFor(this.fo)) t.interupt();
                while(QAThread.instances.lastIndexOf(this) > 0) {
                }
            }

            QAThread.instances.add(this);
            if (!this.interupted) new Phpcs().execute(this.fo);
            if (!this.interupted) new Phpmd().execute(this.fo);
            if (!this.interupted) ViolationRegistry.getInstance().reprintTasks(this.fo);

            QAThread.instances.remove(this);
        }

        public void interupt() {
            this.interupted = true;
        }

        public boolean isInterupted() {
            return this.interupted;
        }
}