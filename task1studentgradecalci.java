//TASK:STUDENT GRADE CALCULATOR
/*Input: Take marks obtained (out of 100) in each subject.
Calculate Total Marks: Sum up the marks obtained in all subjects.
Calculate Average Percentage: Divide the total marks by the total number of subjects to get the
average percentage.
Grade Calculation: Assign grades based on the average percentage achieved.
Display Results: Show the total marks, average percentage, and the corresponding grade to the user*/





import java.util.Scanner;

public class studentgradecalci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();
        int total = 0;

        System.out.println("Enter marks (out of 100) for each subject:");
        for (int i = 1; i <= n; i++) {
            int mark = sc.nextInt();
            total=total+ mark;
        }

        double average = (double) total / n;
        char grade;
        if (average >= 90)
        {
            grade = 'A';
        }
        else if (average >= 75)
        {
            grade = 'B';
        }
        else if (average >= 60) {
            grade = 'C';
        }
        else if (average >= 45){
            grade = 'D';
        }
        else{
            grade = 'F';
        }

        System.out.println("\n---- Result ----");
        System.out.println("Total Marks: " + total + "/" + (n * 100));
        System.out.println("Average Percentage: " + average + "%");
        System.out.println("Grade: " + grade);

        sc.close();
    }
}
