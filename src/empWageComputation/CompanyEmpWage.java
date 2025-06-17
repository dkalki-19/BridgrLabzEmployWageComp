package empWageComputation;

import java.util.ArrayList;

public class CompanyEmpWage {
	 public final String company;
	    public final int wagePerHour;
	    public final int maxWorkingDays;
	    public final int maxWorkingHours;
	    public int totalWage;
	    public ArrayList<Integer> dailyWages;

	    public CompanyEmpWage(String company, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
	        this.company = company;
	        this.wagePerHour = wagePerHour;
	        this.maxWorkingDays = maxWorkingDays;
	        this.maxWorkingHours = maxWorkingHours;
	        this.dailyWages = new ArrayList<>();
	    }

	    public void setTotalWage(int totalWage) {
	        this.totalWage = totalWage;
	    }

	    @Override
	    public String toString() {
	        return "Company: " + company +
	               "\nTotal Wage: ₹" + totalWage +
	               "\nDaily Wages: " + dailyWages + "\n";
	    }

}
