package com.example.android.miwok;

/**
 * Created by Xeos on 2017-02-07.
 */

public class Word {

    private String mEnglishWord;

    private String mMiwokWord;

    private int mResId;

    private int mSoundId;

    public Word (String enWord, String miWord, int iconId, int soundId) {
        mEnglishWord = enWord;
        mMiwokWord = miWord;
        mResId = iconId;
        mSoundId = soundId;
    }

    public Word (String enWord, String miWord, int iconId) {
        mEnglishWord = enWord;
        mMiwokWord = miWord;
        mResId = iconId;
    }

    public Word (String enWord, String miWord) {
        mEnglishWord = enWord;
        mMiwokWord = miWord;
    }


    public String getEnglishTranslation () {
        return mEnglishWord;
    }

    public String getMiwokTranslation () {
        return mMiwokWord;
    }

    public int getResId () {return  mResId; }

    public int getSoundId () {return mSoundId; };

    @Override
    public String toString() {
        return "Word{" +
                "mEnglishWord='" + mEnglishWord + '\'' +
                ", mMiwokWord='" + mMiwokWord + '\'' +
                ", mResId=" + mResId +
                ", mSoundId=" + mSoundId +
                '}';
    }
}
