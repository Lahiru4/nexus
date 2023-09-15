package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployDTO {
    private String employee_id;
    private String tele;
    private String name;
    private String address;
    private String email;

}
