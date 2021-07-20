package com.basic.lambdaExpression;

public class LambdaExpressionDemo {


    private String value = "Enclosing scope value";

    public String scopeExperiment() {
        String d= "ee";


        Foo fooIC = new Foo() {
            String value = "Inner class value";

            @Override
            public String method(String string) {
                return this.value;
            }
        };
        String resultIC = fooIC.method("");

        Foo fooLambda = parameter -> {
            this.value = "Lambda value";
            return value;
        };
        String resultLambda = fooLambda.method("");

        return "Results: resultIC = " + resultIC +
                ", resultLambda = " + resultLambda;
    }

    public static void main(String[] args) {
        LambdaExpressionDemo demo = new LambdaExpressionDemo();
        System.out.println(demo.scopeExperiment());
    }
}

interface Foo {
    String method(String string);
}