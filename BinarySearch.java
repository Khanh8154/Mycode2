import java.util.List;
import java.util.ArrayList;
public class BinarySearch {
    public int binarySearch(ArrayList<Student> students, int left, int right, int studentID) {
        if (right >= left) {
            int mid = left + (right - left) / 2;

            if (students.get(mid).getStudentID() == studentID) {
                return mid;
            }

            if (students.get(mid).getStudentID() > studentID) {
                return binarySearch(students, left, mid - 1, studentID);
            } else {
                return binarySearch(students, mid + 1, right, studentID);
            }
        }
        return -1;
    }
}
