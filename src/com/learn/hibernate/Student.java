package com.learn.hibernate;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table(name="STUDENT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable{

	@Id
	@GeneratedValue
	@Column(name="STUDENT_ID")
	private long id;
	
    @Column(name = "FIRST_NAME")
    private String firstName;
 
    @Column(name = "LAST_NAME")
    private String lastName;
 
    @Column(name = "SECTION")
    private String section;
 
    @OneToOne(cascade=CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address address;
	
    public Student(String firstName, String lastName, String section) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.section = section;
    }
}
