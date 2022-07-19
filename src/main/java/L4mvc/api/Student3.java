package L4mvc.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Student3 {
    @NotNull
    Integer id;
    @NotBlank
    String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
