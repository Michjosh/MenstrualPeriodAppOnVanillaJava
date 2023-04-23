package DTOs;

public class CreateUserRequest {

    private int id;
    private String fullName;
    private String email;
    private CharSequence dateOfLastPeriod;
    private int lengthOfCycle;
    private int lengthOfPeriod;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CharSequence getDateOfLastPeriod() {
        return dateOfLastPeriod;
    }

    public void setDateOfLastPeriod(CharSequence dateOfLastPeriod) {
        this.dateOfLastPeriod = dateOfLastPeriod;
    }

    public int getLengthOfCycle() {
        return lengthOfCycle;
    }

    public void setLengthOfCycle(int lengthOfCycle) {
        this.lengthOfCycle = lengthOfCycle;
    }

    public int getLengthOfPeriod() {
        return lengthOfPeriod;
    }

    public void setLengthOfPeriod(int lengthOfPeriod) {
        this.lengthOfPeriod = lengthOfPeriod;
    }

}
