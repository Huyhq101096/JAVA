import javax.swing.text.Position;

public class Manager extends Staff implements ICalculator {

    private String Position;
    // 1.Business Leader.
    // 2.Project Leader.
    // 3.Technical Leader.

    public Manager() {
    }

    public Manager(String code, String name, int age, double coeffSalary, String startDay, String departmentWork, int dayOff, String position) {
        super(code, name, age, coeffSalary, startDay, departmentWork, dayOff);
        this.Position = position;
    }

    // Hàm tính lương vị trí của leader.
    public int responSalary() {
        if(this.Position == "Business Leader") {
            return 8000000;
        } else if(this.Position == "Project Leader") {
            return 6000000;
        } else {
            return 5000000;
        }
    }

    @Override
    public void displayInformation() {
        System.out.printf("%s\t%s\t\t%d\t%.1f\t\t%s\t%s\t%d\t%s",getCode(),getName(),getAge(),getCoeffSalary(),getStartDay(),getDepartmentWork(),getDayOff(),getPosition());
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    @Override
    public double calculateSalary() {
        return getCoeffSalary() * 5000000 + responSalary();
    }
}
