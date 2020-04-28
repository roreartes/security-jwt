package ar.com.ada.sb.security.jwt.model.mapper.circulardependency;


import org.mapstruct.BeforeMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.TargetType;

import java.util.IdentityHashMap;
import java.util.Map;

public class CycleAvoidingmappingContext {

    private Map<Object, Object> knownInstances = new IdentityHashMap<>();
    private static CycleAvoidingmappingContext INSTANCE = null;

    @BeforeMapping
    public <T> T getMappedInstance (Object source, @TargetType Class<T> targetType){
        return (T) knownInstances.get(source);
    }

    @BeforeMapping
    public void storeMappedinstance(Object source, @MappingTarget Object targetType){
        knownInstances.put(source, targetType);
    }

    public static CycleAvoidingmappingContext getInstance() {
        if(INSTANCE == null)
            INSTANCE = new CycleAvoidingmappingContext();

        return INSTANCE;
    }


}

