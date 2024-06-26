import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class StatusTest {


    @Test
    void canSetOnHold() {
        //Arrange
        //Act
        //Assert
        assertEquals(Status.ON_HOLD, Status.IN_PROGRESS.tryPutOnHold());
        assertEquals(Status.COMPLETED, Status.COMPLETED.tryPutOnHold());
    }

    @Test
    void canReActivate() {
        //Arrange
        //Act
        //Assert
        assertEquals(Status.IN_PROGRESS, Status.ON_HOLD.tryReActivate());
        assertEquals(Status.COMPLETED, Status.COMPLETED.tryReActivate());
    }

    @Test
    void getMoveNext() {
        //Arrange
        //Act
        //Assert
        assertEquals(Status.IN_PROGRESS, Status.NEW.next());
        assertEquals(Status.COMPLETED, Status.IN_PROGRESS.next());
        assertEquals(Status.COMPLETED, Status.COMPLETED.next());
        assertEquals(Status.CANCELED, Status.ON_HOLD.next());
        assertEquals(Status.CANCELED, Status.CANCELED.next());
        assertEquals(Status.IN_PROGRESS, Status.NEW.next());
    }
}