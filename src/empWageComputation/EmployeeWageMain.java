package empWageComputation;

import java.util.Random;

public class EmployeeWageMain {
	
	public static final int WAGE_PER_HOUR = 20;
    public static final int FULL_TIME = 1;
    public static final int PART_TIME = 2;


	public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program on Master Branch");
        
        Random random = new Random();

        int attendance = random.nextInt(2); // 0 or 1
        if (attendance == 0) {
            System.out.println("Employee is Absent");
            System.out.println("Employee Daily Wage: ₹0");
            return;
        }

        System.out.println("Employee is Present");

        int empType = random.nextInt(3); // 0, 1, or 2

        int empHours = 0;
        switch (empType) {
            case FULL_TIME:
                empHours = 8;
                System.out.println("Employee is Full-Time");
                break;
            case PART_TIME:
                empHours = 4;
                System.out.println("Employee is Part-Time");
                break;
            default:
                empHours = 0;
                System.out.println("Invalid Employee Type");
                break;
        }

        int dailyWage = empHours * WAGE_PER_HOUR;
        System.out.println("Employee Daily Wage: ₹" + dailyWage);
    
    }
}
