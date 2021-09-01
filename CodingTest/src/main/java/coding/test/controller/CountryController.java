package coding.test.controller;

import coding.test.model.Country;
import coding.test.service.CountryServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class CountryController {
    @Autowired
    private CountryServiceImpl countryService;

    @GetMapping("/countries")
    public ResponseEntity<?> getAllCountries(){
        log.info("Inside getAllCountries() of CountryController");
        List<Country> countries=countryService.findAllCountries();
        if(countries.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(countries);
    }

    @PostMapping("/Countries")
    public ResponseEntity<?> addCountry(@RequestBody Country country){
        Country addedCountry = countryService.addCountry(country);
        return ResponseEntity.ok(addedCountry);
    }
}
