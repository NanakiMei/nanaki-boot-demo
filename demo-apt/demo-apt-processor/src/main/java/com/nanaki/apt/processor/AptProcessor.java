package com.nanaki.apt.processor;

import com.nanaki.apt.processor.annotation.Apt;
import com.nanaki.apt.processor.constants.AptConstant;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.FileObject;
import javax.tools.StandardLocation;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2023/9/26
 */
//@SupportedAnnotationTypes("com.nanaki.apt.processor.annotation.Apt")
//@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class AptProcessor extends AbstractProcessor {

    private final Map<String, String> properties = new TreeMap<>();

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("AptProcessor ==========================");

        for (Element element : roundEnv.getElementsAnnotatedWith(Apt.class)) {
            System.out.println("annotation:" + element.getSimpleName().toString());
            Apt annotation = element.getAnnotation(Apt.class);
            properties.put(annotation.value(), annotation.version());
        }

        // 注解处理完成，创建配置文件
        if (roundEnv.processingOver()) {
            try {
                generateConfigFiles();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        return true;
    }

    private void generateConfigFiles() throws IOException {
        FileObject file = this.processingEnv.getFiler().createResource( StandardLocation.CLASS_OUTPUT, "", AptConstant.PROPERTIES_FILE );
        try (Writer writer = new OutputStreamWriter( file.openOutputStream(), StandardCharsets.UTF_8 )) {
            for (Map.Entry<String, String> entry : this.properties.entrySet()) {
                writer.append( entry.getKey() );
                writer.append( "=" );
                writer.append( entry.getValue() );
                writer.append( System.lineSeparator() );
            }
        }
    }

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {

        // Element操作类，用来处理Element的工具
        Elements elementUtils = processingEnv.getElementUtils();

        // 类信息工具类，用来处理TypeMirror的工具
        Types typeUtils = processingEnv.getTypeUtils();

        // 日志工具类，因为在process()中不能抛出一个异常，那会使运行注解处理器的JVM崩溃。
        // 所以Messager提供给注解处理器一个报告错误、警告以及提示信息的途径，用来写一些信息给使用此注解器的第三方开发者看
        Messager messager = processingEnv.getMessager();

        // 文件工具类，常用来读取或者写资源文件
        Filer filer = processingEnv.getFiler();

        super.init(processingEnv);
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        // 用来指定需要处理的注解集合，返回的集合元素需要是注解全路径（包名+类名）
        // 默认读取 @SupportedAnnotationTypes
        // return Collections.singleton(Apt.class.getName());
//        return super.getSupportedAnnotationTypes();
        return Collections.singleton(Apt.class.getCanonicalName());
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        // 用来指定当前正在使用的Java版本，一般返回SourceVersion.latestSupported()表示最新的java版本即可
        // 默认读取 @SupportedSourceVersion
         return SourceVersion.RELEASE_8;
//        return super.getSupportedSourceVersion();
    }
}
