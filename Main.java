import java.util.Scanner;
public class Main
{
  public static void main(String[] args) {
    Scanner Read=new Scanner(System.in);
    studentList Students=new studentList();
    Students.createList();
    int x;
    int no;
     while (true){
        System.out.println("-----------------------------------------------------------");
        System.out.println("1-Insert Student");
        System.out.println("2-Retrieve Student");
        System.out.println("3-Modify Student");
        System.out.println("4-Delete Student");
        System.out.println("5-Insert Result");
        System.out.println("6-Print Students");
        System.out.println("7-Print Student Results");
        System.out.println("8-Exit");
        System.out.print("==>");
        x=Read.nextInt();
        System.out.println("-----------------------------------------------------------");
          switch (x){
             
              case 1:                          //insert student
                System.out.println("Enter Student number==>");
                no=Read.nextInt();
                Students.InsertStudent(no);
              break;
              
              case 2:                         //retrieve student
                System.out.println("Enter Student number==>");
                no=Read.nextInt();
                Students.RetrieveStudent(no);
              break;
              
              case 3:                         //modify student
                System.out.println("Enter Student number==>");
                no=Read.nextInt();
                Students.ModifyStudent(no);
              break;
              
              case 4:                         //delete student
                System.out.println("Enter Student number==>");   
                no=Read.nextInt();
                Students.DeleteStudent(no);
              break;
              
              case 5:                         //insert result
                System.out.println("Enter Student number==>");
                no=Read.nextInt();
                Students.InsertResult(no);
              break;
              
              case 6:                        //print students
               if(Students.Emptylist()==true)
                 System.out.println("no students in this list");
               else
                 Students.PrintStudents();
              break;
              
              case 7:                      //print student Results
               System.out.println("Enter Student number==>");
               no=Read.nextInt();
               Students.PrintResults(no);
              break;
              
              case 8:                      //exit
               System.exit(0);
              break;
              
              default:
                System.out.println("Out of range,try again");
              break;
          }
     }

  }
}
