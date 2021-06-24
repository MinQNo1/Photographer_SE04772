/**
 * Gallery.java
 * All Rights Reserved.
 * Copyright(c) by quyenvse04772
 */
package model;

/**
 * Gallery.<br>
 *
 * <pre>
 * class Gallery use to save data from database. In this class, it handle the
 * process below.
 *
 * . GetId.
 * . SetId.
 * . getName.
 * . setName.
 * . getFeturedPicture.
 * . setFeturedPicture.
 * . getDescription.
 * . setDescription.
 * </pre>
 *
 * @author QUYENNV
 * @version 1.0
 */
public class Gallery {

    /**
     * Store id.
     */
    private int id;
    /**
     * Store name.
     */
    private String name;
    /**
     * Store feturedPicture.
     */
    private String feturedPicture;
    /**
     * Store description.
     */
    private String description;

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

    /**
     * get pictureCover <br>
     *
     * @return the pictureCover
     */
    public String getFeturedPicture() {
        return feturedPicture;
    }

    /**
     * Set pictureCover.<br>
     *
     * @param pictureCover the pictureCover
     */
    public void setFeturedPicture(String feturedPicture) {
        this.feturedPicture = feturedPicture;
    }

    /**
     * get description <br>
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set description.<br>
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
