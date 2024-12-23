
package club.system;
 import java.util.ArrayList;
public abstract class  Accountants extends Staff {

    private ArrayList<Staff> staffList; 

  
    public Accountants() {
        this.staffList = new ArrayList<>(); 
    }

    public void addStaff(Staff staff) {
        staffList.add(staff);
        System.out.println("Staff added: " + staff.getProfile());
    }

  
    
    public abstract double calculateSalary();
       public double calculateTotalSalary() {
        double total = 0;
        for (Staff staff : staffList) {
            total += staff.calculateSalary();
        }
        return total;
    }
}


    public void generatePayroll() {
        System.out.println("Payroll for this month:");
        for (Staff staff : staffList) {
            System.out.printf("Name: %s | Role: %s | Salary: %.2f%n",
                    staff.getProfile().split("\n")[1].split(": ")[1], 
                    staff.getProfile().split("\n")[2].split(": ")[1],
                    staff.calculateSalary());
  
} 

