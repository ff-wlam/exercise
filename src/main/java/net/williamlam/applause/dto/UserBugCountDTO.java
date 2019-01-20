package net.williamlam.applause.dto;

import java.util.Map;

import net.williamlam.applause.entity.Testers;

/**
 * <p> UserListDTO
 * </p>
 * @version 1.0
 * @author wlam
 * @since Jan 15, 2019
 */
public class UserBugCountDTO {
    private Map<Testers, Long> userBugCount;

    /**
     * <p>
     * Create a new instance of UserListDTO.
     * </p>
     * @param mapOfUserBugCount
     */
    public UserBugCountDTO( Map<Testers, Long> mapOfUserBugCount ) {
        userBugCount = mapOfUserBugCount;
    }

    /**
     * <p>
     * See {@link #setusers(Map<String,Integer>)}
     * </p>
     * @return Returns the users.
     */
    public Map<Testers, Long> getUserBugCount() {
        return userBugCount;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append( "UserBugCountDTO [userBugCount=" ).append( userBugCount ).append( "]" );
        return builder.toString();
    }
    
    
}
