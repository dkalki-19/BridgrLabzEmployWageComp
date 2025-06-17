package empWageComputation;

import java.util.Random;

public class EmployeeWageMain {


    // Constants
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;

    // Instance variables
    private final String company;
    private final int wagePerHour;
    private final int maxWorkingDays;
    private final int maxWorkingHours;
    private int totalWage;

    // Constructor
    public EmployeeWageMain(String company, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
        this.company = company;
        this.wagePerHour = wagePerHour;
        this.maxWorkingDays = maxWorkingDays;
        this.maxWorkingHours = maxWorkingHours;
    }

    // Method to compute employee wage
    public void computeEmployeeWage() {
        int totalEmpHours = 0;
        int totalWorkingDays = 0;
        totalWage = 0;

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

            if (totalEmpHours + empHours > maxWorkingHours) {
                empHours = maxWorkingHours - totalEmpHours;
            }

            totalEmpHours += empHours;
            int dailyWage = empHours * wagePerHour;
            totalWage += dailyWage;

            System.out.println(company + " - Day " + totalWorkingDays + ": Hours = " + empHours + ", Daily Wage = ₹" + dailyWage);
        }

        System.out.println(company + " - Total Wage for the Month: ₹" + totalWage);
        System.out.println("------------------------------------------------------------");
    }

    public int getTotalWage() {
        return totalWage;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program on Master Branch\n");

        EmployeeWageMain tcs = new EmployeeWageMain("TCS", 20, 20, 100);
        tcs.computeEmployeeWage();

        EmployeeWageMain infosys = new EmployeeWageMain("Infosys", 25, 22, 120);
        infosys.computeEmployeeWage();

        EmployeeWageMain wipro = new EmployeeWageMain("Wipro", 18, 24, 90);
        wipro.computeEmployeeWage();

        // Optional: Display total wage per company
        System.out.println("TCS Total Wage: ₹" + tcs.getTotalWage());
        System.out.println("Infosys Total Wage: ₹" + infosys.getTotalWage());
        System.out.println("Wipro Total Wage: ₹" + wipro.getTotalWage());
    }

}

