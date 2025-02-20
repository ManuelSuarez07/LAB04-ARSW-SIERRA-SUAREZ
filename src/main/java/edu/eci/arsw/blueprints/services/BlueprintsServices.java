package edu.eci.arsw.blueprints.services;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.BlueprintsPersistence;
import edu.eci.arsw.blueprints.services.filter.BlueprintFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BlueprintsServices {

    @Autowired
    private BlueprintsPersistence bpp;

    @Autowired
    private BlueprintFilter blueprintFilter; 

    /**
     * Registra un nuevo blueprint en el sistema.
     * @param bp Blueprint a agregar
     */
    public void addNewBlueprint(Blueprint bp) throws BlueprintPersistenceException {
        bpp.saveBlueprint(bp);
    }

    /**
     * Obtiene todos los blueprints almacenados y les aplica el filtro.
     * @return Set de todos los blueprints filtrados.
     */
    public Set<Blueprint> getAllBlueprints() {
        Set<Blueprint> blueprints = bpp.getAllBlueprints();
        blueprints.forEach(blueprintFilter::filter);
        return blueprints;
    }

    /**
     * Obtiene un blueprint específico por autor y nombre y le aplica el filtro.
     * @param author Autor del blueprint
     * @param name Nombre del blueprint
     * @return Blueprint correspondiente, filtrado.
     * @throws BlueprintNotFoundException si no se encuentra el blueprint
     */
    public Blueprint getBlueprint(String author, String name) throws BlueprintNotFoundException {
        Blueprint blueprint = bpp.getBlueprint(author, name);
        blueprintFilter.filter(blueprint);
        return blueprint;
    }

    /**
     * Obtiene todos los blueprints de un autor específico y les aplica el filtro.
     * @param author Autor de los blueprints
     * @return Set de blueprints del autor filtrados.
     * @throws BlueprintNotFoundException si no existen planos para ese autor
     */
    public Set<Blueprint> getBlueprintsByAuthor(String author) throws BlueprintNotFoundException {
        Set<Blueprint> blueprints = bpp.getBlueprintsByAuthor(author);
        blueprints.forEach(blueprintFilter::filter); 
        return blueprints;
    }
}
