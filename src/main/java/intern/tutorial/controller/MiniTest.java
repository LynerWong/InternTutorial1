package intern.tutorial.controller;
import net.minidev.json.writer.JsonReader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class MiniTest {

    @GetMapping("/html")
    public void hello(@RequestBody String jsonString) {


    }
}
