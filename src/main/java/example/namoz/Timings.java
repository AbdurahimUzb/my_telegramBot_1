
package example.namoz;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@SuppressWarnings("unused")
@Data
public class Timings {
    @SerializedName("Asr")
    private String mAsr;
    @SerializedName("Dhuhr")
    private String mDhuhr;
    @SerializedName("Fajr")
    private String mFajr;
    @SerializedName("Isha")
    private String mIsha;
    @SerializedName("Maghrib")
    private String mMaghrib;
    @SerializedName("Sunrise")
    private String mSunrise;
    @SerializedName("Sunset")
    private String mSunset;
}

@Data
class Dates {
    @SerializedName("timings")
    private Timings timings;

}

@Data
class ApiResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("status")
    private String status;

    @SerializedName("data")
    private Dates dates;


}
