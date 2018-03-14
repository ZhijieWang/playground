build:	
	go build
run: 
	@echo  "Program Output Below\n"
	@cat input.txt  | go run main.go > output.txt; 
	@cat output.txt;
	@echo "\nEnd of Program Output\n" 
	@echo "------------------------------"
	@echo "Comparing Output to Answer"
	@sed -i 's/[ \t]*$$//' output.txt;
	@cmp -s output.txt answer.txt; \
	RETVAL=$$?; \
	if [ $$RETVAL -eq 0 ]; then \
   	printf  "PASS\n"; \
	else \
   	printf "FAILED\n"; \
	fi

