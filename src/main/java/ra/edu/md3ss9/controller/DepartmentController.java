package ra.edu.md3ss9.controller;

import com.example.hrm.dto.ApiResponse;
import com.example.hrm.dto.DepartmentDTO;
import com.example.hrm.entity.Department;
import com.example.hrm.repository.DepartmentRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    private final DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Department>> createDepartment(@Valid @RequestBody DepartmentDTO dto) {
        Department department = new Department();
        department.setName(dto.getName());
        department.setDescription(dto.getDescription());

        Department saved = departmentRepository.save(department);
        ApiResponse<Department> response = new ApiResponse<>("SUCCESS", "Tạo phòng ban thành công", saved);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
