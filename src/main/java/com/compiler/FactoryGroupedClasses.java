package com.compiler;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class FactoryGroupedClasses {

    /**
     * Will be added to the name of the generated factory class
     */
    private static final String SUFFIX = "Factory";

    private String qualifiedClassName;

    private Map<String, FactoryAnnotatedClass> itemsMap =
            new LinkedHashMap<String, FactoryAnnotatedClass>();

    public FactoryGroupedClasses(String qualifiedClassName) {
        this.qualifiedClassName = qualifiedClassName;
    }

    /**
     * Adds an annotated class to this factory.
     *
     * @throws ProcessingException if another annotated class with the same id is
     * already present.
     */
    public void add(FactoryAnnotatedClass toInsert) throws ProcessingException {


        // Write file
//        JavaFile.builder(packageName, typeSpec).build().writeTo(filer);
    }

    /**
     * Generate the java code
     *
     * @throws IOException

    public void generateCode(Elements elementUtils, Filer filer) throws IOException {

    TypeElement superClassName = elementUtils.getTypeElement(qualifiedClassName);
    String factoryClassName = superClassName.getSimpleName() + SUFFIX;

    JavaFileObject jfo = filer.createSourceFile(qualifiedClassName + SUFFIX);
    Writer writer = jfo.openWriter();
    JavaWriter jw = new JavaWriter(writer);

    // Write package
    PackageElement pkg = elementUtils.getPackageOf(superClassName);
    if (!pkg.isUnnamed()) {
    jw.emitPackage(pkg.getQualifiedName().toString());
    jw.emitEmptyLine();
    } else {
    jw.emitPackage("");
    }

    jw.beginType(factoryClassName, "class", EnumSet.of(Modifier.PUBLIC));
    jw.emitEmptyLine();
    jw.beginMethod(qualifiedClassName, "create", EnumSet.of(Modifier.PUBLIC), "String", "id");

    jw.beginControlFlow("if (id == null)");
    jw.emitStatement("throw new IllegalArgumentException(\"id is null!\")");
    jw.endControlFlow();

    for (FactoryAnnotatedClass item : itemsMap.values()) {
    jw.beginControlFlow("if (\"%s\".equals(id))", item.getId());
    jw.emitStatement("return new %s()", item.getTypeElement().getQualifiedName().toString());
    jw.endControlFlow();
    jw.emitEmptyLine();
    }

    jw.emitStatement("throw new IllegalArgumentException(\"Unknown id = \" + id)");
    jw.endMethod();

    jw.endType();

    jw.close();
    }

     */

}
