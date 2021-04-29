package io.github.easytuples.codegen.data;

import java.util.Map;

import static java.util.Map.entry;

public class Constants {
    // Class should not be instantiable.
    private Constants() {}

    /*
     * Map from raw int index to a default type param for that index.
     */
    public static final Map<Integer, String> INDEX_TO_TYPE_PARAM = Map.ofEntries(
            entry(1, "A"),
            entry(2, "B"),
            entry(3, "C"),
            entry(4, "D"),
            entry(5, "E"),
            entry(6, "F"),
            entry(7, "G"),
            entry(8, "H"),
            entry(9, "I"),
            entry(10, "J"),
            entry(11, "K"),
            entry(12, "L"),
            entry(13, "M"),
            entry(14, "N"),
            entry(15, "O"),
            entry(16, "P"),
            entry(17, "Q"),
            entry(18, "R"),
            entry(19, "S"),
            entry(20, "T"),
            entry(21, "U"),
            entry(22, "V"),
            entry(23, "W"),
            entry(24, "X"),
            entry(25, "Y"),
            entry(26, "Z")
    );

    /*
     * The maximum supported tuple size which can be generated.
     */
    public static final int MAX_TUPLE_SIZE = INDEX_TO_TYPE_PARAM.size();
}
