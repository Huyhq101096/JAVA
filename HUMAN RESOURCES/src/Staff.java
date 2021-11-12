
public abstract class Staff implements ICalculator {

    public abstract void displayInformation();

    private String code;
    private String name;
    private  int age;
    private double coeffSalary;
    private  String startDay;
    private  String departmentWork;
    private int dayOff;

    // hàm constructor không tham số và có tham số .
    public Staff() {
    }

    public Staff(String code, String name, int age, double coeffSalary, String startDay, String departmentWork, int dayOff) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.coeffSalary = coeffSalary;
        this.startDay = startDay;
        this.departmentWork = departmentWork;
        this.dayOff = dayOff;
    }

    // setter.

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCoeffSalary(double coeffSalary) {
        this.coeffSalary = coeffSalary;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public void setDepartmentWork(String departmentWork) {
        this.departmentWork = departmentWork;
    }

    public void setDayOff(int dayOff) {
        this.dayOff = dayOff;
    }

    // getter.

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getCoeffSalary() {
        return coeffSalary;
    }

    public String getStartDay() {
        return startDay;
    }

    public String getDepartmentWork() {
        return departmentWork;
    }

    public int getDayOff() {
        return dayOff;
    }

}



