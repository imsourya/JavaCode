package duega.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student{
	int marks;
	String name;
	
	Student(int marks, String name){
		this.marks = marks;
		this.name = name;
	}
}

class StudentComparator implements Comparator<Student>{
	public int compare(Student s1, Student s2) {
		return s1.marks - s2.marks;
	}
}

public class CustomClassSort {
	public static void main(String[] args) {
		List<Student> StudentList = new ArrayList<Student>();
		
		StudentList.add(new Student(100,"Roxy"));
		StudentList.add(new Student(110,"goga"));
		StudentList.add(new Student(107,"yama"));
		StudentList.add(new Student(98,"chiku"));
		StudentList.add(new Student(99,"Lama"));
		
		Collections.sort(StudentList, new StudentComparator());
		
		display(StudentList);
	}

	private static void display(List<Student> studentList) {
		
		if(!studentList.isEmpty()) {
			for(Student s : studentList) {
				System.out.println(s.name+ " ");
			}
		}
		
	}
}
