package simplechat;

import java.io.Serializable;
/**
 * Created by hoanbka on 20-Sep-16.
 */

public class Message implements Serializable {
    private String content;
    private String userName;

    public Message(String content, String userName) {
        this.content = content;
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public String getUserName() {
        return userName;
    }

}