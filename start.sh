#!/bin/sh

if [ "$JRUN" == "true" ]; then
    cd /JavaOne && make run 
else
    tail -f /dev/null
fi
