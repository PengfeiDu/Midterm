package com.cisc181.core;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {
	
	private static ArrayList<Course> course;
	private static ArrayList<Enrollment> enrollment;
	private static ArrayList<Section> section;
	private static ArrayList<Semester> semester;
	private static ArrayList<Student> student;
	
	@BeforeClass
	public static void setup() throws ParseException, PersonException {
		course = new ArrayList();
		enrollment = new ArrayList();
		section = new ArrayList();
		semester = new ArrayList();
		student = new ArrayList();
		
		course.add(new Course(UUID.randomUUID(), "ASDFGHJKL", 0, eMajor.CHEM));
		course.add(new Course(UUID.randomUUID(), "qwertyuiop", 0, eMajor.BUSINESS));
		course.add(new Course(UUID.randomUUID(), "ZXCVBNML", 0, eMajor.NURSING));
		
		try {
			semester.add(new Semester(UUID.randomUUID(),new SimpleDateFormat("dd/MM/yyyy").parse("10/01/2017"),
					new SimpleDateFormat("dd/MM/yyyy").parse("10/10/2017")));
			semester.add(new Semester(UUID.randomUUID(),new SimpleDateFormat("dd/MM/yyyy").parse("09/01/2016"),
					new SimpleDateFormat("dd/MM/yyyy").parse("02/10/2016")));
			for(int x = 0; x < 10; x++) {
				student.add(new Student("George", "P", "Bush",new SimpleDateFormat("dd/MM/yyyy").parse("10/01/2017"),
						eMajor.PHYSICS,"Prospect Ave","(302)111-2222","GPG@gmail.com"));
		}
		}catch(ParseException p) {
			System.out.println("ParseException");
		}catch(PersonException pe) {
			System.out.println("PersonException");
		}
		
		for (int courseN = 0; courseN < course.size(); courseN++) {
			for (int semesterN = 0; semesterN < semester.size(); semesterN++) {
				section.add(new Section(course.get(courseN).getCourseID(),semester.get(semesterN).getSemesterID(),UUID.randomUUID(),100));
			}
			
		}
		for (int sectionN = 0; sectionN < section.size(); sectionN++) {
			for (int studentN = 0; studentN < student.size(); studentN++) {
				enrollment.add(new Enrollment(student.get(studentN).getStudentID(),section.get(sectionN).getSectionID()));
				
			}
		}
		for (int enrollmentN = 0; enrollmentN < enrollment.size(); enrollmentN++) {
			enrollment.get(enrollmentN).setGrade((double) (enrollmentN + 30));
		}
	}

	@Test
	public void gpaTest() {
		int gpa = 0;
		int gpaSum = 0;
		double gbaAver = 0;
		for(int studentN = 0; studentN < student.size(); studentN++) {
			for(int enrollmentS = 0 + studentN; enrollmentS < enrollment.size(); enrollmentS = enrollmentS +10) {
				int y = (int)enrollment.get(enrollmentS).getGrade();
				if(y < 60)
					gpa = 0;
				else if(y < 70 && y > 60)
					gpa = 1;
				else if(y < 80 && y > 70)
					gpa = 2;
				else if(y < 90 && y > 80)
					gpa = 3;
				else if(y < 100 && y > 90)
					gpa = 4;
				
				gpaSum = gpaSum +gpa;
				gbaAver = gpaSum / section.size();
				}
			
		}
			
		}
}