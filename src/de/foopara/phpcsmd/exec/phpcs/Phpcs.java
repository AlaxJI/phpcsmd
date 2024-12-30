package de.foopara.phpcsmd.exec.phpcs;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import org.openide.filesystems.FileObject;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;

import de.foopara.phpcsmd.ViolationRegistry;
import de.foopara.phpcsmd.debug.Logger;
import de.foopara.phpcsmd.generics.GenericExecute;
import de.foopara.phpcsmd.generics.GenericHelper;
import de.foopara.phpcsmd.generics.GenericOutputReader;
import de.foopara.phpcsmd.generics.GenericProcess;
import de.foopara.phpcsmd.generics.GenericResult;
import de.foopara.phpcsmd.option.PhpcsOptions;

/**
 *
 * @author nspecht
 */
public class Phpcs extends GenericExecute
{

    private boolean _enabled = true;

    @Override
    public boolean isEnabled() {
        return this._enabled;
    }

    @Override
    protected GenericResult run(FileObject file, boolean annotations) {
        Logger.getInstance().debug("run", "phpcsmd");
        Lookup lookup = GenericHelper.getFileLookup(file);
        PhpcsOptions options = new PhpcsOptions(lookup);
        if ((Boolean)options.get(PhpcsOptions.Settings.ACTIVATED) == false) {
            Logger.getInstance().debug("ACTIVATED == false", "phpcsmd");
            return this.setAndReturnCurrent(file);
        }

        if (!GenericHelper.isDesirableFile(new File((String)options.get(PhpcsOptions.Settings.SCRIPT)), lookup, false)
                || !GenericHelper.isDesirableFile(file)) {
            Logger.getInstance().debug("!isDesirableFile", "phpcsmd");
            return this.setAndReturnDefault(file);
        }

        if (this.isEnabled() == false) {
            Logger.getInstance().debug("not enabled", "phpcsmd");
            return this.setAndReturnCurrent(file);
        }

        if (!iAmAlive()) {
            Logger.getInstance().debug("I am not Alive", "phpcsmd");
            return this.setAndReturnCurrent(file);
        }

        CustomStandard cstandard = null;
        StringBuilder cmd = new StringBuilder(GenericExecute.escapePath((String)options.get(PhpcsOptions.Settings.SCRIPT)));
        if ((Boolean)options.get(PhpcsOptions.Settings.EXTRAS) == true
                || ((String)options.get(PhpcsOptions.Settings.STANDARD)).trim().length() == 0) {
            cstandard = new CustomStandard(lookup);
            this.appendArgument(cmd, "--standard=", cstandard.toString());
        } else {
            this.appendArgument(cmd, "--standard=", (String)options.get(PhpcsOptions.Settings.STANDARD));
        }
        this.appendArgument(cmd, "--sniffs=", (String)options.get(PhpcsOptions.Settings.SNIFFS));
        this.appendArgument(cmd, "--extensions=", (String)options.get(PhpcsOptions.Settings.EXTENSIONS));
        this.appendArgument(cmd, "--ignore=", (String)options.get(PhpcsOptions.Settings.IGNORES));
        this.appendArgument(cmd, "-d ", GenericHelper.implode(" -d ", ((String)options.get(PhpcsOptions.Settings.INIOVERWRITE)).split(";")));

        if ((Integer)options.get(PhpcsOptions.Settings.TABWIDTH) > -1) {
            cmd.append(" --tab-width=").append((Integer)options.get(PhpcsOptions.Settings.TABWIDTH));
        }

        if ((Boolean)options.get(PhpcsOptions.Settings.WARNINGS) == true) {
            cmd.append(" -w");
        } else {
            cmd.append(" -n");
        }

        cmd.append(" --report=xml");

        cmd.append(" ").append(GenericHelper.escapePath(file));
        Logger.getInstance().logPre(cmd.toString(), "phpcs command");

        /*
         * ExternalProcessBuilder epb = new
         * ExternalProcessBuilder(PhpcsOptions.getScript());
         * epb.workingDirectory(root); epb.addArgument("--standard=" +
         * PhpcsOptions.getStandard()); //epb.addArgument("...");
         * epb.addArgument("--report=xml"); epb.addArgument(file.getPath());
         */
        PhpcsXMLParser parser = new PhpcsXMLParser(lookup);
        if (!iAmAlive()) {
            return this.setAndReturnCurrent(file);
        }
        GenericOutputReader[] reader = GenericProcess.run(cmd.toString(), "", null, lookup);
        if (reader.length < 1) {
            Logger.getInstance().logPre("no output from commmand line", "phpcs command");
            return this.setAndReturnCurrent(file);
        }
        if (!iAmAlive()) {
            return this.setAndReturnCurrent(file);
        }
        PhpcsResult res = parser.parse(reader[0], null);
        if (!iAmAlive()) {
            return this.setAndReturnCurrent(file);
        }

        String staticFile = (String)options.get(PhpcsOptions.Settings.STATIC);
        if (!staticFile.isEmpty()) {
            File staticFile2 = new File(staticFile);
            if (staticFile2.exists() && staticFile2.canRead()) {
                try {
                    Logger.getInstance().log("parsing " + staticFile + " for violoations in " + file.getPath(), "");
                    StringBuilder content = new StringBuilder();
                    content.append(new String(Files.readAllBytes(staticFile2.toPath())));
                    res.addAll(parser.parse(new GenericOutputReader(content), file.getPath()));
                } catch (IOException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
        }
        ViolationRegistry.getInstance().setPhpcs(file, res);

        if ((Boolean)options.get(PhpcsOptions.Settings.EXTRAS) && cstandard != null) {
            cstandard.delete();
        }

        return res;
    }

    private void appendArgument(StringBuilder b, String key, String value) {
        if (value.trim().length() > 0) {
            b.append(" ").append(key).append(value);
        }
    }

    private GenericResult setAndReturnDefault(FileObject file) {
        GenericResult ret = new GenericResult(null, null, null);
        ViolationRegistry.getInstance().setPhpcs(file, ret);
        return ret;
    }

    private GenericResult setAndReturnCurrent(FileObject file) {
        return ViolationRegistry.getInstance().getPhpcs(file);
    }

    public static String[] getStandards(String executable) {
        try {
            File script = new File(executable);
            if (!script.exists() || !script.canExecute() || !script.isFile()) {
                return new String[0];
            }
            Process child = Runtime.getRuntime().exec(GenericExecute.escapePath(executable) + " -i");
            InputStream in = child.getInputStream();
            StringBuilder tmp = new StringBuilder();
            int c;
            while ((c = in.read()) != -1) {
                tmp.append((char)c);
            }
            String installed[] = tmp.toString()
                    .replaceFirst("The installed.*are ", "")
                    .replaceFirst(" and ", ", ")
                    .split(", ");
            return installed;
        } catch (Exception e) {
            Logger.getInstance().log(e);
        }

        return new String[0];
    }
}
