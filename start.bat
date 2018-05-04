@echo off
:check
set hr=%TIME:~0,2%
if %hr:~0,1% == " " && %hr:~1,2% == 1 (
java -jar C:\Users\Student\Desktop\current.jar
exit
)

timeout /t 1 /nobreak
GOTO :check