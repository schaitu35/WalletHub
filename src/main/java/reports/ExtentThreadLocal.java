package reports;

import com.aventstack.extentreports.ExtentTest;

import java.lang.annotation.Documented;

public class ExtentThreadLocal {


    private static ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();

    public static ExtentTest getExtentTest() {
        return extentTestThreadLocal.get();
    }

    public static void setExtentTest(ExtentTest extentTest) {
        extentTestThreadLocal.set(extentTest);
    }









}
