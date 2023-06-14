package techproed.day10_TestBase;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {

    @Test
    public void test01() {
        //Techproeducation sayfasina gidin
        driver.get("https://techproeducation.com");

        //Basligin "Bootcamp" icerdigini test edin
        String actualTitle=driver.getTitle();
        String expectedTitle="Bootcamp";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }
}
