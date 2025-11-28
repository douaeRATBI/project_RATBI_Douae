package org.formation.cashsimplify.mapper;

import org.formation.cashsimplify.dto.ClientDto;
import org.formation.cashsimplify.dto.ClientCreateDto;
import org.formation.cashsimplify.dto.ClientUpdateDto;
import org.formation.cashsimplify.entity.Client;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ClientMapper {

    ClientDto toDto(Client client);

    @Mapping(target = "id", ignore = true)
    Client toEntity(ClientCreateDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget Client client, ClientUpdateDto dto);

    List<ClientDto> toDtoList(List<Client> clients);
}
