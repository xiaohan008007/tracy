package com.tracy.jdk6.scripting;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class HelloScript {
         public static void main(String[] args) throws Exception {
                   ScriptEngineManager factory = new ScriptEngineManager();//step 1
                   ScriptEngine engine = factory.getEngineByName("JavaScript");//Step 2
                   engine.eval("print('Hello, Scripting')");//Step 3
         }
}