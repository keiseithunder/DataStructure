class Student{
    static int numberOfStudent=0;
    int id ;
    String name;
    static final int max_name=50;

    public Student(String name){
        this.name=name;
        numberOfStudent++;
        id=numberOfStudent;
    }
    public String toString(){
        return "ID: "+id+" Name: "+name;
    }
}