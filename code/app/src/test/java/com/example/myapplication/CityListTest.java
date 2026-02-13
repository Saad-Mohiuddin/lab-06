package com.example.myapplication;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityListTest {

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        City city = new City("Calgary", "Alberta");
        cityList.add(city);
        assertTrue(cityList.hasCity(city));
        assertFalse(cityList.hasCity(new City("Vancouver", "British Columbia")));
    }

    @Test void testDelete() {
        CityList cityList = mockCityList();
        City city = new City("Toronto", "Ontario");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        cityList.deleteCity(city);
        assertEquals(1, cityList.getCities().size());
        assertFalse(cityList.getCities().contains(city));
    }

    @Test void testDeleteException() {
        CityList cityList = mockCityList();
        City city = new City("Montreal", "Quebec");
        cityList.add((city));
        cityList.deleteCity(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.deleteCity(city);
        });
    }

    @Test void testCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        cityList.add(new City("Red Deer", "Alberta"));
        assertEquals(2, cityList.getCities().size());
        cityList.add(new City("Winnipeg", "Manitoba"));
        assertEquals(3, cityList.getCities().size());
    }
}
