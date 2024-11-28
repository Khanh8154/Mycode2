import java.util.ArrayList;
public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void add(Student student) {
        root = addRec(root, student);
    }
    private Node addRec(Node root, Student student) {
        if (root == null) {
            root = new Node(student);
            return root;
        }
        if (student.getStudentID().compareTo(root.student.getStudentID()) < 0) {
            root.left = addRec(root.left, student);
        } else if (student.getStudentID().compareTo(root.student.getStudentID()) > 0) {
            root.right = addRec(root.right, student);
        }
        return root;
    }
    public Student search(Integer studentID) {
        return searchRec(root, studentID);
    }
    private Student searchRec(Node root, Integer studentID) {
        if (root == null || root.student.getStudentID().equals(studentID)) {
            return (root != null) ? root.student : null;
        }
        if (studentID.compareTo(root.student.getStudentID()) < 0) {
            return searchRec(root.left, studentID);
        } else {
            return searchRec(root.right, studentID);
        }
    }
    public void inOrderTraversal() {
        inOrderRec(root);
    }
    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.student);
            inOrderRec(root.right);
        }
    }
    public void delete(Integer studentID) {
        root = deleteRec(root, studentID);
    }
    private Node deleteRec(Node root, Integer studentID) {
        if (root == null) return root;

        if (studentID.compareTo(root.student.getStudentID()) < 0) {
            root.left = deleteRec(root.left, studentID);
        } else if (studentID.compareTo(root.student.getStudentID()) > 0) {
            root.right = deleteRec(root.right, studentID);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            root.student = minValue(root.right);
            root.right = deleteRec(root.right, root.student.getStudentID());
        }
        return root;
    }
    public ArrayList<Student> toArrayList() {
        ArrayList<Student> students = new ArrayList<>();
        inOrderTraversal(root, students);
        return students;
    }

    private void inOrderTraversal(Node node, ArrayList<Student> students) {
        if (node != null) {
            inOrderTraversal(node.left, students);
            students.add(node.student);
            inOrderTraversal(node.right, students);
        }
    }
    private Student minValue(Node root) {
        Student minv = root.student;
        while (root.left != null) {
            minv = root.left.student;
            root = root.left;
        }
        return minv;
    }
}
