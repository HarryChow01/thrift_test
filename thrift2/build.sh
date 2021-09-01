#!/bin/bash

thrift -r --gen cpp test_map.thrift
mkdir -p build

