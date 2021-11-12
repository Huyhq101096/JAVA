public class Department {

    private String codeDepartment;
    private String nameDepartment;
    private int numStaff = 0;


    public Department() {
    }

    public Department(String codeDepartment, String nameDepartment, int numStaff) {
        this.codeDepartment = codeDepartment;
        this.nameDepartment = nameDepartment;
        this.numStaff = numStaff;
    }

    public String getCodeDepartment() {
        return codeDepartment;
    }

    public void setCodeDepartment(String codeDepartment) {
        this.codeDepartment = codeDepartment;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    public int getNumStaff() {
        return numStaff;
    }

    public void setNumStaff(int numStaff) {
        this.numStaff = numStaff;
    }

    @Override
    // Hiển thị thông tin bộ phận.
    public String toString() {
        return codeDepartment + " " + nameDepartment + " " + numStaff;
    }
}
