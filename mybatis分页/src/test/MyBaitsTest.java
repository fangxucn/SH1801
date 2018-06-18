import com.qfedu.mybatis.mapper.TeacherMapper;
import com.qfedu.mybatis.pojo.Teacher;
import com.qfedu.mybatis.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyBaitsTest {
    @Test
    public void testGet(){
        SqlSession session=MyBatisUtil.session();
        TeacherMapper teacherMapper=session.getMapper(TeacherMapper.class);
        Teacher teacher=teacherMapper.get(1);
        System.out.println(teacher.getName());
    }
    @Test
    public void testGetAll(){
        SqlSession session=MyBatisUtil.session();
        TeacherMapper teacherMapper=session.getMapper(TeacherMapper.class);
        List<Teacher> teachers=teacherMapper.getAll();
        System.out.println(teachers);
    }

    @Test
    public void testGetByName(){
        SqlSession session=MyBatisUtil.session();
        TeacherMapper teacherMapper=session.getMapper(TeacherMapper.class);
        List<Teacher> teachers=teacherMapper.getByName("许_%");
        System.out.println(teachers);
    }

    @Test
    public void testInsert(){
        SqlSession session=MyBatisUtil.session();
        TeacherMapper teacherMapper=session.getMapper(TeacherMapper.class);

        Teacher teacher=new Teacher();
        teacher.setName("张三");

        teacherMapper.insert(teacher);
        session.commit();
    }



    @Test
    public void testUpdate(){
        SqlSession session=MyBatisUtil.session();
        TeacherMapper teacherMapper=session.getMapper(TeacherMapper.class);

        Teacher teacher=new Teacher();
        teacher.setId(7);
        teacher.setName("张三1");

        teacherMapper.update(teacher);
        session.commit();
    }

    @Test
    public void testDelete(){
        SqlSession session=MyBatisUtil.session();
        TeacherMapper teacherMapper=session.getMapper(TeacherMapper.class);



        teacherMapper.delete(7);
        session.commit();
    }
}
