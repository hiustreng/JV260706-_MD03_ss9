package ra.edu.md3ss9.dto;

import jakarta.validation.constraints.*;

public class EmployeeCreateDTO {

    @NotBlank(message = "Họ tên không được để trống")
    private String fullName;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "^(03|05|07|08|09)\\d{8}$", message = "Số điện thoại không hợp lệ")
    private String phone;

    @NotNull(message = "Lương không được để trống")
    @Min(value = 5000000, message = "Lương tối thiểu là 5.000.000")
    private Double salary;

    @NotNull(message = "departmentId không được để trống")
    private Long departmentId;

    public EmployeeCreateDTO() {
    }

    public EmployeeCreateDTO(String fullName, String email, String phone, Double salary, Long departmentId) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.departmentId = departmentId;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
