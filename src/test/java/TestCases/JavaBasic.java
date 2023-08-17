package TestCases;

public class JavaBasic {
    public static void main(String[] args) {

        String username = "Donald";
        int ages =  77;
        int age = 7;
        String location = "Chicago";
        String prod = "Fall Detector Alarm";
        double price = 39.99;

        System.out.println("Good morning " + username +"! Thanks to your venerable age of " + ages +
                " ,we have special offer for you. It`s a '" +prod+ "' for only $" + price +
                "." + '\n' + "Please, visit our office in " + location +" for further information." );

        System.out.println('\n' + "Addition "+ ages +" and "+ age + ": " + (ages + age));
        System.out.println("Subtract "+ age +" from "+ ages + ": " + (ages - age));
        System.out.println("Multiply "+ ages +" by "+ age + ": " + (ages * age));
        System.out.println("Divide "+ ages +" by "+ age + ": " + (ages / age));

    }
}
