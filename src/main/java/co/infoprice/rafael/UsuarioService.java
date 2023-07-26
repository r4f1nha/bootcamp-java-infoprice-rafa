package co.infoprice.rafael;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> getUsers(){
        return repository.findAll();



    }
    public Usuario save (UsuarioDTO usuarioDTO){
        Optional<Usuario> githubUser = repository.findbygithubUser(usuarioDTO.getGithubUser());

        if(githubUser.isPresent())
            throw new RuntimeException("Usuario ja cadastrado");



        Usuario usuario = new Usuario();
        usuario.setName(usuarioDTO.getName());
        usuario.setOccupation(usuarioDTO.getOccupation());
        usuario.setGithubUser(usuarioDTO.getGithubUser());
        return repository.save(usuario);
    }


    public Usuario atualizarUsuario( Long userId, Usuario userDetails){

        Usuario usuario = repository.getReferenceById(userId);

        usuario.setName(userDetails.getName());
        usuario.setOccupation(userDetails.getOccupation());
        usuario.setGithubUser(userDetails.getGithubUser());

        Usuario atualizarUsuario = repository.save(usuario);
        return atualizarUsuario;
    }

    public void excuirUsuario(Long userId){

        repository.deleteById(userId);


    }

}
