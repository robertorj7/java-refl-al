package org.example.refl;

import org.example.Endereco;
import org.example.Pessoa;
import org.example.PessoaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

public class TransformatorTest {
    Pessoa pessoa = new Pessoa(1, "Carlos", "123456");
    Pessoa pessoaNull = new Pessoa(2, "", "");
    Endereco endereco = new Endereco("Av. São Paulo", 1001);

    @Test
    public void shouldTransform() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Transformator transformator = new Transformator();
        PessoaDTO dto = transformator.transform(pessoa);

        Assertions.assertInstanceOf(PessoaDTO.class, dto);
        Assertions.assertEquals(pessoa.getNome(), dto.getNome());
        Assertions.assertEquals(pessoa.getCpf(), dto.getCpf());
    }

    @Test
    public void shouldNotTransform() {
        Assertions.assertThrows(ClassNotFoundException.class, () -> {
            Transformator transformator = new Transformator();
            transformator.transform(endereco);
        });
    }

    @Test
    public void shouldTransformWithSomeFieldNull() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Transformator transformator = new Transformator();
        PessoaDTO dto = transformator.transform(pessoaNull);

        Assertions.assertInstanceOf(PessoaDTO.class, dto);
        Assertions.assertEquals(pessoaNull.getNome(), dto.getNome());
        Assertions.assertEquals(pessoaNull.getCpf(), dto.getCpf());
    }
}
