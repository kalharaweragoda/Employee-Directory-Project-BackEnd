package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    private Long id;
    private String Name;
    private String Email;
    private String Department;
    private SimpleDateFormat CreatedAt;
    private SimpleDateFormat UpdatedAt;

}
