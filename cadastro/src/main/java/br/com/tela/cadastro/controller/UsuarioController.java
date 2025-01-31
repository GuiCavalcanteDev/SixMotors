package br.com.tela.cadastro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tela.cadastro.model.Usuario;
import jakarta.persistence.EntityManager;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private EntityManager entityManager; // Injeta o EntityManager para executar a stored procedure

    @Transactional // Adiciona a anotação @Transactional para iniciar uma transação
    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        try {
            // Chama a stored procedure sp_inserir_usuario passando os parâmetros do usuário
            entityManager.createNativeQuery(
                "CALL sp_inserir_usuario(:tipoCliente, :nome, :cpf, :telefone, :email, :senha)")
                .setParameter("tipoCliente", usuario.getTipoCliente())
                .setParameter("nome", usuario.getNome())
                .setParameter("cpf", usuario.getCpf())
                .setParameter("telefone", usuario.getTelefone())
                .setParameter("email", usuario.getEmail())
                .setParameter("senha", usuario.getSenha())
                .executeUpdate();

            return usuario; // Retorna o usuário criado
        } catch (Exception e) {
            // Trata possíveis erros, você pode personalizar essa parte de acordo com suas
            // necessidades
            e.printStackTrace();
            return null;
        }
    }
}

