import java.util.List;
import java.util.ArrayList;
public class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList() {
        head = null;
    }

    public void add2(Student student) {
        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public Student search2(Integer studentID) {
        Node temp = head;
        while (temp != null) {
            if (temp.student.getStudentID().equals(studentID)) {
                return temp.student;
            }
            temp = temp.next;
        }
        return null;
    }

    public void delete2(Integer studentID) {
        if (head == null) return;

        if (head.student.getStudentID().equals(studentID)) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && !temp.next.student.getStudentID().equals(studentID)) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public void display2() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.student);
            temp = temp.next;
        }
    }

    private class Node {
        Student student;
        Node next;

        public Node(Student student) {
            this.student = student;
            this.next = null;
        }
    }
}

