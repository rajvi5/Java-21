import java.io.File;

import static java.lang.StringTemplate.STR;
import static java.util.FormatProcessor.FMT;

/**String Templates - runtime evaluation of Strings*/

public class StringTemplate {
    public static void main(String[] args)
    {
        int a = 10;
        int b = 5;
        System.out.println(STR."Value of a is \{a}");
        System.out.println(STR."Value of b is \{b}");
        System.out.println(STR."\{a}"+ STR."\{b}");
        System.out.println(STR."\{a + b}");

        String filePath = "tmp.dat";
        File file     = new File(filePath);
        String old = "The file " + filePath + " " + (file.exists() ? "does" : "does not") + " exist";
        String msg = STR."The file \{filePath} \{file.exists() ? "does" : "does not"} exist";
        System.out.println(old);
        System.out.println(msg);

    // Embedded expressions can be postfix increment expressions
        int index = 0;
        String data = STR."\{index++}, \{index++}, \{index++}, \{index++}";
        System.out.println(data);

    //Multi-line template expression
        String title = "Demo on Java 21 features";
        String heading = "Welcome!!";
        String message = "We are learning about String templates that helps in evaluating Strings at runtime";

        String html = STR. """
    
                <html>
                    <head>
                        <title>\{title}</title>
                    </head>
                    <body>
                        <heading>\{heading}</heading>
                        <p>\{message}</p>
                    </body>
                </html>
                """;

            System.out.println(html);

    //FMT processor
        record Rectangle(String name, double width, double height) {
            double area() {
                return width * height;
            }
        }
        Rectangle[] zone = new Rectangle[] {
                new Rectangle("Alfa", 17.8, 31.4),
                new Rectangle("Bravo", 9.6, 12.4),
                new Rectangle("Charlie", 7.1, 11.23),
        };
        String table = STR."""
        Description  Width  Height  Area
        \{zone[0].name}  \{zone[0].width}  \{zone[0].height}     \{zone[0].area()}
        \{zone[1].name}  \{zone[1].width}  \{zone[1].height}     \{zone[1].area()}
        \{zone[2].name}  \{zone[2].width}  \{zone[2].height}     \{zone[2].area()}
        Total \{zone[0].area() + zone[1].area() + zone[2].area()}
        """;
        System.out.println(table);
        String formattedTable = FMT."""
        Description     Width    Height     Area
        %-12s\{zone[0].name}  %7.2f\{zone[0].width}  %7.2f\{zone[0].height}     %7.2f\{zone[0].area()}
        %-12s\{zone[1].name}  %7.2f\{zone[1].width}  %7.2f\{zone[1].height}     %7.2f\{zone[1].area()}
        %-12s\{zone[2].name}  %7.2f\{zone[2].width}  %7.2f\{zone[2].height}     %7.2f\{zone[2].area()}
        \{" ".repeat(28)} Total %7.2f\{zone[0].area() + zone[1].area() + zone[2].area()}
        """;
        System.out.println(formattedTable);

    /*Note: String interpolation is dangerous.
    For ex: String that holds SQL statements can lead to sql injection attacks.*/
    }
}
