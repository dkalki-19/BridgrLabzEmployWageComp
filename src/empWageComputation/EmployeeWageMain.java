package empWageComputation;

import java.util.Random;

import java.util.Random;

public class EmployeeWageMain {

    // Constants
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;
    public static final int WAGE_PER_HOUR = 20;
    public static final int WORKING_DAYS_PER_MONTH = 20;

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program on Master Branch");

        int totalWage = 0;
        Random random = new Random();

        for (int day = 1; day <= WORKING_DAYS_PER_MONTH; day++) {
            int empHours = 0;
            int empCheck = random.nextInt(3); // 0, 1, 2

            switch (empCheck) {
                case IS_PART_TIME:
                    empHours = 4;
                    break;
                case IS_FULL_TIME:
                    empHours = 8;
                    break;
                default:
                    empHours = 0;
            }

            int dailyWage = empHours * WAGE_PER_HOUR;
            totalWage += dailyWage;

            System.out.println("Day " + day + ": Employee Hours = " + empHours + ", Daily Wage = ₹" + dailyWage);
        }

        System.out.println("Total Monthly Wage for 20 Days: ₹" + totalWage);
    }
}
