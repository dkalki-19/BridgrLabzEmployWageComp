package empWageComputation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;



public class EmployeeWageMain implements IEmployeeWageComputation{

	public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;

    private final List<CompanyEmpWage> companyList;
    private final Map<String, CompanyEmpWage> companyToEmpWageMap;

    public EmployeeWageMain() {
        companyList = new ArrayList<>();
        companyToEmpWageMap = new HashMap<>();
    }

    @Override
    public void addCompanyEmpWage(String company, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
        CompanyEmpWage companyEmpWage = new CompanyEmpWage(company, wagePerHour, maxWorkingDays, maxWorkingHours);
        companyList.add(companyEmpWage);
        companyToEmpWageMap.put(company, companyEmpWage);
    }

    @Override
    public void computeEmployeeWage() {
        for (CompanyEmpWage company : companyList) {
            int totalWage = computeWage(company);
            company.setTotalWage(totalWage);
            System.out.println(company);
        }
    }

    private int computeWage(CompanyEmpWage company) {
        int totalHours = 0;
        int totalDays = 0;
        int totalWage = 0;
        Random random = new Random();

        while (totalDays < company.maxWorkingDays && totalHours < company.maxWorkingHours) {
            totalDays++;
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

            if (totalHours + empHours > company.maxWorkingHours) {
                empHours = company.maxWorkingHours - totalHours;
            }

            totalHours += empHours;
            int dailyWage = empHours * company.wagePerHour;
            company.dailyWages.add(dailyWage);
            totalWage += dailyWage;
        }

        return totalWage;
    }

    @Override
    public int getTotalWage(String company) {
        if (companyToEmpWageMap.containsKey(company)) {
            return companyToEmpWageMap.get(company).totalWage;
        } else {
            System.out.println("Company not found!");
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program on Master Branch\n");

        IEmployeeWageComputation empWageBuilder = new EmployeeWageMain();
        empWageBuilder.addCompanyEmpWage("TCS", 20, 20, 100);
        empWageBuilder.addCompanyEmpWage("Infosys", 25, 22, 120);
        empWageBuilder.addCompanyEmpWage("Wipro", 18, 24, 90);

        empWageBuilder.computeEmployeeWage();

        // UC14: Query total wage by company
        System.out.println("Queried Wage for Infosys: ₹" + empWageBuilder.getTotalWage("Infosys"));
        System.out.println("Queried Wage for Wipro: ₹" + empWageBuilder.getTotalWage("Wipro"));
    }

}


