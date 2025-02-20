package edu.eci.arsw.blueprints.test.services.filter;

import static org.junit.Assert.assertEquals;


import org.junit.Test;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.services.filter.SubsamplingFilter;




public class SubSamplingFilterTest {
    @Test
    public void filterTest(){
        SubsamplingFilter filter = new SubsamplingFilter();

        Point[] points = new Point[]{
            new Point(40, 40), new Point(15, 15), new Point(20, 20), 
            new Point(25, 25), new Point(30, 30), new Point(35, 35), 
            new Point(40, 40), new Point(45, 45)
        };

        Blueprint bp0 = new Blueprint("mack", "mypaint", points);

        filter.filter(bp0);

        assertEquals(4, bp0.getPoints().size());

        assertEquals(new Point(40, 40), bp0.getPoints().get(0));
        assertEquals(new Point(20, 20), bp0.getPoints().get(1));
        assertEquals(new Point(30, 30), bp0.getPoints().get(2));
        assertEquals(new Point(40, 40), bp0.getPoints().get(3));
    }
}
