
public class SocialPerformanceRecord {
    private int sid;
    private int year;
    private int score;
    private String feedback;

    public SocialPerformanceRecord(int sid, int year, int score, String feedback) {
        this.sid = sid;
        this.year = year;
        this.score = score;
        this.feedback = feedback;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
