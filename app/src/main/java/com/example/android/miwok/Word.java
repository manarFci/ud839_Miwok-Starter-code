package com.example.android.miwok;

/**
 * Created by macbook on 3/14/18.
 */

public class Word {
    private String mDefaultTranslation;
    private String mMiowkTranslation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private int mAudioResourceId = NO_IMAGE_PROVIDED;
    /**
     * Constant value that represents no image was provided for this word
     */
    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String defaultTranslation, String miowkTranslation,int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiowkTranslation = miowkTranslation;
        mAudioResourceId= audioResourceId;

    }

    public Word(String defaultTranslation, String miowkTranslation, int imageResourceId,int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiowkTranslation = miowkTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId= audioResourceId;
    }

    public String getDefaultTranslation() {

        return mDefaultTranslation;
    }

    public String getMiowkTranslation() {

        return mMiowkTranslation;
    }

    /**
     * Get the image resource ID
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
public int getAudioResourceId(){

        return mAudioResourceId;
}
}
