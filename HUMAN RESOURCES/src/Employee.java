import java.util.Scanner;

public class Employee extends Staff implements ICalculator {



    private double hourOvertime;

    public Employee() {

    }


    public double getHourOvertime() {
        return hourOvertime;
    }

    public void setHourOvertime(int hourOvertime) {
        this.hourOvertime = hourOvertime;
    }



    public Employee(String code, String name, int age, double coeffSalary,
                    String startDay, String departmentWork, int dayOff, double hourOvertime) {
        super(code, name, age, coeffSalary, startDay, departmentWork, dayOff);
        this.hourOvertime = hourOvertime;
    }

    // Hàm tính lương cho nhân viên.
    @Override
    public double calculateSalary() {
        return getCoeffSalary() * 3000000 + getHourOvertime() * 200000;
    }


    @Override
    public void displayInformation() {

        System.out.printf("%s\t%s\t\t%d\t%.1f\t\t%s\t%10s\t%d\t%.1f",getCode(),getName(),getAge(),getCoeffSalary(),getStartDay(),getDepartmentWork(),getDayOff(),getHourOvertime());

    }



}




