import java.util.*;

class TotalMarks {
    int totalMarks;
    int numOfSubjects;
    int percentage;

    void inputMarks(Scanner s) {

        System.out.print("Enter number of subjects : ");
        numOfSubjects = s.nextInt();

        for (int i = 1; i <= numOfSubjects; i++) {
            System.out.print("Enter subject " + i + " marks : ");
            try {
                int marks = s.nextInt();

                if (marks <= 100) {
                    totalMarks += marks;
                }
            } catch (InputMismatchException e) {
                System.out.println(e);
                System.out.println("Enter valid marks between 1 to 100");
                System.exit(0);
            }
        }
        System.out.println("Total Marks Obtained = " + totalMarks);
    }

    void calculatePercentage() {
        percentage = (int) (this.totalMarks * 100) / (this.numOfSubjects * 100);

        System.out.println(this.numOfSubjects);
        System.out.println("Percentage = " + percentage);
    }

    void calculateGrade() {
        String grade;
        if (percentage >= 90) {
            grade = "A+";
        } else if (percentage >= 80) {
            grade = "A";
        } else if (percentage >= 70) {
            grade = "B";
        } else if (percentage >= 60) {
            grade = "C";
        } else if (percentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }
        System.out.println("Grade = " + grade);
    }
}

class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        TotalMarks tm = new TotalMarks();

        tm.inputMarks(s);

        tm.calculatePercentage();

        tm.calculateGrade();

        s.close();
    }
}