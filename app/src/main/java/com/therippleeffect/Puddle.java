package com.therippleeffect;

public class Puddle {
    /** an integer representing puddle image resource*/
    private int mIamgeResource = No_Image;
    /** a constant to check if there is an imgae*/
    private static final int No_Image = -1;
    /** a string representing the puddle initiator's name*/
    private String mpuddleInitiator;
    /** a string representing the puddle's title*/
    private String mpuddleName;
    /** a string representing the puddle's short discription*/
    private String muddleShortDescription;
    /**
     * this is the song class constructor
     */
    public Puddle(int imagesource, String initiatorName, String puddlesName, String puddleShortDescription) {
        mIamgeResource = imagesource;
        mpuddleInitiator = initiatorName;
        mpuddleName = puddlesName;
        muddleShortDescription = puddleShortDescription; }
    /**@return song image resource*/
    public int getPuddleIamgeResource() { return mIamgeResource; }
    /**@return puddle initiator's name */
    public String getPuddleInitiatorName() { return mpuddleInitiator;}
    /**@return puddle's title*/
    public String getPuddleName() { return mpuddleName; }
    /**@return puddle's title*/
    public String getPuddleShortDiscription() { return muddleShortDescription; }
    /**@return whether there was an image or not*/
    public boolean puddleHasImage(){ return mIamgeResource != No_Image;}
}
