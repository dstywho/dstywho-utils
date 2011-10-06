package dstywho.joda;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class USDateFormats {
    public static final DateTimeFormatter mmddyyyy = DateTimeFormat.forPattern("MM/dd/yyyy");
    public static final DateTimeFormatter mmddyy   = DateTimeFormat.forPattern("MM/dd/YY");
}