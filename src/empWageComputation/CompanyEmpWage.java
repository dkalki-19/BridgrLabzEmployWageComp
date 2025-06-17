package empWageComputation;

public class CompanyEmpWage {
    public final String company;
    public final int wagePerHour;
    public final int maxWorkingDays;
    public final int maxWorkingHours;
    public int totalWage;

    public CompanyEmpWage(String company, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
        this.company = company;
        this.wagePerHour = wagePerHour;
        this.maxWorkingDays = maxWorkingDays;
        this.maxWorkingHours = maxWorkingHours;
        this.totalWage = 0;
    }

    public void setTotalWage(int totalWage) {
        this.totalWage = totalWage;
    }

    @Override
    public String toString() {
        return "Total Wage for Company " + company + " is ₹" + totalWage;
    }
}
