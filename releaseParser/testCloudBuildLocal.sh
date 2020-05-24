cloud-build-local --dryrun=false --write-workspace=$HOME/jar-ci .
ls -l  $HOME/jar-ci/workspace/releaseParserProj/build/libs/releaseParser.jar 