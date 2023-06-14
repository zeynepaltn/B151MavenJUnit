package techproed.day08_Junit;

import org.junit.*;

public class C02_BeforeClassAfterClass {
    /*
    @BeforeClass class'da en once calisan methoddur
    @AfterClass class'da en son calisan methoddur
    @BeforeClass da @AfterClass'da sadece static methodlar ile calisir
     */

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Class'da en once calisan methoddur ve sadece bir kez calisir ");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Class'da en son calisan methoddur ve sadece bir kez calisir");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Her test methodundan once calisir");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her test methodundan sonra calisir");
    }

    @Test
    public void test01() {
        System.out.println("Ilk test");
    }

    @Test
    public void test02() {
        System.out.println("Ikinci test");
    }
}
