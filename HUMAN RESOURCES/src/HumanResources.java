import java.sql.SQLOutput;
import java.util.*;

public class HumanResources {

    static ArrayList<Staff> staffList = new ArrayList<>();
    static ArrayList<Department> departmentList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Danh sách nhân viên có sẵn trong công ty.
        staffList.add(new Employee("2001","Huynh Quoc Huy",25,3.1,"23/1/2018","Marketing", 12,3));
        staffList.add(new Employee("2007","Huynh Quoc Huy",25,3.1,"23/1/2018","Marketing", 12,5));
        staffList.add(new Employee("2002","Tran Van Tan",26,4.0,"23/5/2019","Marketing", 11,5));
        staffList.add(new Employee("2003","Huynh Huy Hoang",27,3.2,"2/2/2019","HR", 12,4));
        staffList.add(new Employee("2004","Huynh Huy Hoang",27,3.3,"27/2/2020","HR", 12,4));
        staffList.add(new Employee("2005","Huynh Van Nam",28,3.4,"25/5/2021","IT", 12,4));
        //staffList.add(new Manager("2006","Tran Van Tuan",40,3.5,"25/6/2020","IT",12,"Business Leader"));
        departmentList.add(new Department("M001","Marketing",0));
        departmentList.add(new Department("H002","HR",0));
        departmentList.add(new Department("I003","IT",0));

        int choose;
        boolean contitue = true;

        do {
            int numContinue;
            showMenu();
            System.out.print("Hãy chọn tính năng mà bạn muốn: ");
            choose = sc.nextInt();
            System.out.println();

            while(choose  < 1 || choose > 7) {
                System.out.print("Hãy chọn các tính năng có trong chương trình: ");
                choose = sc.nextInt();
            }
            switch(choose) {
                case 1:
                    showInfo();
                    break;
                case 2:
                    showDepartment();
                    break;
                case 3:
                    showEmployeeDepartment();
                    break;
                case 4:
                    addEmployee();
                    break;
                case 5:
                    findStaff();
                    break;
                case 6:
                    showSalary();
                    break;
                case 7:
                    break;
            }
            System.out.println();
            System.out.print("Bạn có muốn tiếp tục chương trình không (1.Yes or 2.No): ");
            numContinue = sc.nextInt();
            while(numContinue != 1 && numContinue != 2) {
                System.out.print("Hãy nhập số theo yêu cầu của đề bài: ");
                numContinue = sc.nextInt();
            }
            if (numContinue == 1) {
                contitue = true;
            } else if(numContinue == 2) {
                contitue = false;
            }
        } while (contitue);
    }

    public static void showMenu() {
        System.out.println("chào mừng bạn đến với phần mềm quản lí nhân viên.");
        System.out.println("1. Hiển thị danh sách nhân viên có trong công ty");
        System.out.println("2. Hiển thị các bộ phận trong công ty");
        System.out.println("3. Hiển thị nhân viên theo từng bộ phận");
        System.out.println("4. Thêm nhân viên mới vào công ty.");
        System.out.println("5. Tìm kiếm nhân viên.");
        System.out.println("6. Hiển thị bảng lương.");
        System.out.println("7. Dừng chương trình.");
    }

    // hiển thị danh sách nhân viên.
    public static void showInfo() {
        System.out.println("Danh sách nhân viên:");
        for(int i = 0; i < staffList.size(); i++) {
            staffList.get(i).displayInformation();
            System.out.println();
        }
    }

    // hiển thị các bộ phận trong công ty.
    public static void showDepartment() {
        System.out.println("Hiển thị các bộ phận có trong công ty. (Mã bộ phận/Tên bộ phận/Số lượng nhân viên.)");
        for(int i = 0; i < departmentList.size(); i++) {
            int countStaff = 0;
            // lăp qua số lượng nhân viên.
            for(int j = 0; j < staffList.size(); j++) {
                if(staffList.get(j).getDepartmentWork().equals(departmentList.get(i).getNameDepartment())) {
                    countStaff++;
                }
            }
            departmentList.get(i).setNumStaff(countStaff);
            System.out.println(departmentList.get(i).toString());
        }
    }

    // Hiển thị nhâm viên theo từng bộ phận.
    public static void showEmployeeDepartment() {
        System.out.print("Hiển bị bộ phận mà bạn muốn chọn. Chọn: 0. Marketing || 1. HR || 2. IT : ");
        int chooseDpm = sc.nextInt();

        while(chooseDpm < 0 || chooseDpm > 2) {
            System.out.print("Nhập đúng bộ phân theo yêu cầu: ");
            chooseDpm = sc.nextInt();
        }
        System.out.println("Danh sách nhân viên của bộ phận. " + departmentList.get(chooseDpm).getNameDepartment());
        for(int i = 0; i < staffList.size(); i++) {
            if(staffList.get(i).getDepartmentWork().equals(departmentList.get(chooseDpm).getNameDepartment())) {
                staffList.get(i).displayInformation();
                System.out.println();
            }
        }
    }

    //Thêm nhân viên mới vào công ty.
    public static void addEmployee() {

        int addStaff;
        System.out.print("Bạn muốn thêm nhân viên hay quản lí. (1. Nhân viên || 2. Quản lí) : ");
        addStaff = sc.nextInt();
        sc.nextLine();
         String code;
         String name;
         int age;
         double coeffSalary;
         String startDay;
         String departmentWork;
         int dayOff;
        double hourOvertime;
        String position;

        if(addStaff == 1) {
            System.out.println("Hãy điền thông tin của sinh viên.");
            System.out.print("Nhập mã nhân viên: ");
            code = sc.nextLine();

            System.out.print("Nhập họ tên nhân viên: ");
            name = sc.nextLine();

            System.out.print("Nhập tuổi: ");
            age = sc.nextInt();

            System.out.print("Hệ số lương: ");
            coeffSalary = sc.nextDouble();
            sc.nextLine();

            System.out.print("Ngày bắt đầu làm việc: ");
            startDay = sc.nextLine();

            System.out.print("Bộ phận: 0.Marketing || 1.HR || 2.IT : ");
            int chooseDpm = sc.nextInt();
            while( chooseDpm < 0 || chooseDpm > 2) {
                System.out.print("Chọn bộ phận đúng theo yêu cầu: ");
                chooseDpm = sc.nextInt();
            }
            if(chooseDpm == 0) {
                departmentWork = "Marketing";
            } else if(chooseDpm == 1) {
                departmentWork = "HR";
            } else {
                departmentWork = "IT";
            }

            System.out.print("Số ngày nghi: ");
            dayOff = sc.nextInt();

            System.out.print("Số giờ làm thêm: ");
            hourOvertime = sc.nextInt();

            staffList.add(new Employee(code, name, age, coeffSalary, startDay, departmentWork, dayOff, hourOvertime));

            for(int i = 0; i < staffList.size(); i++) {
                staffList.get(i).displayInformation();
                System.out.println();
            }
        } else if(addStaff == 2) {
            System.out.println("Hãy điền thông tin của quản lí.");
            System.out.print("Nhập mã nhân viên: ");
            code = sc.nextLine();

            System.out.print("Nhập họ tên nhân viên: ");
            name = sc.nextLine();

            System.out.print("Nhập tuổi: ");
            age = sc.nextInt();

            System.out.print("Hệ số lương: ");
            coeffSalary = sc.nextDouble();
            sc.nextLine();

            System.out.print("Ngày bắt đầu làm việc (DD/MM/YYYY): ");
            startDay = sc.nextLine();

            System.out.print("Bộ phận quản lí: 0. Marketing || 1.HR || 2. IT : ");
            int chooseDpm = sc.nextInt();
            while( chooseDpm < 0 || chooseDpm > 2) {
                System.out.print("Chọn bộ phận đúng theo yêu cầu: ");
                chooseDpm = sc.nextInt();
            }
            if(chooseDpm == 0) {
                departmentWork = "Marketing";
            } else if(chooseDpm == 1) {
                departmentWork = "HR";
            } else {
                departmentWork = "IT";
            }

            System.out.print("Số ngày nghỉ: ");
            dayOff = sc.nextInt();
            sc.nextLine();

            System.out.print("Chức vụ của quản lí: 0.Business Leader || 1.Project Leader || 2. Technical Leader: ");
            int choosePosition = sc.nextInt();
            while( choosePosition < 0 || choosePosition > 2) {
                System.out.print("Chọn vị trí đúng theo yêu cầu: ");
                choosePosition = sc.nextInt();
            }
            if(choosePosition == 0) {
                position = "Business Leader";
            } else if(choosePosition == 1) {
                position = "Project Leader";
            } else {
                position = "Technical Leader";
            }
            staffList.add(new Manager(code,name,age,coeffSalary,startDay,departmentWork,dayOff,position));
            for(int i = 0; i < staffList.size(); i++) {
                staffList.get(i).displayInformation();
                System.out.println();
            }
        }
    }


    // Tìm kiếm thông tin nhân viên.
    public static void findStaff() {
        // bạn muốn tìm theo tên hay mã số nhân viên.
        int findSt;
        System.out.print("Tìm theo tên hay mã số nhân viên. 1.MSNV || 2.Tên: ");
        findSt = sc.nextInt();
        sc.nextLine();

        if(findSt == 1) {
            System.out.println("Nhập mã số nhân viên: ");
            String findCode = sc.nextLine();
            for(int i = 0; i < staffList.size(); i++) {
                if(findCode.equals(staffList.get(i).getCode())) {
                    staffList.get(i).displayInformation();
                }
            }
        }
        if(findSt == 2) {
            System.out.print("Nhập tên của nhân viên");
            String findName = sc.nextLine();
            for(int i = 0; i < staffList.size(); i++) {
                if(findName.equals(staffList.get(i).getName())) {
                    staffList.get(i).displayInformation();
                }
            }
        }
    }

    // sắp xếp bảng lương từ nhỏ đến lớn trong công ty.
    public static void showSalary() {

        System.out.print("Chọn các tính năng: 1.Hiển thị bảng lương của nhân viên. || 2. Lương tăng dần || 3. Lương giảm dần : ");
        int chooseFn = sc.nextInt();
        while(chooseFn < 1  || chooseFn > 3) {
            System.out.println("Chọn các tính năng hiện có");
            chooseFn = sc.nextInt();
        }
        if(chooseFn == 1) {
            for(int i = 0; i < staffList.size(); i++) {
                System.out.printf("%s\t%s\t%.1f\n", staffList.get(i).getCode(),staffList.get(i).getName(),staffList.get(i).calculateSalary());
            }
        } else if(chooseFn == 2) {
            Collections.sort(staffList, new Comparator<Staff>() {
                @Override
                public int compare(Staff o1, Staff o2) {
                    if(o1.calculateSalary() > o2.calculateSalary()) {
                        return 1;
                    } else {
                        return -1;
                    }
                    //return o1.calculateSalary() - o2.calculateSalary();
                }
            });
            System.out.println("Danh sách sắp xếp theo thứ tự điểm tăng dần là: ");
            for(int i = 0; i < staffList.size(); i++) {
                System.out.printf("%s\t%s\t%.1f\n", staffList.get(i).getCode(),staffList.get(i).getName(),staffList.get(i).calculateSalary());
            }
        } else {
            Collections.sort(staffList, new Comparator<Staff>() {
                @Override
                public int compare(Staff o1, Staff o2) {
                    if(o1.calculateSalary() > o2.calculateSalary()) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            });
            System.out.println("Danh sách sắp xếp theo thứ tự điểm giảm dần là: ");
            for(int i = 0; i < staffList.size(); i++) {
                System.out.printf("%s\t%s\t%.1f\n", staffList.get(i).getCode(),staffList.get(i).getName(),staffList.get(i).calculateSalary());
            }
        }
    }
}
