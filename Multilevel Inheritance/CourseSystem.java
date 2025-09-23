class Course {
    protected String courseName;
    protected int duration; // in hours

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public void displayCourseInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
    }
}

class OnlineCourse extends Course {
    protected String platform;
    protected boolean isRecorded;

    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    public void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount; // in percentage

    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    @Override
    public void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Fee: $" + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Price: $" + calculateFinalPrice());
    }

    public double calculateFinalPrice() {
        return fee - (fee * discount / 100);
    }
}

public class CourseSystem {
    public static void main(String[] args) {
        Course basicCourse = new Course("Introduction to Programming", 20);
        OnlineCourse onlineCourse = new OnlineCourse("Java Fundamentals", 30, "Coursera", true);
        PaidOnlineCourse paidCourse = new PaidOnlineCourse("Advanced Java", 40, "Udemy", true, 100.0, 20.0);

        System.out.println("=== Basic Course ===");
        basicCourse.displayCourseInfo();
        System.out.println();

        System.out.println("=== Online Course ===");
        onlineCourse.displayCourseInfo();
        System.out.println();

        System.out.println("=== Paid Online Course ===");
        paidCourse.displayCourseInfo();
    }
}
