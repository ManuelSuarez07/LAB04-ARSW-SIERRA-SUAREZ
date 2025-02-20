package edu.eci.arsw.blueprints.test.services.filter;

import org.junit.Test;
import static org.junit.Assert.*;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.services.filter.RedundancyFilter;

public class RedundancyFilterTest {
    @Test
    public void filterTest(){
        RedundancyFilter filter = new RedundancyFilter();

        Point[] points = new Point[]{
            new Point(40, 40), new Point(40, 40), new Point(15, 15), 
            new Point(15, 15), new Point(30, 30), new Point(30, 30), 
            new Point(40, 40), new Point(40, 40)
        };

        Blueprint bp0 = new Blueprint("mack", "mypaint", points);

        filter.filter(bp0);

        assertEquals(4, bp0.getPoints().size());

        assertEquals(new Point(40, 40), bp0.getPoints().get(0));
        assertEquals(new Point(15, 15), bp0.getPoints().get(1));
        assertEquals(new Point(30, 30), bp0.getPoints().get(2));
        assertEquals(new Point(40, 40), bp0.getPoints().get(3));
    }
}
