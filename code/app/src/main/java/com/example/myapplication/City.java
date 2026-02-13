package com.example.myapplication;

import java.util.Objects;

/**
 * This is a class that defines a city.
 */
public class City implements Comparable<City> {

    private String city;
    private String province;

    /**
     * This is the city object constructor.
     * @param city
     *      Name of the city
     * @param province
     *      Name of the province the city is located in
     */
    City (String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * This returns the city name.
     * @return
     *      Name of the city
     */
    String getCityName(){
        return this.city;
    }

    /**
     * This returns the province name.
     * @return
     *      Name of the province the city is located in
     */
    String getProvinceName() {
        return this.province;
    }

    /**
     * Defines the comparison function used to sort a collection of cities
     * @param o
     *      The reference object with which to compare
     * @return
     *      Returns <code>int</code> representing where the <code>string</code> names of the city
     *      being compared are lexographically in relation to each other
     */
    @Override
    public int compareTo(City o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }

    /**
     * Determines whether two objects share the same fields and are equivalent
     * @param o
     *      The reference object with which to compare
     * @return
     *      Returns <code>true</code> whether the objects are equivalent, <code>false</code> otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(getCityName(), city.getCityName()) &&
                Objects.equals(getProvinceName(), city.getProvinceName());
    }

    /**
     * Returns hashcode of the city.
     * @return
     *      Returns hashcode of the city name.
     */
    @Override
    public int hashCode() {
        return this.city.hashCode();
    }

}
