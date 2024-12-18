package hospital.doctor;

import javax.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "specialization", nullable = false)
	private String specialization;

	@Column(name = "phone", nullable = false)
	private String phone;

	@Column(name = "address", nullable = false)
	private String address;

	@Column(name = "age", nullable = false)
	private int age;

	@Column(name = "blood_group", nullable = false)
	private String bloodGroup;

	@Column(name = "password", nullable = false)
	private String password;

	// Constructors, getters, setters, and toString method

	public Doctor() {
	}

	public Doctor(String name, String email, String specialization, String phone, String address, int age,
			String bloodGroup, String password) {
		super();
		this.name = name;
		this.email = email;
		this.specialization = specialization;
		this.phone = phone;
		this.address = address;
		this.age = age;
		this.bloodGroup = bloodGroup;
		this.password = password;
	}

	public Doctor(Long id, String name, String email, String specialization, String phone, String address, int age,
			String bloodGroup, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.specialization = specialization;
		this.phone = phone;
		this.address = address;
		this.age = age;
		this.bloodGroup = bloodGroup;
		this.password = password;
	}

	// Getters and Setters

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

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
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
	
	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", email=" + email + ", specialization=" + specialization
				+ ", phone=" + phone + ", address=" + address + ", age=" + age + ", bloodGroup=" + bloodGroup
				+ ", password=" + password + "]";
	}

}
