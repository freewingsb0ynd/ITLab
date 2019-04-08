public class GenericDemo {
    public static void main(String[] args) throws Exception {
        Dictionary<String, Integer> entry = new Dictionary<String, Integer>("hoang", 947852);
        System.out.println("Name: " + entry.getKey() + "; Phone: " + entry.getValue());

        PhoneBookName entry1 = new PhoneBookName("manh", 565846);
        System.out.println("Name: " + entry1.getKey() + "; Phone: " + entry1.getValue());

        StringAndValueEntry<String> entry2 = new StringAndValueEntry<String>("E001", "Tom");
        String empNumber = entry2.getKey();
        String empName = entry2.getValue();
        System.out.println("Emp Number = " + empNumber + "; Emp Name = " + empName);

        EmployeeInfo<String,String,String> emp1 = new EmployeeInfo<String, String, String>("Alice","FE566", "good");
        System.out.println("Emp Name = " + emp1.getKey() + "; Emp Code = " + emp1.getValue() + "; Emp Info: " + emp1.getInfo());

        ObjImpGenericI<String> emp2 = new ObjImpGenericI<String>("TOPICA");
        System.out.println("Emp Unit = " + emp2.doSomething());

        MyGeneric<Bar> mg = new MyGeneric<Bar>(Bar.class);
        Bar bar = mg.getTObject();
        bar.currentDate();

    }
}
