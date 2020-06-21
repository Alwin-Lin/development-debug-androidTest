#!/bin/bash
# Parse a release

if [[ -z $INDIR ]]; then
    echo to set INDIR="path/to/release/folder"
    exit
fi

if [[ -z $OUTDIR ]]; then
    echo to set OUTDIR="path/to/output/folder"
    exit
fi

if [[ -z $REL_PARSER_JAR ]]; then
    echo to set REL_PARSER_JAR="path/to/releaseParser.jar"
    exit
fi

if [[ -z $JAVA ]]; then
    echo to set JAVA="path/to/java9+"
    exit
fi

which aapt
echo Need aapt in the PATH

$JAVA -version
echo "Need Java version >=9"

echo Clean up $OUTDIR
rm -rf $OUTDIR
mkdir -p $OUTDIR

$JAVA -jar $REL_PARSER_JAR -i $INDIR -o $OUTDIR -a 28