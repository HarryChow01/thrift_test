#!/bin/bash

../common/thrift-0.10.0/bin/thrift -r --gen cpp student.thrift
../common/thrift-0.10.0/bin/thrift -r --gen java student.thrift
mkdir -p build

