#!/bin/bash

  if [ $# -ne 3 ]; then
    echo "Please provide host, port and script"
    exit 1
  fi
healthCheck() {
  echo "In healthCheck";
  dpkg -s netcat

  if [ $? -ne 0 ]; then
    apt-get update
    apt-get install netcat --assume-yes
  fi
  host=$1
  port=$2
  count=0
  while ! nc -vz $host $port; do
    echo "unable to reach host. sleeping for 1 sec"
    sleep 5
    count=$((count + 1))
    if [ $count -eq 60 ]; then
      echo "host not reachable for 5 min, Exiting"
      exit 1
    fi
  done
}

execute(){
  echo "in execute $1 $2";
  host=$1
  mysql -h "$host" -u root -proot < /"$2"
}

healthCheck "$1" "$2"
execute "$1" "$3"