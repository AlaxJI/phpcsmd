package de.foopara.phpcsmd.debug;

import de.foopara.phpcsmd.option.GeneralOptions;

/**
 *
 * @author nspecht
 */
public class Logger {

    public enum Severity {
        ALL, TRACE, DEBUG, INFO, WARNING, ERROR, FATAL
    }

    private static volatile Logger instance = null;

    public static Logger getInstance() {
        if (Logger.instance == null) {
            Logger.instance = new Logger();
        }
        return Logger.instance;
    }

    protected StringBuilder buff = new StringBuilder();

    public void debug(String str) {
        this.log(str, null, Severity.DEBUG);
    }

    public void debug(String str, String caption) {
        this.log(str, caption, Severity.DEBUG);
    }

    public void info(String str) {
        this.log(str);
    }

    public void info(String str, String caption) {
        this.log(str, caption);
    }

    public void warning(String str) {
        this.log(str, null, Severity.WARNING);
    }

    public void warning(String str, String caption) {
        this.log(str, caption, Severity.WARNING);
    }

    public void log(String str) {
        this.log(str, null, Severity.INFO);
    }

    public void log(String str, String caption) {
        this.log(str, caption, Severity.INFO);
    }

    public void log(String str, String caption, Severity severity) {
        if (severity.ordinal() < (Integer) GeneralOptions.loadOriginal(GeneralOptions.Settings.MINSEVERITY)) {
            return;
        }

        if ((Boolean) GeneralOptions.loadOriginal(GeneralOptions.Settings.DEBUGLOG) == true) {
            caption = caption != null ? caption : "";
            this.buff.append("<tr>");
            this.buff.append("<td style=\"vertical-align:top\"><b>").append(caption).append("</b></td>");
            this.buff.append("<td style=\"vertical-align:top\">").append(str).append("</td>");
            this.buff.append("</tr>");
        }
    }

    public void log(Error ex) {
        this.log(ex, Severity.ERROR);
    }

    public void log(Error ex, Severity severity) {
        StringBuilder exStr = new StringBuilder();
//        exStr.append(ex.getMessage()).append("\n");
        for (StackTraceElement element : ex.getStackTrace()) {
            exStr.append(element.toString()).append("\n");
        }
        this.log("<pre style=\"padding:5px\">" + exStr.toString() + "</pre>", "Error:<br />" + ex.getMessage(), severity);
    }

    public void log(Exception ex) {
        this.log(ex, Severity.FATAL);
    }

    public void log(Exception ex, Severity severity) {
        StringBuilder exStr = new StringBuilder();
//        exStr.append(ex.getMessage()).append("\n");
        for (StackTraceElement element : ex.getStackTrace()) {
            exStr.append(element.toString()).append("\n");
        }
        this.log("<pre style=\"padding:5px\">" + exStr.toString() + "</pre>", "Exception:<br />" + ex.getMessage(), severity);
    }

    public void logPre(String str, String caption) {
        this.logPre(str, caption, Severity.INFO);
    }

    public void logPre(String str, String caption, Severity severity) {
        str = str
                .replaceAll(" ", "&nbsp;")
                .replaceAll("[^A-Za-z0-9\\.\\n\\r\\w\\\\\\/\\!\\$%&:,;\\(\\)=\\?\"'<>\\*-]", "&otimes;")
                .replaceAll("<", "&lt;")
                .replaceAll(">", "&gt;")
                .replaceAll("\n", "<br />");
        this.log("<pre style=\"border:#444444 1px solid;padding:5px;\">" + str + "</pre>", caption, severity);
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("<html>")
                .append("<body style=\"font-size:10px\">")
                .append("<table cellspacing=\"0\" cellpadding=\"1\">")
                .append(this.buff.toString())
                .append("</table>")
                .append("</body>")
                .append("</html>");
        return ret.toString();
    }

    public void clear() {
        this.buff = new StringBuilder();
    }

}
