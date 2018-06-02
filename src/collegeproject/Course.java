package collegeproject;

public class Course {

    String name;
    String details;

    public Course(String name, String details) {
        this.name = name;
        this.details = details;
    }

    public String getDetails() {
        return details;
    }

    public String getName() {
        return name;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "name : " + this.getName() + " , details : " + this.getDetails();
    }
}
