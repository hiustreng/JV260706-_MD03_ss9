package ra.edu.md3ss9.controller;

import com.example.hrm.dto.ApiResponse;
import com.example.hrm.dto.EmployeeCreateDTO;
import com.example.hrm.entity.Employee;
import com.example.hrm.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Employee>> createEmployee(@Valid @RequestBody EmployeeCreateDTO dto) {
        Employee employee = employeeService.createEmployee(dto);
        ApiResponse<Employee> response = new ApiResponse<>("SUCCESS", "Thêm nhân viên thành công", employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
