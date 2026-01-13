package com.leandromendes25.agendador_de_tarefas.business.mapper;

import com.leandromendes25.agendador_de_tarefas.business.dto.TarefasDTO;
import com.leandromendes25.agendador_de_tarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")//faz o spring injetar as dependencias que precisa
public interface TarefasConverter {
    TarefasEntity paraTarefaEntity(TarefasDTO dto);
    TarefasDTO paraTarefaDTO(TarefasEntity entity);
}
