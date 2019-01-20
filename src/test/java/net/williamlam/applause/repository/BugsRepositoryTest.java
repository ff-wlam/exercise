/**
 * BugsRepositoryTest.java
 * Jan 15, 2019
 * <p>
 * Copyright © FirstFuel Software. 2010-2019 All right reserved. The copyright to
 * the computer program(s) herein is the property of FirstFuel Software. The
 * program(s) may be used and/or copied only with the written permission of
 * FirstFuel Software.
 * </p>
 */
package net.williamlam.applause.repository;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.williamlam.applause.entity.Bugs;

/**
 * <p> BugsRepositoryTest
 * </p>
 * @version 1.0
 * @author wlam
 * @since Jan 15, 2019
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration(classes = AppConfig.class)
public class BugsRepositoryTest {

    @Autowired
    private BugsRepository repo;
    
    @Test
    public void findByCountries() {
        List<String> countries = Arrays.asList( "US,JP".split( "," ) );
        List<Bugs> bugs = repo.findByCountries( countries );
        
        Assert.assertTrue( bugs.size() > 0 );
    }
    
    @Test
    public void findByDevices() {
        List<String> devices = Arrays.asList( "iPhone 4,iPhone 5".split( "," ) );
        List<Bugs> bugs = repo.findByDevices( devices );
        
        Assert.assertTrue( bugs.size() > 0 );
    }

    @Test
    public void findByDevicesAndCountries() {
        List<String> devices = Arrays.asList( "iPhone 4,iPhone 5".split( "," ) );
        List<String> countries = Arrays.asList( "US,JP".split( "," ) );
        List<Bugs> bugs = repo.findByDevicesAndCountries( devices, countries );
        
        Assert.assertTrue( bugs.size() > 0 );
    }

}
