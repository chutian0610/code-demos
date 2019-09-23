package info.victorchu.demos.processor;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

/**
 * @Author victor
 * @Email victorchu0610@outlook.com
 * @Version 1.0
 * @Description 编译期注解处理器
 */

// 注解处理器支持的注解
@SupportedAnnotationTypes(
        "info.victorchu.demos.annotation.ClassInfoPrinter")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class ClassInfoPrinterProcessor extends AbstractProcessor {
    
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        // annotations 是注解处理器要处理的所有注解
        // 此处只有 @ClassInfoPrinter
        for (TypeElement  annotation: annotations) {
            for ( Element element : roundEnv.getElementsAnnotatedWith(annotation) ) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "found @ClassInfoPrinter at " + element);
            }
        }
        return false;
    }
}
