package empWageComputation;

import java.util.Random;

public class EmployeeWageMain {

    // Constants
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;
    public static final int WAGE_PER_HOUR = 20;
    public static final int MAX_WORKING_DAYS = 20;
    public static final int MAX_WORKING_HOURS = 100;

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program on Master Branch");

        int totalWorkingDays = 0;
        int totalEmpHours = 0;
        int totalWage = 0;

        Random random = new Random();

        while (totalWorkingDays < MAX_WORKING_DAYS && totalEmpHours < MAX_WORKING_HOURS) {
            totalWorkingDays++;

            int empHours = 0;
            int empCheck = random.nextInt(3); // 0, 1, or 2

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

            // Ensure hours don't exceed max
            if (totalEmpHours + empHours > MAX_WORKING_HOURS) {
                empHours = MAX_WORKING_HOURS - totalEmpHours;
            }

            totalEmpHours += empHours;
            int dailyWage = empHours * WAGE_PER_HOUR;
            totalWage += dailyWage;

            System.out.println("Day " + totalWorkingDays + ": Hours Worked = " + empHours + ", Daily Wage = ₹" + dailyWage);
        }

        System.out.println("\nTotal Working Days: " + totalWorkingDays);
        System.out.println("Total Hours Worked: " + totalEmpHours);
        System.out.println("Total Wage for the Month: ₹" + totalWage);
    }
}

