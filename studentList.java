import java.util.Scanner;
public class studentList {
    private Snode list;
    private Snode location;
    private Snode predloc;
    Scanner Read=new Scanner(System.in);
  
  public void createList()
  {   list=null;
  }

  public void DestroyList()
  {   list=null;
  }

  public boolean Emptylist(){
    if(list==null)  
       return true;
    else
       return false; 
  }

  public void FindStudent(int key){
    location =list;
    predloc=null;
       while(location!=null){
            if (location.no== key) 
                    break;
            else{
                if(location.no> key) 
                  location=null;
                else
                { 
                  predloc=location;
                  location=location.Snext;
                }
           }
     } 
  }
 
  public void InsertStudent(int Key){
    Snode ptr;
    FindStudent(Key);
        if(location!=null)
            System.out.println("this Element is found");
        else
              { 
                ptr=new Snode();
                ptr.no=Key;
                System.out.println("Enter Student name==>");
                ptr.name=Read.next();
                System.out.println("Enter Department==>");
                ptr.department=Read.next();
                ptr.units_no=0;
                ptr.Cnext=null;     
                    if (predloc==null)
                    {
                      ptr.Snext=list;
                      list=ptr;
                    }else { 
                      ptr.Snext=predloc.Snext;
                      predloc.Snext=ptr;  
                    }
        } 
  }

  public void PrintStudents(){
     System.out.println("number\tname\tdepartment\tnumber of units");
     System.out.println("---------------------------------------------------------------------------------");
       Snode ptr=list;
         while(ptr!=null){
              System.out.println(ptr.no+"\t\t"+ptr.name+"\t\t"+ptr.department+"\t\t"+ptr.units_no);
              ptr=ptr.Snext;
         }
  }

  public void DeleteStudent(int Key){
     FindStudent(Key);
         if(location==null)                                      //element not found
                System.out.println("this Element Is Not Found");
         else {                                                  //element found
          if(location.Cnext==null)                 //checks if student has classess
               {
                if(predloc==null)                //delete student
                        list=location.Snext;
                else
                        predloc.Snext=location.Snext;
                System.out.println("student has been deleted");
               }
               else{
                System.out.println("This student cannot be deleted because he has results");  
               }
        }
  }

  public void RetrieveStudent(int Key){
    FindStudent(Key);
        if(location==null)
             System.out.println("Student not found");
        else
             System.out.println(location.no+"\t"+location.name+"\t"+location.department+"\t"+location.units_no);
  }
                 
  public void ModifyStudent(int Key){
    FindStudent(Key);
     if(location==null)
         System.out.println("This Element Is Not Found");
      else
     { 
      int x;
      do
      {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("what do you wish to modify");
        System.out.println("1-Student name");
        System.out.println("2-Student Department");
        System.out.println("3-number of units(incase of mixup)");
        System.out.println("4-go back");
        System.out.print("==>");
        x=Read.nextInt();
        System.out.println("---------------------------------------------------------------------");
        switch(x){
            case 1:                                      //modify name
              System.out.println("Enter new name==>");
              location.name=Read.next();
              RetrieveStudent(location.no);
            break;
            
            case 2:                                       //modify department
              System.out.println("Enter new Department==>");
              location.department=Read.next();
              RetrieveStudent(location.no);
            break;
            
            case 3:                                      //modify number of units
              System.out.println("Enter new number of units==>");
              location.units_no=Read.nextInt();
              RetrieveStudent(location.no);
            break;
            
            case 4:                                     //go back to main switch
            System.out.println("back");
            break;
            
            default:
            System.out.println("Out of range,try again");
            break;
            
        }
     }while(x!=4);

    }
  }
 
  void InsertResult(int key){
    FindStudent(key);
     if(location==null)        
         System.out.println("Student not found");
     else{                                         //student found                       
         if(IsGraduate(location)==true)            //testing number of units
           System.out.print("Student is graduate, therefore cannot add result");
         else{
           System.out.print("Enter result==>");
             double result=Read.nextDouble();
           if(result>=0 && result<=100)
          { 
             Cnode C=new Cnode();  
             C.result=result;
             System.out.print("enter number of class==>");
             C.no=Read.nextInt();
               if(C.result>=50)
                 location.units_no+=C.units;
           //attach node
           C.next=location.Cnext;
           location.Cnext=C;
        }
         }
    }
  }

  boolean IsGraduate(Snode student)
  {
   if(student.units_no>=132)
     return true;
   else
     return false;
  }
  
  void PrintResults(int key)
  {
   FindStudent(key);
     if(location==null)
        System.out.println("Student not found");
     else if(location.Cnext!=null)
     {  RetrieveStudent(key);
        Cnode x=location.Cnext; 
         while(x!=null)
         {
           System.out.println(x.no+"\t"+x.result+"\t"+x.units);
           x=x.next;
         }
     }else{
       System.out.println("this student has no results");  
     }
     
  }
 }
                
                