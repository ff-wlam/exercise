package net.williamlam.applause.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p> Tester
 * </p>
 * @version 1.0
 * @author wlam
 * @since Jan 15, 2019
 */
@Entity
@Table(name = "testers")
public class Testers {

    @Id
    @Column(name = "id")
    private int id;
    
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "country")
    private String country;

    public Testers() {
        
    }
    public Testers(String firstName, String lastName, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
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
     * See {@link #setfirstName(String)}
     * </p>
     * @return Returns the firstName.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * <p>
     * See {@link #setlastName(String)}
     * </p>
     * @return Returns the lastName.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * <p>
     * See {@link #setcountry(String)}
     * </p>
     * @return Returns the country.
     */
    public String getCountry() {
        return country;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append( "Testers [id=" ).append( id ).append( ", firstName=" ).append( firstName )
                .append( ", lastName=" ).append( lastName ).append( ", country=" ).append( country ).append( "]" );
        return builder.toString();
    }
}
