package org.example.refl;

import org.example.Pessoa;

public class ObjectToJsonTester {
    public static void main(String... x) {
        Pessoa pessoa = new Pessoa(1, "Joao", "123456");
        ObjectToJson objectToJson = new ObjectToJson();

        System.out.println(objectToJson.transform(pessoa));
    }
}
