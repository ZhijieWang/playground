PROJECT := GeekforGeek
CC=javac
CFLAGS=-I.
SRC_EXT = c

make: main.java
	@$(CC) main.java
run : main.class 
	@echo  "Program Output Below\n"
	@tee input.txt  | java main; 
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

