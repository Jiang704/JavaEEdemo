import com.jiang.pojo.Login;
import com.jiang.pojo.Student;
import com.jiang.service.LoginService;
import com.jiang.service.StudentService;
import com.jiang.utils.FaceGetList;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest01 {
    @Test
    public void test(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        //StudentService studentService = (StudentService) context.getBean("studentServiceImpl");

       // studentService.updateStudent(new Student(201892001,"王军腾","18698936266",555666888,"123456@qq.com"));
        //for (Student student : studentService.searchStudent("军")) {
          //  System.out.println(student);
       // }
       // System.out.println(studentService.queryStudentById(201892001));
        LoginService loginService = (LoginService) context.getBean("loginServiceImpl");
        Login login = loginService.queryLoginById(1);
        System.out.println(login);

    }

    @Test
    public void testw(){
        for(int i =201892001; i <201892008 ;i++) {
            StringBuffer s = new StringBuffer(FaceGetList.faceGetList(i));
            System.out.println(s);
            try
            {
                Thread.sleep(300);//单位：毫秒
            } catch (Exception e) {
            }
        }
    }
}
