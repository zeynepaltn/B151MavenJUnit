package techproed.day07_Maven_Junit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class C03_BeforeAfter {
    @Before
    public void setUp() throws Exception{
        System.out.println("Her test methodu oncesi bir kez calisir");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Her test methodu sonrasi bir kez calisir");
    }

    @Test
    public void test01() {
        System.out.println("Ilk Test");
    }

    @Test
    public void test02() {
        System.out.println("Ikinci Test");
    }
}//class
