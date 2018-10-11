package intern.tutorial.controller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import intern.tutorial.model.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestingController {

    //Parameter 1 (Post Method)
    @PostMapping("/post_by_param1")
    public String handleParameter(Param parameter, Model model) {

        String one = parameter.getParam1();
        String two = parameter.getParam2();
        String three = parameter.getParam3();

        return ("Parameter 1 : " + one + "\n" + "Parameter 2 : " + two + "\n" + "Parameter 3 : " + three);
    }

    //Parameter 2 not work
    @RequestMapping(value = "/post_by_param2", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public void parameter2(@RequestParam MultiValueMap<String, String> para) {

        System.out.println(para);
        String x = para.toString();

        String[] strx = x.split("\n");

//        System.out.println();
//        System.out.println(strx.length+" meme");
//        System.out.println("*****************************");
//        for(int i=1; i<strx.length-1; i+=4){
//            System.out.println(strx[i].substring(strx[i].indexOf("\"")+1,strx[i].lastIndexOf("\"")));
//
//        }

        for (int i = 3; i < strx.length; i += 4) {

            System.out.println("Parameter: " + strx[i]);
        }


    }

    //Parameter 3
    @RequestMapping(value = "/post_by_param3", method = RequestMethod.POST)
    public String parameter3(@RequestParam("param1") String paramm1, @RequestParam("param2") String paramm2, @RequestParam("param3") String paramm3) {


        return ("Paramater 1 : " + paramm1 + "\n" + "Parameter 2 : " + paramm2 + "\n" + "Parameter 3 : " + paramm3);

    }

    //Parameter 4
    @RequestMapping(value = "/post_by_param4", method = RequestMethod.POST)
    @ResponseBody
    public String[] doGet(@RequestBody String para) {
        String[] finalvalue = new String[3];
        String newpara = para.replaceAll("[?=.^:,]", "");

        String[] str = newpara.split("&");

        for (int i = 0; i < str.length; i++) {
            String test = str[i].replace("param" + (i + 1), "");
            finalvalue[i] = ("Parameter " + (i + 1) + " : " + test);
        }

        return finalvalue;
    }


    //Parameter1 Get
    @RequestMapping(value = "/get_param1", method = RequestMethod.GET)
    public String parameter01(@RequestParam("param1") String paramm1, @RequestParam("param2") String paramm2, @RequestParam("param3") String paramm3) {


        return ("Paramater 1 : " + paramm1 + "\n" + "Parameter 2 : " + paramm2 + "\n" + "Parameter 3 : " + paramm3);

    }

    //Parameter2 Get
    @RequestMapping(path = "/get_param2/{para1}/{para2}/{para3}")
    public String parameter02(@PathVariable("para1") String para1, @PathVariable("para2") String para2, @PathVariable("para3") String para3) {

        return ("Paramater 1 : " + para1 + "\n" + "Parameter 2 : " + para2 + "\n" + "Parameter 3 : " + para3);
    }

    //JSON1
    @RequestMapping("/post_by_json1")
    @ResponseBody
    public String JSON1(@RequestBody ArrayList<String> users) throws JSONException {

        //users.forEach(System.out::println);
            return ("Parameter 1: " + users.get(0) + "\n" + "Parameter 2: " +  users.get(1) + "\n"+ "Parameter 3: " + users.get(2));


    }

    //JSON2 not work
    @RequestMapping("/post_by_json2")
    @ResponseBody
    public String JSON2(@RequestBody ArrayList<Integer> para) {

        //para.forEach(System.out::println);
        return ("Parameter 1: " + para.get(0) + "\n" + "Parameter 2: " +  para.get(1) + "\n"+ "Parameter 3: " + para.get(2));
    }

    //JSON 3
    @RequestMapping("/post_by_json3")
    @ResponseBody
    public String JSON3(@RequestBody Param param ) {

        return ("Parameter 1 : " + param.getParam1()  + "\n" + "Parameter 2 : " + param.getParam2()  + "\n" + "Parameter 3 : " + param.getParam3());


    }

    //JSON 4
    @RequestMapping("/post_by_json4")
    @ResponseBody
    public String JSON4(@RequestBody Paramint paramint) {

        return ("Parameter 1 : " + paramint.getParam1()  + "\n" + "Parameter 2 : " + paramint.getParam2()  + "\n" + "Parameter 3 : " + paramint.getParam3());


    }

    //JSON 5
    @RequestMapping("/post_by_json5")
    @ResponseBody
    public String JSON5(@RequestBody Param1 param1) {

        return ("Parameter 1 : " + param1.getParam1()  + "\n" + "Parameter 2 : " + param1.getParam2()  + "\n" + "Parameter 3 : " + param1.getParam3());

    }

    //JSON 6
    @RequestMapping(value = "/post_by_json6")
    @ResponseBody
    private String JSON6(@RequestBody Parameter parameter)
    {

        //parameter.getParam1().forEach(System.out::println);
        return ("Parameter 1: " + parameter.getParam1().get(0) + "\n" +
                "Parameter 2: " + parameter.getParam1().get(1) + "\n"+
                "Parameter 3: " + parameter.getParam1().get(2) + "\n\n" +
                "Parameter 2-value 1: " + parameter.getParam2().getParam2_value1()+ "\n"+
                "Parameter 2-value 2: " + parameter.getParam2().getParam2_value2()+ "\n"+
                "Parameter 2-value 3: " + parameter.getParam2().getParam2_value3());

    }
}




