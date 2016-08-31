package tomczyk.konrad.krasnik.models;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Konrad_Tomczyk on 31.08.2016.
 */
@IgnoreExtraProperties
public class User {
    public String username;
    public String email;

    public User() {
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
