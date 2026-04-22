import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class helloworld {
    public static void main(String[] args) {
        // Create a date for January 26
        LocalDate jan26 = LocalDate.of(2026, Month.JANUARY, 26);
        
        // Print information about January 26
        System.out.println("========== JANUARY 26 INFORMATION ==========");
        System.out.println();
        
        // Date Information
        System.out.println("Date: " + jan26);
        System.out.println("Day of Week: " + jan26.getDayOfWeek());
        System.out.println("Month: " + jan26.getMonth());
        System.out.println("Day: " + jan26.getDayOfMonth());
        System.out.println("Year: " + jan26.getYear());
        System.out.println();
        
        // Formatted Date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy");
        System.out.println("Formatted Date: " + jan26.format(formatter));
        System.out.println();
        
        // Special Information
        System.out.println("=== SPECIAL INFORMATION ===");
        System.out.println("This is India's Republic Day!");
        System.out.println("Celebrates: Adoption of Indian Constitution");
        System.out.println("Year of Constitution: 1950");
        System.out.println("Days until January 26: " + getDaysUntil(jan26));
    }
    
    // Method to calculate days until the given date from today
    public static long getDaysUntil(LocalDate targetDate) {
        LocalDate today = LocalDate.now();
        
        // If the date has already passed this year, calculate for next year
        LocalDate dateThisYear = targetDate.withYear(today.getYear());
        
        if (dateThisYear.isBefore(today)) {
            return java.time.temporal.ChronoUnit.DAYS.between(today, 
                   targetDate.withYear(today.getYear() + 1));
        } else {
            return java.time.temporal.ChronoUnit.DAYS.between(today, dateThisYear);
        }
    }
}
