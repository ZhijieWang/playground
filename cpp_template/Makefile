PROJECT := GeekforGeek
CC=g++
CFLAGS=-I.
SRC_EXT = c

make: main.cpp
	@$(CC) -o main main.cpp
run : main
	@echo  "Program Output Below\n"
	@./main; 
	@echo "\nEnd of Program Output\n" 
	@echo "------------------------------"
	@echo "Comparing Output to Answer"
	@cmp -s output.txt answer.txt; \
	RETVAL=$$?; \
	if [ $$RETVAL -eq 0 ]; then \
    	printf  "PASS"; \
	else \
    	printf "FAILED"; \
	fi

