PROJECT := GeekforGeek

JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        main.java 

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
run : main.class 
	@echo  "Program Output Below\n"
	@cat input.txt  | java main > output.txt; 
	@cat output.txt;
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

