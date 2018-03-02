PROJECT := GeekforGeek
CC=gcc
CFLAGS=-I.
SRC_EXT = c

make: main.c
	@$(CC) -o main main.c
run : main
	@echo  "Program Output Below\n"
	@./main; 
	@echo "\nEnd of Program Output\n" 
	@echo "------------------------------"
	@echo "Comparing Output to Answer"
	@cmp -s output.txt answer.txt; \
	RETVAL=$$?; \
	if [ $$RETVAL -eq 0 ]; then \
    	printf  "PASS\n"; \
	else \
    	printf "FAILED\n"; \
	fi

