package org.example.refl;

import org.example.Pessoa;
import org.example.PessoaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

public class TransformatorTest {
    Pessoa pessoa = new Pessoa(1, "Carlos", "123456");

    @Test
    public void shouldTransform() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        br.com.alura.refl.Transformator transformator = new br.com.alura.refl.Transformator();
        PessoaDTO dto = transformator.transform(pessoa);

        Assertions.assertInstanceOf(PessoaDTO.class, dto);
        Assertions.assertEquals(pessoa.getNome(), dto.getNome());
        Assertions.assertEquals(pessoa.getCpf(), dto.getCpf());
    }
}
