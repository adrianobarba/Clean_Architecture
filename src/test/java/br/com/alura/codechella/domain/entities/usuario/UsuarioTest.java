package br.com.alura.codechella.domain.entities.usuario;

import br.com.alura.codechella.domain.usuario.FabricaDeUsuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioTest {
    @Test
    public void naoDeveCadastrarUsuarioComCpfFormatoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123456789-99", "Adriano", LocalDate.parse("1990-09-06"), "email@email.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("12345678999", "Adriano", LocalDate.parse("1990-09-06"), "email@email.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("", "Adriano", LocalDate.parse("1990-09-06"), "email@email.com"));
    }

    @Test
    public void DeveCriarUsuarioFabricaDeUsuario() {
        FabricaDeUsuario fabrica = new FabricaDeUsuario();
        Usuario usuario = fabrica.comNomeCpfNascimento("Emily", "658.265.147-88",
                LocalDate.parse("2000-10-01"));

        Assertions.assertEquals("Emily", usuario.getNome());

        usuario = fabrica.incluiEndereco("54252-369", 40, "apt 201");

        Assertions.assertEquals("apt 201", usuario.getEndereco().getComplemento());

    }
}
