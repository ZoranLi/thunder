package com.baidu.android.common.logging;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.MessageFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

class SimpleFormatter extends Formatter {
    private static String format = "{0,date} {0,time}";
    private Object[] args = new Object[1];
    Date dat = new Date();
    private MessageFormat formatter;

    SimpleFormatter() {
    }

    public synchronized String format(LogRecord logRecord) {
        StringBuffer stringBuffer;
        String className;
        String methodName;
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int length = stackTrace.length;
        int i = 0;
        int i2 = i;
        while (i < length) {
            StackTraceElement stackTraceElement = stackTrace[i];
            if (stackTraceElement.getClassName().startsWith(Log.class.getName())) {
                i2 = 1;
            } else if (i2 != 0) {
                className = stackTraceElement.getClassName();
                methodName = stackTraceElement.getMethodName();
                i = stackTraceElement.getLineNumber();
                break;
            }
            i++;
        }
        i = 0;
        className = null;
        methodName = className;
        logRecord.setSourceClassName(className);
        logRecord.setSourceMethodName(methodName);
        stringBuffer = new StringBuffer();
        this.dat.setTime(logRecord.getMillis());
        this.args[0] = this.dat;
        StringBuffer stringBuffer2 = new StringBuffer();
        if (this.formatter == null) {
            this.formatter = new MessageFormat(format);
        }
        this.formatter.format(this.args, stringBuffer2, null);
        stringBuffer.append(stringBuffer2);
        StringBuilder stringBuilder = new StringBuilder(".");
        stringBuilder.append(logRecord.getMillis() % 1000);
        stringBuffer.append(stringBuilder.toString());
        stringBuffer.append(" ");
        stringBuffer.append(logRecord.getSourceClassName() != null ? logRecord.getSourceClassName() : logRecord.getLoggerName());
        if (logRecord.getSourceMethodName() != null) {
            stringBuffer.append(" ");
            stringBuffer.append(logRecord.getSourceMethodName());
        }
        stringBuffer.append(" ");
        stringBuffer.append(i);
        stringBuffer.append(" ");
        methodName = formatMessage(logRecord);
        stringBuffer.append(logRecord.getLevel().getLocalizedName());
        stringBuffer.append(": ");
        stringBuffer.append(methodName);
        stringBuffer.append("\n");
        if (logRecord.getThrown() != null) {
            try {
                Writer stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                logRecord.getThrown().printStackTrace(printWriter);
                printWriter.close();
                stringBuffer.append(stringWriter.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return stringBuffer.toString();
    }
}
