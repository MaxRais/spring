package hello;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/board/{size}", produces = "text/plain")
    public String board(@PathVariable("size") String size) {
        StringBuilder response = new StringBuilder();
        int boardSize;

        try {
            boardSize = Integer.parseInt(size);
            if (boardSize < 1) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            return "Invalid board size: " + size;
        }

        String divider = buildDivider(boardSize);

        for(int row = 0; row < boardSize; row++) {
            response.append(divider);
            response.append("\n");
            for(int col = 0; col < boardSize; col++) {
                response.append("| O ");
            }
            response.append("|\n");
        }
        response.append(divider);
        return response.toString();
    }

    private String buildDivider(int width) {
        String div = "";
        for(int i = 0; i < width; i++) {
            div = div.concat("----");
        }
        return div;
    }
    
}
