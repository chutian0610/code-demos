# java-size-agent

## Instrumentation

```bash
mvn clean package
cd target
java -XX:-UseCompressedOops -javaagent:java-size-agent-1.0-SNAPSHOT.jar -jar java-size-agent-1.0-SNAPSHOT.jar 
```