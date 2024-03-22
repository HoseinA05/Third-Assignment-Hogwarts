public class Review {

    private String text;
    private Student reviewer;
    private int point;
    public Review(String text, int point, Student student){
        this.text = text;
        this.point = point;
        this.reviewer = student;
    }
}
