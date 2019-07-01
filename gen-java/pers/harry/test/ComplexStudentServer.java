package pers.harry.test;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pers.harry.test.StudentService.Processor;


public class ComplexStudentServer {
    private static final Logger logger = LoggerFactory.getLogger(ComplexStudentServer.class.getName());

    public void startServer() {
        try {
            TNonblockingServerTransport serverSocket = new TNonblockingServerSocket(9090);
            TThreadedSelectorServer.Args args = new TThreadedSelectorServer.Args(serverSocket);
            args.protocolFactory(new TBinaryProtocol.Factory());
            args.processor(new StudentService.Processor<StudentService.Iface>(new StudentServiceImpl()));

            logger.info("Complex server start");
            TServer server = new TThreadedSelectorServer(args);
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ComplexStudentServer complexStudentServer = new ComplexStudentServer();
        complexStudentServer.startServer();
    }
}
