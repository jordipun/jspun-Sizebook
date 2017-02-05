package com.example.jspun_sizebook;

import java.util.Date;

/**
 * The type Records.
 */
public class Records {

    private String name;
    private String neck;
    private String waist;
    private String chest;
    private String hip;
    private String inseam;
    private String bust;
    private String date;
    private String comment;

    /**
     * Instantiates a new Records.
     *
     * @param name the name
     */
    public Records(String name) {
        this.name = name;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets neck.
     *
     * @return the neck
     */
    public String getNeck() {
        return neck;
    }

    /**
     * Sets neck.
     *
     * @param neck the neck
     */
    public void setNeck(String neck) {
        this.neck = neck;
    }

    /**
     * Gets waist.
     *
     * @return the waist
     */
    public String getWaist() {
        return waist;
    }

    /**
     * Sets waist.
     *
     * @param waist the waist
     */
    public void setWaist(String waist) {
        this.waist = waist;
    }

    /**
     * Gets chest.
     *
     * @return the chest
     */
    public String getChest() {
        return chest;
    }

    /**
     * Sets chest.
     *
     * @param chest the chest
     */
    public void setChest(String chest) {
        this.chest = chest;
    }

    /**
     * Gets hip.
     *
     * @return the hip
     */
    public String getHip() {
        return hip;
    }

    /**
     * Sets hip.
     *
     * @param hip the hip
     */
    public void setHip(String hip) {
        this.hip = hip;
    }

    /**
     * Gets inseam.
     *
     * @return the inseam
     */
    public String getInseam() {
        return inseam;
    }

    /**
     * Sets inseam.
     *
     * @param inseam the inseam
     */
    public void setInseam(String inseam) {
        this.inseam = inseam;
    }

    /**
     * Gets bust.
     *
     * @return the bust
     */
    public String getBust() {
        return bust;
    }

    /**
     * Sets bust.
     *
     * @param bust the bust
     */
    public void setBust(String bust) {
        this.bust = bust;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets comment.
     *
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets comment.
     *
     * @param comment the comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }


    /**
     * sets the list name in listview
     * @return
     */
    @Override
    public String toString(){
        return name.toString();
    }
}