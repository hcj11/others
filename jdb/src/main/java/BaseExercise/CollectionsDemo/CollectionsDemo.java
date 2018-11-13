package BaseExercise.CollectionsDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by hcj on 18-8-8
 */
public class CollectionsDemo {

  public static void main(String[] args) {
//    demo1();
//    demo2();
//    demo3();
    demo4();
  }

  private static void demo4() {
    // List<Student>  -> Map<List<Student>>
    List<Student> students = new ArrayList<>();
    students.add(new Student("1", "2", Sex.FEMALE));
    students.add(new Student("2", "3", Sex.FEMALE));
    students.add(new Student("2", "4", Sex.MALE));
    students.add(new Student("4", "5", Sex.MALE));
    students.add(new Student("4", "6", Sex.MALE));
    Student build = Student.builder().Name("").No("").build();

    // method two
//    Map<String, List<Student>> collect = students.stream()
//        .collect(Collectors.groupingBy(Student::getNo));
    HashMap<String, List<Student>> map = new HashMap<>();
    // 重写equal and hashCode ?
    for (Student student : students) {
      List<Student> students1 = map.get(student.getNo());

      if (null== students1){
        List<Student> students2 = new ArrayList<>();
        students2.add(student);
        map.put(student.getNo(),students2);
      }else{
        if (students1.contains(student)) {
          students1.add(student);
        }
      }


    }

    System.out.println(map);
  }

  private static void demo3() {
    // List<Student>  -> Map<List<Student>>
    List<Student> students = new ArrayList<>();
    students.add(new Student("1", "2", Sex.FEMALE));
    students.add(new Student("2", "3", Sex.FEMALE));
    students.add(new Student("2", "4", Sex.MALE));
    students.add(new Student("4", "5", Sex.MALE));
    students.add(new Student("4", "6", Sex.MALE));
    // method one
    Map<String, List<Student>> collect = students.stream()
        .collect(Collectors.groupingBy(Student::getNo));
    System.out.println(collect);


  }


  private static void demo2() {
    String[] ss = {"d", "b", "1", "2", "e"};
    Set<String> list = new HashSet<>();
    list.add("g");
    Collections.addAll(list, ss);
    System.out.println(list);
  }

  private static void demo1() {
    String[] ss = {"d", "b", "1", "2", "e"};
    List<String> list = new ArrayList<>();
    list.add("g");
    Collections.addAll(list, ss);
    System.out.println(list);
  }

  @Setter
  @Getter
  @ToString
  @Builder
  static class Student {

    private String No;
    private String Name;
    private Sex sex;

    public Student() {
    }

    public Student(String no, String name, Sex sex) {
      No = no;
      Name = name;
      this.sex = sex;
    }

    @Override
    public boolean equals(Object obj) {
      // 自反性，一致性，
      if (obj == null) {
        return false;
      }
      if (obj instanceof Student) {
        if (((Student) obj).getNo().equals(this.getNo())) {
          return true;
        } else {
          return false;
        }
      } else {
        return false;
      }
    }

    @Override
    public int hashCode() {
      return super.hashCode();
    }
  }

  enum Sex {
    FEMALE, MALE
  }
}
