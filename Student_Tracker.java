/*Develop a program that allows a teacher to enter
students' grades and compute their average,
highest, and lowest scores. You can use arrays or
ArrayLists to store the student data. */


import java.util.*;

/* This below class is made for Science Stream Student and it contains many methods. */

class Students_Science{

    Scanner sc = new Scanner(System.in);
    String choice;      // global variable is created.
    private ArrayList<String> S_Name = new ArrayList<>();
    private ArrayList<String> S_Grades = new ArrayList<>();
    private ArrayList<Integer> English_Marks= new ArrayList<>();
    private ArrayList<Integer> Physics_Marks= new ArrayList<>();
    private ArrayList<Integer> Chemistry_Marks= new ArrayList<>();
    private ArrayList<Integer> Biology_Marks= new ArrayList<>();
    private ArrayList<Integer> Maths_Marks= new ArrayList<>();
    
     /*This below function is called in all the other methods to check the conditions as given by the user input. */
        boolean checkCondition(String choice){
            if(choice.equalsIgnoreCase("yes")|| choice.equalsIgnoreCase("y")|| choice.equalsIgnoreCase("yep")) {
                return true;
            }
            else{
                return false;
            }
        }
  
        /*This below function is used to add the students details in the database. */
        private void addStudent(String name, String grade,int Eng_marks,int  Phy_marks,int Chem_marks,int Bio_marks,int Math_marks){

        this.S_Name.add(name);
        this.S_Grades.add(grade);
        this.English_Marks.add(Eng_marks);
        this.Physics_Marks.add(Phy_marks);
        this.Chemistry_Marks.add(Chem_marks);
        this.Biology_Marks.add(Bio_marks);
        this.Maths_Marks.add(Math_marks);
}

 /*The below function is called when the mrks is being updated. */
private void updateStudent(String name, int correctMarks, String subject) {
    for(int i = 0; i < S_Name.size(); i++){
        if (S_Name.get(i).equals(name)) {
            if (subject.equalsIgnoreCase("English_marks")) {
                English_Marks.set(i, correctMarks);
            } else if (subject.equalsIgnoreCase("Physics_marks")) {
                Physics_Marks.set(i, correctMarks);
            } else if (subject.equalsIgnoreCase("Chemistry_marks")) {
                Chemistry_Marks.set(i, correctMarks);
            } else if (subject.equalsIgnoreCase("Biology_marks")) {
                Biology_Marks.set(i, correctMarks);
            } else if (subject.equalsIgnoreCase("Maths_Marks")) {
                Maths_Marks.set(i, correctMarks);
            } 
            int englishMark = English_Marks.get(i);
            int Phy_mark = Physics_Marks.get(i);
            int Chem_mark = Chemistry_Marks.get(i);
            int Bio_mark = Biology_Marks.get(i);
            int mathsMark = Maths_Marks.get(i);
            String grade = getGrade(englishMark, Phy_mark, Chem_mark, Bio_mark, mathsMark);
            S_Grades.set(i, grade);
           
            break;
        }
    }
}
      
 /*This below function is used to update names or marks */
private void updateMarksOrNamesScience(){
    String correct_name,Wrong_Name;
                System.out.println("\nTo update names, Please either write  yes or no.");
                choice= sc.next();
                if (checkCondition(choice)) {
                    System.out.println("\nEnter the Wrong name of the student you want to correct");
                    sc.nextLine();
                     Wrong_Name = sc.nextLine();
                    System.out.println("\nEnter the correct Name");
                     correct_name = sc.nextLine();
                   
                    for(int i =0;i<S_Name.size();i++){
                     
                        if(S_Name.get(i).equals(Wrong_Name)){
                                S_Name.set(i,correct_name);   
                        }

                       
                    }
                   
                }
                else{
                System.out.println("\nDo you want to correct Marks.");
                System.out.println("Write only in yes or no");
                 choice = sc.next();
               
                if (checkCondition(choice)) {
                    System.out.println("\nEnter the Full Name of the student you want to do it for.");
                    sc.nextLine();
                    String name = sc.nextLine();
                    
                    for(int i=0;i<S_Name.size();i++){
                        if(S_Name.get(i).equalsIgnoreCase(name)){
                        System.out.println("\nEnter the subject name you want to correct with underscores. For EX - Maths_marks");
                        String sub = sc.next();
                        System.out.println("\nEnter the Correct Marks");
                        int Correct_Marks = sc.nextInt();

                        if(sub.equalsIgnoreCase("English_marks") ){
                           English_Marks.set(i, Correct_Marks);
                           updateStudent(name, Correct_Marks, sub);
                           break;
                        }
                       else if(sub.equalsIgnoreCase("Physics_marks") ){
                           Physics_Marks.set(i, Correct_Marks);
                            updateStudent(name, Correct_Marks, sub);
                           break;
                        }
                       else if(sub.equalsIgnoreCase("Chemistry_marks") ){
                           Chemistry_Marks.set(i, Correct_Marks);
                            updateStudent(name, Correct_Marks, sub);
                           break;
                        }
                      else  if(sub.equalsIgnoreCase("Biology_marks") ){
                           Biology_Marks.set(i, Correct_Marks);
                            updateStudent(name, Correct_Marks, sub);
                           break;
                        }
                       else if(sub.equalsIgnoreCase("Maths_marks") ){
                           Maths_Marks.set(i, Correct_Marks);
                            updateStudent(name, Correct_Marks, sub);
                           break;
                        }
                        String Grade = getGrade(English_Marks.get(i),Physics_Marks.get(i),Chemistry_Marks.get(i),Biology_Marks.get(i),Maths_Marks.get(i));
           
                        addStudent(name, Grade, English_Marks.get(i),Physics_Marks.get(i),Chemistry_Marks.get(i),Biology_Marks.get(i),Maths_Marks.get(i));
                    }
                   
                    }
                }
            }
            display();
        }

         /*This below function is used to remove the record of the students data from the database. */
        private void removeStudent(String name){
            
            for (int i = S_Name.size()-1; i >=0; i--) {
                if (S_Name.get(i).equalsIgnoreCase(name)) {
                    S_Name.remove(i);
                    S_Grades.remove(i);
                    English_Marks.remove(i);
                    Physics_Marks.remove(i);
                    Chemistry_Marks.remove(i);
                    Biology_Marks.remove(i);
                    Maths_Marks.remove(i);
                    
                    break;
                }
            }
            System.out.printf("\n%-20s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s  %n", "Students_Name", "Grade", "English_Marks", "Physics_Marks", "Chemistry_Marks", "Biology_Marks","Maths_Marks");

            for(int i = 0; i < S_Name.size(); i++){
                System.out.printf("\n%-20s | %-10s | %-13s | %-15s | %-13s | %-15s | %-15s  %n", S_Name.get(i), S_Grades.get(i), English_Marks.get(i), Physics_Marks.get(i), Chemistry_Marks.get(i), Biology_Marks.get(i), Maths_Marks.get(i));
            }
        }

         /*This below function is used to free the space of the database. */
public void freespace(){
    System.out.println();
    System.out.println("\nPlease write yes if you want to update Marks or Names.");
     choice = sc.next();
    if(checkCondition(choice)){
        updateMarksOrNamesScience();
    }
    else{
        System.out.println("\nPlease write yes if  you want to clear the list. ");
        System.out.println("Answer only in yes or no.");
         choice = sc.next();
        if(checkCondition(choice)){
            System.out.println("\nPlease write yes if you want to clear the list.");
            choice= sc.next();
            if(checkCondition(choice)){
                System.out.println("\nEnter the name of the student you want to remove. ");
                sc.nextLine();
                String name1 = sc.nextLine();
                removeStudent(name1);
            }
            else{
            for(int i =0;i<English_Marks.size();i++){
                S_Name.clear();
                English_Marks.clear();
                Physics_Marks.clear();
                Chemistry_Marks.clear();
                Biology_Marks.clear();
                Maths_Marks.clear();
            }
            if(S_Name.isEmpty() && English_Marks.isEmpty()&& Physics_Marks.isEmpty()&& Chemistry_Marks.isEmpty() && Biology_Marks.isEmpty() && Maths_Marks.isEmpty()){
                System.out.println("\nThe data has been cleared...\n");
                
                }
                System.out.printf("\n%-20s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s  %n", "Students_Name", "Grade", "English_Marks", "Physics_Marks", "Chemistry_Marks", "Biology_Marks","Maths_Marks");

                for(int i = 0; i < S_Name.size(); i++){
                    System.out.printf("\n%-20s | %-10s | %-13s | %-15s | %-13s | %-15s | %-15s  %n", S_Name.get(i), S_Grades.get(i), English_Marks.get(i), Physics_Marks.get(i), Chemistry_Marks.get(i), Biology_Marks.get(i), Maths_Marks.get(i));
                }   
                System.out.println();
        }
    }
        else{
            while (true) {
                System.out.println("\nPlease write yes if want to continue.");
           choice= sc.next();
           if(checkCondition(choice)){
            break;
        }
        else{
            break;
        }
            
            }
        }
    }
        
        }
  
         /*This below function calculates the total scores scored by the students and which student perform the best and lowest.*/
        private void Calculate_Scores(){
         
        int Highest_Marks = Integer.MIN_VALUE;
        int Lowest_Marks = Integer.MAX_VALUE;
        String Highest_Student_Name= "";
        String Lowest_Student_Name= "";
        for (int i = 0; i < English_Marks.size(); i++) {
            
                   int sum= English_Marks.get(i)+Physics_Marks.get(i)+ Chemistry_Marks.get(i)+Biology_Marks.get(i)+Maths_Marks.get(i);
                   double average = (double) sum / 5;

                   if(sum>Highest_Marks){
                    Highest_Marks=sum;
                    Highest_Student_Name=S_Name.get(i);
                }
                 if(sum<Lowest_Marks){
                    Lowest_Marks=sum;
                    Lowest_Student_Name=S_Name.get(i);
                }
                System.out.println();
                    System.out.println("\nSum of Marks of all Subjects : " + S_Name.get(i) + " is " + sum);
                System.out.println("\nAverage of Marks of all Subjects : " + S_Name.get(i) + " is " + average);

                System.out.println();
                }
                System.out.println("\nHighest marks: " + Highest_Marks + " is scored by " + Highest_Student_Name);
                System.out.println("\nLowest marks: " + Lowest_Marks + " is scored by " + Lowest_Student_Name);
             freespace();
    }

/*This below function is used to display the data of the Science Streams students. */
    public void display(){
        System.out.printf("\n%-20s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s %n", "Students_Name", "Grade", "English_Marks", "Physics_Marks", "Chemistry_Marks", "Biology_Marks", "Maths_Marks");

            for(int i = 0; i < S_Name.size(); i++){

         System.out.printf("\n%-20s | %-10s | %-13s | %-13s | %-15s | %-13s | %-10s %n", S_Name.get(i), S_Grades.get(i), English_Marks.get(i), Physics_Marks.get(i), Chemistry_Marks.get(i), Biology_Marks.get(i), Maths_Marks.get(i));
}
        System.out.println();
        if(S_Name.isEmpty() && English_Marks.isEmpty()&& Physics_Marks.isEmpty()&& Chemistry_Marks.isEmpty() && Biology_Marks.isEmpty() && Maths_Marks.isEmpty()){
            System.out.println("\nThe list is Empty. Please Enter Some Input");
            process();
        }
        Calculate_Scores();
    }

    /*This below function is used to record all the data for students. */
    public void process(){
        while(true){
            int  marks_1, marks_2, marks_3, marks_4, marks_5;
        System.out.println("\nEnter the name of the student:");
        String name = sc.nextLine();
       
        System.out.println("\nEnter the English Marks of the student:");
         marks_1 = sc.nextInt();
        System.out.println("\nEnter the Physics Marks of the student:");
         marks_2 = sc.nextInt();
        System.out.println("\nEnter the Chemistry Marks of the student:");
         marks_3 = sc.nextInt();
        System.out.println("\nEnter the Biology Marks of the student:");
         marks_4 = sc.nextInt();
        System.out.println("\nEnter the Maths Marks of the student:");
         marks_5 = sc.nextInt();
            sc.nextLine();
         if((marks_1>100 ||  marks_1<0) || (marks_2>100 || marks_2<0) || (marks_3>100 || marks_3<0)|| (marks_4>100 || marks_4<0)||(marks_5>100 || marks_5<0)){

            System.out.println("\nWARNING !");
            System.out.println("The Marks should be between 0 and 100.");
            System.out.println("Please enter the marks again");
            continue;
         }
         else{
            System.out.println("\nThe Grades are between A+ , A , B+ , B , C , D , E , F.");
            String Grade = getGrade(marks_1,marks_2,marks_3,marks_4,marks_5);
           
            addStudent(name, Grade, marks_1,marks_2,marks_3,marks_4,marks_5);
            System.out.println("\nThe Student Data has been Added! Please proceed further to check. ");
            System.out.println("Please write yes if you want to add more students.");
           choice= sc.next();
            sc.nextLine();
            if (checkCondition(choice)) {
               continue;
            }
            else{
                break;
            }
           
         }
        

       
    }  
}
    
 /*This below function is used to get the Grades performed by the student. */
    private String getGrade(int marks_1,int marks_2,int marks_3,int marks_4,int marks_5){

    if( marks_1<=30 || marks_2<=30 || marks_3<=30 ||  marks_4<=30 || marks_5<=30){
        return "F FAIL !";
        
    }
    else{
    int sum = marks_1 + marks_2 + marks_3 + marks_4 + marks_5;
    int average= sum/5;
    if(average>90 &&average<=100){
        return "A+";
    }
    else if(average>80 &&average<=90){
       return "A";
    }
    else if(average>70 &&average<=80){
        return "B+";
    }
    else if(average>60 &&average<=70){
        return "B";
    }
    else if(average>50 &&average<=60){
        return "C";
    }
    else if(average>40 &&average<=50){
        return "D";
    }

    else if(average>30 &&average<=40){
        return "E";
    }
    else if(average>=0 &&average<=30){
        return "F FAIL !";
    }
}
    return "Invalid Grade";
}
}

/* This below class is made for Commerce Stream Student and it contains many methods. */

    class Student_Commerce {
        Scanner sc = new Scanner(System.in);
        String choice;      // global variable is created.

        private ArrayList<String> S_Name = new ArrayList<>();
        private ArrayList<String> S_Grades = new ArrayList<>();
        private ArrayList<Integer> English_Marks= new ArrayList<>();
        private ArrayList<Integer> Accounts_Marks= new ArrayList<>();
        private ArrayList<Integer> Economics_Marks= new ArrayList<>();
        private ArrayList<Integer> Business_Studies_Marks= new ArrayList<>();
        private ArrayList<Integer> Maths_Marks= new ArrayList<>();
        
        /*This below function is called in all the other methods to check the conditions as given by the user input. */
        boolean checkCondition(String choice){
            if(choice.equalsIgnoreCase("yes")|| choice.equalsIgnoreCase("y")|| choice.equalsIgnoreCase("yep")) {
                return true;
            }
            else{
                return false;
            }
        }

        /*This below function is used to add the students details in the database. */
        private void addStudent(String name, String grade,int Eng_marks,int  Account_marks,int Economics_marks,int BST_marks,int Math_marks){
    
            this.S_Name.add(name);
            this.S_Grades.add(grade);
            this.English_Marks.add(Eng_marks);
            this.Accounts_Marks.add(Account_marks);
            this.Economics_Marks.add(Economics_marks);
            this.Business_Studies_Marks.add(BST_marks);
            this.Maths_Marks.add(Math_marks);
    }

    
    /*The below function is called when the mrks is being updated. */
    private void updateStudent(String name, int correctMarks, String subject) {
        for(int i = 0; i < S_Name.size(); i++){
            if (S_Name.get(i).equals(name)) {
                if (subject.equalsIgnoreCase("English_marks")) {
                    English_Marks.set(i, correctMarks);
                } else if (subject.equalsIgnoreCase("Accounts_Marks")) {
                    Accounts_Marks.set(i, correctMarks);
                } else if (subject.equalsIgnoreCase("Economics_Marks")) {
                    Economics_Marks.set(i, correctMarks);
                } else if (subject.equalsIgnoreCase("Business_Studies_Marks")) {
                    Business_Studies_Marks.set(i, correctMarks);
                } else if (subject.equalsIgnoreCase("Maths_Marks")) {
                    Maths_Marks.set(i, correctMarks);
                } 
                int englishMark = English_Marks.get(i);
                int accountsMark = Accounts_Marks.get(i);
                int economicsMark = Economics_Marks.get(i);
                int businessStudiesMark = Business_Studies_Marks.get(i);
                int mathsMark = Maths_Marks.get(i);
                String grade = getGrade(englishMark, accountsMark, economicsMark, businessStudiesMark, mathsMark);
                S_Grades.set(i, grade);
               
                break;
            }
        }
    }
   
    /*This below function is used to update names or marks */
    private void updateMarksOrNamesCommerce(){
        System.out.println("\nPlease write either yes to update names or no for marks.");
        choice= sc.next();
        if (checkCondition(choice)) {
            System.out.println("\nEnter the Wrong name of the student you want to update.");
            sc.nextLine();
            String Wrong_Name = sc.nextLine();
            System.out.println("\nEnter the correct Name");
            String correct_name = sc.nextLine();
            for(int i =0;i<S_Name.size();i++){
               
                if(S_Name.get(i).equalsIgnoreCase(Wrong_Name)){
                        S_Name.set(i,correct_name);
                }
               
            }
        }
            
                else{
                    System.out.println("\nDo you want to correct Marks.");
        System.out.println("\n Please Write only in yes or no");
        choice = sc.next();
       
        if (checkCondition(choice)) {
            System.out.println("\nEnter the Full Name of the student you want to do it for.");
            sc.nextLine();
            String name = sc.nextLine();

            for(int i=0;i<S_Name.size();i++){
                if(S_Name.get(i).equalsIgnoreCase(name)){
                System.out.println("\nEnter the subject name you want to correct with underscores. For EX - Maths_marks");
                String sub = sc.next();
                System.out.println("\nEnter the Correct Marks");
                int Correct_Marks = sc.nextInt();

                if(sub.equalsIgnoreCase("English_marks") ){
                   English_Marks.set(i, Correct_Marks);
                   updateStudent(name, Correct_Marks, sub);
                   break;
                }
               else if(sub.equalsIgnoreCase("Accounts_marks") ){
                   Accounts_Marks.set(i, Correct_Marks);
                    updateStudent(name, Correct_Marks, sub);
                   break;
                }
               else if(sub.equalsIgnoreCase("Economics_marks") ){
                   Economics_Marks.set(i, Correct_Marks);
                    updateStudent(name, Correct_Marks, sub);
                   break;
                }
              else  if(sub.equalsIgnoreCase("Business_Studies_marks") ){
                   Business_Studies_Marks.set(i, Correct_Marks);
                    updateStudent(name, Correct_Marks, sub);
                   break;
                }
               else if(sub.equalsIgnoreCase("Maths_marks") ){
                   Maths_Marks.set(i, Correct_Marks);
                    updateStudent(name, Correct_Marks, sub);
                   break;
                   }

            }
           
            }
                }
                }
                display();
            }
        
            /*This below function is used to remove the record of the students data from the database. */
            private void removeStudent(String name){
            
                for (int i = S_Name.size()-1; i >=0; i--) {
                    if (S_Name.get(i).equalsIgnoreCase(name)) {
                        S_Name.remove(i);
                        S_Grades.remove(i);
                        English_Marks.remove(i);
                        Accounts_Marks.remove(i);
                        Economics_Marks.remove(i);
                        Business_Studies_Marks.remove(i);
                        Maths_Marks.remove(i);
                        
                        break;
                    }
                }
                System.out.printf("\n%-20s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s %n", "Students_Name", "Grade", "English_Marks", "Accounts_Marks", "Economics_Marks", "Business_Studies_Marks", "Maths_Marks");
                for(int i = 0; i < S_Name.size(); i++){
                    System.out.printf("\n%-20s | %-10s | %-13s | %-14s | %-15s | %-22s | %-12s %n", S_Name.get(i), S_Grades.get(i), English_Marks.get(i), Accounts_Marks.get(i), Economics_Marks.get(i), Business_Studies_Marks.get(i), Maths_Marks.get(i));
                }
            }
   
   /*This below function is used to free the space of the database. */
            private void freespace(){
        System.out.println();
        System.out.println("Please write yes if you want to update names or marks, else write no .");
         choice = sc.next();
        if(checkCondition(choice)){
            updateMarksOrNamesCommerce();
        }
        else{
        System.out.println();
            System.out.println("\nPlease write yes if you want to free the space.");
           choice = sc.next();
            if(checkCondition(choice)){
                System.out.println("\nPlease write yes if you want to remove only particular list from the database.");
           choice = sc.next();
            if(checkCondition(choice)){
                System.out.println("\nEnter the name of the student you want to remove. ");
                sc.nextLine();
                String name1 = sc.nextLine();
                removeStudent(name1);
            }
            else{
                for(int i =0;i<English_Marks.size();i++){
                    S_Name.clear();
                    English_Marks.clear();
                    Economics_Marks.clear();
                    Accounts_Marks.clear();
                    Business_Studies_Marks.clear();
                    Maths_Marks.clear();

                }
                if(S_Name.isEmpty() && English_Marks.isEmpty()&& Economics_Marks.isEmpty()&& Business_Studies_Marks.isEmpty() && Accounts_Marks.isEmpty() && Maths_Marks.isEmpty()){
                    System.out.println("The data has been cleared...");
                    System.out.println();
                    }
                    System.out.printf("\n%-20s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s %n", "Students_Name", "Grade", "English_Marks", "Accounts_Marks", "Economics_Marks", "Business_Studies_Marks", "Maths_Marks");
    for(int i = 0; i < S_Name.size(); i++){
        System.out.printf("\n%-20s | %-10s | %-13s | %-14s | %-15s | %-22s | %-12s %n", S_Name.get(i), S_Grades.get(i), English_Marks.get(i), Accounts_Marks.get(i), Economics_Marks.get(i), Business_Studies_Marks.get(i), Maths_Marks.get(i));
    }
                    System.out.println();
            }
        }
            else{
                while (true) {
                    System.out.println("\nPlease write yes if you want to continue to add data.\n If not write no");
                choice = sc.next();
                if(checkCondition(choice)){
                    break;
                }
                else{
                    break;
                }
                }
            }
        }
            
            }
      
      /*This below function calculates the total scores scored by the students and which student perform the best and lowest.*/
            private void Calculate_Scores(){
            int Highest_Marks = Integer.MIN_VALUE;
            int Lowest_Marks = Integer.MAX_VALUE;
            String Highest_Student_Name= "";
            String Lowest_Student_Name= "";
            
            for (int i = 0; i < English_Marks.size(); i++) {
                
                       int sum= English_Marks.get(i)+Accounts_Marks.get(i)+ Economics_Marks.get(i)+Business_Studies_Marks.get(i)+Maths_Marks.get(i);
                       double average = (double) sum / 5;
                    if(sum>Highest_Marks){
                        Highest_Marks=sum;
                        Highest_Student_Name=S_Name.get(i);
                    }
                    if(sum<Lowest_Marks){
                        Lowest_Marks=sum;
                        Lowest_Student_Name=S_Name.get(i);
                    }
                        System.out.println("\nSum of all Subjects of : " + S_Name.get(i) + " is " + sum);
                    System.out.println("\nAverage of all Subjects of : " + S_Name.get(i) + " is " + average);
                    System.out.println();
                    }
                   
                    System.out.println("\nHighest marks: " + Highest_Marks + " by " + Highest_Student_Name);
            System.out.println("\nLowest marks: " + Lowest_Marks + " by " + Lowest_Student_Name);
            freespace();
                 
        }
      
        /*This below function is used to display the data of the Commerce Streams students. */
        public void display(){
            System.out.printf("\n%-20s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s %n", "Students_Name", "Grade", "English_Marks", "Accounts_Marks", "Economics_Marks", "Business_Studies_Marks", "Maths_Marks");
    for(int i = 0; i < S_Name.size(); i++){
        System.out.printf("\n%-20s | %-10s | %-13s | %-14s | %-15s | %-22s | %-12s %n", S_Name.get(i), S_Grades.get(i), English_Marks.get(i), Accounts_Marks.get(i), Economics_Marks.get(i), Business_Studies_Marks.get(i), Maths_Marks.get(i));
    }

    if(S_Name.isEmpty() && English_Marks.isEmpty()&& Economics_Marks.isEmpty()&& Business_Studies_Marks.isEmpty() && Accounts_Marks.isEmpty() && Maths_Marks.isEmpty()){
        System.out.println("\nThe list is Empty. Please Enter some data");
        process();
    }
            Calculate_Scores();
        }
    
        /*This below function is used to record all the data for students. */
        public void process(){
            while(true){
                int  marks_1, marks_2, marks_3, marks_4, marks_5;
            System.out.println("\nEnter the name of the student:");
           
            String name = sc.nextLine();
           
            System.out.println("\nEnter the English Marks of the student:");
            marks_1 = sc.nextInt();
            System.out.println("\nEnter the Acounts Marks of the student:");
            marks_2 = sc.nextInt();
            System.out.println("\nEnter the Economics Marks of the student:");
            marks_3 = sc.nextInt();
            System.out.println("\nEnter the Business Studies Marks of the student:");
             marks_4 = sc.nextInt();
            System.out.println("\nEnter the Maths Marks of the student:");
             marks_5 = sc.nextInt();
                sc.nextLine();
             if((marks_1>100 ||  marks_1<0) || (marks_2>100 || marks_2<0) || (marks_3>100 || marks_3<0)|| (marks_4>100 || marks_4<0) || (marks_5>100 || marks_5<0)){
    
                System.out.println("\nWARNING !");
                System.out.println("The Marks should be between 0 and 100.");
                System.out.println("Please enter the marks again.\n");
                continue;
             }
             else{
                System.out.println("\nThe Grades are between A+ , A , B+ , B , C , D , E , F.\n");
                String Grade = getGrade(marks_1,marks_2,marks_3,marks_4,marks_5);
               
                addStudent(name, Grade, marks_1,marks_2,marks_3,marks_4,marks_5);
                System.out.println("\nThe Student Data has been Added! Please proceed further to check. ");
                System.out.println("Please tell yes if you want to add more students.");
                choice= sc.next();
                sc.nextLine();
                if (checkCondition(choice)) {
                    continue;
                }
                else{
                    break;
                }
               
             }
            
    
           
        }  
    }
  
    /*This below function is used to get the Grades performed by the student. */
    private String getGrade(int marks_1,int marks_2,int marks_3,int marks_4,int marks_5){
    
        if( marks_1<=30 || marks_2<=30 || marks_3<=30 ||  marks_4<=30 || marks_5<=30){
            return "F FAIL !";
            
        }
        else{
        int sum = marks_1 + marks_2 + marks_3 + marks_4 + marks_5;
        int average= sum/5;
        if(average>90 &&average<=100){
            return "A+";
        }
        else if(average>80 &&average<=90){
           return "A";
        }
        else if(average>70 &&average<=80){
            return "B+";
        }
        else if(average>60 &&average<=70){
            return "B";
        }
        else if(average>50 &&average<=60){
            return "C";
        }
        else if(average>40 &&average<=50){
            return "D";
        }
    
        else if(average>30 &&average<=40){
            return "E";
        }
        else if(average>=0 &&average<=30){
            return "F FAIL !";
        }
    }
        return "Invalid Grade";
    }
    }
    
    /* This below class is made for Arts Stream Student and it contains many methods. */

    class Student_Arts
    {
        Scanner sc = new Scanner(System.in);
        String choice;      // global variable is created.

        private ArrayList<String> S_Name = new ArrayList<>();
        private ArrayList<String> S_Grades = new ArrayList<>();
        private ArrayList<Integer> English_Marks= new ArrayList<>();
        private ArrayList<Integer> Economics_Marks= new ArrayList<>();
        private ArrayList<Integer> History_Marks= new ArrayList<>();
        private ArrayList<Integer> Geography_Marks= new ArrayList<>();
        private ArrayList<Integer> Sociology_Marks= new ArrayList<>();
        private ArrayList<Integer> Psychology_Marks= new ArrayList<>();
        
        /*This below function is called in all the other methods to check the conditions as given by the user input. */
        boolean checkCondition(String choice){
            if(choice.equalsIgnoreCase("yes")|| choice.equalsIgnoreCase("y")|| choice.equalsIgnoreCase("yep")) {
                return true;
            }
            else{
                return false;
            }
        }

 /*This below function is used to add the students details in the database. */
        private void addStudent(String name, String grade,int Eng_marks,int  Eco_marks,int History_marks,int Geo_marks,int Sociology_marks,int Psychology_marks){
    
            this.S_Name.add(name);
            this.S_Grades.add(grade);
            this.English_Marks.add(Eng_marks);
            this.Economics_Marks.add(Eco_marks);
            this.History_Marks.add(History_marks);
            this.Geography_Marks.add(Geo_marks);
            this.Sociology_Marks.add(Sociology_marks);
            this.Psychology_Marks.add(Psychology_marks);
    }

    /*The below function is called when the mrks is being updated. */
    private void updateStudent(String name, int correctMarks, String subject) {
        for(int i = 0; i < S_Name.size(); i++){
            if (S_Name.get(i).equals(name)) {
                if (subject.equalsIgnoreCase("English_marks")) {
                    English_Marks.set(i, correctMarks);
                } else if (subject.equalsIgnoreCase("Economics_Marks")) {
                    Economics_Marks.set(i, correctMarks);
                } else if (subject.equalsIgnoreCase("History_Marks")) {
                    History_Marks.set(i, correctMarks);
                } else if (subject.equalsIgnoreCase("Geograpphy_Marks")) {
                    Geography_Marks.set(i, correctMarks);
                } else if (subject.equalsIgnoreCase("Sociology_Marks")) {
                    Sociology_Marks.set(i, correctMarks);
                } 
                } else if (subject.equalsIgnoreCase("Psychology_Marks")) {
                    Psychology_Marks.set(i, correctMarks);
                } 
                int englishMark = English_Marks.get(i);
                int Eco_Mark = Economics_Marks.get(i);
                int History_mark = History_Marks.get(i);
                int Geo_Mark = Geography_Marks.get(i);
                int Social_Mark = Sociology_Marks.get(i);
                int Psycho_Mark = Sociology_Marks.get(i);
                String grade = getGrade(englishMark, Eco_Mark, History_mark, Geo_Mark, Social_Mark,Psycho_Mark);
                S_Grades.set(i, grade);
               
                break;
            }
        }
    
        /*This below function is used to update names or marks */
    private void updateMarksOrNamesArts(){
        System.out.println("\nPlease write yes if you want to update names else no for marks.");
        choice= sc.next();
        if (checkCondition(choice)) {
            System.out.println("\nEnter the Wrong name of the student you want to correct");
               sc.nextLine();
                String Wrong_Name = sc.nextLine();
                System.out.println("\nEnter the correct Name");
                String correct_name = sc.nextLine();
            for(int i =0;i<S_Name.size();i++){
                
                if(S_Name.get(i).equalsIgnoreCase(Wrong_Name)){
                        S_Name.set(i,correct_name);
                }
                
            }
        }
        else{
        System.out.println("\nIf you want to update Marks.");
        System.out.println("Please write only in yes or no");
       choice = sc.next();
       
        if (checkCondition(choice)) {
            System.out.println("\nEnter the Full Name of the student you want to do it for.");
            sc.nextLine();
            String name = sc.nextLine();

            for(int i=0;i<S_Name.size();i++){
                if(S_Name.get(i).equalsIgnoreCase(name)){
                System.out.println("\nEnter the subject name you want to correct with underscores. For EX - Psychology_marks");
                String sub = sc.next();
                System.out.println("\nEnter the Correct Marks");
                int Correct_Marks = sc.nextInt();

                if(sub.equalsIgnoreCase("English_marks") ){
                   English_Marks.set(i, Correct_Marks);
                    updateStudent(name, Correct_Marks, sub);
                   break;
                }
               else if(sub.equalsIgnoreCase("Economics_marks") ){
                   Economics_Marks.set(i, Correct_Marks);
                    updateStudent(name, Correct_Marks, sub);
                    break;
                }
               else if(sub.equalsIgnoreCase("History_marks") ){
                   History_Marks.set(i, Correct_Marks);
                    updateStudent(name, Correct_Marks, sub);
                    break;
                }
              else  if(sub.equalsIgnoreCase("Geography_marks") ){
                   Geography_Marks.set(i, Correct_Marks);
                    updateStudent(name, Correct_Marks, sub);
                    break;
                }
               else if(sub.equalsIgnoreCase("Sociology_marks") ){
                   Sociology_Marks.set(i, Correct_Marks);
                    updateStudent(name, Correct_Marks, sub);
                    break;
                }
               else if(sub.equalsIgnoreCase("Psychology_marks") ){
                   Psychology_Marks.set(i, Correct_Marks);
                    updateStudent(name, Correct_Marks, sub);
                    break;
                }
                break;
               
            }
            
            }
        }
    }
    
    display();
}

    /*This below function is used to remove the record of the students data from the database. */

public void removeStudent(String name){
            
    for (int i = S_Name.size()-1; i >=0; i--) {
        if (S_Name.get(i).equalsIgnoreCase(name)) {
            S_Name.remove(i);
            S_Grades.remove(i);
            English_Marks.remove(i);
            Economics_Marks.remove(i);
            History_Marks.remove(i);
            Geography_Marks.remove(i);
            Sociology_Marks.remove(i);
            Psychology_Marks.remove(i);
            
            break;
        }
    }
    System.out.printf("\n%-20s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s %n", "Students_Name", "Grade", "English_Marks", "Economics_Marks", "History_Marks", "Geography_Marks","Sociology_Marks", "Psychology_Marks");

    for(int i = 0; i < S_Name.size(); i++){
        System.out.printf("\n%-20s | %-10s | %-13s | %-15s | %-13s | %-15s | %-15s | %-12s %n", S_Name.get(i), S_Grades.get(i), English_Marks.get(i), Economics_Marks.get(i), History_Marks.get(i), Geography_Marks.get(i), Sociology_Marks.get(i), Psychology_Marks.get(i));
    }   
}

     /*This below function is used to free the space of the database. */
    public void freespace(){
        System.out.println();
            System.out.println("\nPlease write yes if you want to update names or marks, if not not simply write no.");
             choice = sc.next();
            if(checkCondition(choice)){
                updateMarksOrNamesArts();
            }
            else{
                System.out.println("\nPlease write yes if you want to remove the list from the database.\n If you don't want to remove list please write no. ");
                choice = sc.next();
            if(checkCondition(choice)){
                System.out.println("\nPlease write yes if you want to remove a particular student list from the database.\n if no then the whole data will be erased.");
                choice= sc.next();
                if(checkCondition(choice)){
                    System.out.println("\nEnter the name of the student you want to  remove. ");
                    sc.nextLine();
                    String name1 = sc.nextLine();
                    removeStudent(name1);
                    
                }
                else{
                for(int i =0;i<English_Marks.size();i++){
                   
                    S_Name.clear();
                    English_Marks.clear();
                    Economics_Marks.clear();
                    History_Marks.clear();
                    Geography_Marks.clear();
                    Sociology_Marks.clear();
                    Psychology_Marks.clear();

                }
                if(S_Name.isEmpty() && English_Marks.isEmpty()&& Economics_Marks.isEmpty()&& History_Marks.isEmpty() && Geography_Marks.isEmpty() && Sociology_Marks.isEmpty() && Psychology_Marks.isEmpty()){
                    System.out.println("\nThe data has been cleared...");
                    System.out.println();
                    }
                    System.out.printf("\n%-20s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s %n", "Students_Name", "Grade", "English_Marks", "Economics_Marks", "History_Marks", "Geography_Marks","Sociology_Marks", "Psychology_Marks");

                    for(int i = 0; i < S_Name.size(); i++){
                        System.out.printf("\n%-20s | %-10s | %-13s | %-15s | %-13s | %-15s | %-15s | %-12s %n", S_Name.get(i), S_Grades.get(i), English_Marks.get(i), Economics_Marks.get(i), History_Marks.get(i), Geography_Marks.get(i), Sociology_Marks.get(i), Psychology_Marks.get(i));
                    }   
                    System.out.println();
            }
            }
           
            else{
                while (true) {
                    System.out.println("\nIf you want to continue to add data please write yes.");
                choice = sc.next();
                if(checkCondition(choice)){
                    break;
                }
                else{
                    break;
                }
                }
                }} 
            }

              /*This below function calculates the total scores scored by the students and which student perform the best and lowest.*/
    
        private void Calculate_Scores(){
            int Highest_Marks = Integer.MIN_VALUE;
            int Lowest_Marks = Integer.MAX_VALUE;
            String Highest_Student_Name= "";
            String Lowest_Student_Name= "";
           
            
            for (int i = 0; i < English_Marks.size(); i++) {
                
                       int sum= English_Marks.get(i)+Economics_Marks.get(i)+ History_Marks.get(i)+Geography_Marks.get(i)+Sociology_Marks.get(i)+ Psychology_Marks.get(i);
                       float average = (float) sum / 6;
                       if(sum>Highest_Marks){
                        Highest_Marks=sum;
                        Highest_Student_Name=S_Name.get(i);
                    }
                     if(sum<Lowest_Marks){
                        Lowest_Marks=sum;
                        Lowest_Student_Name=S_Name.get(i);
                    }
                        System.out.println("\nSum of all Subjects of : " + S_Name.get(i) + " is " + sum);
                    System.out.println("\nAverage of all Subjects of : " + S_Name.get(i) + " is " + average);
                   
            System.out.println();
                    }
                    System.out.println("\nHighest marks: " + Highest_Marks + " by " + Highest_Student_Name);
                    System.out.println("\nLowest marks: " + Lowest_Marks + " by " + Lowest_Student_Name);

                    freespace();
        }

        /*This below function is used to display the data of the Arts Stream students. */
        public void display(){
            System.out.printf("\n%-20s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s %n", "Students_Name", "Grade", "English_Marks", "Economics_Marks", "History_Marks", "Geography_Marks","Sociology_Marks", "Psychology_Marks");

    for(int i = 0; i < S_Name.size(); i++){
        System.out.printf("\n%-20s | %-10s | %-13s | %-15s | %-13s | %-15s | %-15s | %-12s %n", S_Name.get(i), S_Grades.get(i), English_Marks.get(i), Economics_Marks.get(i), History_Marks.get(i), Geography_Marks.get(i), Sociology_Marks.get(i), Psychology_Marks.get(i));
    }   
    if(S_Name.isEmpty() && English_Marks.isEmpty()&& Economics_Marks.isEmpty()&& History_Marks.isEmpty() && Geography_Marks.isEmpty() && Sociology_Marks.isEmpty() && Psychology_Marks.isEmpty()){
        System.out.println("\nThe list is Empty. Please Enter Some Input");
        process();
        display();
    }
    System.out.println();
            Calculate_Scores();
        }
    
        /*This below function is used to record all the data for students. */
        public void process(){
            while(true){
                int  marks_1, marks_2, marks_3, marks_4, marks_5,marks_6;
            System.out.println("\nEnter the name of the student:");
            
            String name = sc.nextLine();
            
            System.out.println("\nEnter the English Marks of the student:");
             marks_1 = sc.nextInt();
            System.out.println("\nEnter the Economics Marks of the student:");
             marks_2 = sc.nextInt();
            System.out.println("\nEnter the History Marks of the student:");
             marks_3 = sc.nextInt();
            System.out.println("\nEnter the Geography Marks of the student:");
             marks_4 = sc.nextInt();
            System.out.println("\nEnter the Sociology Marks of the student:");
             marks_5 = sc.nextInt();
            System.out.println("\nEnter the Psychology Marks of the student:");
             marks_6 = sc.nextInt();
             sc.nextLine();
             if((marks_1>100 ||  marks_1<0) || (marks_2>100 || marks_2<0) || (marks_3>100 || marks_3<0) || (marks_4>100 || marks_4<0) ||(marks_5>100 || marks_5<0) || (marks_6>100 || marks_6<0)){
    
                System.out.println("\nWARNING !");
                System.out.println("The Marks should be between 0 and 100.");
                System.out.println("Please enter the marks again");
                continue;
             }
             else{
                System.out.println("\nThe Grades are between A+ , A , B+ , B , C , D , E , F.");
                String Grade = getGrade(marks_1,marks_2,marks_3,marks_4,marks_5,marks_6);
               
                addStudent(name, Grade, marks_1,marks_2,marks_3,marks_4,marks_5,marks_6);
                System.out.println("\nThe Student Data has been Added! Please proceed further to check. ");
                System.out.println("If you want to add more students write yes.");
                choice= sc.next();
                sc.nextLine();
                if (checkCondition(choice)) {
                    continue;
                }
                else{
                    break;
                }
               
             }
            
    
           
        }  
    }
    /*This below function is used to get the Grades performed by the student. */
    private String getGrade(int marks_1,int marks_2,int marks_3,int marks_4,int marks_5,int marks_6){
    
        if( marks_1<=30 || marks_2<=30 || marks_3<=30 ||  marks_4<=30 || marks_5<=30 || marks_6<=30){
            return "F FAIL !";
            
        }
        else{
        int sum = marks_1 + marks_2 + marks_3 + marks_4 + marks_5 + marks_6;
        float average= (float)sum/6;
        if(average>90 &&average<=100){
            return "A+";
        }
        else if(average>80 &&average<=90){
           return "A";
        }
        else if(average>70 &&average<=80){
            return "B+";
        }
        else if(average>60 &&average<=70){
            return "B";
        }
        else if(average>50 &&average<=60){
            return "C";
        }
        else if(average>40 &&average<=50){
            return "D";
        }
    
        else if(average>30 &&average<=40){
            return "E";
        }
        else if(average>=0 &&average<=30){
            return "F FAIL !";
        }
    }
        return "Invalid Grade";
    }
    }

    /*The below is main class name and where the main function of all the classes are being called. */
    public class Student_Tracker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Students_Science S_S = new Students_Science();
        Student_Commerce S_C = new Student_Commerce();
        Student_Arts S_A = new Student_Arts();
        
        System.out.println("\n Welccome to the Student Tracker System.\n Please choose your stream related subjects you want to add students. ");
       
        
        while(true){
            System.out.println("\n1. Enter 1 to store data for Science Students. ");
        System.out.println("2. Enter 2 to store data for Commerce Students. ");
        System.out.println("3. Enter 3 to store data for Arts Students. ");
        System.out.println("4. Enter 4 to display data for Science Students. ");
        System.out.println("5. Enter 5 to display data for Commerce Students. ");
        System.out.println("6. Enter 6 to display data for Science Students. ");
        System.out.println("7. Enter 7 To exit.");
        int choice = sc.nextInt();
            switch (choice) {
                case 1:
               
                S_S.process(); 
                S_S.display();
                    break;
            
                case 2:
               
                S_C.process(); 
                S_C.display();
                    break;
                case 3:
              
                S_A.process();
                S_A.display();
                break;

                case 4:
                S_S.display();
                break;

                case 5:
                S_C.display();
                break;

                case 6:
                S_A.display();
                break;

                case 7:
                System.exit(0);
                    break;
            }
            System.out.println("\nPlease write yes if you want to add more students from other Streams. ");
            String condition= sc.next();
            if (condition.equals("no")|| condition.equalsIgnoreCase("n")) {
                System.out.println("\nTerminating the program.");
                break;
            }   
        }
    }  
}