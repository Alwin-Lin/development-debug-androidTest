#!/bin/bash
# Parse a release
MY_NAME=$0 # = "/path/to/test.sh"
MY_FILENAME=${MY_NAME##*/} # = "test.sh"
MY_DIR=${MY_NAME%/$MY_FILENAME} # = "/path/to"

echo Script dir = $MY_DIR

INDIR="$MY_DIR/releaseParserSrc/tests/resources" \
    OUTDIR="$HOME/jar-ci/workspace/tmp/testReleaseParser" \
    REL_PARSER_JAR="$HOME/jar-ci/workspace/releaseParserProj/build/libs/releaseParser.jar" \
    JAVA="/usr/bin/java" \
    $MY_DIR/releaseParser.sh