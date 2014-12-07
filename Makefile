JAR_NAME=myHelloEjb.jar

all: compile package

compile:
	javac org/acme/*.java

package: compile
	jar cvf $(JAR_NAME) org META-INF

deploy:
	openejb deploy -a -m $(JAR_NAME)

undeploy:
	openejb undeploy $(OPENEJB_HOME)/apps/$(JAR_NAME)

redeploy: undeploy deploy

client: compile
	java -Dopenejb.home=$(OPENEJB_HOME) org.acme.HelloWorld

clean:
	@rm *~ org/acme/*~ org/acme/*.class $(JAR_NAME) 2> /dev/null ; echo -n ""

