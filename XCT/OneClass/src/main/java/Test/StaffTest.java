package Test;

import com.oneclasswork.pojo.Staff;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class StaffTest {
    SqlSessionFactoryBuilder builder=null;
    SqlSessionFactory factory = null;
    SqlSession session=null;
    @Before
    public void before() {
        String resources = "mybatis-config.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resources);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         builder = new SqlSessionFactoryBuilder();
         factory = builder.build(reader);
         session = factory.openSession();
    }
    //根据员工id查询员工信息
    @Test
    public void StaffFindByIdTest() {
        Staff staff = session.selectOne("findStaffById", 3);
        System.out.println("员工ID："+staff.getStaffdid());
        System.out.println("员工姓名："+staff.getStaffname());
        System.out.println("员工年龄："+staff.getStaffage());
        System.out.println("职位："+staff.getStaffposition());
    }
    //添加员工信息
    @Test
    public void StaffAddTest(){
        Staff staff =new Staff();
        staff.setStaffname("新增");
        staff.setStaffage(33);
        staff.setStaffposition("副经理");
        session.insert("addStaff", staff);
    }
//根据id删除员工信息
    @Test
    public void StaffDeleteTest() {
        session.delete("deleteStaffById", 12);
    }
    //更新员工信息
    @Test
    public void updateStaffByIdTest() {
        Staff upStaff = new Staff();
        upStaff.setStaffdid(12);
        upStaff.setStaffname("王6");
        upStaff.setStaffage(28);
        upStaff.setStaffposition("总裁");
        session.update("updateStaffById", upStaff);
    }
    @After
    public void after() {
        session.commit();
        session.close();
    }
}
