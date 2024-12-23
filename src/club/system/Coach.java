
package club.system;
import java.util.Scanner;
import java.time.LocalDate;
public class Coach  extends Staff{
    
   private double winBonus;
  private String speciality;
  private double overTime;
    
public Coach (){
        super();
        
}

    public Coach(double winBonus, String speciality, double overTime, LocalDate hireDate, double salary, double baseSalary, int workHours, int memberId, String name, String mobileNo, String gender) {
        super(hireDate, salary, baseSalary, workHours, memberId, name, mobileNo, gender);
        this.winBonus = winBonus;
        this.speciality = speciality;
        this.overTime = overTime;
    }

    public double getWinBonus() {
        return winBonus;
    }

    public void setWinBonus(double winBonus) {
        this.winBonus = winBonus;
    }

  public String getSpecialty() {
    return speciality;
  }
  
  public void setSpecialty(String specialty) {
    this.speciality = specialty;
  }
  
  public double getOverTime() {
    return overTime;
  }
  
  public void setOverTime(double overTime) {
    this.overTime = overTime;
  }
        @Override
  public void input(){
            super.input();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Whats your speciality? ");
            String speciality=scanner.next();
            this.setSpecialty(speciality);
            System.out.println("How many hours did you work overtime?");
            int overtime=scanner.nextInt();
            this.setOverTime(overTime);
            
        }
    @Override
    public double calculateSalary() {
        
        return calculateSalary() + winBonus;
    }
  
  @Override
  public String toString() {
    return String.format("\n%-10sMember type: Coach\nSpecialty: %-21sOvertime: %-10s", super.toString(), speciality, overTime);
  }

}

