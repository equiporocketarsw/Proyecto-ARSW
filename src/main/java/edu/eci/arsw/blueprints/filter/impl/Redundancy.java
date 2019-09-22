/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.filter.impl;
import edu.eci.arsw.blueprints.filter.Filtering;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import org.springframework.stereotype.Component;
/**
 *
 * @author 2133832
 */

@Component("Redundancy")
public class Redundancy implements Filtering{
    
    
    public void filtrar (Blueprint bp){
        List<Point> points = bp.getPoints();
        List<Point> newPoints = points;
        
        for(Point p :  points){
            if(!newPoints.contains(p))
                newPoints.add(p);
        }
        bp.setPoints(newPoints);
    }
    
}
