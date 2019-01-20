package net.williamlam.applause.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.williamlam.applause.dto.UserBugCountDTO;
import net.williamlam.applause.entity.Bugs;
import net.williamlam.applause.entity.Testers;
import net.williamlam.applause.repository.BugsRepository;

/**
 * <p> SearchServiceImpl
 * </p>
 * @version 1.0
 * @author wlam
 * @since Jan 15, 2019
 */
@Service(value="searchService")
public class SearchServiceImpl implements SearchService {

    private BugsRepository bugsRepo;

    @Autowired
    public SearchServiceImpl(BugsRepository bugsRepo) {
        this.bugsRepo = bugsRepo;
    }
    
    /**
     * @see net.williamlam.applause.service.SearchService#search(java.util.List, java.util.List)
     */
    @Override
    public UserBugCountDTO search( List<String> countries, List<String> devices ) {
        List<Bugs> bugs;
        
        if ( countries.contains( "ALL" )  && devices.contains( "ALL" ) ) {
            bugs = bugsRepo.findAll();
        }
        else if ( countries.contains( "ALL" ) ) {
            bugs = bugsRepo.findByDevices( devices );
        } else if ( devices.contains( "ALL" ) ) {
            bugs = bugsRepo.findByCountries( countries );
        } else {
            bugs = bugsRepo.findByDevicesAndCountries( devices, countries );
        }
        Map<Testers, Long> mapOfUserBugCount = bugs.stream().collect( Collectors.groupingBy( Bugs::getTester, Collectors.counting() ) );
        
        return  new UserBugCountDTO( mapOfUserBugCount );
    }

}
