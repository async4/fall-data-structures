SOURCE_DIR		:= Source/
BUILD_DIR		:= Build/Classes/
RES_DIR			:= Resources/
MAIN_FILE		:= App

RM					:= rm -rf
SIZE				:= du -sh
JAVA				:= java
JAVAC				:= javac

JFLAGS			:= -g									\
						-sourcepath $(SOURCE_DIR)	\
						-d $(BUILD_DIR)				\

SUFFIX_JAVA		:= *.java
SUFFIX_CLASS	:= *.class

INFO				:= echo "\e[32m[OK]\e[0m" || echo "\e[31m[ERROR]\e[0m"


all: compile

.PHONY: compile
compile:
	@ $(JAVAC) $(JFLAGS) $(SOURCE_DIR)$(SUFFIX_JAVA) &&\
		cp $(RES_DIR) -r $(BUILD_DIR)							 &&\
		$(INFO)

.PHONY: run
run:
	@ cd $(BUILD_DIR) &&\
		$(JAVA) $(MAIN_FILE) 

.PHONY: clean
clean:
	@ $(RM) $(BUILD_DIR)$(SUFFIX_CLASS) &&\
		$(INFO)

.PHONY: delete
delete:
	@ $(RM) Build/ &&\
		$(INFO)
