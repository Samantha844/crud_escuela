package com.example.crud.modulos.grado.controlador;

import com.example.crud.modulos.docente.dto.DocenteDTO;
import com.example.crud.modulos.grado.dto.GradoDTO;
import com.example.crud.modulos.grado.servicio.GradoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("grado")
public class GradoControlador {
    @Autowired
    private GradoServicio gradoServicio;

    @GetMapping("obtener")
    public ResponseEntity<List<GradoDTO>> obtenerGrado() {
        List<GradoDTO> respuesta = gradoServicio.obtenerGrados();
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @GetMapping("obtener/id")
    public ResponseEntity<GradoDTO> obtenerGradosPorId(@RequestParam Integer id_grado) {
        GradoDTO respuesta = gradoServicio.obtenerGradosPorId(id_grado);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PostMapping("guardar")
    public ResponseEntity<Boolean> guardarGrado(@RequestBody GradoDTO parametros) {
        Boolean respuesta = gradoServicio.guardarGrado(parametros);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PutMapping("actualizar")
    public ResponseEntity<Boolean> actualizarGrado(@RequestBody GradoDTO parametros) {
        Boolean respuesta = gradoServicio.actualizarGrado(parametros);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @DeleteMapping("eliminar")
    public ResponseEntity<Boolean> eliminarGrado(@RequestParam Integer id_grado) {
        Boolean respuesta = gradoServicio.eliminarGrado(id_grado);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PutMapping("activar-inactivar")
    public ResponseEntity<Boolean> activarInactivarGrado(@RequestBody Integer id_grado) {
        Boolean respuesta = gradoServicio.activarInactivarGrado(id_grado);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

}
