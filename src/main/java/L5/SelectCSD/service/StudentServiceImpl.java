package L5.SelectCSD.service;

import L5.SelectCSD.Student;
import L5.SelectCSD.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao studentDao;

    @Override
    public Student getById(Integer studentId) {
       return studentDao.getById(studentId);
    }
}
