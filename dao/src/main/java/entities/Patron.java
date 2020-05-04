package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Patron {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int patronID;
    private String name;
    private String email;
    private Date memberSince;
    private Date membershipExpires;
    private boolean patronType;

    public Patron(){}

    public Patron(String name, String email, Date memberSince, Date membershipExpires, boolean patronType) {
        this.name = name;
        this.email = email;
        this.memberSince = memberSince;
        this.membershipExpires = membershipExpires;
        this.patronType = patronType;
    }

    public int getPatronID() {
        return patronID;
    }

    public void setPatronID(int patronID) {
        this.patronID = patronID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getMemeberSince() {
        return memberSince;
    }

    public void setMemeberSince(Date memeberSince) {
        this.memberSince = memeberSince;
    }

    public Date getMebershipExpires() {
        return membershipExpires;
    }

    public void setMebershipExpires(Date mebershipExpires) {
        this.membershipExpires = mebershipExpires;
    }

    public boolean isPatronType() {
        return patronType;
    }

    public void setPatronType(boolean patronType) {
        this.patronType = patronType;
    }
}
