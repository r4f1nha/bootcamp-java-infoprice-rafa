package co.infoprice.rafael;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UsuarioControler {
    @Autowired
    private UsuarioService service;

    @GetMapping("/all")
    public List<Usuario> getUsers(){
        return service.getUsers();


    }
    @PostMapping
    public Usuario save(@RequestBody UsuarioDTO usuarioDTO){
        return service.save(usuarioDTO);
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable(value = "id") Long userId,
                                    @RequestBody Usuario userDetails){

        return service.atualizarUsuario(userId, userDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excuirUsuario(@PathVariable("id") Long userId){
        service.excuirUsuario(userId);
        return ResponseEntity.ok("Legal");
    }

}
