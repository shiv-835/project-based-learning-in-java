import java.util.*;

class Video {
    private String title;
    private boolean checkedOut;
    private double avgRating;
    private int ratingCount;

    public Video(String title) {
        this.title = title;
        this.checkedOut = false;
        this.avgRating = 0;
        this.ratingCount = 0;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void checkOut() {
        this.checkedOut = true;
    }

    public void returnVideo() {
        this.checkedOut = false;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void addRating(int rating) {
        avgRating = (avgRating * ratingCount + rating) / (++ratingCount);
    }

    @Override
    public String toString() {
        String status = checkedOut ? "Checked out" : "Available";
        return title + "\t" + status + "\t" + String.format("%.2f", avgRating);
    }
}

public class VideoStore {
    private ArrayList<Video> videos;

    public VideoStore() {
        this.videos = new ArrayList<>();
    }

    public void addVideo(String title) {
        videos.add(new Video(title));
        System.out.println("Added video: " + title);
    }

    public void checkOutVideo(String title) {
        Video video = findVideo(title);
        if (video != null) {
            if (video.isCheckedOut()) {
                System.out.println("Video is already checked out.");
            } else {
                video.checkOut();
                System.out.println("Checked out video: " + title);
            }
        } else {
            System.out.println("Video not found.");
        }
    }

    public void returnVideo(String title) {
        Video video = findVideo(title);
        if (video != null) {
            if (video.isCheckedOut()) {
                video.returnVideo();
                System.out.println("Returned video: " + title);
            } else {
                System.out.println("Video was not checked out.");
            }
        } else {
            System.out.println("Video not found.");
        }
    }

    public void rateVideo(String title, int rating) {
        Video video = findVideo(title);
        if (video != null) {
            video.addRating(rating);
            System.out.println(title + " rated: " + rating);
        } else {
            System.out.println("Video not found.");
        }
    }

    public void listInventory() {
        if (videos.isEmpty()) {
            System.out.println("No videos available.");
            return;
        }
        System.out.println("Title\tStatus\tAverage Rating");
        for (Video video : videos) {
            System.out.println(video);
        }
    }

    private Video findVideo(String title) {
        for (Video video : videos) {
            if (video.getTitle().equalsIgnoreCase(title)) {
                return video;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        VideoStore store = new VideoStore();
        Scanner input = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("-------- Video Store --------");
            System.out.println("1. Add a new video");
            System.out.println("2. Check out a video");
            System.out.println("3. Return a video");
            System.out.println("4. Rate a video");
            System.out.println("5. List all videos");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String titleToAdd = input.nextLine();
                    store.addVideo(titleToAdd);
                    break;
                case 2:
                    System.out.print("Enter title: ");
                    String titleToCheckOut = input.nextLine();
                    store.checkOutVideo(titleToCheckOut);
                    break;
                case 3:
                    System.out.print("Enter title: ");
                    String titleToReturn = input.nextLine();
                    store.returnVideo(titleToReturn);
                    break;
                case 4:
                    System.out.print("Enter title: ");
                    String titleToRate = input.nextLine();
                    System.out.print("Enter rating: ");
                    int rating = input.nextInt();
                    store.rateVideo(titleToRate, rating);
                    break;
                case 5:
                    System.out.println("List of all videos:");
                    store.listInventory();
                    break;
                case 6:
                    running = false;
                    System.out.println("Thank you for using the system!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            if (running) {
                System.out.print("Any more operations? (Y/N): ");
                String moreOperations = input.nextLine();
                if (moreOperations.equalsIgnoreCase("N")) {
                    running = false;
                    System.out.println("Thank you for using the system!");
                }
            }
        }

        input.close();
    }
}
