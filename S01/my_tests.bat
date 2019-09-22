::my_tests.bat
@java -cp .;J:\jxtra Decoder
@echo 1==========
@pause
@java -cp .;J:\jxtra Decoder hello.enc hello.ptx
::@type hello.ptx
@fc hello.txt hello.ptx
@echo 2==========
@pause
@java -cp .;J:\jxtra Decoder sample.enc sample.ptx
::@type sample.ptx
@fc sample.txt sample.ptx
@echo 3==========
@pause
@java -cp .;J:\jxtra Decoder gtyburg.enc gtyburg.ptx
::@type gtyburg.ptx
@fc gtyburg.txt gtyburg.ptx
@echo 4==========
@pause
