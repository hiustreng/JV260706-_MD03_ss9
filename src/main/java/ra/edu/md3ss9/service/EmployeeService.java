package ra.edu.md3ss9.service;

import com.example.hrm.dto.EmployeeCreateDTO;
import com.example.hrm.entity.Department;
import com.example.hrm.entity.Employee;
import com.example.hrm.exception.DuplicateResourceException;
import com.example.hrm.exception.ResourceNotFoundException;
import com.example.hrm.repository.DepartmentRepository;
import com.example.hrm.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public Employee createEmployee(EmployeeCreateDTO dto) {
        // 1. Kiểm tra tồn tại phòng ban -> nếu không có, ném lỗi 404
        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Phòng ban không tồn tại"));

        // 2. Kiểm tra trùng email -> nếu trùng, ném lỗi 409
        if (employeeRepository.existsByEmail(dto.getEmail())) {
            throw new DuplicateResourceException("Email đã được sử dụng");
        }

        Employee employee = new Employee();
        employee.setFullName(dto.getFullName());
        employee.setEmail(dto.getEmail());
        employee.setPhone(dto.getPhone());
        employee.setSalary(dto.getSalary());
        employee.setDepartment(department);

        return employeeRepository.save(employee);
    }
}
