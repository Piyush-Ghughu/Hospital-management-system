package hospital.admin;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "qualification", nullable = false)
    private String qualification;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "blood_group", nullable = false)
    private String bloodGroup;
    
    @Column(name = "password", nullable = false) // Add this line
    private String password; // Add this line

    public Admin() {
    }

    // Constructor
    public Admin(String name, String email, String qualification, String phone, String address, int age,
                 String bloodGroup, String password) { // Add password to constructor
        this.name = name;
        this.email = email;
        this.qualification = qualification;
        this.phone = phone;
        this.address = address;
        this.age = age;
        this.bloodGroup = bloodGroup;
        this.password = password; // Add this line
    }

    public Admin(Long id, String name, String email, String qualification, String phone, String address, int age,
                 String bloodGroup, String password) { // Add password to constructor
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.qualification = qualification;
        this.phone = phone;
        this.address = address;
        this.age = age;
        this.bloodGroup = bloodGroup;
        this.password = password; // Add this line
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getPassword() { // Add this method
        return password;
    }

    public void setPassword(String password) { // Add this method
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", qualification='" + qualification + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", password='" + password + '\'' + // Include password in toString
                '}';
    }
}
