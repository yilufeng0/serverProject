@echo off
start
D:\ffmpeg\bin\ffmpeg.exe -i %1 -ss 1 -vframes 1 -r 1 -ac 1 -ab 2 -s %2 -f image2 %3 -y
exit