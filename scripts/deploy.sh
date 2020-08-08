#!/bin/bash

REPOSITORY=/home/ec2-user/app/step2
PROJECT_NAME=springboot

echo "> Build file copy"
cp $REPOSITORY/zip/*.jar $REPOSITORY/

echo "> Checking current working application pid"
CURRENT_PID=$(pgrep -fl springboot | grep jar | awk '{print $1}')
echo "> PID : $CURRENT_PID"

if [ -z "$CURRENT_PID" ]; then
  echo "> No terminated : There is no working application."
else
  echo "> kill -15 $CURRENT_PID"
  kill -15 $CURRENT_PID
  sleep 5
fi

echo "> Deploy new application"
JAR_NAME=$(ls -tr $REPOSITORY/*.jar | tail -n 1)
echo "> JAR name : $JAR_NAME"

echo "> Add a execution to JAR"
chmod +x $JAR_NAME
echo "> Start $JAR_NAME"

nohup java -jar \
 -Dspring.config.location=classpath:/application.yml,/home/ec2-user/app/application-oauth.yml,\
/home/ec2-user/app/application-real-db.yml,classpath:/application-real.yml \
 -Dspring.profiles.active=real \
 $JAR_NAME > $REPOSITORY/nohup.out 2>&1 &