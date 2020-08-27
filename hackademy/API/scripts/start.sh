#!/usr/bin/env bash

set -euo pipefail


BASE=$(dirname $0)/..
cd $BASE

VERSION=$(cat daml.yaml | grep version | grep -v sdk-version | tr -d ' ' | cut -d':' -f2 | tr -d '\n' | tr -d '\r')
APP_JAR=./target/karma-0.0.1-SNAPSHOT.jar

APP_PIDS=""

CSI="\033["
viewport=$(($(tput lines) - 2))
cmd=$((viewport + 1))
status=$((cmd + 1))

waitport() {
    while ! nc -z localhost $1 ; do sleep 1 ; done
}

stop() {
# terminate all the apps and the sandbox
  printf "${CSI}2J${CSI}1;$(tput lines)r"  # reset screen scroll
  echo Stopping applications...
  kill $APP_PIDS > /dev/null 2>&1
  sleep 3
  exit 0
}

trap stop 1 2 3 15

startSandbox() {
  echo ">> Starting Sandbox..."
  daml sandbox -- --wall-clock-time --port 6865 target/hackademy.dar &
  APP_PIDS="$APP_PIDS $!"
  waitport 6865
  echo "<< Sandbox ready"
  echo ""
}

startNavigator() {
  echo ">> Starting Navigator..."
  daml navigator -- server localhost 6865 --port 7500 &
  APP_PIDS="$APP_PIDS $!"
  waitport 7500
  echo "<< Navigator ready"
  echo ""
}

startApp() {
  echo ">> Starting App..."
  java -jar $APP_JAR $@ &
  APP_PIDS="$APP_PIDS $!"
  waitport 8080
  echo "<< App ready"
  echo ""
}

# Clear screen and set the scroll area
printf "${CSI}2J${CSI}1;${viewport}r"

startSandbox
startNavigator
#startApp

cmdpre="${CSI}${cmd};1H${CSI}2K"

printf "$cmdpre"
while read -p "Running, [S]top > " line
do
  case $line in
  stop|s|S) break ;;
  *) ;;
  esac
  printf "$cmdpre"
done

stop
