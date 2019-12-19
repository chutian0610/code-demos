# maven 方式使用注解

执行命令：

```
mvn clean package
```

在输出中可以看到：

```
[INFO] found @ClassInfoPrinter at info.victorchu.demos.App
```

## 说明

项目目录如下:

```text
.
├── pom.xml
├── processed
├── processor
└── README.md
```

* processor 模块是编译期注解相关代码
* processed 模块是用于演示的demo

在 processed 模块的pom文件中可以看到如下片段:

```xml
<build>
    <plugins>
        <plugin>
            <artifactId>maven-compiler-plugin</artifactId>
            <configuration>
                <annotationProcessors>
                   <annotationProcessor>info.victorchu.demos.processor.ClassInfoPrinterProcessor</annotationProcessor>
                </annotationProcessors>
                <showWarnings>true</showWarnings>
            </configuration>
        </plugin>
    </plugins>
</build>
```
