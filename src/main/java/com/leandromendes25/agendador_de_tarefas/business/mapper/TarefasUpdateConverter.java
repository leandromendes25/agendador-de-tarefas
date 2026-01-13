package com.leandromendes25.agendador_de_tarefas.business.mapper;

import com.leandromendes25.agendador_de_tarefas.business.dto.TarefasDTO;
import com.leandromendes25.agendador_de_tarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

//Null faz verificação, se for valor nullo, pegue as propriedades da outra,
//ignora nullo que o mapper faz o mapeamento automatico.
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TarefasUpdateConverter {
    //mapping target -> indica que será o principal caso o dto seja nulo
    void updateTarefas(TarefasDTO dto, @MappingTarget TarefasEntity entity);
}
