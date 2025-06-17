package empWageComputation;

import java.util.Random;

public class EmployeeWageMain {

    // Constants
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;

    // Method with parameters
    public static void computeEmployeeWage(String company, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
        int totalWorkingDays = 0;
        int totalEmpHours = 0;
        int totalWage = 0;
        Random random = new Random();

        while (totalWorkingDays < maxWorkingDays && totalEmpHours < maxWorkingHours) {
            totalWorkingDays++;

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

            // Ensure not exceeding max hours
            if (totalEmpHours + empHours > maxWorkingHours) {
                empHours = maxWorkingHours - totalEmpHours;
            }

            totalEmpHours += empHours;
            int dailyWage = empHours * wagePerHour;
            totalWage += dailyWage;

            System.out.println(company + " - Day " + totalWorkingDays + ": Hours = " + empHours + ", Daily Wage = ₹" + dailyWage);
        }

        System.out.println(company + " - Total Working Days: " + totalWorkingDays);
        System.out.println(company + " - Total Hours Worked: " + totalEmpHours);
        System.out.println(company + " - Total Monthly Wage: ₹" + totalWage);
        System.out.println("---------------------------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program on Master Branch\n");

        // UC8: Compute for multiple companies
        computeEmployeeWage("TCS", 20, 20, 100);
        computeEmployeeWage("Infosys", 25, 22, 120);
        computeEmployeeWage("Wipro", 18, 24, 90);
    }
}

