import java.util.Scanner;
class helloworld {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.printf("Enter today's date: ");
        int date = in.nextInt();
        System.out.print("Enter the number of days elapsed since today: ");
        int dayplusplus = in.nextInt();

        int future = (date + dayplusplus) % 7;
        String day = "";

        switch(date){
            case 0 -> day = "Sunday";
            case 1 -> day = "Monday";
            case 2 -> day = "Tuesday";
            case 3 -> day = "Wednesday";
            case 4 -> day = "Thursday";
            case 5 -> day = "Friday";
            case 6 -> day = "Saturday";
        }

        switch (future) {
            case 0 -> System.out.println("Today is "+day+" and the future day is Sunday");
            case 1 -> System.out.println("Today is "+day+" and the future day is Monday");
            case 2 -> System.out.println("Today is "+day+" and the future day is Tuesday");
            case 3 -> System.out.println("Today is "+day+" and the future day is Wednesday");
            case 4 -> System.out.println("Today is "+day+" and the future day is Thursday");
            case 5 -> System.out.println("Today is "+day+" and the future day is Friday");
            case 6 -> System.out.println("Today is "+day+" and the future day is Saturday");

        }
    }
}