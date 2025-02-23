import java.util.*;
 
class Course{
  private String courseCode,title,description,schedule;
  private int capacity,enrolled;
  
  public Course(String courseCode,String title,String description,String schedule,int capacity){
    this.courseCode=courseCode;
    this.title=title;
    this.description=description;
    this.schedule=schedule;
    this.capacity=capacity;
    this.enrolled=0;
  }

  public String getCourseCode(){
    return courseCode;
  }

  public String getTitle(){
    return title;
  }

  public String getDescription(){
    return description;
  }

  public String getSchedule(){
    return schedule;
  }

  public int getAvailableSlots(){
    return capacity-enrolled;
  }

  public boolean registerStudent(){
    if(enrolled<capacity){
      enrolled++;
      return true;
    }
    return false;
  }

  public void dropStudent(){
    if(enrolled>0){
       enrolled--;
    }
  }

  public void displayCourseInfo(){
    System.out.println(courseCode+"-"+title+"("+schedule+")");
    System.out.println("Description:"+description);
    System.out.println("Available Slots:"+getAvailableSlots()+"/"+capacity);

    System.out.println("-----------------------------"); 
  }
}

class Student{
  private String studentID,name;
  private List<Course>registeredCourses;

  public Student(String studentID,String name){
    this.studentID=studentID;
    this.name=name;
    this.registeredCourses=new ArrayList<>();
  }

  public String getStudentID(){
    return studentID;
  }

  public String getName(){
    return name;
  }

  public void registerCourse(Course course){
   if(!registeredCourses.contains(course)){
     if(course.registerStudent()){
       registeredCourses.add(course);
       System.out.println("Successfully registered for"+course.getTitle());
     }else{
       System.out.println("Course is full.Cannot register.");
     }
    }else{
      System.out.println("Already registered for this course.");
   }
  }

  public void dropCourse(Course course){
    if(registeredCourses.remove(course)){
       course.dropStudent();
       System.out.println("Successfully dropped"+course.getTitle());
    }else{
       System.out.println("You are not registered for this course.");
    }
  }

  public void displayRegisteredCourses(){
    System.out.println("\n"+name+"s Registered Courses.");
    if(registeredCourses.isEmpty()){
       System.out.println("No courses registered.");
    }else{
      for(Course c:registeredCourses){
        System.out.println(c.getCourseCode()+"-"+c.getTitle());
      }
     }
    }
  }

  public class CourseRegistrationSystem{
    public static void main(String[]args){
      Scanner scanner=new Scanner(System.in);

      List<Course>courses=new ArrayList<>();
      courses.add(new Course("CS101","Java Programming","Introduction to Internet of Things","Mon-Wed 10AM",2));
      courses.add(new Course("CS102","Data Structures","Learn about arrays,lists,stacks","Tue-Thu 2PM",3));
      courses.add(new Course("CS103","Databases","Introduction to SQL","Fri 11AM",2));

     System.out.print("Enter Student ID:");
     String studentID=scanner.nextLine();
     System.out.print("Enter Student Name:");
     String name=scanner.nextLine();
     Student student=new Student(studentID,name);

     int choice;
     do{
       System.out.println("\n===Course Registration System===");
       System.out.println("1.View Available Courses");
       System.out.println("2.Register for a Course");
       System.out.println("3.Drop a Course");
       System.out.println("4.View Registered Courses");
       System.out.println("5.Exit");
       System.out.println("Enter your choice:");
       choice=scanner.nextInt();

       switch(choice){
         case 1:
           System.out.println("\nAvailable Courses:");
           for(Course course:courses){
             course.displayCourseInfo();
           }
           break;
         case 2:
           System.out.print("Enter Course Code to Register:");
           String regCode=scanner.next();
           Course selectedCourse=findCourse(courses,regCode);
           if(selectedCourse!=null){
              student.registerCourse(selectedCourse);
           }else{
              System.out.println("Invalid Course Code.");
           }
           break;
         case 3:
           System.out.print("Enter Course Code to Drop:");
           String dropCode=scanner.next();
           Course dropCourse=findCourse(courses,dropCode);
           if(dropCourse!=null){
             student.dropCourse(dropCourse);
           }else{
             System.out.println("Invalid Course Code.");
           }
           break;
         case 4:
           student.displayRegisteredCourses();
           break;
         case 5:
           System.out.println("Exiting...Thank you!");
           break;
         default:
           System.out.println("Invalid choice!Try again.");
       }
      }while(choice!=5);
      scanner.close();
  }
  private static Course findCourse(List<Course>courses,String code){
    for(Course c:courses){
      if(c.getCourseCode().equalsIgnoreCase(code)){
         return c;
      }
    }
    return null;
  }
}   


  