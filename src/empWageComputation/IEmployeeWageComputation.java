package empWageComputation;

public interface IEmployeeWageComputation {
	void addCompanyEmpWage(String company, int wagePerHour, int maxWorkingDays, int maxWorkingHours);
    void computeEmployeeWage();
}
