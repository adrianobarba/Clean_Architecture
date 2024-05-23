package br.com.alura.codechella.domain.usuario;

import br.com.alura.codechella.domain.Endereco;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

import java.time.LocalDate;

public class FabricaDeUsuario {
    private Usuario usuario;

    public Usuario comNomeCpfNascimento(String nome, String cpf, LocalDate nascimento) {
        this.usuario = new Usuario(cpf, nome, nascimento, "");
        return this.usuario;
    }

    public Usuario incluiEndereco(String cep, Integer numero, String complemeto) {
        this.usuario.setEndereco(new Endereco(cep, numero, complemeto));
        return this.usuario;
    }
}
