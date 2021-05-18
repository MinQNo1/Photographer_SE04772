/**
 * Contact.java
 * All Rights Reserved.
 * Copyright(c) by quyenvse04772
 */
package model;

/**
 * Contact.<br>
 *
 * <pre>
 * class Contact use to save data from database. In this class, it handle the
 * process below.
 *
 * . GetId.
 * . SetId.
 * . GetAddress.
 * . SetAddress.
 * . GetCity.
 * . SetCity.
 * . GetCountry.
 * . SetCountry.
 * . GetTel.
 * . SetTel.
 * . GetEmail.
 * . SetEmail.
 * . GetAbout_me.
 * . SetAbout_me.
 * </pre>
 *
 * @author AM
 * @version 1.0
 */
public class Contact {

    /**
     * Store id.
     */
    private int id;
    /**
     * Store address.
     */
    private String address;
    /**
     * Store city.
     */
    private String city;
    /**
     * Store country.
     */
    private String country;
    /**
     * Store tel.
     */
    private String tel;
    /**
     * Store email.
     */
    private String email;
    /**
     * Store about_me.
     */
    private String about_me;

    /**
     * get id <br>
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Set id.<br>
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * get address <br>
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set address.<br>
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * get city <br>
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Set city.<br>
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * get country <br>
     *
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Set country.<br>
     *
     * @param country the country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * get tel <br>
     *
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * Set tel.<br>
     *
     * @param tel the tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * get email<br>
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set email.<br>
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * get about_me <br>
     *
     * @return the about_me
     */
    public String getAbout_me() {
        return about_me;
    }

    /**
     * Set about_me.<br>
     *
     * @param about_me the about_me
     */
    public void setAbout_me(String about_me) {
        this.about_me = about_me;
    }

}
