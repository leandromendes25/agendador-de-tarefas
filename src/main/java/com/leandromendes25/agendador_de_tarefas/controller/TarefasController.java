package com.leandromendes25.agendador_de_tarefas.controller;

import com.leandromendes25.agendador_de_tarefas.business.TarefasService;
import com.leandromendes25.agendador_de_tarefas.business.dto.TarefasDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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
    //DatimeFormat serve para na hora de inserir a data, possamos faze-la de forma mais simples
    //iso -> formato aceito lá no banco de dados
 @GetMapping("/eventos")
    public ResponseEntity<List<TarefasDTO>> buscaListaDeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal){
    return ResponseEntity.ok(tarefasService.buscaTarefaAgendadaPorPeriodo(dataInicial, dataFinal));
 }
 @GetMapping
    public ResponseEntity<List<TarefasDTO>> buscaTarefasEmail(@RequestHeader("Authorization") String token){
        return ResponseEntity.ok(tarefasService.buscaTarefasPorEmail(token));
 }
}
