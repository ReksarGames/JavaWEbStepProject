package ua.com.danit.domain;

public class Employee {
    private Long employeeId;
    private String firstName;
    private Department department;

    public Employee(Long employeeId, String firstName, Department department) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.department = department;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
