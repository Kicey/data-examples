package site.kicey.entity;

import java.time.LocalDate;
import lombok.Data;

@Data
public class EmployeesEntity {
  Integer empNo;

  LocalDate birthDate;

  String firstName;

  String lastName;

  String gender;

  LocalDate hireDate;

}
