package coding.test.service;

import coding.test.model.Country;

import java.util.List;

public interface CountryService {
    public List<Country> findAllCountries();
    public Country addCountry(Country country);
}
