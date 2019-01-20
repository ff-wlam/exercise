package net.williamlam.applause.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.williamlam.applause.entity.Bugs;

/**
 * <p> BugsRepository
 * </p>
 * @version 1.0
 * @author wlam
 * @since Jan 15, 2019
 */
@Repository(value="bugsRepository")
public interface BugsRepository extends JpaRepository<Bugs, Integer>{
    @Query(value="select b from Bugs b where b.tester.country in (:countries)")
    List<Bugs> findByCountries( @Param("countries") List<String> countries);
    
    @Query(value="select b from Bugs b where b.device.description in (:devices)")
    List<Bugs> findByDevices(@Param("devices") List<String> devices);
    
    @Query(value="select b from Bugs b where b.tester.country in (:countries)  and b.device.description in (:devices)")
    List<Bugs> findByDevicesAndCountries(@Param("devices") List<String> devices, @Param("countries") List<String> countries);
}
