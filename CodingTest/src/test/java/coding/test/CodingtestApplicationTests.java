package coding.test;

import coding.test.model.Country;
import coding.test.repository.CountryRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CodingtestApplicationTests {
    @Autowired
    CountryRepository countryRepository;

    @Test
    public void testAddCountry(){
        Country country=new Country();
        country.setId(1);
        country.setLanguage("english");
        countryRepository.save(country);
        assertNotNull(countryRepository.findById(1));
    }

    @Test
    public void testGetAllCountries(){
        List<Country> countries=countryRepository.findAll();
       assertThat(countries).asList().size().isGreaterThan(0);
    }


}
