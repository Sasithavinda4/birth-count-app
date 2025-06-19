import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeSinceBirthWithCountdown {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your birthdate and time (yyyy-MM-dd HH:mm): ");
        String input = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        try {
            LocalDateTime birthDateTime = LocalDateTime.parse(input, formatter);
            LocalDateTime now = LocalDateTime.now();

            Duration duration = Duration.between(birthDateTime, now);
            Period period = Period.between(birthDateTime.toLocalDate(), now.toLocalDate());

            long totalSeconds = duration.getSeconds();
            long totalMinutes = totalSeconds / 60;
            long totalHours = totalMinutes / 60;
            long totalDays = totalHours / 24;
            long totalWeeks = totalDays / 7;
            long totalYears = period.getYears();
            long totalMonths = totalYears * 12 + period.getMonths();
            double totalDecades = totalYears / 10.0;
            double totalCenturies = totalYears / 100.0;

            double dogYears = totalYears * 7.0;
            double fullMoons = totalDays / 29.53;
            long heartbeats = totalMinutes * 75;

            LocalDate nextBirthday = birthDateTime.toLocalDate().withYear(now.getYear());
            if (!nextBirthday.isAfter(now.toLocalDate())) {
                nextBirthday = nextBirthday.plusYears(1);
            }
            LocalDateTime nextBirthdayTime = nextBirthday.atTime(birthDateTime.toLocalTime());
            Duration untilNext = Duration.between(now, nextBirthdayTime);

            long days = untilNext.toDays();
            long hours = untilNext.toHours() % 24;
            long minutes = untilNext.toMinutes() % 60;
            long seconds = untilNext.getSeconds() % 60;

            System.out.println("Time since your birth:");
            System.out.println("Seconds: " + totalSeconds);
            System.out.println("Minutes: " + totalMinutes);
            System.out.println("Hours: " + totalHours);
            System.out.println("Days: " + totalDays);
            System.out.println("Weeks: " + totalWeeks);
            System.out.println("Months: " + totalMonths);
            System.out.println("Years: " + totalYears);
            System.out.printf("Decades: %.2f%n", totalDecades);
            System.out.printf("Centuries: %.4f%n", totalCenturies);

            System.out.println("\nTime until your next birthday:");
            System.out.printf("%d days, %d hours, %d minutes, %d seconds%n", days, hours, minutes, seconds);

            System.out.println("\nFun Facts:");
            System.out.printf("Dog Years: %.2f%n", dogYears);
            System.out.printf("Full Moons Lived: %.1f%n", fullMoons);
            System.out.println("Estimated Heartbeats: " + heartbeats);

        } catch (Exception e) {
            System.out.println("Invalid input. Please use yyyy-MM-dd HH:mm format.");
        }
    }
}
