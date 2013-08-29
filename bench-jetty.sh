#!/bin/sh -e
ulimit -n 10000
# run once for warmup
ab -n 1000 -c 1000 -r http://127.0.0.1:8888/index.html > warmup.log 2> warmup.err
# run again
ab -n 200000 -c 8000 -r http://127.0.0.1:8888/test15K.html
# Test
# Test2 (merge)
