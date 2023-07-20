package site.kicey;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import site.kicey.entity.EmployeesEntity;
import site.kicey.mybatis.mapper.EmployeesMapper;

/**
 * Hello world!
 */
public class Main {

  private static SqlSessionFactory sqlSessionFactory;

  static {
    try {
      String resource = "mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static SqlSession getSession() {
    return sqlSessionFactory.openSession();
  }

  public static void main(String[] args) {
    SqlSession sqlSession = getSession();

    // 执行 SQL 语句
    EmployeesMapper mapper = sqlSession.getMapper(EmployeesMapper.class);
    List<EmployeesEntity> employeesEntityList = mapper.getEmployeesByEmpNo(10001);

    for (EmployeesEntity user:employeesEntityList) {
      System.out.println(user);
    }

    // 关闭 SqlSession
    sqlSession.close();

    System.out.println("Hello World!");
  }
}
