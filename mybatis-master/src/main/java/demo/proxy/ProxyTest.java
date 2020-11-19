package demo.proxy;

import com.llkj.retire.manage.mapper.Permission;
import com.llkj.retire.manage.mapper.Permission2Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * ProxyTest
 * 责任人:  Chuck
 * 修改人： Chuck
 * 创建/修改时间: 2020/11/19 11:47
 * Copyright :  版权所有
 **/
public class ProxyTest {

    public static void main(String[] args) {

        try {
            String resource = "META-INF/mybatis.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession sqlSession=sqlSessionFactory.openSession();
            //List<Permission> permission=sqlSession.selectList("com.llkj.retire.manage.mapper.PermissionMapper.queryPermissionInfoByAccId", "b5b476bdee704495902303d443d18996");



            Permission2Mapper mapper = (Permission2Mapper) demo.proxy.SqlSession.getMapper(Permission2Mapper.class);

            List<Permission> permission = mapper.queryPermissionInfoByAccId("b5b476bdee704495902303d443d18996");

            System.out.println("permission = [" + permission + "]");

        } catch ( Exception exc) {
            //com.mysql.jdbc.Driver A;
            System.out.println("异常 = [" + exc + "]");
        }

    }
}
