package pers.harry.test;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class StudentServiceImpl implements StudentService.Iface {

    private HashMap<Integer, String> snoSnameMap = new HashMap<>();
    private Lock lock = new ReentrantLock();
    public void put(Student student) {
        lock.lock();
        snoSnameMap.put(student.sno, student.sname);
        lock.unlock();
    }

    public Student get(int sno) {
        Student student = new Student();
        student.sno = sno;
        student.sname = snoSnameMap.get(sno);
        if (student.sname == null) {
            student.sname = "";
        }
        student.setSnameIsSet(true);
        return student;
    }
}
