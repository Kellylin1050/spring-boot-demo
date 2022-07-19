package L5.SelectCSD.dao;

import L5.SelectCSD.Student;
import L5.SelectCSD.StudentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SrudentDaoImpl implements StudentDao{

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Student getById(Integer studentId) {
        String sql = "SELECT id, name FROM student WHERE id = :studentId";

        Map<String, Object> map = new HashMap<>();
        map.put("studentId",studentId);

        List<Student> list = namedParameterJdbcTemplate.query(sql ,map ,new StudentRowMapper());

        //return list.get(0); //取得list中第一個object
        if (list.size() > 0){
            return list.get(0);
        }else {
            return null;
        }
    }
}
