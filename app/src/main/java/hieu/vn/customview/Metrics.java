package hieu.vn.customview;

public class Metrics {

    private String mTitle;
    private String mNumber;
    private String mDescription;
    private String mLastUpdate;
    private int mImage;

    public String getmLastUpdate() {
        return mLastUpdate;
    }

    public void setmLastUpdate(String mLastUpdate) {
        this.mLastUpdate = mLastUpdate;
    }

    public Metrics(String mTitle, String mNumber, String mDescription, String mLastUpdate, int mImage) {
        this.mTitle = mTitle;
        this.mNumber = mNumber;
        this.mDescription = mDescription;
        this.mLastUpdate = mLastUpdate;
        this.mImage = mImage;
    }

    public String getmNumber() {
        return mNumber;
    }

    public void setmNumber(String mNumber) {
        this.mNumber = mNumber;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }
}
