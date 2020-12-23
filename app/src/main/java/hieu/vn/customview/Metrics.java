package hieu.vn.customview;

import android.os.Parcel;
import android.os.Parcelable;

public class Metrics implements Parcelable {

    private String mTitle;
    private String mNumber;
    private String mDescription;
    private String mLastUpdate;
    private int mImage;

    protected Metrics(Parcel in) {
        mTitle = in.readString();
        mNumber = in.readString();
        mDescription = in.readString();
        mLastUpdate = in.readString();
        mImage = in.readInt();
    }

    public static final Creator<Metrics> CREATOR = new Creator<Metrics>() {
        @Override
        public Metrics createFromParcel(Parcel in) {
            return new Metrics(in);
        }

        @Override
        public Metrics[] newArray(int size) {
            return new Metrics[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeString(mNumber);
        dest.writeString(mDescription);
        dest.writeString(mLastUpdate);
        dest.writeInt(mImage);
    }
}
