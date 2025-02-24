package edu.icet.dto;

import edu.icet.util.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Teacher {

    private  Integer id;
    private String name;
    private Integer age;
    private Gender gender;
    private Double salary;
}
