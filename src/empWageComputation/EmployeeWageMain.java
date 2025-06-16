package empWageComputation;

import java.util.Random;

public class EmployeeWageMain {

	public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program on Master Branch");
        
        Random random = new Random();
        int attendance = random.nextInt(2); // 0 for Absent, 1 for Present

        if (attendance == 1) {
            System.out.println("Employee is Present");
        } else {
            System.out.println("Employee is Absent");
        }  
	}
}
