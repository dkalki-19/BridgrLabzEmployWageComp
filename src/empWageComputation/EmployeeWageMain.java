package empWageComputation;

import java.util.Random;



public class EmployeeWageMain {

    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;

    private CompanyEmpWage[] companyEmpWageArray;
    private int numOfCompanies = 0;

    public EmployeeWageMain() {
        companyEmpWageArray = new CompanyEmpWage[5]; // Can hold 5 companies initially
    }

    public void addCompanyEmpWage(String company, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
        companyEmpWageArray[numOfCompanies++] = new CompanyEmpWage(company, wagePerHour, maxWorkingDays, maxWorkingHours);
    }

    public void computeEmployeeWage() {
        for (int i = 0; i < numOfCompanies; i++) {
            CompanyEmpWage company = companyEmpWageArray[i];
            int totalWage = this.computeWage(company);
            company.setTotalWage(totalWage);
            System.out.println(company);
        }
    }

    private int computeWage(CompanyEmpWage company) {
        int totalEmpHours = 0;
        int totalWorkingDays = 0;
        int totalWage = 0;
        Random random = new Random();

        while (totalWorkingDays < company.maxWorkingDays && totalEmpHours < company.maxWorkingHours) {
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

            if (totalEmpHours + empHours > company.maxWorkingHours) {
                empHours = company.maxWorkingHours - totalEmpHours;
            }

            totalEmpHours += empHours;
            int dailyWage = empHours * company.wagePerHour;
            totalWage += dailyWage;

            System.out.println(company.company + " - Day " + totalWorkingDays + ": Hours = " + empHours + ", Daily Wage = ₹" + dailyWage);
        }

        return totalWage;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program on Master Branch\n");

        EmployeeWageMain empWageBuilder = new EmployeeWageMain();
        empWageBuilder.addCompanyEmpWage("TCS", 20, 20, 100);
        empWageBuilder.addCompanyEmpWage("Infosys", 25, 22, 120);
        empWageBuilder.addCompanyEmpWage("Wipro", 18, 24, 90);

        empWageBuilder.computeEmployeeWage();
    }
}


