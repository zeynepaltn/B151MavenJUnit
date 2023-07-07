package techproed.day23_Log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class C01_Log4j {
    @Test
    public void test01() {
        /*
Log4j system.out.println gibi her test adımında bilgilendirme yapamıza yarayan bir api dir.
Log4j ile bu bilgilendirmeleri hem console de hem tarih saat olarak hem de src>mainZresources
içine koyduğumuz Log4j.xml file da belirttiğimiz .log uzantılı dosyada yine tarih saat olarak
kayıt altına almış olacağız. Log4j kullanabilmek için öncelikle Log4j api ve log4j-core
dependency lerini mvnrepository.com adresindan (aynı version numaralarına sahip) alıp pom.xml dosyamıza koymalıyız.
src>mainZresources içine koyduğumuz Log4j.xml dosyasındaki kodlara pdf deki adresten ulaşabilirsiniz.
 */
        Logger logger= LogManager.getLogger(C01_Log4j.class);
        logger.info("INFO");
        logger.debug("DEBUG");
        logger.error("ERROR");
        logger.fatal("FATAL");
        logger.warn("WARNING");
    }
}
