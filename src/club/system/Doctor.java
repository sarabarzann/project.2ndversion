
package club.system;
import java.time.LocalDate;
public class Doctor extends Staff {
 
    private String specialization;
    private int patientsCaredFor;
  public Doctor() {
        super();
    }

    public Doctor(String specialization, int patientsCaredFor, LocalDate hireDate, double salary, double baseSalary, int workHours, int memberId, String name, String mobileNo, String gender) {
        super(hireDate, salary, baseSalary, workHours, memberId, name, mobileNo, gender);
        this.specialization = specialization;
        this.patientsCaredFor = patientsCaredFor;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getPatientsCaredFor() {
        return patientsCaredFor;
    }

    public void setPatientsCaredFor(int patientsCaredFor) {
        this.patientsCaredFor = patientsCaredFor;
    }

    @Override
    public double calculateSalary() {
        
        return calculateSalary() + (patientsCaredFor * 50);
    }
}

