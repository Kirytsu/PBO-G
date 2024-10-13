/**
 * Implementasi Interface Storable
 *
 * Kelompok 17
 * Nathanael Valen Susilo   -   5025231099
 * Basten Andika Salim      -   5025231132
 * 
 */

import java.io.IOException;

public interface Storable {

    void tambahItem(String item, int jumlah) throws IOException;

    void hapusItem(String item) throws IOException;

    void tampilkanItem() throws IOException;
}
