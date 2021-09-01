package coding.test;

import coding.test.model.Country;
import coding.test.service.CountryServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.internal.org.objectweb.asm.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class CountryApplication {

    public static void main(String[] args) {
        SpringApplication.run(CountryApplication.class, args);
    }

    /*
    I forget the syntax on how to parse json to object and vice versa.
    It has been long time since I applied it.
    Thank you!
     */

    @Bean
    public static CommandLineRunner runner(CountryServiceImpl countryService) {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Country>> typeReference = new TypeReference<List<Country>>() {
        };
        InputStream stream = TypeReference.class.getResourceAsStream("/json/country.json");
        List<Country> countries=stream.read();
        countries.forEach(c->countryService.addCountry(c));

    }

    }


