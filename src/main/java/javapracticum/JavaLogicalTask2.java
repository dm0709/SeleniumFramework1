package javapracticum;

public class JavaLogicalTask2 {

    public static void main(String[] args) {

        String department = "finance";
        switch (department){
            case "sales" :
                System.out.println("Sales department works from 8am to 12pm.");
                break;
            case "operations":
                System.out.println("Operations department works from 9am to 3pm");
                break;
            case "marketing":
                System.out.println("Marketing department works from 9am to 2pm");
                break;
            case "management" :
                System.out.println("Management department works from 10am to 3pm.");
                break;
            case "finance":
                System.out.println("Finance department works from 8am to 12pm");
                break;
            case "logistics":
                System.out.println("Logistics department works from 1pm to 7pm");
                break;
            default:
                System.out.println("Write correct department please");
        }
    }
}
