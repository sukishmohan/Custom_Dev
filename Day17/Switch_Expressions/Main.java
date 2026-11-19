public class Main {
    public static void main(String[] args) {
        int day = 3;

        String dayName = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Invalid day";
        };

        System.out.println(dayName);

        int number = 2;
        String result = switch (number) {
            case 1, 2, 3 -> {
                System.out.println("Number is between 1 and 3");
                yield "Small";
            }
            default -> "Other";
        };
        System.out.println(result);
    }
}
