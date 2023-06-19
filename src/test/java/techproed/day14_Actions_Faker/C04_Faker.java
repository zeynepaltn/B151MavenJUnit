package techproed.day14_Actions_Faker;

import com.github.javafaker.Faker;
import org.junit.Test;
import utilities.TestBase;

public class C04_Faker  {
    @Test
    public void faker() {
          /*
        Faker class'indan sahte verileri kullanabilmek icin obje olusturmamiz gerekir
         */
        Faker faker=new Faker();

        //faker objesini kullanarak bir isim yazdiriniz
        System.out.println("Isim "+faker.name().firstName());
        //faker objesini kullanarak bir lastName yazdiralim
        System.out.println("Soyisim "+faker.name().lastName());
        //faker objesini kullanarak bir fullName yazdiralim
        System.out.println("Isim ve Soyisim "+faker.name().fullName());
        //faker objesini kullanarak bir adress yazdiralim
        System.out.println("Adres "+faker.address().fullAddress());
        //faker objesini kullanarak bir tel_no yazdiralim
        System.out.println("Cep No "+faker.phoneNumber().cellPhone());
        System.out.println("Tel No "+faker.phoneNumber().phoneNumber());
        //Rastgele 15 haneli bir numara yazdiralim
        System.out.println(faker.number().digits(15));
        //Bir mesleki pozisyon yazdirin
        System.out.println(faker.job().position());


    }
}
