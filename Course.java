public class Course {
    public String name;
    public String code;
    public int credit;
    public String model;
    public String user;
    public String [] contacts;

    public Course(String name, String code, int credit, String model, String user ){
    this.name = name;
    this.code = code;
    this.credit = credit;
    }

    public void updateDetails(){
        System.out.println("Course Name: "+ name);
        System.out.println("Course Code: "+ code);
        System.out.println("Course Credit: "+ credit);
    }

    public static void main(String [] args){
        Course c1 = new Course("Pl1", "CSE110", 3);
        Course c2 = new Course("Pl4", "CSE111", 3);
        Course c3 = new Course("Pl3", "CSE320", 3);

        c1.updateDetails();
        c2.updateDetails();
        c3.updateDetails();
    }
}
