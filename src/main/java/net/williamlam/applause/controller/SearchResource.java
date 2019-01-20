package net.williamlam.applause.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.williamlam.applause.dto.UserBugCountDTO;
import net.williamlam.applause.model.UserBugCountModelList;
import net.williamlam.applause.service.SearchService;

/**
 * <p> SearchResource
 * </p>
 * @version 1.0
 * @author wlam
 * @since Jan 15, 2019
 */
@RestController
public class SearchResource {
    @Autowired
    private SearchService searchService;

    @RequestMapping(value="/search", method=RequestMethod.GET)
    public UserBugCountModelList search(@RequestParam("countries") final String countries,
            @RequestParam("devices") final String devices) {
        
        String[] countryArray = countries.split( "," );
        List<String> countryList = Arrays.stream( countryArray ).map( c -> c.trim() ).collect( Collectors.toList() );

        String[] deviceArray = devices.split( "," );
        List<String> deviceList = Arrays.stream( deviceArray ).map( d -> d.trim() ).collect( Collectors.toList() );

        System.out.println( "inputs, countryList:" + countryList +", deviceList:" + deviceList );
        
        UserBugCountDTO userListDTO = searchService.search(countryList, deviceList);

        return new UserBugCountModelList(userListDTO);
    }
}
