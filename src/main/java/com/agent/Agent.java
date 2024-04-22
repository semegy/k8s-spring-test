package com.agent;

//import com.sun.tools.attach.*;

//import java.io.IOException;
//import java.lang.instrument.ClassFileTransformer;
//import java.lang.instrument.IllegalClassFormatException;
//import java.lang.instrument.Instrumentation;
//import java.security.ProtectionDomain;

public class Agent {
//    public static void premain(String args, Instrumentation instrumentation) {
//        instrumentation.addTransformer(new ClassFileTransformer() {
//            @Override
//            public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
////                System.out.println(System.currentTimeMillis() + className);
//                return classfileBuffer;
//            }
//        });
//    }

//    public static void agentmain(String args, Instrumentation instrumentation) {
//        instrumentation.addTransformer(new ClassFileTransformer() {
//            @Override
//            public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
//                System.out.println(System.currentTimeMillis() + className);
//                return classfileBuffer;
//            }
//        });
//    }

//    public static void main(String[] args) throws IOException, AttachNotSupportedException, AgentLoadException, AgentInitializationException, InterruptedException {
//        do {
//            for (VirtualMachineDescriptor virtualMachineDescriptor : VirtualMachine.list()) {
//                if (virtualMachineDescriptor.displayName().equals("com.example.springtest.SpringTestApplication")) {
//                    String id = virtualMachineDescriptor.id();
//                    VirtualMachine attach = VirtualMachine.attach(id);
//                    attach.loadAgent("D:\\workspace\\spring-test\\target\\spring-test-0.0.1-SNAPSHOT.jar");
//                    attach.detach();
//                }
//            }
//            Thread.sleep(100);
//        } while (true);
//
//    }
}
