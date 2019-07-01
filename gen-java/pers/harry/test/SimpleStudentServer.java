package pers.harry.test;

import org.apache.thrift.transport.*;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TServer.Args;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pers.harry.test.StudentService.Processor;


public class SimpleStudentServer {

    private static final Logger logger = LoggerFactory.getLogger(SimpleStudentServer.class.getName());

    public void startServer() {
        try {

            TServerSocket serverTransport = new TServerSocket(9090);
            StudentService.Processor process =
                    new StudentService.Processor<StudentService.Iface>(new StudentServiceImpl());

            Factory protocolFactory = new TBinaryProtocol.Factory(true, true);

            Args args = new Args(serverTransport);
            args.processor(process);
            args.protocolFactory(protocolFactory);

            logger.info("Simple server start");
            TServer server = new TSimpleServer(args);
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SimpleStudentServer server = new SimpleStudentServer();
        server.startServer();
    }
}
