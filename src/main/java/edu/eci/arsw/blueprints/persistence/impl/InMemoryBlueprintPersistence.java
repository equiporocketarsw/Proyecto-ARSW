/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.BlueprintsPersistence;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Component;

/**
 *
 * @author hcadavid
 */


@Component("InMemory")
public class InMemoryBlueprintPersistence implements BlueprintsPersistence{

    private final Map<Tuple<String,String>,Blueprint> blueprints=new HashMap<>();

    public InMemoryBlueprintPersistence() {
        //load stub data
        Point[] pts=new Point[]{new Point(140, 140),new Point(115, 115)};
        Blueprint bp=new Blueprint("_authorname_", "_bpname_ ",pts);
        blueprints.put(new Tuple<>(bp.getAuthor(),bp.getName()), bp);
        
        Point[] pts1=new Point[]{new Point(14, 14),new Point(11, 11)};
        Blueprint bp1=new Blueprint("mack", "mypaint",pts1);
        
        Point[] pts2=new Point[]{new Point(10, 10),new Point(15, 15)};
        Blueprint bp2=new Blueprint("john", "thepaint",pts2);
        
        Point[] pts3=new Point[]{new Point(40, 40),new Point(115, 115)};
        Blueprint bp3=new Blueprint("john", "otherpaint",pts3);
        
        Point[] pts4=new Point[]{new Point(5, 10),new Point(10, 15),new Point (15,20)};
        Blueprint bp4=new Blueprint("Santiago", "mipintura",pts4);
        
        
        blueprints.put(new Tuple<>(bp1.getAuthor(),bp1.getName()), bp1);
        
        blueprints.put(new Tuple<>(bp2.getAuthor(),bp2.getName()), bp2);
        
        blueprints.put(new Tuple<>(bp3.getAuthor(),bp3.getName()), bp3);
        
        blueprints.put(new Tuple<>(bp4.getAuthor(),bp4.getName()), bp4);
        
    }    
    
    @Override
    public void saveBlueprint(Blueprint bp) throws BlueprintPersistenceException {
        if (blueprints.containsKey(new Tuple<>(bp.getAuthor(),bp.getName()))){
            throw new BlueprintPersistenceException("The given blueprint already exists: "+bp);
        }
        else{
            blueprints.put(new Tuple<>(bp.getAuthor(),bp.getName()), bp);
        }        
    }

    @Override
    public Blueprint getBlueprint(String author, String bprintname) throws BlueprintNotFoundException {
        
        if (blueprints.containsKey(new Tuple<>(author, bprintname))){
            return blueprints.get(new Tuple<>(author, bprintname));
           
        }
        else
        {
             throw new BlueprintNotFoundException("El nombre de ese autor no existe");
        }
        
    }

    @Override
    public Set<Blueprint> getBlueprintsByAuthor(String author) throws BlueprintNotFoundException {
        Set<Blueprint> autores = new HashSet<Blueprint>();
        int cont=0;
        for (Map.Entry<Tuple<String,String>,Blueprint> blue:blueprints.entrySet()){
            String a=blue.getValue().getAuthor();
            if(a.equals(author)){
                autores.add(blue.getValue());
                cont+=1;
            }
        }
        if (cont==0){
            throw new BlueprintNotFoundException("El autor no existe");
        }
        else{
            return autores;  
        }
        
    }

    @Override
    public Set<Blueprint> getAllBlueprints() throws BlueprintNotFoundException {
        Set<Blueprint> autores = new HashSet<Blueprint>();
        
        for (Map.Entry<Tuple<String,String>,Blueprint> blue:blueprints.entrySet()){
                autores.add(blue.getValue());

        }
        return autores;
    }

    @Override
    public void updatePoints(String author, String bprintname, List<Point> points) throws BlueprintNotFoundException {
        
    }

    
    
}
