package net.williamlam.applause.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.williamlam.applause.dto.UserBugCountDTO;
import net.williamlam.applause.entity.Bugs;
import net.williamlam.applause.entity.Devices;
import net.williamlam.applause.entity.Testers;
import net.williamlam.applause.repository.BugsRepository;

/**
 * <p> SearchServiceImplTest
 * </p>
 * @version 1.0
 * @author wlam
 * @since Jan 15, 2019
 */
@RunWith( SpringJUnit4ClassRunner.class )
public class SearchServiceImplTest {
    @Mock
    private BugsRepository bugsRepo;
    
    private SearchService searchService;

    @Test
    public void test() {
        
        searchService = new SearchServiceImpl(bugsRepo);
        
        List<Bugs> bugs = new ArrayList<>();
        Testers tester1 =  new Testers("John", "Wayne", "US");
        Devices device1 = new Devices("iPhone 4");
        Bugs bug1 = new Bugs(tester1, device1);
        bugs.add( bug1 );
        Testers tester2 =  new Testers("Mary", "Kay", "JP");
        Devices device2 = new Devices("iPhone 3");
        Bugs bug2 = new Bugs(tester2, device2);
        bugs.add( bug2 );
        Mockito.when( bugsRepo.findByDevicesAndCountries( Mockito.anyList(), Mockito.anyList() ) ).thenReturn( bugs );
        
        UserBugCountDTO userListDTO = searchService.search( Arrays.asList( "US" ), Arrays.asList( "iPhone 4" ) );
        Assert.assertTrue( "cannot be empty", 
                userListDTO.getUserBugCount() != null && userListDTO.getUserBugCount().size() > 0 );
        
        Assert.assertEquals("2 users should be found " + userListDTO,  2, userListDTO.getUserBugCount().entrySet().size());
        userListDTO.getUserBugCount().values().forEach( v -> {
            Assert.assertEquals("1 bug should be found ",  new Long(1), v);
        });
        
        userListDTO = searchService.search( Arrays.asList( "US,JP" ), Arrays.asList( "iPhone 4, iPhone 3" ) );
        Assert.assertTrue( "cannot be empty", 
                userListDTO.getUserBugCount() != null && userListDTO.getUserBugCount().size() > 0 );
        
        Assert.assertEquals("2 users should be found " + userListDTO,  2, userListDTO.getUserBugCount().entrySet().size());
        userListDTO.getUserBugCount().values().forEach( v -> {
            Assert.assertEquals("1 bug should be found ",  new Long(1), v);
        });
    }

}
