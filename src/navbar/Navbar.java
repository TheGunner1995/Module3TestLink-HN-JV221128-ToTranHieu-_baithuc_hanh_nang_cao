package navbar;

import model.Student;

import java.util.Arrays;
import java.util.Scanner;

public class Navbar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        Student list[] = new Student[100];
        list[0] = new Student(1, "nam", 18);
        list[1] = new Student(2, "khiet", 20);
        list[2] = new Student(3, "hieu", 19);
        do {
            System.out.println("********STUDENT MANAGE ********");
            System.out.println("1. Show List Student.");
            System.out.println("2. Create Student.");
            System.out.println("3. Update Student.");
            System.out.println("4. Delete Student.");
            System.out.println("5. Sort Student By Age ASC (tăng dần).");
            System.out.println("6. Exit.");
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    for (int i = 0; i < list.length; i++) {
                        if (list[i] == null) {
                            continue;
                        } else {
                            System.out.println(list[i]);
                        }
                    }
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("Nhập student name : ");
                    String stName = scanner.nextLine();
                    System.out.println("Nhập tuổi : ");
                    int age = scanner.nextInt();
                    for (int i = 0; i < list.length; i++) {
                        if (list[i] == null) {
                            list[i] = new Student(list[i - 1].studentId + 1, stName, age);
                            break;
                        }
                    }
                    for (int i = 0; i < list.length; i++) {
                        if (list[i] == null) {
                            continue;
                        } else {
                            System.out.println(list[i]);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Nhập Id mà bạn muốn sửa : ");
                    int id = scanner.nextInt();
                    if (list[id - 1] != null) {
                        scanner.nextLine();
                        System.out.println("Nhập tên thay đổi : ");
                        String updateName = scanner.nextLine();
                        System.out.println("Nhập tuổi thay đổi : ");
                        int updateAge = scanner.nextInt();
                        list[id - 1].studentName = updateName;
                        list[id - 1].age = updateAge;
                        for (int i = 0; i < list.length; i++) {
                            if (list[i] == null) {
                                continue;
                            } else {
                                System.out.println(list[i]);
                            }
                        }
                    } else {
                        System.out.println("id bạn nhập không tồn tại");
                    }
                    break;
                case 4:
                    System.out.println("Nhập idDelete : ");
                    int idDel = scanner.nextInt();
                    if (list[idDel - 1] != null) {
                        Student newList[] = new Student[100];
                        for (int i = 0; i < list.length; i++) {
                            if (i == idDel - 1) {
                                break;
                            }
                            newList[i] = list[i];
                        }
                        for (int i = 0; i < newList.length; i++) {
                            if (i == idDel - 1) {
                                newList[i] = list[idDel];
                            }
                        }
                        for (int i = 0; i < newList.length; i++) {
                            list[i] = newList[i];
                        }
                        for (int i = 0; i < list.length; i++) {
                            if (list[i] == null) {
                                continue;
                            } else {
                                System.out.println(list[i]);
                            }
                        }
                    } else {
                        System.out.println("id bạn nhập k tồn tại");
                    }
                    break;
                case 5:
                    Student temp;
                    for (int i = 0; i < list.length; i++) {
                        if (list[i] == null) {
                            continue;
                        } else {
                            for (int j = i + 1; j < list.length; j++) {
                                if (list[j] == null) {
                                    continue;
                                } else if (list[i].age > list[j].age) {
                                    temp = list[j];
                                    list[j] = list[i];
                                    list[i] = temp;
                                }
                            }
                        }
                    }
                    for (int i = 0; i < list.length; i++) {
                        if (list[i] == null) {
                            continue;
                        } else {
                            System.out.println(list[i]);
                        }
                    }
                    break;
                case 6:
                    System.exit(0);
                default:
                    break;
            }
        } while (true);
    }
}
