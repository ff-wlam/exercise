package net.williamlam.applause.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * <p> TestersDevices
 * </p>
 * @version 1.0
 * @author wlam
 * @since Jan 15, 2019
 */
@Entity
@Table(name = "tester_device")
public class TesterDevice {
    @Id
    @Column(name = "id")
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "tester_id")
    private Testers tester;
    
    @ManyToOne
    @JoinColumn(name = "device_id")
    private Devices device;

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
