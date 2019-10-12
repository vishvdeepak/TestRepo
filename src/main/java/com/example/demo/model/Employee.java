package com.example.demo.model;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
@AllArgsConstructor
@Getter @Setter
@Table("emp")
public class Employee {
 @PrimaryKey 
 @Column("empid")
 private @NonNull  Integer empid;
 @Column("emp_first")
 private @NonNull  String emp_first;
 @Column("emp_last")
 private @NonNull  String emp_last;
 @Column("emp_dept")
 private @NonNull String emp_dept;
}