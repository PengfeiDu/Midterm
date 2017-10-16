package com.cisc181.core;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

public class Staff_Test {
	
	private static ArrayList<Staff> staff = new ArrayList(); 

	@BeforeClass
	public static void setup() throws PersonException {
		try {
			staff.add(new Staff("Joseph", "R", "Jostar", (new SimpleDateFormat("dd/MM/yyyy")).parse("10/31/1997"),
					"Hamlet Way","(302)-123-4567","ruarua@gmail.com","6 AM to 8 PM", 5, 10000, 
					(new SimpleDateFormat("dd/MM/yyyy")).parse("04/03/2010"),eTitle.MR));
			staff.add(new Staff("Joseph", "R", "Jostar", (new SimpleDateFormat("dd/MM/yyyy")).parse("10/31/1997"),
					"Hamlet Way","(302)-123-4567","ruarua@gmail.com","6 AM to 8 PM", 5, 20000, 
					(new SimpleDateFormat("dd/MM/yyyy")).parse("04/03/2010"),eTitle.MR));
			staff.add(new Staff("Joseph", "R", "Jostar", (new SimpleDateFormat("dd/MM/yyyy")).parse("10/31/1997"),
					"Hamlet Way","(302)-123-4567","ruarua@gmail.com","6 AM to 8 PM", 5, 30000, 
					(new SimpleDateFormat("dd/MM/yyyy")).parse("04/03/2010"),eTitle.MR));
			staff.add(new Staff("Joseph", "R", "Jostar", (new SimpleDateFormat("dd/MM/yyyy")).parse("10/31/1997"),
					"Hamlet Way","(302)-123-4567","ruarua@gmail.com","6 AM to 8 PM", 5, 40000, 
					(new SimpleDateFormat("dd/MM/yyyy")).parse("04/03/2010"),eTitle.MR));
			staff.add(new Staff("Joseph", "R", "Jostar", (new SimpleDateFormat("dd/MM/yyyy")).parse("10/31/1997"),
					"Hamlet Way","(302)-123-4567","ruarua@gmail.com","6 AM to 8 PM", 5, 50000, 
					(new SimpleDateFormat("dd/MM/yyyy")).parse("04/03/2010"),eTitle.MR));
		} catch (ParseException e) {
			System.out.println("ParseException");
		} catch (PersonException pe) {
			System.out.println("PersonException");
			// TODO Auto-generated catch block
		}
	}
	
	@Test
	public void test() {
		double salaryAver;
		double salarySum = 0;
		
		for (Staff member: staff) {
			salarySum = salarySum + member.getSalary();
		}
		salaryAver = salarySum / staff.size();
		assertEquals(30000.00, salaryAver,0.1);
	}	
	public void testDOB() throws ParseException, PersonException{
		boolean flag = false;
		try {
			staff.get(0).setDOB((new SimpleDateFormat("dd/MM/yyyy")).parse("20/08/1920"));
			
		}catch (ParseException e) {
			System.out.println("ParseException");
		}catch (PersonException pe) {
			System.out.println("PersonException");
		}assertTrue(flag);
	}
	public void testPhone() {
		boolean flag = false;
		try {
			staff.get(0).setPhone("987654321");
		}catch(PersonException pe) {
			flag = true;
		}assertTrue(flag);
		boolean flag2 = false;
		try {
			staff.get(0).setPhone("(302)4447777");
		}catch(PersonException pe) {
			flag2 = true;
		}assertTrue(flag2);
	}

}
