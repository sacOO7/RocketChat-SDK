package Models;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by SAC on 13-03-2017.
 */
public class TokenObject {
    String Tokenid;
    String AuthToken;
    Date Expiry;

    public TokenObject(String tokenid, String authToken, Date expiry) {
        Tokenid = tokenid;
        AuthToken = authToken;
        Expiry = expiry;
    }
    public TokenObject(JSONObject object) throws JSONException {
        Tokenid=object.optString("id");
        AuthToken=object.optString("token");
        Expiry=new Date(new Timestamp(object.optJSONObject("tokenExpires").getLong("$date")).getTime());
    }

    public String getTokenid() {
        return Tokenid;
    }

    public String getAuthToken() {
        return AuthToken;
    }

    public Date getExpiry() {
        return Expiry;
    }
}
