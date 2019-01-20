package net.williamlam.applause.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import net.williamlam.applause.dto.UserBugCountDTO;
import net.williamlam.applause.entity.Testers;

/**
 * <p> UserModelList
 * </p>
 * @version 1.0
 * @author wlam
 * @since Jan 15, 2019
 */
public class UserBugCountModelList {
    private List<UserBugCountModel> userModelList;

    /**
     * <p>
     * Create a new instance of UserModelList.
     * </p>
     * @param userListDTO
     */
    public UserBugCountModelList( UserBugCountDTO userListDTO ) {
        Map<Testers, Long> userBugCount = userListDTO.getUserBugCount();
        
        userModelList = new ArrayList<>(userBugCount.size());
        
        userBugCount.entrySet().forEach( entry -> {
            userModelList.add( new UserBugCountModel(entry.getKey().getFirstName(), entry.getKey().getLastName(), entry.getValue()) );
        });
        
        userModelList.sort( new Comparator<UserBugCountModel>( ) {

            @Override
            public int compare( UserBugCountModel o1, UserBugCountModel o2 ) {
                return (o1.getBugCount() > o2.getBugCount() ? -1 : (o1.getBugCount() < o2.getBugCount() ? 1 : 0) );
            }
        } );
        
    }

    /**
     * <p>
     * See {@link #setuserModelList(List<UserModel>)}
     * </p>
     * @return Returns the userModelList.
     */
    public List<UserBugCountModel> getUserModelList() {
        return userModelList;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append( "UserBugCountModelList [userModelList=" ).append( userModelList ).append( "]" );
        return builder.toString();
    }
}
