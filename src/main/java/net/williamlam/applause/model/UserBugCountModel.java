package net.williamlam.applause.model;

/**
 * <p> UserModel
 * </p>
 * @version 1.0
 * @author wlam
 * @since Jan 15, 2019
 */
public class UserBugCountModel {
    private String firstName;
    private String lastName;
    private long bugCount;
    /**
     * <p>
     * Create a new instance of UserModel.
     * </p>
     * @param firstName
     * @param bugCount
     */
    public UserBugCountModel( String firstName, String lastName, long bugCount ) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.bugCount = bugCount;
    }
    /**
     * <p>
     * See {@link #setuserId(String)}
     * </p>
     * @return Returns the userId.
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * <p>
     * See {@link #setlastName(String)}
     * </p>
     * @return Returns the lastName.
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * <p>
     * See {@link #setbugCount(int)}
     * </p>
     * @return Returns the bugCount.
     */
    public long getBugCount() {
        return bugCount;
    }
    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append( "UserBugCountModel [userId=" ).append( firstName ).append( ", bugCount=" ).append( bugCount )
                .append( "]" );
        return builder.toString();
    }
}
