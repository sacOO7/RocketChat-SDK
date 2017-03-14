package Models;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by SAC on 14-03-2017.
 */
public class MessageObject {

    String messageId;
    String roomId;
    String message;
    Date msgTimestamp;
    JSONObject sender;
    Date updatedAt;  //Message saved on the server
    Date editedAt;
    JSONObject editedBy;

    public MessageObject(JSONObject object){
        try {
            messageId=object.getString("_id");
            roomId=object.getString("rid");
            message=object.getString("msg");
            msgTimestamp= new Date(new Timestamp(object.getJSONObject("ts").getLong("$date")).getTime());
            sender=object.getJSONObject("u");

            if (object.optJSONObject("editedAt")!=null) {
                editedAt = new Date(new Timestamp(object.getJSONObject("editedAt").getLong("$date")).getTime());
                editedBy = object.getJSONObject("editedBy");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public String getMessageId() {
        return messageId;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getMessage() {
        return message;
    }

    public Date getMsgTimestamp() {
        return msgTimestamp;
    }

    public JSONObject getSender() {
        return sender;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Date getEditedAt() {
        return editedAt;
    }

    public JSONObject getEditedBy() {
        return editedBy;
    }
}
