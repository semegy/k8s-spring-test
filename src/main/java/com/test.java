package com;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class test {
    public static void main(String[] args) throws IOException {
        // Write file
        FileOutputStream inputStream = new FileOutputStream("D:\\workspace\\spring-test\\src\\main\\java\\com\\MealFactory.java");
        String s = "package com.compiler;\n" +
                "public class MargheritaPizzaFactory implements Meal{\n" +
                "    @Override\n" +
                "    public float getPrice() {\n" +
                "        return 0.1f;\n" +
                "    }\n" +
                "}\n";
        inputStream.write(s.getBytes(StandardCharsets.UTF_8));
        inputStream.flush();
    }

}
