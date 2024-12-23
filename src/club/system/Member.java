
package club.system;
import java.util.Scanner;
public class Member {

  private int memberId;
  private String name;
  private String mobileNo;
  private String gender;
  
   public Member() {}
  public Member(int memberId, String name, String mobileNo, String gender) {
    this.setMemberId(memberId);
    this.setName(name);
    this.setMobileNo(mobileNo);
    this.setGender(gender);
  }
         
  public int getMemberId() {
    return memberId;
  }

  
  public void setMemberId(int memberId) {
    this.memberId = memberId;
  }

  

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  
  public String getMobileNo() {
    return mobileNo;
  }

  
  public void setMobileNo(String mobileNo) {
    this.mobileNo = mobileNo;
  }

  public String getGender() {
    return gender;
  }
  
  public void setGender(String gender) {
    this.gender = gender;
  }
  
       
    public void input( ) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Member ID:");
    int memberId = scanner.nextInt();
    this.setMemberId(memberId);
    System.out.println("Name:");
    String name = scanner.next();
    this.setName(name); 
    System.out.println("Phone number:");
    String mobileNo = scanner.next();
    this.setMobileNo(mobileNo); 
    System.out.println("Gender:");
    String gender = scanner.next();
    this.setGender(gender); 
}
  public String toString() {
    return String.format("---------------------\nMember Id: %-10s\nName: %-9s\nMobile number: %-15s\nGender: %-7s\n", memberId, name, mobileNo, gender);
  }
}

