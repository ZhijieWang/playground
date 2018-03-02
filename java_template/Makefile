PROJECT := GeekforGeek

JFLAGS = -g

JC = javac

.SUFFIXES: .java .class

.java.class:

		$(JC) $(JFLAGS) $*.java

CLASSES = run.java

MAIN = Main

default: classes

classes: $(CLASSES:.java=.class)

# run: classes
# 	$(JVM) $(MAIN)
clean:
	$(RM) *.class
run : run.class 
	@echo  "Program Output Below\n"
	@cat input.txt  | java run > output.txt; 
	@cat output.txt;
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

