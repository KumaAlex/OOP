public class a {
    public static void main(String[] args) {
        Person p = new Person("myName", "myStreet");
        System.out.println(p.name);
        System.out.println(p.getAddress());

        Student st = new Student("stName", "stAddress", "stProg", 18, 10.32);
        System.out.println(st.toString());
        System.out.println(st.getYear());
        System.out.println(st.getAddress());
        System.out.println(st.getProgram());
        System.out.println(st.getFee());
        System.out.println(st.toString());
        

        Staff staff = new Staff("Alex", "Gil", "Meme", 13521.213);
        System.out.println(staff.getAddress());
        System.out.println(staff.getName());
        System.out.println(staff.getPay());
        System.out.println(staff.getSchool());
        System.out.println(staff.toString());
    }
}

class Person {
    protected String name;
    protected String address;

    public Person(String a, String b) {
        this.name = a;
        this.address = b;
    }

    public String getName() {
        return(this.name);
    }

    public String getAddress() {
        return(this.address);
    }

    public void setAddress(String new_add) {
        this.address = new_add;
    }

    public String toString() {
        return("Person[name=" + this.name
        + ",address=" + this.address + ']');
    }
}


class Student extends Person {
    private String program;
    private double fee;
    private int year;

    public Student(String name, String address, String program, int year, double fee) {
        super(name, address);
        this.program = program;
        this.year = year;
        this.fee = fee;
    }

    public String getProgram() {
        return(this.program);
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getYear() {
        return(this.year);
    }

    public void setYear(int year) {
        this.year = year;
    } 

    public double getFee() {
        return(this.fee);
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return("Student[" + super.toString() 
        + ",program=" + this.program + ", year=" 
        + this.year + ", fee=" + this.fee + "]");
    }
}

class Staff extends Person {
    private String school;
    private double pay;
    
    public Staff(String name, String address, String school, double pay) {
        super(name, address);
        this.school = school;
        this.pay = pay;
    }

    public String getSchool() {
        return(this.school);
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public double getPay() {
        return(this.pay);
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return("Staff[" + super.toString() 
        + ",school=" + this.school + ", pay=" 
        + this.pay + "]");
    }
}