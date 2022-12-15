package demo;

import com.llkj.retire.manage.mapper.Permission;
import com.llkj.retire.manage.mapper.Permission2Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * Test
 * 责任人:  Chuck
 * 修改人： Chuck
 * 创建/修改时间: 2020/11/18 12:18
 * Copyright :  版权所有
 **/

public class AnotationTest {

    public static void main(String[] args) {

        try {
            String resource = "META-INF/mybatis.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession sqlSession=sqlSessionFactory.openSession();

            Permission2Mapper mapper = sqlSession.getMapper(Permission2Mapper.class);


            List<Permission> permission=mapper.queryPermissionByParentId(  "1100");

            System.out.println("permission = [" + permission + "]");

        } catch ( Exception exc) {
             //com.mysql.jdbc.Driver A;
            System.out.println("异常 = [" + exc + "]");
        }

    }
}
