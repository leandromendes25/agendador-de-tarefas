package com.leandromendes25.agendador_de_tarefas.infrastructure.client;

import com.leandromendes25.agendador_de_tarefas.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {
        @GetMapping
        UsuarioDTO buscarUsuarioPorEmail(@RequestParam("email") String email,
                                         @RequestHeader("Authorization") String token);
}
