package com.example.myapplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects.
 * */
public class CityList {

    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not already exist.
     * @param city
     *      This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities.
     * @return
     *      Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This checks whether a city is in the list.
     * @param city
     *      This is the city to check
     * @return
     *      Returns <code>true</code> is city is in the list, <code>false</code> otherwise
     */
    public boolean hasCity (City city) {
        if (cities.contains(city)) {
            return true;
        }
        return false;
    }

    /**
     * This deletes a city from the list if it exists.
     * @param city
     *      This is the city to delete
     */
    public void deleteCity (City city) {
        if (cities.contains(city)) {
            cities.remove(city);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This returns the count of cities in the list.
     * @return
     *      Returns <code>int</code> representing the cities count
     */
    public int countCities() {
        return cities.size();
    }

}
