import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CreateFile {
    public static void main(String[] args) {
        CreateFile createFile = new CreateFile();
        createFile.start();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the company name: ");
        String companyName = scanner.nextLine();

        System.out.print("Enter the location served by the company: ");
        String location = scanner.nextLine();

        System.out.print("Enter the number of halls: ");
        int numberOfHalls = scanner.nextInt();

        System.out.print("Enter the number of rows in each hall: ");
        int rowsPerHall = scanner.nextInt();

        System.out.print("Enter the number of seats per row: ");
        int seatsPerRow = scanner.nextInt();

        createFile(companyName, location, numberOfHalls, rowsPerHall, seatsPerRow);
        System.out.println("File created successfully.");

        openMainMenu();
    }

    private void createFile(String companyName, String location, int numberOfHalls, int rowsPerHall, int seatsPerRow) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("ticket_system.txt"))) {
            writer.println("Company Name: " + companyName);
            writer.println("Location served by the company: " + location);
            writer.println("Number of halls: " + numberOfHalls);
            writer.println("Number of rows in each hall: " + rowsPerHall);
            writer.println("Number of seats per row: " + seatsPerRow);
            writer.println();

            for (int hallNumber = 1; hallNumber <= numberOfHalls; hallNumber++) {
                writer.println("Hall " + hallNumber + ":");
                for (int row = 1; row <= rowsPerHall; row++) {
                    writer.print("Row " + row + ": ");
                    for (int seat = 1; seat <= seatsPerRow; seat++) {
                        writer.print("Seat " + seat);
                        if (seat < seatsPerRow) {
                            writer.print(", ");
                        }
                    }
                    writer.println();
                }
                writer.println();
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }

    private void openMainMenu() {
        System.out.println("Opening the main menu...");
    }
}
