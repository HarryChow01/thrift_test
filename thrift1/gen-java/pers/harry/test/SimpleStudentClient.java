package pers.harry.test;

import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleStudentClient {
    private static final Logger logger = LoggerFactory.getLogger(SimpleStudentClient.class.getName());

    public static void main(String[] args) {
        try {
            TTransport transport = new TSocket("127.0.0.1", 9090);
            TProtocol protocol = new TBinaryProtocol(transport);
            StudentService.Client client = new StudentService.Client(protocol);
            transport.open();

            Student s1 = new Student();
            s1.sno = 1001;
            s1.setSname("Zhou");

            logger.info("student s1: " + s1);
            client.put(s1);

            Student s2 = new Student();
            s2.sno = 1001;
            logger.info("first student s2: " + s2);
            s2 = client.get(s2.sno);
            logger.info("second student s2: " + s2);

            transport.close();

        } catch (TException e) {
            e.printStackTrace();
        }
    }
}
