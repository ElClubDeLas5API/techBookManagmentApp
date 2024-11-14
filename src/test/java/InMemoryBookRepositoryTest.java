import org.TBMA.Book;
import org.TBMA.BookRepository;
import org.TBMA.InMemoryBookRepository;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import javax.naming.AuthenticationException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static  org.junit.jupiter.api.Assertions.assertEquals;

public class InMemoryBookRepositoryTest {
    @Test
    @DisplayName("Test lista usuarios mayores de edad")
    void test_whenTheBookIsInTheRepo_thenReturnTrue() throws SQLException {
    //  GIVEN
        BookRepository inMemoryTest = new InMemoryBookRepository();
        Book book1 = new Book("Tests", "Test", "A000");
    //  WHEN
        inMemoryTest.save(book1);
    //  THEN
        List<Book> booksDB = inMemoryTest.findAll();
        assertEquals(1, booksDB.size()) ;
        assertEquals("A000", booksDB.get(0).getIsbn()) ;
    }
}
