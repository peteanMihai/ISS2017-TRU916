package ro.tru916.web.converter;

import ro.tru916.core.model.BaseEntity;
import ro.tru916.web.dto.BaseDto;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Laura on 4/30/2017.
 */
public abstract class BaseConverter<Model extends BaseEntity<Long>, Dto extends BaseDto> implements Converter<Model, Dto> {

    @Override
    public Model convertDtoToModel(Dto dto) {
        throw new RuntimeException("not implemented");
    }

    @Override
    public Dto convertModelToDto(Model model) {
        throw new RuntimeException("not implemented");
    }

    public Set<Long> convertModelsToIDs(Set<Model> models) {
        return models.stream()
                .map(model -> model.getId())
                .collect(Collectors.toSet());
    }

    public Set<Long> convertDTOsToIDs(Set<Dto> dtos) {
        return dtos.stream()
                .map(dto -> dto.getId())
                .collect(Collectors.toSet());
    }

    public Set<Dto> convertModelsToDtos(Collection<Model> models) {
        return models.stream()
                .map(model -> convertModelToDto(model))
                .collect(Collectors.toSet());
    }
}
