package com.leandromendes25.agendador_de_tarefas.business;

import com.leandromendes25.agendador_de_tarefas.business.dto.TarefasDTO;
import com.leandromendes25.agendador_de_tarefas.business.mapper.TarefasConverter;
import com.leandromendes25.agendador_de_tarefas.infrastructure.entity.TarefasEntity;
import com.leandromendes25.agendador_de_tarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.leandromendes25.agendador_de_tarefas.infrastructure.repository.TarefasRepository;
import com.leandromendes25.agendador_de_tarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefasService {
    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefaConverter;
    private final JwtUtil jwtUtil;
    public TarefasDTO gravarTarefa(String token,TarefasDTO dto){
        String email = jwtUtil.extractUsername(token.substring(7));
        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefaConverter.paraTarefaEntity(dto);
        return tarefaConverter.paraTarefaDTO(tarefasRepository.save(entity));

    }
}
