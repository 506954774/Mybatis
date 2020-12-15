package demo;

import com.llkj.retire.manage.mapper.Permission;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.List;
import java.util.Properties;

/**

 **/

public class Test {

    public static void main(String[] args) {

        try {
            String resource = "META-INF/mybatis.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream );

            SqlSession sqlSession=sqlSessionFactory.openSession();
            List<Permission> permission=sqlSession.selectList("com.llkj.retire.manage.mapper.PermissionMapper.queryPermissionInfoByAccId", "b5b476bdee704495902303d443d18996");

            System.out.println("permission = [" + permission + "]");

        } catch ( Exception exc) {
             //com.mysql.jdbc.Driver A;
            System.out.println("异常 = [" + exc + "]");

        }

    }
}
