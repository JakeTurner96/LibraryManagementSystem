package entities;

public class Publisher {

    private int publisherID;
    private String name;
    private String headquarters;
    private int yearFounded;

    public Publisher(){}

    public Publisher(String name, String headquarters, int yearFounded) {
        this.name = name;
        this.headquarters = headquarters;
        this.yearFounded = yearFounded;
    }

    public int getPublisherID() {
        return publisherID;
    }

    public void setPublisherID(int publisherID) {
        this.publisherID = publisherID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    public void setHeadquarters(String headquarters) {
        this.headquarters = headquarters;
    }

    public int getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(int yearFounded) {
        this.yearFounded = yearFounded;
    }
}
