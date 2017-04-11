@echo off

java -cp ^
target\classes\;^
%HOME%\.m2\repository\com\rabbitmq\amqp-client\4.1.0\amqp-client-4.1.0.jar;^
%HOME%\.m2\repository\org\slf4j\slf4j-api\1.7.21\slf4j-api-1.7.21.jar;^
%HOME%\.m2\repository\org\slf4j\slf4j-nop\1.7.21\slf4j-nop-1.7.21.jar ^
com.github.dgarcia202.App
