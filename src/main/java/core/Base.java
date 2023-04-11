package core;

import resources.WebTestDriver;

public class Base {

    public static WebTestDriver SeleniumExecutionInstance;

    public static String _ReportDirectory;

    public static void set_ReportDirectory(String Directory )
    {
        _ReportDirectory = Directory;
    }

    public static String get_ReportDirectory()
    {
        return _ReportDirectory;
    }

    public static String TestName;
}
