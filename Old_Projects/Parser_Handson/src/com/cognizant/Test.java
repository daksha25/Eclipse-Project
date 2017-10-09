package com.cognizant;
import java.io.FileInputStream;

import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.visitor.VoidVisitorAdapter;

public class Test
  {
	  public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("D:\\eclipse\\eclips projects\\Parser_Handson\\src\\com\\test\\Java8Lexer.java");
        CompilationUnit cu = JavaParser.parse(in);
        
        new MethodVisitor().visit(cu, null);
        
	  }
	  
        private static class MethodVisitor extends VoidVisitorAdapter<Object>{
       
          
            public void visit(MethodDeclaration n, Object arg) {
            
                System.out.println(n.getName());
                super.visit(n, arg);
            }
    
}
  }
  