package com.compiler;


import com.google.auto.service.AutoService;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

@AutoService(Processor.class)
@SupportedAnnotationTypes("com.compiler.Factory")
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class FactoryProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Set<? extends Element> elementsAnnotatedWith = roundEnv.getElementsAnnotatedWith(Factory.class);
        if (elementsAnnotatedWith.size() == 0) {
            return false;
        }
        Iterator<? extends Element> iterator = elementsAnnotatedWith.iterator();
        while (iterator.hasNext()) {
            Element element = iterator.next();
            try {
                // Generate code
                String simpleName = element.getSimpleName().toString() + "Factory";
                FileOutputStream inputStream = new FileOutputStream("out\\com\\example\\springtest\\" + simpleName + ".java");
                String s = "package com.example.springtest;\n" +
                        "import com.compiler.Meal;\n" +
                        "public class ";
                s += simpleName + " implements Meal{\n" +
                        "    @Override\n" +
                        "    public float getPrice() {\n" +
                        "        return 0.1f;\n" +
                        "    }\n" +
                        "}\n";
                inputStream.write(s.getBytes(StandardCharsets.UTF_8));
                inputStream.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }
}
