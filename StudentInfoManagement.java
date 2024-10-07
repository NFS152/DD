import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

// Student class
class Student{
	private int ID;
	private String name;
	private String grade;
	private double GPA;

	// Constructor
	public Student(int ID, String name, String grade, double GPA){
		this.ID = ID;
		this.name = name;
		this.grade = grade;
		this.GPA = GPA;
	}

	// set() functions
	public void setName(String name){
		this.name = name;
	}

	public void setGrade(String grade){
		this.grade = grade;
	}

	public void setGPA(double GPA){
		this.GPA = GPA;
	}

	// get() functions
	public int getID(){
		return this.ID;
	}

	public String getName(){
		return this.name;
	}

	public String getGrade(){
			return this.grade;
	}

	public double getGPA(){
			return this.GPA;
	}

	public void displayInfo(){
		System.out.println("ID: " + ID);
		System.out.println("Name: " + name);
		System.out.println("Grade: " + grade);
		System.out.println("GPA: " + GPA + "\n");
	}
}

class StudentDatabase{
	ArrayList<Student> database = new ArrayList<Student>();

	public void addStudent(Student student){
		database.add(student);
	}

	public void displayAllInfo(){
		for(Student student:database){
			//student.displayInfo();
			System.out.println("Student ID: " + student.getID());
			System.out.println("Student Name: " + student.getName());
			System.out.println("Student Grade: " + student.getGrade());
			System.out.println("Student GPA: " + student.getGPA() + "\n");

		}
	}
}

// Main class
class StudentInfoManagement{
	public static void searchStudent(){}

	public static String grade_calculator(double gpa){
		if(gpa == 4.0) return "A+";
		else if(gpa < 4 && gpa >= 3.75) return "A";
		else if(gpa < 3.75 && gpa >= 3.5) return "A-";
		else if(gpa < 3.5 && gpa >= 3.25) return "B+";
		else if(gpa < 3.25 && gpa >= 3) return "B";
		else if(gpa < 3 && gpa >= 2.75) return "B-";
		else if(gpa < 2.75 && gpa >= 2.5) return "C+";
		else if(gpa < 2.5 && gpa >= 2.25) return "C";
		else if(gpa < 2.25 && gpa >= 2) return "D";
		else return "F";
	}

	public static double gpa_calculator(ArrayList<String> grades, int sub_num){
		double gpa = 0;
		for(String s : grades){
			switch(s){
				case "A+":
					gpa += 4;
					break;
				case "A":
					gpa += 3.75;
					break;
				case "A-":
					gpa += 3.5;
					break;
				case "B+":
					gpa += 3.25;
					break;
				case "B":
					gpa += 3;
					break;
				case "B-":
					gpa += 2.75;
					break;
				case "C+":
					gpa += 2.5;
					break;
				case "C":
					gpa += 2.25;
					break;
				case "D":
					gpa += 2;
					break;
				case "F":
					gpa += 0;
					break;
				default:
					break;

			}
		}
		gpa /= sub_num;
		return gpa;
	}

	public static Student addStudent(){
		System.out.println("\nAdd student:");
		Scanner sc = new Scanner(System.in);
		System.out.print("ID: ");
		int ID = sc.nextInt();
		System.out.print("Name: ");
		String name = sc.next();
		/*
		System.out.print("Grade: ");
		String grade = sc.next();
		System.out.print("GPA: ");
		double GPA = sc.nextDouble();
		*/

		System.out.print("How many subject number do you want to enter: ");
		int sub_number = sc.nextInt();
		ArrayList<String> grades = new ArrayList<String>();
		for(int i=0;i<sub_number;i++){
			String x = sc.next();
			grades.add(x);
		}

		double GPA = gpa_calculator(grades, sub_number);
		String grade = grade_calculator(GPA);


		System.out.println();

		return new Student(ID, name, grade, GPA);
	}

	public static void main(String[] args){
		/*Student s = new Student(32, "Mehedi", "A+", 4.00);
		StudentDatabase studentDatabase = new StudentDatabase();
		studentDatabase.addStudent(s);
		// s.displayInfo();
		studentDatabase.displayAllInfo();*/

		StudentDatabase studentDatabase = new StudentDatabase();

		Scanner sc = new Scanner(System.in);

		// Menu loop
		while(true){
			// Menu
			System.out.println("Main menu");
			System.out.println("\t1. Add new student");
			System.out.println("\t2. Search student by ID");
			System.out.println("\t3. Display all students data");
			System.out.println("\t4. Exit");
			System.out.print(">> ");
			int selector;
			selector = sc.nextInt();
			switch(selector){
				case 1:
					studentDatabase.addStudent(addStudent());
					break;
				case 2:
					//searchStudent();
					boolean flag = false;
					System.out.print("Enter ID number: ");
					int searchID = sc.nextInt();
					System.out.println("\nStudent: ");
					for(Student student : studentDatabase.database){
						if(student.getID() == searchID){
							student.displayInfo();
							flag = true;
							break;
						}
					}
					if(flag == true){
						//System.out.print("Do you want to change data [y/n]: ");

					}
					else
						System.out.println("Not found\n");

					break;
				case 3:
					System.out.println("\nAll students data:\n----------------");
					studentDatabase.displayAllInfo();
					System.out.println();
					break;
				case 4:
					return;
				default:
					System.out.println("Invalid key.");
			}
		}
	}
}