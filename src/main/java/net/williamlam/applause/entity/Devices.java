package net.williamlam.applause.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p> Devices
 * </p>
 * @version 1.0
 * @author wlam
 * @since Jan 15, 2019
 */
@Entity
@Table(name = "devices")
public class Devices {

    @Id
    @Column(name = "id")
    private int id;
    
    @Column(name = "description")
    private String description;
    
    public Devices() {
        
    }
    public Devices( String description ) {
        this.description = description;
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
     * See {@link #setdescription(String)}
     * </p>
     * @return Returns the description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append( "Devices [id=" ).append( id ).append( ", description=" ).append( description ).append( "]" );
        return builder.toString();
    }
}
