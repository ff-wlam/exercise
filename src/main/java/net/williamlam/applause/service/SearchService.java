package net.williamlam.applause.service;

import java.util.List;

import net.williamlam.applause.dto.UserBugCountDTO;

/**
 * <p> SearchSearch
 * </p>
 * @version 1.0
 * @author wlam
 * @since Jan 15, 2019
 */
public interface SearchService {

    /**
     * <p>
     * 
     * </p>
     * @param countries
     * @param devices
     * @return
     */
    UserBugCountDTO search( List<String> countries, List<String> devices );

}
