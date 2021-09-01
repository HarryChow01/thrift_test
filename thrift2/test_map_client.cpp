
#include <memory>
#include <iostream>
#include <string>
#include <map>

#include <thrift/transport/TSocket.h>
#include <thrift/transport/TBufferTransports.h>
#include <thrift/protocol/TBinaryProtocol.h>

#include "gen-cpp/TestMapService.h"

using namespace apache::thrift;
using namespace apache::thrift::protocol;
using namespace apache::thrift::transport;

const size_t kStrLen = 1023;
const size_t kMapSize = 80 * 1024;
const size_t kLoopNum = 1;

void pushMapData() {
    std::shared_ptr<TSocket> socket(new TSocket("localhost", 9090));
    std::shared_ptr<TTransport> transport(new TFramedTransport(socket));
    std::shared_ptr<TProtocol> protocol(new TBinaryProtocol(transport));

    const std::string data(kStrLen, 'x');
    std::map<int64_t, std::string> mapData;
    for (int i = 0; i < kMapSize; ++i) {
        int64_t key = 10000 + i + 1;
        mapData.emplace(key, data);
    }

    transport->open();
    TestMapServiceClient client(protocol);

    for (int i = 0; i < kLoopNum; ++i) {
        int64_t reqId = i + 1;
        client.pushData(reqId, mapData);
    }

    transport->close();
}

int main(int argc, char **argv) {
    pushMapData();
    return 0;
}


