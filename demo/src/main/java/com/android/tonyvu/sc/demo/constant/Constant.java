package com.android.tonyvu.sc.demo.constant;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.android.tonyvu.sc.demo.model.Product;

public final class Constant {
    public static final List<Integer> QUANTITY_LIST = new ArrayList<Integer>();

    static {
        for (int i = 1; i < 11; i++) QUANTITY_LIST.add(i);
    }

    public static final Product PRODUCT1 = new Product(1, "48", BigDecimal.valueOf(199.996), "Eragon and the fledgling dragon must navigate the dangerous terrain and dark enemies of an empire ruled by a king whose evil knows no bounds", "productonesmall");
    public static final Product PRODUCT2 = new Product(2, "334", BigDecimal.valueOf(449.9947), "This is the second book in a three-part series, which takes you on a journey to enlightenment. The first book is called The Light: A Book of Wisdom.", "producttwo");
    public static final Product PRODUCT3 = new Product(3, "1635  The Eastern Front", BigDecimal.valueOf(319.998140), "BackStage is a raucously funny, narrative non-fiction compilation of stories, tales, and gems from the Golden Era of entertainment circa 1960 - 1980.", "productthree");
    public static final Product PRODUCT4 = new Product(4, "Before I knew", BigDecimal.valueOf(319.998140), "Author Jamie Beck returns with an engrossing series about family, friendship, and starting over. In this first Cabot novel, a legacy of secrets tests old friends seeking a second chance at life and love.", "productfour");
    public static final Product PRODUCT5 = new Product(5, "1636  The Saxon Uprising", BigDecimal.valueOf(319.998140), "The Maze Runner is a 2009 young adult post-apocalyptic dystopian science fiction novel written by American author James Dashner and the first book released in The Maze Runner series, although it is the third chronologically. ", "productfive");
    public static final Product PRODUCT6 = new Product(6, "1824  The Arkansas War", BigDecimal.valueOf(319.998140), "Head Above Water is a 1996 American comedy thriller film directed by Jim Wilson and starring Harvey Keitel, Cameron Diaz, Craig Sheffer. It was rated PG-13 by the MPAA. The film is a remake of Hodet over vannet by Norwegian film director Nils Gaup.", "productsix");
    public static final Product PRODUCT7 = new Product(7, "1982  Janine", BigDecimal.valueOf(319.998140), "The book recounts the failure of the Imperial Trans-Antarctic Expedition led by Sir Ernest Shackleton in its attempt to cross the Antarctic continent in 1914 and the subsequent struggle for survival endured by the twenty-eight man crew for almost two years.", "productseven");
    public static final Product PRODUCT8 = new Product(8, "A Cold Case", BigDecimal.valueOf(319.998140), "The Hunger Games is a trilogy of young adult dystopian novels written by American novelist Suzanne Collins. The series is set in The Hunger Games universe, and follows young characters Katniss Everdeen and Peeta Mellark.", "producteight");
    public static final Product PRODUCT9 = new Product(9, "A Feast Unknown", BigDecimal.valueOf(319.998140), "Insurgent is a 2015 American science fiction action film directed by Robert Schwentke, based on Insurgent, the second book in the Divergent trilogy by Veronica Roth. It is the sequel to the 2014 film Divergent", "productnine");

    public static final List<Product> PRODUCT_LIST = new ArrayList<Product>();

    static {
        PRODUCT_LIST.add(PRODUCT1);
        PRODUCT_LIST.add(PRODUCT2);
        PRODUCT_LIST.add(PRODUCT3);
        PRODUCT_LIST.add(PRODUCT4);
        PRODUCT_LIST.add(PRODUCT5);
        PRODUCT_LIST.add(PRODUCT6);
        PRODUCT_LIST.add(PRODUCT7);
        PRODUCT_LIST.add(PRODUCT8);
        PRODUCT_LIST.add(PRODUCT9);
    }

    public static final String CURRENCY = "$";
}
