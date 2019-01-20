package net.williamlam.applause.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * <p> Bugs
 * </p>
 * @version 1.0
 * @author wlam
 * @since Jan 15, 2019
 */
@Entity
@Table(name = "bugs")
public class Bugs {
    
    @Id
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "tester_id")
    private Testers tester;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Devices device;

    public Bugs() {
        
    }
    
    public Bugs(Testers tester, Devices device) {
        this.tester = tester;
        this.device = device;
    }
    
    /**
     * <p>
     * See {@link #setid(int)}
     * </p>
     * @return Returns the id.
     */
    public int getId() {
        return id;
    }

    /**
     * <p>
     * See {@link #settester(Testers)}
     * </p>
     * @return Returns the tester.
     */
    public Testers getTester() {
        return tester;
    }

    /**
     * <p>
     * See {@link #setdevice(Devices)}
     * </p>
     * @return Returns the device.
     */
    public Devices getDevice() {
        return device;
    }
}
