/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.filter.impl;

import edu.eci.arsw.blueprints.filter.Filtering;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

/**
 *
 * @author 2133832
 */
@Component("Subsampling")
public class Subsampling implements Filtering {
    
    @Override
    public void filtrar (Blueprint bp){
        List<Point> points = bp.getPoints();
        List<Point> newPoints =  new ArrayList<>();
        
        for (int i=0;i<points.size();i++)
        {
            if (i%2==0){
                newPoints.add(points.get(i));
            }
        }
        bp.setPoints(newPoints);
    }
}
