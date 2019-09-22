/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.test.filter;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.impl.InMemoryBlueprintPersistence;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author 2133832
 */
public class FilteringTest {
     @Test
    public void RedundancyTest() throws BlueprintPersistenceException, BlueprintNotFoundException{
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices bs = ac.getBean(BlueprintsServices.class);
        
        

        Point[] pts0=new Point[]{new Point(40, 40),new Point(15, 15),new Point(40, 40),new Point(40, 40)};
        Blueprint bp0=new Blueprint("mack", "mypaint",pts0);
        
        bs.filter(bp0);
        
        List<Point> newPoints =  new ArrayList<>();
        newPoints.add(new Point(40, 40));
        newPoints.add(new Point(15, 15));
        
        for (int i=0;i<newPoints.size();i++){
            assertEquals(newPoints.get(i).getX(),bp0.getPoints().get(i).getX());
            assertEquals(newPoints.get(i).getY(),bp0.getPoints().get(i).getY());
        }
        
    }


    @Test
    public void SubsamplingTest() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices bs = ac.getBean(BlueprintsServices.class);
        
        

        Point[] pts0=new Point[]{new Point(10, 10),new Point(20, 20),new Point(30, 30),new Point(40, 40),new Point(50, 50)};
        Blueprint bp0=new Blueprint("mack", "mypaint",pts0);
        
        bs.filter(bp0);
        
        List<Point> newPoints =  new ArrayList<>();
        newPoints.add(new Point(10, 10));
        newPoints.add(new Point(30, 30));
        newPoints.add(new Point(50, 50));
        
        for (int i=0;i<newPoints.size();i++){
            assertEquals(newPoints.get(i).getX(),bp0.getPoints().get(i).getX());
            assertEquals(newPoints.get(i).getY(),bp0.getPoints().get(i).getY());
        }
                
        
    }
}
