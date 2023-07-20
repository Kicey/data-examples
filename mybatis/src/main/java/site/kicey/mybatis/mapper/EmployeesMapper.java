package site.kicey.mybatis.mapper;

import java.util.List;
import site.kicey.entity.EmployeesEntity;

public interface EmployeesMapper {
  List<EmployeesEntity> getEmployeesByEmpNo(Integer empNo);
}
