
#include <iostream>
#include <string>

#include <thrift/transport/TSocket.h>
#include <thrift/transport/TBufferTransports.h>
#include <thrift/protocol/TBinaryProtocol.h>

#include "StudentService.h"

using namespace apache::thrift;
using namespace apache::thrift::protocol;
using namespace apache::thrift::transport;

using boost::shared_ptr;

int main(int argc, char **argv)
{
    boost::shared_ptr<TSocket> socket(new TSocket("localhost", 9090));
    boost::shared_ptr<TTransport> transport(new TFramedTransport(socket));
    boost::shared_ptr<TProtocol> protocol(new TBinaryProtocol(transport));

    transport->open();

    Student s1;
    s1.sno = 1001;
    s1.__set_sname("Zhou");
    //s1.sname = "Zhou";
    //s1.__isset.sname = true;

    std::cout << "student s1: " << s1 << std::endl;

    StudentServiceClient client(protocol);

    client.put(s1);

    Student s2;
    s2.sno = 1001;
    std::cout << "first student s2: " << s2 << std::endl;
    client.get(s2, s2.sno);
    std::cout << "second student s2: " << s2 << std::endl;

    transport->close();

    return 0;
}


