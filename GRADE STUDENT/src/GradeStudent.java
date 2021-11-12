import java.util.Scanner;

public class GradeStudent {
     public static void main(String[] args) {
        begin();
        midTerm();
        finalTerm();
        homeWork();
        double totalMark = getPointMid + getPointFinal + getPointHomework;
        report(totalMark);
    }

    static Scanner sc = new Scanner(System.in);
    public static int weightMid;  // nhập trọng số giữa kì.
    public static int weightFinal;  // nhập trọng số giữa kì.
    public static int weightHomework;  // nhập trọng số giữa kì.
    public static int totalWeight;  // tổng trọng số .
    public static int EarnMid;    // điểm đạt được giữa kì.
    public static int EarnFinal;    // điểm đạt được giữa kì.
    public static int scorePlus;  // có điểm cộng hay không có điểm cộng.(yes or no).
    public static int shiftAmount;      // số điểm cộng là bao nhiêu.
    public static double getPointMid;  // lấy điểm giữa kì.
    public static double getPointFinal; // lấy điểm cuối kì.
    public static double getPointHomework;  // lấy điểm bài tập về nhà.
    public static double totalMid;  // tổng giá trị điểm giữa kì.
    public static double totalFinal;  // tổng giá trị điểm cuối kì.

    // hàm giới thiệu chào mừng.
    public static void begin() {
        System.out.println("This program reads exam/homework scores and reports your overall course grade.");
        System.out.println();
    }

    // hàm điểm giữa kì.
    public static void midTerm() {

        System.out.println("Midterm:");
        System.out.print("Weight (0 - 100)? ");
        weightMid = sc.nextInt();

        System.out.print("Score earned? ");
        EarnMid = sc.nextInt();

        System.out.print("Were scores shifted (1 = yes, 2 = no)? ");
        scorePlus = sc.nextInt();

        // đoạn code đã được sửa lại để không bị lặp code và điểm sẽ bằng  trọng số khi nhập lớn hơn 100.
        if(scorePlus == 1) {
            System.out.print("Shift amount? ");
            shiftAmount = sc.nextInt();
            totalMid = EarnMid+shiftAmount;
            if(totalMid >= 100) {
                totalMid = 100;
            }
        } else {
            totalMid = EarnMid;
            if(totalMid >= 100) {
                totalMid = 100;
            }
        }
        System.out.println("Total points = " + (int)totalMid + " / 100");
        System.out.println("Weighted score = "  + Math.round(((totalMid/100)*weightMid)*10.0)/10.0 + " / " + weightMid);
        getPointMid = (totalMid/100)*weightMid;
        System.out.println();
    }

    // hàm điểm cuối kì.
    public static void finalTerm() {
        System.out.println("Final :");
        System.out.print("Weight (0 - 100)? ");
        weightFinal = sc.nextInt();

        System.out.print("Score earned? ");
        EarnFinal = sc.nextInt();

        System.out.print("Were scores shifted (1 = yes, 2 = no)? ");
        scorePlus = sc.nextInt();

        // đoạn code đã được sửa lại để không bị lặp code và điểm sẽ bằng  trọng số khi nhập lớn hơn 100.
        if(scorePlus == 1) {
            System.out.print("Shift amount? ");
            shiftAmount = sc.nextInt();
            totalFinal = EarnFinal + shiftAmount;
            if(totalFinal >= 100) {
                totalFinal = 100;
            }
        } else {
            totalFinal = EarnFinal;
            if(totalFinal >= 100) {
                totalFinal = 100;
            }
        }
        System.out.println("Total points = " + (int)totalFinal + " /100");
        System.out.println("Weighted score = "  + Math.round(((totalFinal/100)*weightFinal)*10.0)/10.0 + " / " + weightFinal);
        getPointFinal = (totalFinal/100)*weightFinal;
        System.out.println();
    }

    // hàm tính điểm bài tập về nhà.
    public static void homeWork() {
        System.out.println("Homework :");
        System.out.print("Weight scores (0 - 100)? ");
        weightHomework = sc.nextInt();
        System.out.print("Number of assignment? ");
        int numAgm = sc.nextInt();
        int totalScore = 0;  // tổng điểm đạt được của bài tập.
        int score;              // điểm đạt được của bài tập.
        int totalMax = 0;
        int max;
        for(int i=1; i <= numAgm; i++) {
            System.out.print("Assignment " + (i) + " score and max? ");
            score = sc.nextInt();
            max = sc.nextInt();
            totalScore += score;
            totalMax += max;
        }

        System.out.print("How many sections did you attend? ");
        int attendence = sc.nextInt();
        int totalAttendence = attendence*5;
        // totalAttendence không được lớn hơn 30.
        if(totalAttendence >= 30) {
            totalAttendence = 30;
        }

        // tổng điểm đạt được trong bài tập về nhà .
        double totalHomeworkScore = totalScore + totalAttendence;

        // tổng điểm tối đa.
        double totalHomeworkMax = totalMax + 30;

        if (totalHomeworkMax >= 150 ) {
            totalHomeworkMax = 150;
            if (totalHomeworkScore >= 150) {
                totalHomeworkScore = 150;
            }
        }
        getPointHomework = (totalHomeworkScore/totalHomeworkMax)*weightHomework;
        System.out.println("Section points = " + totalAttendence + " / 30");
        System.out.println("Total points = " + (int)totalHomeworkScore + " / " + (int)totalHomeworkMax);
        System.out.println("Weighted score = " + Math.round(getPointHomework*10.0)/10.0 + " / " + weightHomework);
        System.out.println();
    }

    // hàm báo cáo điểm và GPA.
    public static double report(double overall) {
        totalWeight = weightMid + weightFinal + weightHomework;
        System.out.printf("Your grade: %.1f\n",overall);
        if(totalWeight == 100) {
            if(overall >= 85) {
                System.out.println("GPA = 3.0");
            } else if(overall >= 75 && overall < 85) {
                System.out.println("GPA = 2.0");
            } else if(overall < 75 && overall >= 60) {
                System.out.println("GPA = 1.0");
            } else {
                System.out.println("GPA = 0.0");
            }
        } else {
            System.out.println("Your weighted score not equal 100!");
        }
        return overall;
    }
}
