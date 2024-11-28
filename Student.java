public class Student {
    private Integer studentID;
    private String fullName;
    private double score;
    private String rank;

    public Student(Integer studentID, String fullName, double score) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.score = score;
        this.rank = determineRank(score);
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public String getFullName() {
        return fullName;
    }

    public double getScore() {
        return score;
    }

    public String getRank() {
        return rank;
    }

    public void updateScore(double score) {
        this.score = score;
        this.rank = determineRank(score);
    }

    public void updateFullName(String fullName) {
        this.fullName = fullName;
    }

    private String determineRank(double score) {
        if (score < 5.0) return "Fall";
        else if (score < 6.5) return "Medium";
        else if (score < 7.5) return "Good";
        else if (score < 9.0) return "Very Good";
        else return "Excellent";
    }

    @Override
    public String toString() {
        return "ID: " + studentID + ", Name: " + fullName + ", Score: " + score + ", Rank: " + rank;
    }
}
