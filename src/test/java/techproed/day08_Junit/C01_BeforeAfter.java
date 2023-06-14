package techproed.day08_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeAfter {
    //Before her test methodundan once, after da her test methodun dan sonra calisir.
    WebDriver driver;
    @Before
    public void setUp() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test01() {
        driver.get("https://techproeducation.com");
    }

    @Test
    public void test02() {
        driver.get("https://amazon.com");
    }
}//class
