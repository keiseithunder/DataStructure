public class Test{
    public static void main(String[] args) {
        Student s1 = new Student("s1xczxczxc");
        Student s2 = new Student("s2zxczxczxczx");
        Student s3 = new Student("s3cxzczxczxcx");
        Student s4 = new Student("s4czxczxczxc");
        Student s5 = new Student("s5zxczxczx");
        FileManager f1 = new FileManager("file1");
        f1.writeToFile(s1);
        f1.writeToFile(s2);
        f1.writeToFile(s3);
        f1.writeToFile(s4);
        f1.writeToFile(s5);
        f1.readFromFile();
    }
}