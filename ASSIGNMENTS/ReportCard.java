package com.Assignments;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class ReportCard {
	public String Name;
	public String SurName;
    public  String Class;
	public Map<String, String[]>subjectGrades;
	public Map<String, String[]>studentDetails;
	
	
	public static void main(String[] args) {
		
		System.out.println("REPORT CARD");
		Scanner scan = new Scanner(System.in);
		
		//GETTING INPUT FROM USER
		System.out.print("Enter Student Name: ");
		String Name = scan.nextLine();
		System.out.print("Enter Student SurName: ");
		String SurName = scan.nextLine();
		System.out.print("Enter Student's Class: ");
		String Class = scan.nextLine();
		int num = 0;
		
		String Status = "True";
		while(Status=="True"){
		       ReportCard Student = new ReportCard(Name,SurName, Class);
		       num = num+1;
		       
		       // Getting grades and judgment of a student from user
		       System.out.print("SUBJECTS:"+"\n"+"------------"+"\n");
		       System.out.print("1. Tamil"+"\n"+"2. English"+"\n"+"3. Mathematics"+"\n"+"4. Science"+"\n"+"5. History"+"\n"+"6. Geography"+"\n"+"7. Computer Science");
		       System.out.print("GRADES"+"\n"+"------------"+"\n");
		       System.out.print("A - Excellent"+"\n"+"B - Good"+"\n"+"C - Needs Improvement"+"\n"+"D - Poor");
		       
		       System.out.print("For how many subjects do you want to provide grade?: ");
		       int n = scan.nextInt();
		       
		       for(int i=0;i<n;i++) {
		       System.out.print("Enter Subject: ");
		       String subject = scan.nextLine();
		       System.out.print("Enter Grade: ");
		       String grade = scan.nextLine();
		       System.out.print("Enter Judgement: ");
		       String judgement = scan.nextLine();
		       
		       Student.addSubjectGrade(subject, Name, grade, judgement);
		       }
		       
		       System.out.print("Want to continue?(YES/NO): ");
		       String result = scan.nextLine(); 
		       if(result=="NO") {
		    	   Status = "False" ;
		       }
		}
		
		System.out.print("Want to see grades?(YES/NO): ");
		String result1 = scan.nextLine(); 
	       if(result1=="YES") {
	    	   Display(scan,num, subjectGrades);
	       }
	       else {
	    	   System.out.print("Thanks for your response");
	       }
		
	}
	
	
	//CONSTRUCTOR
	public ReportCard(String Name, String SurName, String Class) {
		this.Name = Name;
		this.SurName = SurName;
		this.Class = Class;
		this.subjectGrades = new HashMap<>();
		this.studentDetails = new HashMap<>();
	}

	// Adding Student Report Card details to the HashMap container--> subjectGrades
	public void addSubjectGrade(String subject, String Name,String grade, String judgment) {
		subjectGrades.put(subject, new String[]{Name, grade, judgment});
	}
	
	
	//Adding Student details to the HashMap container--> student details
	public void Student(String Name, String SurName, String Class) {
		studentDetails.put(Name, new String[]{SurName, Class});
	}
	
	//To display Report Card
	
	public static void Display(Scanner scan,int num,Map<String, String[]> subjectGrades) {
		System.out.print("Want to see specific student details or all?(Specific/All):");
		String result2 = scan.nextLine(); 
		int num1;
		String studentname;
	    if(result2=="Specific") {
	    	System.out.print("Enter Student Name: ");
	    	studentname = scan.nextLine();
	    	num1 = 1;
	    }
	    else {
	    	studentname= "All"; 
	    	num1 = num;
	    }
	    
	    for(int i=0;i<num1;i++) {//i=0,1
	    	if(result2=="Specific"){ 
	    	for (Map.Entry<String, String[]> entry : subjectGrades.entrySet()){
	    		   String[] gradeAndJudgment = entry.getValue();
	    		   String name = gradeAndJudgment[0];
	    		   String grade = gradeAndJudgment[1];
	               String judgment = gradeAndJudgment[2];
	    		   if(name==studentname) {
	    			   System.out.println
	    		   }
	    	   }
	     }
	    }
	       
	}
	
}
