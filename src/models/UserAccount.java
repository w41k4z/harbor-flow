package models;

import connection.AppConnection;
import orm.annotation.Column;
import orm.annotation.PrimaryKey;
import orm.annotation.Table;
import orm.database.connection.DatabaseConnection;
import orm.database.object.relation.Relation;

@Table(name = "user_account", columnCount = 6)
public class UserAccount extends Relation<UserAccount> {
    /* FIELDS SECTION */

    @PrimaryKey(column = @Column(name = "id"), prefix = "USR", length = 7, sequence = "user_account_sequence")
    private String userAccountID;

    @Column
    private String name;

    @Column(name = "first_name")
    private String firstName;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String profile;

    /* CONSTRUCTOR SECTION */
    public UserAccount() throws Exception {
        super();
    }

    /* SETTERS SECTION */
    public void setUserAccountID(String userAccountID) {
        this.userAccountID = userAccountID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    /* GETTERS SECTION */
    public String getUserAccountID() {
        return this.userAccountID;
    }

    public String getName() {
        return this.name;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getProfile() {
        return this.profile;
    }

    /* METHODS SECTION */
    public static UserAccount authenticate(String email, String password)
            throws Exception {
        DatabaseConnection connection = new AppConnection();
        UserAccount[] userAccount = new UserAccount().findAll(connection,
                "WHERE email='" + email + "' AND password='" + password + "'");
        if (userAccount.length == 0) {
            throw new Exception("Invalid credentials");
        }
        return userAccount[0];
    }
}
