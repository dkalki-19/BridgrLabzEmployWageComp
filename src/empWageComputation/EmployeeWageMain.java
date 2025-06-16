package empWageComputation;

import java.util.Random;

public class EmployeeWageMain {
	
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;
    public static final int WAGE_PER_HOUR = 20;

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program on Master Branch");

        Random random = new Random();
        int empCheck = random.nextInt(3); 

        int empHours = 0;

        switch (empCheck) {
            case IS_PART_TIME:
                empHours = 4;
                System.out.println("Employee is Part-Time");
                break;
            case IS_FULL_TIME:
                empHours = 8;
                System.out.println("Employee is Full-Time");
                break;
            default:
                empHours = 0;
                System.out.println("Employee is Absent");
        }

        int dailyWage = empHours * WAGE_PER_HOUR;
        System.out.println("Employee Daily Wage: ₹" + dailyWage);
    }
}
