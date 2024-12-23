
package club.system;
    import java.time.LocalDate;
import java.util.Scanner;
public class Administrator extends Staff{

    private int projectsManaged;
    private String jobTitle;

    public Administrator() {
        super();
    }

    public Administrator(int projectsManaged, String jobTitle, LocalDate hireDate, double salary, double baseSalary, int workHours, int memberId, String name, String mobileNo, String gender) {
        super(hireDate, salary, baseSalary, workHours, memberId, name, mobileNo, gender);
        this.projectsManaged = projectsManaged;
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getProjectsManaged() {
        return projectsManaged;
    }

    public void setProjectsManaged(int projectsManaged) {
        this.projectsManaged = projectsManaged;
    }

    @Override
    public void input() {
        super.input(); 
        Scanner scanner = new Scanner(System.in);
        System.out.println("What's your job title? ");
        this.jobTitle = scanner.nextLine();
    }

    @Override
   public double calculateSalary() {
        
        return getBaseSalary() + (projectsManaged * 200);
    }

    
    @Override
    public String toString() {
        return String.format(
            "%s\nMember Type: Administrator\nAdministrator Job Title: %s",
            super.toString(), jobTitle
        );
    }
}

