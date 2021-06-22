/**
 * Picture.java
 * All Rights Reserved.
 * Copyright(c) by quyenvse04772
 */
package model;

/**
 * Picture.<br>
 *
 * <pre>
 * class Picture use to save data from database. In this class, it handle the
 * process below.
 *
 * . GetId.
 * . SetId.
 * . getName.
 * . setName.
 * </pre>
 *
 * @author AM
 * @version 1.0
 */
public class Picture {

    /**
     * Store id.
     */
    private int no;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
    
    private int id;
    /**
     * Store name.
     */
    private String name;

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
     * get name <br>
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Set name.<br>
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }
}
