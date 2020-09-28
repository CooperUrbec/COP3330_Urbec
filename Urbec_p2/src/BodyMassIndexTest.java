import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {
    @Test
    public void testBodyMassIndexUnderweight(){
        BodyMassIndex b = new BodyMassIndex(72, 60);
        assert(b.calculateBMI() < 18.5);
    }

    @Test
    public void testBodyMassIndexNormalWeight(){
        BodyMassIndex b = new BodyMassIndex(72, 140);
        assert(b.calculateBMI() >= 18.5 && b.calculateBMI() <= 24.9);
    }

    @Test
    public void testBodyMassIndexOverweight(){
        BodyMassIndex b = new BodyMassIndex(72, 220);
        assert(b.calculateBMI() >= 25 && b.calculateBMI() <= 29.9);
    }

    @Test
    public void testBodyMassIndexObese(){
        BodyMassIndex b = new BodyMassIndex(72, 500);
        assert(b.calculateBMI() >= 30);
    }
}