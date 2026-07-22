public class Course {

    private String code;
    private String title;
    private int unit;

    public Course(String code, String title, int unit) {
        this.code = code;
        this.title = title;
        this.unit = unit;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public int getUnit() {
        return unit;
    }

    public void display() {
        System.out.println("-----------------------------------");
        System.out.println("Course Code : " + code);
        System.out.println("Course Title: " + title);
        System.out.println("Course Unit : " + unit);
        System.out.println("-----------------------------------");
    }
}
