package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final List<Country> countryList;

    @SuppressWarnings("unchecked")
    public CountryService() {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        countryList = (List<Country>) context.getBean("countryList");
    }

    public Country getCountry(String code) {

        for (Country country : countryList) {

            if (country.getCode().equalsIgnoreCase(code)) {
                return country;
            }

        }

        return null;
    }
}