package com.leandromendes25.agendador_de_tarefas.controller;

import com.leandromendes25.agendador_de_tarefas.business.TarefasService;
import com.leandromendes25.agendador_de_tarefas.business.dto.TarefasDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tarefas")
@RequiredArgsConstructor
public class TarefasController {
    private final TarefasService tarefasService;
    @PostMapping
    public ResponseEntity<TarefasDTO> gravarTarefas(@RequestBody TarefasDTO dto,
                                                    @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(tarefasService.gravarTarefa(token, dto));
    }
}
