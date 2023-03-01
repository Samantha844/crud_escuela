package com.example.crud.modulos.grupo.controlador;

import com.example.crud.modulos.grupo.dto.GrupoDTO;
import com.example.crud.modulos.grupo.servicio.GrupoServicio;
import com.example.crud.modulos.persona.dto.PersonaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("grupo")
public class GrupoControlador {
    @Autowired
    private GrupoServicio grupoServicio;

    @GetMapping("obtener")
    public ResponseEntity<List<GrupoDTO>> obtenerGrupos(){
        List<GrupoDTO> respuesta = grupoServicio.obtenerGrupos();
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @GetMapping("obtener/id")
    public ResponseEntity<GrupoDTO> obtenerGrupos(@RequestParam Integer id_grupo){
        GrupoDTO respuesta = grupoServicio.obtenerGruposPorId(id_grupo);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PostMapping("guardar")
    public ResponseEntity<Boolean> guardarGrupo(@RequestBody GrupoDTO parametros){
        Boolean respuesta = grupoServicio.guardarGrupo(parametros);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PutMapping("actualizar")
    public ResponseEntity<Boolean> actualizarGrupo(@RequestBody GrupoDTO parametros){
        Boolean respuesta = grupoServicio.actualizarGrupo(parametros);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
    @DeleteMapping("eliminar")
    public ResponseEntity<Boolean> eliminarGrupo(@RequestParam Integer id_grupo){
        Boolean respuesta = grupoServicio.eliminarGrupo(id_grupo);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
    @PutMapping("activar-inactivar")
    public ResponseEntity<Boolean> activarInactivarGrupo(@RequestBody Integer id_grupo){
        Boolean respuesta = grupoServicio.activarInactivarGrupo(id_grupo);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }


}
