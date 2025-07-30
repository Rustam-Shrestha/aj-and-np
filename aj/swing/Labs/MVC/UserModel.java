package Labs.MVC;

// User Model: Stores user information
public class UserModel {
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private boolean subscribed;

    // Getters and Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public boolean isSubscribed() { return subscribed; }
    public void setSubscribed(boolean subscribed) { this.subscribed = subscribed; }

    // Format the user details
    public String getUserDetails() {
        return "User Details:\n" +
               "Name: " + firstName + " " + lastName + "\n" +
               "Age: " + age + "\n" +
               "Gender: " + gender + "\n" +
               "Subscribed: " + (subscribed ? "Yes" : "No");
    }
}

